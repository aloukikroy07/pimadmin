package com.gigatechltd.pim.admin;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages=
{
	"com.gigatechltd.pim.admin.configuration"
	, "com.gigatechltd.pim.admin.controller"
	, "com.gigatechltd.pim.admin.services"
	, "com.gigatechltd.pim.admin.repository"
	, "com.gigatechltd.pim.admin.model"
	, "com.gigatechltd.pim.admin.service.menu"
	, "com.gigatechltd.pim.admin.service.security"
	, "com.gigatechltd.pim.admin.service.user"
	, "com.gigatechltd.pim.admin.utils"
	
})
@CrossOrigin(origins = "*")
public class Application implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    @Transactional(readOnly = true)
    public void run(String... args) throws Exception {
        System.out.println("PIM Project Started");
    }
}
