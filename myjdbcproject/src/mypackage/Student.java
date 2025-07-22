package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student 
{
	public void createDatabase() {
	
}

	public void createTable() {
		 try {
	         // MySQL connection details
	         String url = "jdbc:mysql://localhost:3306/gaurav"; // Replace with your DB name
	         String userName = "root";
	         String password = "ram1";

	         // Load MySQL JDBC driver
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         // Establish connection
	         Connection conn = DriverManager.getConnection(url, userName, password);
	        Statement stm=conn.createStatement();
	        String query="create table Student(sid int(3) ,sname varchar(20) ,semail varchar(20))";
	   boolean bl= stm.execute(query);
	         System.out.println(" Table create Successful");
	        
	         // Close connection (good practice)
	         conn.close();
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
		
	}

	public void createData() {
	    try {
	        String url = "jdbc:mysql://localhost:3306/";
	        String db = "gaurav";
	        String userName = "root";
	        String password = "ram1";

	        Connection conn = DriverManager.getConnection(url + db, userName, password);

	        String query = "INSERT INTO Student (sid, sname, semail) VALUES (?, ?, ?)";
	        PreparedStatement psmt = conn.prepareStatement(query);

	        // Set values first
	        psmt.setInt(1, 12);
	        psmt.setString(2, "raju");
	        psmt.setString(3, "raju23@gmail.com");

	       psmt.executeUpdate();    

	      
	            System.out.println("Data inserted into table successfully.");

	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void readData() {
		try {
		    String url = "jdbc:mysql://localhost:3306/";
		    String db = "gaurav";
		    String userName = "root";
		    String password = "ram1";

		    // Connect to the database
		    Connection conn = DriverManager.getConnection(url + db, userName, password);

		    // SELECT query
		    String query = "SELECT * FROM Student";
		    PreparedStatement psmt = conn.prepareStatement(query);
		    ResultSet rs = psmt.executeQuery();

		    // Read data from the result set
		    while (rs.next()) {
		        int id = rs.getInt("sid");
		        String name = rs.getString("sname");
		        String email = rs.getString("semail");

		        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
		    }

		    // Close connection
		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}

		
	}

	public void updateData() {
		try {
		    String url = "jdbc:mysql://localhost:3306/";
		    String db = "gaurav";
		    String userName = "root";
		    String password = "ram1";

		    // Connect to the database
		    Connection conn = DriverManager.getConnection(url + db, userName, password);

		    // UPDATE query – change email of student with sid = 10
		    String query = "UPDATE Student SET semail = ? WHERE sid = ?";

		    PreparedStatement psmt = conn.prepareStatement(query);
		    psmt.setString(1, "newemai@gmail.com"); // New email
		    psmt.setInt(2, 10);                         // ID of student to update

		    int rowsUpdated = psmt.executeUpdate();     // Use executeUpdate() for update

		    if (rowsUpdated > 0) {
		        System.out.println("Data updated successfully.");
		    } else {
		        System.out.println("No data found to update.");
		    }

		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

	public void deleteData() {
		try {
		    String url = "jdbc:mysql://localhost:3306/";
		    String db = "gaurav";
		    String userName = "root";
		    String password = "ram1";

		    // Connect to the database
		    Connection conn = DriverManager.getConnection(url + db, userName, password);

		    // DELETE query – deletes student with sid = 10
		    String query = "DELETE FROM Student WHERE sid = ?";

		    PreparedStatement psmt = conn.prepareStatement(query);
		    psmt.setInt(1, 10);  // Student ID to delete

		    int rowsDeleted = psmt.executeUpdate(); // Use executeUpdate() for delete

		    if (rowsDeleted > 0) {
		        System.out.println("Record deleted successfully.");
		    } else {
		        System.out.println("No matching record found to delete.");
		    }

		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}

		
	}

	}

