package com.gigatechltd.pim.admin.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	private static final Logger logger = LoggerFactory.getLogger(Config.class);
    public static final int STATUS_PENDING = 0;
    public static final int STATUS_ACTIVE = 1;
    
    
    @Bean
    public Connection getDataSource() throws SQLException, ClassNotFoundException {
    	Connection connection = null ;
    	try {
			Class.forName("com.oracle.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("In getDataSource method in Config class : "+e);
		}
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.70.55:1521/APEXDB.GIGATECHLTD.COM?user=pimuser&password=pimuser");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("In getDataSource method in Config class : "+e);
		}
        return connection;
    }
   
}
