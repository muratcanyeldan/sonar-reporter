package com.sonar.reporter.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("sonar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SonarProperties {

    private String url;
    private String token;
}
