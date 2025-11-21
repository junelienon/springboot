package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testdb {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/logs?useSSL=false&serverTimezone=UTC",
            "root",
            ""
        );
        System.out.println("Connected: " + conn);
    }
}
