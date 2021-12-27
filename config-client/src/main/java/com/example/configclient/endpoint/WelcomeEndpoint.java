package com.example.configclient.endpoint;

import com.example.configclient.annotation.AdvController;
import com.example.configclient.config.BusinessUnitConfig;
import com.example.configclient.config.WelcomeConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@AdvController
@RequiredArgsConstructor
@Slf4j
@RefreshScope
public class WelcomeEndpoint {
    private final WelcomeConfig welcomeConfig;
    private final BusinessUnitConfig businessUnitConfig;

    @Value("${spring.data.mongodb.uri:UNSET}")
    private String mongoDbUri;

    @Value("${common.message:UNSET}")
    private String commonMessage;

    @GetMapping(value = "/")
    public ResponseEntity hello() {

        return ResponseEntity.ok(Map.of(
                "welcome", welcomeConfig,
                "business-unit", businessUnitConfig,
                "mongodb-uri", mongoDbUri,
                "commons",commonMessage
        ));
    }

    @EventListener
    public void onApplicationEvent(WebServerInitializedEvent event) {
        log.info("server http://localhost:" + event.getWebServer().getPort() + "/ is up and ready");
    }
}