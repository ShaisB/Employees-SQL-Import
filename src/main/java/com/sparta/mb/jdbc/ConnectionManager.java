package com.sparta.mb.jdbc;

import com.sparta.mb.util.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    private static Connection connection;
    public static Connection connectToDB(){
        String url = PropertiesLoader.getProperties().getProperty("url");
        String username = PropertiesLoader.getProperties().getProperty("userName");
        String password = PropertiesLoader.getProperties().getProperty("password");

        try {
            connection = DriverManager.getConnection(url , username , password);
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
