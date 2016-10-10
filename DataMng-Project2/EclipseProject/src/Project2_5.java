import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Project2_5 {
	
	public static void main(String[] args) throws SQLException{
		
	    Connection con = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;

	    String url = "jdbc:mysql://localhost:3306/socialnet";
	    String user = "USERNAME";
	    String pwd = "PASSWORD";
	    
	    try {
	    	con = DriverManager.getConnection(url, user, pwd);
	    	con.setAutoCommit(false);
	    	
	    	for(int i = 1; i < 6; i++){
	    	String str1 = "INSERT INTO company(id, companyName)" +
	    			"VALUES ('"+i+"', 'Company"+i+"')";
	  
	    	PreparedStatement preparedStmt1 = con.prepareStatement(str1);
	    	preparedStmt1.execute();
	    	con.commit();
	    	}
	   
	   
	   
	    	//Create SocialUsers 1-5
	    	for(int i = 1; i < 6; i++){
		    	String str2 = "INSERT INTO SocialUser(email, firstName, lastName)" +
		    			"VALUES ('email"+i+"@email.com', 'fistName"+i+"', 'lastName"+i+"')";
		  
		    	PreparedStatement preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    }
	    	
	    	//Creating Recruiters 1-4
	    	String str2 = "INSERT INTO Recruiter(email)" +
	    			"VALUES ((SELECT email FROM SocialUser WHERE email='email1@email.com'))";
	    	PreparedStatement preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	str2 = "INSERT INTO Recruiter(email)" +
	    			"VALUES ((SELECT email FROM SocialUser WHERE email='email2@email.com'))";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	str2 = "INSERT INTO Recruiter(email)" +
	    			"VALUES ((SELECT email FROM SocialUser WHERE email='email3@email.com'))";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	str2 = "INSERT INTO Recruiter(email)" +
	    			"VALUES ((SELECT email FROM SocialUser WHERE email='email4@email.com'))";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	  
	    	// 'Great opportunity!'
	    	for(int i = 0; i < 250000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, NULL, 'Great opportunity!', True, '1')";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    	// 'MongoDB'
	    	for(int i = 250000; i < 500000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, NULL, 'MongoDB', True, '2')";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    	// max salary '50000'
	    	for(int i = 500000; i < 750000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, '50000', NULL, True, '3')";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    	// max salary '75000'
	    	for(int i = 750000; i < 1000000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, '75000', NULL, True, '4')";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    	
	    } catch (SQLException oops) {
	    	System.err.println("Something went very wrong.");
	    	con.rollback();
	    }
	}

}
