package com.ncee.saa.core.config;

import com.ncee.saa.core.properties.SAAProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SAAProperties.class)
public class PropertiesConfig {
}
