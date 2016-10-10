import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Project1 {
	
	public static void main(String[] args) throws SQLException {

	    Connection con = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;

	    String url = "jdbc:mysql://localhost:3306/socialnet";
	    String user = "USERNAME";
	    String pwd = "PASSWORD";
	    
	    try {
	    	con = DriverManager.getConnection(url, user, pwd);
	    	con.setAutoCommit(false);
	    	String str1 = "INSERT INTO Users(email, firstName, lastName)" +
	    			"VALUES ('test1@email.com', 'Jim', 'Smithh')";
	    	String str2 = "INSERT INTO Users(email, firstName, lastName)" +
	    			"VALUES ('test2@email.com', 'John', 'Smithy')";
	    	String str3 = "INSERT INTO Company(id, name, description, "
	    			+ "numEmplees, address, category)" +
	    			"VALUES ('Co12345', 'Company1', 'Company1s Description',"
	    			+ " '10', '1 Green Street, Syracuse NY', 'Manufacturing')";
	    	String str4 = "INSERT INTO Skill(id, name, level)" +
	    			"VALUES ('sk12345', 'Skill1', '10')";
	    	
	    	String str5 = "INSERT INTO User(email, firstName, lastName)" +
	    			"VALUES ('test1@email.com', 'Bill', 'Johnson')";
	    	PreparedStatement preparedStmt1 = con.prepareStatement(str1);
	    	PreparedStatement preparedStmt2 = con.prepareStatement(str2);
	    	PreparedStatement prdStmt3 = con.prepareStatement(str3);
	    	PreparedStatement prdStmt4 = con.prepareStatement(str4);
	    	PreparedStatement prdStmt5 = con.prepareStatement(str5);
	
	    	preparedStmt1.execute();
	    	preparedStmt2.execute();
	    	prdStmt3.execute();
	    	prdStmt4.execute();
	    	prdStmt5.execute();
	    	con.commit();
	    	
	    } catch (SQLException oops) {
	    	con.rollback();
	    }
	    
	   /* 
	    try { 
	    	
	    	con = DriverManager.getConnection(url, user, pwd);
	        String query = " insert into Users (email, firstName, lastName)"
	                + " values ('test@email.com', 'Bob','Smith')";

	              // create the mysql insert preparedstatement
	              PreparedStatement preparedStmt = con.prepareStatement(query);
	 

	              // execute the preparedstatement
	              preparedStmt.execute();
	              
	              //con.close();
	            }
	            catch (Exception e)
	            {
	              System.err.println("Got an exception!");
	              System.err.println(e.getMessage());
	            }
	    
	    try {

	    	con = DriverManager.getConnection(url, user, pwd);
	    	// Looping through each row
	    	      java.sql.Statement sta = con.createStatement(); 
	    	      ResultSet res = sta.executeQuery(
	    	        "SELECT ALL email FROM Users.email");
	    	      System.out.println("Emails");
	    	      while (res.next()) {
	    	        String firstName = res.getString("email");
	    	        //String lastName = res.getString("lastName");
	    	        System.out.println(firstName);
	    	      }

	    	      con.close();        
	    	    } catch (Exception e) {
	    	      System.err.println("Exception: "
	    	        +e.getMessage());
	    	    }
	    
	    try {

	        con = DriverManager.getConnection(url, user, pwd);
	        st = con.prepareStatement("SELECT email FROM Users");
	        rs = st.executeQuery();

	        if (rs.next()) {
	            System.out.println(rs.getString("email"));
	            System.out.println(rs.getString("email"));
	        }

	    } catch(SQLException oops) {

	        System.out.println("Something went wrong");
	        
	    } 

	    
	    finally {
	        try {
	            if (st!=null)     rs.close();
	            if (st!=null)     st.close();
	            if (con!=null)    con.close();
	        } catch (SQLException oops) {
	            System.out.println("Something went really wrong");
	        }
	    }
	*/
	}

}
