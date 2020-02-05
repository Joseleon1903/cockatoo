package com.sea.lion.entertaiment.studio.cockatoo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ApplicationConfig{

    @Value("${com.cockatoo.api.username}")
    private String usernameApi;

    @Value("${com.cockatoo.api.password}")
    private String passwordApi;

}