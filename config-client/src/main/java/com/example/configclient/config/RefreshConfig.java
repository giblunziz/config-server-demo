package com.example.configclient.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
//@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class RefreshConfig {

    private final RefreshEndpoint refreshEndpoint;
    private final HealthEndpoint healthEndpoint;

    @Scheduled(fixedDelay = 6000)
    public void refresh() {
        refreshEndpoint.refresh();
        HealthComponent result = healthEndpoint.health();
        log.info(result.toString());
    }

}
