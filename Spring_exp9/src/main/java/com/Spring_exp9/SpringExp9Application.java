package com.Spring_exp9;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringExp9Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringExp9Application.class, args);
    }

    @Bean
    CommandLineRunner run(StudentRepository repository) {

        return args -> {

            // Student 1
            Student s1 = new Student();
            s1.setId(1);
            s1.setName("Rahul");
            s1.setEmail("rahul@gmail.com");
            s1.setRoll_no("CS101");

            // Student 2
            Student s2 = new Student();
            s2.setId(2);
            s2.setName("Amit");
            s2.setEmail("amit@gmail.com");
            s2.setRoll_no("CS102");

            // Student 3
            Student s3 = new Student();
            s3.setId(3);
            s3.setName("Viraj");
            s3.setEmail("viraj@gmail.com");
            s3.setRoll_no("CS103");

            // Save 3 students
            repository.save(s1);
            repository.save(s2);
            repository.save(s3);

            // Update last student (Student 3)
            s3.setName("Viraj Potdar");
            s3.setEmail("virajpotdar@gmail.com");
            s3.setRoll_no("CS999");

            repository.save(s3);

            System.out.println("3 students saved successfully.");
            System.out.println("3rd student updated successfully.");
        };
    }
}