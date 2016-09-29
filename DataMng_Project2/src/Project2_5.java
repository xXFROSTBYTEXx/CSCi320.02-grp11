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
	    	/*
	    	//Interviews during 2013 and 2014
	    	str2 = "INSERT INTO Interview(recruiter, schedueled)" +
	    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
	    			+ "'2013-01-01')";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	str2 = "INSERT INTO Interview(recruiter, schedueled)" +
	    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
	    			+ "'2014-01-01')";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//Champion Recruiter 2014 - 2016
	    	for(int i = 2; i < 12; i++){
		    	str2 = "INSERT INTO Interview(recruiter, schedueled)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "'2014-01-0"+i+"')";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    	
		    	str2 = "INSERT INTO Interview(recruiter, schedueled)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "'2015-01-0"+i+"')";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    	
		    	str2 = "INSERT INTO Interview(recruiter, schedueled)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "'2016-01-0"+i+"')";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
	    	}
	    	*/
	    	//JobPost 'Worker' max salary
	    	
	    	for(int i = 0; i < 250000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, recruiter, schedueled, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, NULL, 'Great opportunity!', True, "
	    					+ "(SELECT email FROM Recruiter WHERE email='email1@email.com'), "
	    					+ "NULL, "
	    					+ "(SELECT id FROM Company WHERE companyName='Company1'))";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    	
	    	for(int i = 250000; i < 500000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, recruiter, schedueled, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, NULL, 'MongoDB', True, "
	    					+ "(SELECT email FROM Recruiter WHERE email='email2@email.com'), "
	    					+ "NULL, "
	    					+ "(SELECT id FROM Company WHERE companyName='Company2'))";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    	
	    	for(int i = 500000; i < 750000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, recruiter, schedueled, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, '50000', NULL, True, "
	    					+ "(SELECT email FROM Recruiter WHERE email='email3@email.com'), "
	    					+ "NULL, "
	    					+ "(SELECT id FROM Company WHERE companyName='Company3'))";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    	
	    	for(int i = 750000; i < 1000000; i++){
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, recruiter, schedueled, company)" +
	    			"VALUES ('"+i+"', 'Worker', NULL, '75000', NULL, True, "
	    					+ "(SELECT email FROM Recruiter WHERE email='email4@email.com'), "
	    					+ "NULL, "
	    					+ "(SELECT id FROM Company WHERE companyName='Company4'))";
	    	
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
