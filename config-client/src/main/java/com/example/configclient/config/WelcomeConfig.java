package com.example.configclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
@ConfigurationProperties(prefix = "global")
@Data
public class WelcomeConfig {
    private String motd;
    private String header;
    private String appType;
}
