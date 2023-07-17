package com.cac.HomeBanking.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerPortConfig {

    @Value("${server.port}")
    private int serverPort;

}
