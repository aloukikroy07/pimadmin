package com.gigatechltd.pim.admin.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public static final int STATUS_PENDING = 0;
    public static final int STATUS_ACTIVE = 1;
    
    
   
}
