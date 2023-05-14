package com.todo.todoapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailSenderServiceConfig {

    @Value("${spring.mail.host}")
    private String emailHost;

    @Value("${spring.mail.port}")
    private String emailPort;

    @Value("${spring.mail.username}")
    private String emailUsername;

    @Value("${spring.mail.password}")
    private String emailPassword;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(emailHost);
        javaMailSender.setPort(Integer.parseInt(emailPort));
        javaMailSender.setUsername(emailUsername);
        javaMailSender.setPassword(emailPassword);

        Properties javaMailProperties = javaMailSender.getJavaMailProperties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");

        return javaMailSender;
    }

}
