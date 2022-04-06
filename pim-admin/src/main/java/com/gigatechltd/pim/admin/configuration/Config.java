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
    
    @Bean
    public Connection getDataSource() throws SQLException, ClassNotFoundException {
    	Connection connection = null ;
    	try {
			Class.forName("com.oracle.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.70.55:1521/APEXDB.GIGATECHLTD.COM?user=pimuser&password=pimuser");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return connection;
    }
   
}
