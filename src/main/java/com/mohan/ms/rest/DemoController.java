package com.mohan.ms.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@RestController
@Slf4j
public class DemoController {


    @GetMapping({"", "/api/info"})
    public Map<String, String> apiInfo()
    {
        log.info("Request for apiInfo at : {}", LocalDateTime.now());
        return Collections.singletonMap("WORKING REVIEW", "password1");
    }

    private String getHostname() {
        String hostName = "Unknown";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostName = addr.getHostName();
        } catch (Exception e) {
            log.error("Error in getting hostname", e);
        }
        return hostName;
    }
}