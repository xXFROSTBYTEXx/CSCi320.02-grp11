import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class neo4jQuery {
	
	public static void main(String[] args) throws IOException{
	
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		
		GraphDatabaseService db = dbFactory.newEmbeddedDatabase(new File("socialnet(neo4j)"));
		
		Result res = db.execute("MATCH (u1:User) - [:Recommends] -> (u2:User) "
							  + "WHERE u2.worksAt =  \"Amazon\" "
							  + "RETURN u2.firstName");
		System.out.println("Recommended User who works at Amazon.");
		
		while (res.hasNext()){
			System.out.println(res.next());
		}
		
		System.out.println();
		
		res = db.execute("MATCH (u1:User) -[:Friends]-> (u2:User) "
					   + "WHERE u2.recommended = \"true\" "
					   + "RETURN u1.firstName");
		
		System.out.println("Friend of a recommended User.");
		
		while (res.hasNext()){
			System.out.println(res.next());
		}
		
		System.out.println();
		
		res = db.execute("MATCH (u1:User) - [:Recommends] -> (u2:User) "
					  +	 "WHERE u2.worksAt = \"IBM\" "
					  +  "RETURN u1.firstName");
		
		System.out.println("Recommender of a User that works at IBM.");
		
		while (res.hasNext()){
			System.out.println(res.next());
		}
	}

}
