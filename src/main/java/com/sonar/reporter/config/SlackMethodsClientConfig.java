package com.sonar.reporter.config;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.sonar.reporter.properties.SlackProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SlackMethodsClientConfig {

    private final SlackProperties slackProperties;
    private final Slack slack;

    @Bean
    public MethodsClient methods() {
        return slack.methods(slackProperties.getToken());
    }
}
