package com.jo2.server.auth.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.jo2.server.auth")
@ImportAutoConfiguration(FeignAutoConfiguration.class)
public class OpenFeignConfig {
}
