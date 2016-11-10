import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserters;

public class neo4j {

	public static void main(String[] args) throws IOException{
		
		BatchInserter inserter = BatchInserters.inserter(new File("socialnet(neo4j)"));
		
		// Sandra works at Amazon, she will be recommended by Bob
		Map<String, Object> attributesSandra = new HashMap<>();
		
		attributesSandra.put("firstName", "Sandra");
		attributesSandra.put("worksAt", "Amazon");
		attributesSandra.put("recommended", "true");
		long sandraNode= inserter.createNode(attributesSandra, Label.label("User"));
		
		// Bob works at IBM and will recommend Sandra
		Map<String, Object> attributesBob = new HashMap<>();
		
		attributesBob.put("firstName", "Bob");
		attributesBob.put("worksAt", "IBM");
		long BobNode= inserter.createNode(attributesBob, Label.label("User"));
		
		// Jim is a recommender of Bob who works at IBM
		Map<String, Object> attributesJim = new HashMap<>();
		
		attributesJim.put("firstName", "Jim");
		attributesJim.put("worksAt", "Walmart");
		long JimNode= inserter.createNode(attributesJim, Label.label("User"));
		
		// Bill is a friend of Sandra who was recommended
		Map<String, Object> attributesBill = new HashMap<>();
		
		attributesBill.put("firstName", "Bill");
		attributesBill.put("worksAt", "Walmart");
		long BillNode= inserter.createNode(attributesBill, Label.label("User"));
		
		
		// Bob recommends Sandra who works at Amazon
		inserter.createRelationship(BobNode, sandraNode, RelationshipType.withName("Recommends"), null);
		
		// Jim recommends Bob who works at IBM
		inserter.createRelationship(JimNode, BobNode, RelationshipType.withName("Recommends"), null);
		
		// Bill is friends with Sandra who is a recommended user
		inserter.createRelationship(BillNode, sandraNode, RelationshipType.withName("Friends"), null);
		
		inserter.shutdown();
	}
}
