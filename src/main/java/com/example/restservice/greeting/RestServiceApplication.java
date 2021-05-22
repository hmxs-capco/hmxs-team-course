package com.example.restservice.greeting;

//import com.example.restservice.database.DatabaseConnection;

import com.mongodb.client.MongoDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({@PropertySource(value = "classpath:application.properties")})
public class RestServiceApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // testDbConnection();
        testReadWriteToDb();
    }

    private void testDbConnection() {
//        DatabaseConnection dbCon = new DatabaseConnection();
//        try {
//            MongoDatabase db = dbCon.db();
//            System.out.println("mongo::Connected to database: " + db.getName());
//        } catch (Exception e) {
//            System.out.println("mongo::Error connecting to database");
//        }
    }

    private void testReadWriteToDb() {
//        userRepo.deleteAll();
////
//        // save a couple of users
//		userRepo.save(new User("Alice", "Smith"));
//		userRepo.save(new User("Bob", "Smith"));

        // fetch all users
        System.out.println("Users:");
        System.out.println("-------------------------------");
        for (User user : userRepo.findAll()) {
            System.out.println(user.toString());
        }
        System.out.println();
    }

}
