package com.sonar.reporter.service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sonar.reporter.constants.RequestConstants;
import com.sonar.reporter.constants.TableConstants;
import com.sonar.reporter.model.IssuesItem;
import com.sonar.reporter.model.request.IssueSearchRequest;
import com.sonar.reporter.model.response.IssueSearchResponse;
import com.sonar.reporter.model.response.ResolvedIssuesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReporterService {

    private final IssueService issueService;
    private final SlackService slackService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");


    public void sendMonthlyReport() {
        List<IssuesItem> resolvedIssues = findResolvedIssuesInLastMonth().stream().sorted(Comparator.comparing(IssuesItem::getProject)).toList();
        List<IssuesItem> createdIssues = findCreatedIssuesInLastMonth().stream().sorted(Comparator.comparing(IssuesItem::getProject)).toList();
        createPDFFile(resolvedIssues, createdIssues);
    }

    private void createPDFFile(List<IssuesItem> resolvedIssues, List<IssuesItem> createdIssues) {
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, Color.RED);

        try (Document document = new Document(PageSize.A4)) {
            PdfWriter.getInstance(document, new FileOutputStream("sonarIssuesTable.pdf"));
            float width = document.getPageSize().getWidth();
            document.open();

            float[] columnDefinitionSize = {25F, 25F, 25F, 25F};

            PdfPTable createdIssuesTable = initializeTable(columnDefinitionSize, width);
            PdfPTable resolvedIssuesTable = initializeTable(columnDefinitionSize, width);
            PdfPCell createdIssuesCell;
            PdfPCell resolvedIssuesCell;

            createdIssuesCell = new PdfPCell(new Phrase("Created Issues in Last Month", titleFont));
            createdIssuesCell.setColspan(columnDefinitionSize.length);

            resolvedIssuesCell = new PdfPCell(new Phrase("Resolved Issues in Last Month", titleFont));
            resolvedIssuesCell.setColspan(columnDefinitionSize.length);

            addColumnCellToTable(createdIssuesTable, createdIssuesCell);
            addColumnCellToTable(resolvedIssuesTable, resolvedIssuesCell);
            addIssueContentCellToTable(resolvedIssues, resolvedIssuesTable);
            addIssueContentCellToTable(createdIssues, createdIssuesTable);

            document.add(resolvedIssuesTable);
            document.add(createdIssuesTable);
            slackService.sendMessageToSlack("Monthly report is ready to be sent");
        } catch (DocumentException | IOException ex) {
            log.error("Error creating PDF file", ex);
            slackService.sendMessageToSlack("Error creating monthly report PDF file");
        }
    }

    private void addIssueContentCellToTable(List<IssuesItem> resolvedIssues, PdfPTable resolvedIssuesTable) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 8);
        for (IssuesItem issue : resolvedIssues) {
            resolvedIssuesTable.addCell(new Phrase(issue.getProject(), font));
            resolvedIssuesTable.addCell(new Phrase(issue.getSeverity(), font));
            resolvedIssuesTable.addCell(new Phrase(issue.getType(), font));
            resolvedIssuesTable.addCell(new Phrase(issue.getMessage(), font));
        }
    }

    private void addColumnCellToTable(PdfPTable createdIssuesTable, PdfPCell createdIssuesCell) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE, Color.BLACK);
        createdIssuesTable.addCell(createdIssuesCell);
        createdIssuesTable.addCell(new Phrase(TableConstants.PROJECT, font));
        createdIssuesTable.addCell(new Phrase(TableConstants.SEVERITY, font));
        createdIssuesTable.addCell(new Phrase(TableConstants.TYPE, font));
        createdIssuesTable.addCell(new Phrase(TableConstants.MESSAGE, font));
    }

    private PdfPTable initializeTable(float[] columnDefinitionSize, float width) {
        PdfPTable table;
        table = new PdfPTable(columnDefinitionSize);
        table.getDefaultCell().setBorder(0);
        table.setHorizontalAlignment(0);
        table.setTotalWidth(width - 72);
        table.setLockedWidth(true);
        return table;
    }

    private List<IssuesItem> findResolvedIssuesInLastMonth() {
        ResolvedIssuesResponse resolvedIssuesResponse = getResolvedIssuesForGivenPage(1);
        List<IssuesItem> issuesList = resolvedIssuesResponse.getIssuesList();
        if (resolvedIssuesResponse.getPageCount() > 1) {
            for (int currentPage = 2; currentPage <= resolvedIssuesResponse.getPageCount(); currentPage++) {
                resolvedIssuesResponse = getResolvedIssuesForGivenPage(currentPage);
                issuesList.addAll(resolvedIssuesResponse.getIssuesList());
            }
        }

        return issuesList;
    }

    private ResolvedIssuesResponse getResolvedIssuesForGivenPage(int page) {
        IssueSearchResponse issueSearchResponse = issueService.getProjectIssues(IssueSearchRequest.builder()
                .timeZone(RequestConstants.TIMEZONE)
                .ps(RequestConstants.PAGE_SIZE)
                .p(String.valueOf(page))
                .s(RequestConstants.UPDATE_DATE)
                .resolved("true").build());

        OffsetDateTime lastMonth = OffsetDateTime.now().minusMonths(1L);

        List<IssuesItem> issuesList = issueSearchResponse.getIssues().stream()
                .dropWhile(x -> OffsetDateTime.parse(x.getUpdateDate(), formatter).isBefore(lastMonth)).collect(Collectors.toList());
        int pageCount = (issueSearchResponse.getPaging().getTotal() / issueSearchResponse.getPaging().getPageSize()) + 1;
        return new ResolvedIssuesResponse(issuesList, pageCount);
    }

    private List<IssuesItem> findCreatedIssuesInLastMonth() {
        return issueService.getProjectIssues(IssueSearchRequest.builder()
                .timeZone(RequestConstants.TIMEZONE)
                .ps(RequestConstants.PAGE_SIZE)
                .p(RequestConstants.START_PAGE_NUM)
                .s(RequestConstants.UPDATE_DATE)
                .createdInLast("1m")
                .resolved("false").build()).getIssues();
    }
}
