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

	    } catch (SQLException oops) {
	    	con.rollback();
	    }
	}
}
