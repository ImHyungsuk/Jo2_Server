package com.jo2.server.chatserver.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.jo2.server.chatserver")
public class OpenFeignConfig {
}