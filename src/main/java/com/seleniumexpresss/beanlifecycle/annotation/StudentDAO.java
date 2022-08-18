package com.seleniumexpresss.beanlifecycle.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDAO {

	private String driver;
	private String url;
	private String userName;
	private String password;

	Connection con;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//@PostConstruct
	public void init() throws ClassNotFoundException, SQLException {
		System.out.println("inside menthod  for studentDB");
		createStudentDBConnection();
	}

	public void createStudentDBConnection() throws ClassNotFoundException, SQLException {

		Class.forName(driver);

		// get a connection
		con = DriverManager.getConnection(url, userName, password);

	}

	public void selectAllRows() throws ClassNotFoundException, SQLException {

		System.out.println("Retriving all Student data..");
		// load driver

		// execute query
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM payrollservice.employeepayroll;");

		while (rs.next()) {

			int id = rs.getInt(1);
			String name = rs.getString(2);
			String salary = rs.getString(3);
			String startDate = rs.getString(4);
			String gender = rs.getString(5);

			System.out.println(id + " " + name + " " + salary + " " + startDate + " " + gender);
		}
		con.close();

	}

	public void deleteStudentRecord(int id) throws ClassNotFoundException, SQLException {

		// execute query
		Statement stmt = con.createStatement();

		stmt.executeUpdate("delete from payrollservice.employeepayroll where id=" + id);

		System.out.println("Record deleted with the id" + id);

	}


	public void closeConnection() throws SQLException {

		con.close();
	}

	//@PreDestroy
	public void destroy() throws SQLException {
		System.out.println("inside destroy method");
		closeConnection();
	}

}
