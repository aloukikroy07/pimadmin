package com.gigatechltd.pim.admin;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    @Transactional(readOnly = true)
    public void run(String... args) throws Exception {
        System.out.println("PIM Project Started");
    }
}
