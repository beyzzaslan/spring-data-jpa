package com.beyzaslan.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component//spring contexte bean oluşturmam laızm ki bilgileri çekebileyim
@ConfigurationProperties(prefix = "app")
public class GlobalProperties {
    private List<Server> servers;


/*
*
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;*/
}
