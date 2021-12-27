package com.example.configclient.annotation;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("adv")
public @interface AdvController {
}
