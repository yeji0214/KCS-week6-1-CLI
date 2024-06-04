package com.kiosk;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// AppConfig.java
@Configuration
@ComponentScan(basePackages = "com.kiosk") // 패키지 경로는 올바르게 설정하자
public class AppConfig {}