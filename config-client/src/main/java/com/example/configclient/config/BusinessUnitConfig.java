package com.example.configclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
@ConfigurationProperties(prefix = "business-unit")
@Data
public class BusinessUnitConfig {
    private String code; // LMES
    private String countryCode; // ES
    private String countryName; // Spain
    private String buCode; // LM
    private String buName; // Leroy Merlin
}
