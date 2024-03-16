package com.sonar.reporter.service;

import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.sonar.reporter.properties.SlackProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SlackService {

    private final SlackProperties slackProperties;
    private final MethodsClient methods;

    public ChatPostMessageResponse sendMessageToSlack(String message) {

        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(slackProperties.getChannelId())
                .text(message)
                .build();

        ChatPostMessageResponse response = new ChatPostMessageResponse();
        try {
            response = methods.chatPostMessage(request);
        } catch (Exception e) {
            log.error("Error sending message to slack", e);
        }
        return response;
    }
}
