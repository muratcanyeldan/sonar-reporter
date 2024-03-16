package com.sonar.reporter.config;

import com.sonar.reporter.properties.SonarProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

    private final SonarProperties sonarProperties;

    @Bean
    public RestClient restClient() {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        return RestClient.builder()
                .baseUrl(sonarProperties.getUrl())
                .defaultHeader("Authorization", "Bearer " + sonarProperties.getToken())
                .requestFactory(factory)
                .build();
    }
}
