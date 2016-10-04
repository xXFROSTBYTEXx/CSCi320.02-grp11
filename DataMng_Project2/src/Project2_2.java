import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Project2_2 {

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
	    	
	  
	    	//Company 1 and 2 have more than 1000 positions
	    	int j =1003;
	    	for(int i = 1; i < 1003; i++){
	    	String str1 = "INSERT INTO JobPosition(id, initD, endD, title, company)" +
	    			"VALUES ('"+i+"', NULL, NULL, 'Position"+i+"', "
	    					+ "(SELECT id FROM company WHERE companyName='Company1') )";
	    	
	    	String str2 = "INSERT INTO JobPosition(id, initD, endD, title, company)" +
	    			"VALUES ('"+j+"', NULL, NULL, 'Position"+j+"', "
	    					+ "(SELECT id FROM company WHERE companyName='Company2') )";
	  
	    	j++;
	    	PreparedStatement preparedStmt1 = con.prepareStatement(str1);
	    	PreparedStatement preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt1.execute();
	    	preparedStmt2.execute();
	    	con.commit();
	    	}
	    
	    	// Company that branches into other companies
	    	 String str1 = "INSERT INTO BranchesInto(main, branch)" +
	    			"VALUES ((SELECT id FROM company WHERE companyName='Company1'),"
	    			+ " (SELECT id FROM company WHERE companyName='Company2'))";
	  
	    	PreparedStatement preparedStmt1 = con.prepareStatement(str1);
	    	preparedStmt1.execute();
	    	con.commit();
	    	
	    	 str1 = "INSERT INTO BranchesInto(main, branch)" +
		    			"VALUES ((SELECT id FROM company WHERE companyName='Company2'),"
		    			+ " (SELECT id FROM company WHERE companyName='Company3'))";
		  
		    preparedStmt1 = con.prepareStatement(str1);
		    preparedStmt1.execute();
		    con.commit();
	   
	    	//Create SocialUsers 1-5
	    	for(int i = 1; i < 6; i++){
		    	String str2 = "INSERT INTO SocialUser(email, firstName, lastName)" +
		    			"VALUES ('email"+i+"@email.com', 'fistName"+i+"', 'lastName"+i+"')";
		  
		    	PreparedStatement preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    }
	    	//Users last name starts with "Smi"
	    	String str2 = "INSERT INTO SocialUser(email, firstName, lastName)" +
	    			"VALUES ('email6@email.com', 'fistName6', 'Smith')";
	    	PreparedStatement preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	str2 = "INSERT INTO SocialUser(email, firstName, lastName)" +
	    			"VALUES ('email7@email.com', 'fistName7', 'Smithy')";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//User for more than 10 interviews each year
	    	str2 = "INSERT INTO SocialUser(email, firstName, lastName)" +
	    			"VALUES ('email8@email.com', 'fistName8', 'Johnson')";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//Creating Recruiters 1-4
	    	str2 = "INSERT INTO Recruiter(email)" +
	    			"VALUES ((SELECT email FROM SocialUser WHERE email='email1@email.com'))";
	    	preparedStmt2 = con.prepareStatement(str2);
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
	    	
	    	//JobPost 'Worker' max salary
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, company)" +
	    			"VALUES ('1', 'Worker', '20000', '100000', NULL, True, "
	    					+ "(SELECT id FROM Company WHERE companyName='Company1'))";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//JobPost for 'Software Developer'
	    	str2 = "INSERT INTO JobPost(id, jobPosition, minSalary, maxSalary, description,"
	    			+ " active, company)" +
	    			"VALUES ('2', 'Software Developer', '25000', '75000', NULL, True, "
	    					+ "(SELECT id FROM Company WHERE companyName='Company2'))";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//Interviews during 2013 and 2014
	    	str2 = "INSERT INTO Interview(recruiter, schedueled, jobPost)" +
	    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
	    			+ "'2013-01-01', '1')";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	str2 = "INSERT INTO Interview(recruiter, schedueled, jobPost)" +
	    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
	    			+ "'2014-01-01', '1')";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//Champion Recruiter 2014 - 2016
	    	for(int i = 2; i < 13; i++){
		    	str2 = "INSERT INTO Interview(recruiter, schedueled, jobPost)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "'2014-01-0"+i+"', '1')";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    	
		    	str2 = "INSERT INTO Interview(recruiter, schedueled, jobPost)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "'2015-01-0"+i+"', '1')";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    	
		    	str2 = "INSERT INTO Interview(recruiter, schedueled, jobPost)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "'2016-01-0"+i+"', '1')";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
	    	}
	    	

	    	
	    	//JobPosition for Unemployed during 2015
	    	str2 = "UPDATE JobPosition SET initD = '2013-01-01', endD = '2014-06-10'"
	    			+ " WHERE id='1'";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//JobPosition for Still Employed
	    	str2 = "UPDATE JobPosition SET initD = '2013-01-01'"
	    			+ " WHERE id='1003'";
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    
	    	//'Smith' worked JobPosition '1' : Unemployed in 2015
	    	str2 = "INSERT INTO WorksIn(socialUser, jobPosition) " +
	    			"VALUES ((SELECT email FROM SocialUser WHERE email='email6@email.com'),"
	    			+ " (SELECT id FROM JobPosition WHERE id='1'))";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	//'Smithy' works in JobPosition '1003' at Company '2' which has
	    	//an active JobPost for 'Software Developers'
	    	str2 = "INSERT INTO WorksIn(socialUser, jobPosition) " +
	    			"VALUES ((SELECT email FROM SocialUser WHERE email='email7@email.com'),"
	    			+ " (SELECT id FROM JobPosition WHERE id='1003'))";
	    	
	    	preparedStmt2 = con.prepareStatement(str2);
	    	preparedStmt2.execute();
	    	con.commit();
	    	
	    	
	    	//User who participates in on average more than 10 interviews a year
	    	for(int i = 2; i < 13; i++){
	    		
		    	str2 = "INSERT INTO ParticipatesIn(recruiter, schedueled, jobPost, socialUser)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "(SELECT schedueled FROM Interview WHERE schedueled='2014-01-0"+i+"'), "
		    					+ "'1', "
		    			+ "(SELECT email FROM SocialUser WHERE email='email6@email.com'))";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    
		    	str2 = "INSERT INTO ParticipatesIn(recruiter, schedueled, jobPost, socialUser)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "(SELECT schedueled FROM Interview WHERE schedueled='2015-01-0"+i+"'), "
		    					+ "'1', "
		    			+ "(SELECT email FROM SocialUser WHERE email='email6@email.com'))";
		    	preparedStmt2 = con.prepareStatement(str2);
		    	preparedStmt2.execute();
		    	con.commit();
		    	
		    	str2 = "INSERT INTO ParticipatesIn(recruiter, schedueled, jobPost, socialUser)" +
		    			"VALUES ((SELECT email FROM Recruiter WHERE email='email1@email.com'), "
		    			+ "(SELECT schedueled FROM Interview WHERE schedueled='2016-01-0"+i+"'), "
		    					+ "'1', "
		    			+ "(SELECT email FROM SocialUser WHERE email='email6@email.com'))";
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
