package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.dao.impl.ExtendedRepositoryImpl;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = ExtendedRepositoryImpl.class)
public class StudentJPAH2Config {
    // additional JPA Configuration
}
