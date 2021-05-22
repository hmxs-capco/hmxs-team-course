package com.example.restservice.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseConnection {

//    @Value("${database.mongo.host}")
//    private String DB_HOST;
//
//    @Value("${database.mongo.port}")
//    private int DB_PORT;
//
//    @Value("${database.mongo.name}")
//    private String DB_NAME;

    private String DB_HOST = "localhost";
    private int DB_PORT = 27017;
    private String DB_NAME = "digital-engineering-mongo";

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(DB_HOST, DB_PORT);
    }

    @Bean
    public MongoDatabase db() {
        return mongoClient().getDatabase(DB_NAME);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), DB_NAME);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
