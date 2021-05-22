package com.example.restservice;

import com.example.restservice.user.User;
import com.example.restservice.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.example.restservice" })
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@PropertySources({@PropertySource(value = "classpath:application.properties")})
public class RestServiceApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initUsersInDb();
    }

    private void initUsersInDb() {
        userRepo.deleteAll();
		// userRepo.save(new User("Alice", "Smith"));
		// userRepo.save(new User("Bob", "Smith"));
        System.out.println("Users:");
        System.out.println("-------------------------------");
        for (User user : userRepo.findAll()) {
            System.out.println(user.toString());
        }
        System.out.println();
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

}
