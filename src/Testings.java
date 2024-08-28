import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testings {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	Random rand = new Random();
	int customernumber = rand .nextInt(10000);
@BeforeTest
public void start() throws SQLException {
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","hussein1997@");
	
}
@Test (priority = 1  )
public void Add() throws SQLException {
	
	String query = "insert into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit) VALUES ( "+customernumber+", 'john', 'mike', 'Michael', '212-555-1234', '123 Main Street', 'Suite 200', 'New York', 'NY', '10001', 'USA', 1621, 50000.00)";
	stmt=conn.createStatement();
	stmt.executeUpdate(query);
}
@Test(priority = 2 )
public void Update () throws SQLException {
	String query = "update customers set contactFirstName = 'hussein' where phone= '212-555-1234'";
	stmt=conn.createStatement();
	stmt.executeUpdate(query);
}
@Test(priority = 3 )
public void git_data() throws SQLException {
	String Fname;
	String Lname;
	String query = "select * from customers where customerNumber = 684";
	stmt=conn.createStatement();
	rs=stmt.executeQuery(query);
	while(rs.next()) {
	Fname=rs.getString("contactFirstName");
	Lname=rs.getString("contactLastName");
	System.out.println(Fname);
	System.out.println(Lname);
}
}
@Test(priority = 4)
public void Delete() throws SQLException {
	String query = "delete from customers where customerNumber = 684";
	stmt=conn.createStatement();
	stmt.executeUpdate(query);
	
}
}
