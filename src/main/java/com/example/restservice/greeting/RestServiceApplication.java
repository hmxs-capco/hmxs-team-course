package com.example.restservice.greeting;

import com.example.restservice.database.DatabaseConnection;

import com.mongodb.client.MongoDatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({@PropertySource(value = "classpath:application.properties")})
public class RestServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testDbConnection();
    }

    private void testDbConnection() {
        DatabaseConnection dbCon = new DatabaseConnection();
        try {
            MongoDatabase db = dbCon.db();
            System.out.println("mongo::Connected to database: " + db.getName());
        } catch (Exception e) {
            System.out.println("mongo::Error connecting to database");
        }
    }

}
