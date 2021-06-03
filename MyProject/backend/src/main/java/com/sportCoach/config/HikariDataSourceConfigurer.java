package com.sportCoach.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class HikariDataSourceConfigurer {
    @Value("${spring.datasource.hikari.username}")
    private String username;

    @Value("${spring.datasource.hikari.password}")
    private String password;

    @Value("${spring.datasource.hikari.schema}")
    private String schema;

    @Value("${spring.datasource.hikari.url}")
    private String url;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private Integer maxPoolSize;

    @Value("${spring.datasource.hikari.idle-timeout}")
    private Long idleTimeout;

    @Value("${spring.datasource.hikari.connection-timeout}")
    private Long connectionTimeout;


    @Bean
    public DataSource dataSource() throws Exception {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setSchema(schema);
        hikariDataSource.setIdleTimeout(idleTimeout);
        hikariDataSource.setConnectionTimeout(connectionTimeout);
        hikariDataSource.setMaximumPoolSize(maxPoolSize);
        return hikariDataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource db) {
        return new NamedParameterJdbcTemplate(db);
    }
}
