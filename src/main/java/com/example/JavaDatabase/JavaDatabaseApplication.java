package com.example.JavaDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication

@RestController
class HelloWorld {
	@RequestMapping("/")
	public String index() {
		String dbURL = "jdbc:mysql://localhost:8889/java"; //SQL Port 8889
		String username = "fnovello";
		String password = "novello2";

		try {

			Connection conn = DriverManager.getConnection(dbURL, username, password);

			if (conn != null) {
				System.out.println("Connected");

				String sql = "INSERT INTO Test (message) VALUES('Success!')";

				Statement statement = conn.createStatement();
				int rows = statement.executeUpdate(sql);

				if(rows > 0) {
					return "Row inserted into Database!!!";
				}
				else {
					return "Failed to insert row into database";
				}
			}else {
				System.out.println("failed");
				return "Failed!";
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "Failed";
	}
}
public class JavaDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorld.class, args);
	}

}
