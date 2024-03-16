package com.sonar.reporter.controller;

import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.sonar.reporter.service.SlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/slack")
@RequiredArgsConstructor
public class SlackController {

    private final SlackService slackService;

    @GetMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChatPostMessageResponse> getProjectIssues(@RequestParam(name = "message", required = false) String message) {
        return new ResponseEntity<>(slackService.sendMessageToSlack(message), HttpStatus.OK);
    }
}
