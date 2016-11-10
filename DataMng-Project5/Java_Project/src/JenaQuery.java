import java.io.IOException;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.tdb.TDBFactory;

public class JenaQuery {
	
	public static void main(String[] args) throws IOException{
		Dataset dataset = TDBFactory.createDataset("socialnet(Jena)");
		dataset.begin(ReadWrite.READ);
		/*
		Query query = 
				QueryFactory.create("prefix dbo: <http://dbpedia.org/ontology/>" +
									"prefix dbr: <http://dbpedia.org/resource/>" +
									"prefix dbt: <http://dbpedia.org/datatype/>" +
									"prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
									"prefix xsd: <http://www.w3.org/2001/XMLSchema#>" +
									"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
				 					"SELECT ?node ?name ?j" +
									"WHERE { " +
									//"?u  rdf:type            model:User."
								   // "?u	   	rdf:type			   dbo:User."+
									"?node		rdf:type				     dbo:User."+
									"?name		dbo:Skill							?j."+
								   // "?u	   model:hasSkill 		   ?j. "+
								   // "FILTER(?j = \"Java\")"+
								    "}");
		*/
		Query query = QueryFactory.create("SELECT * WHERE{?s ?p ?o.}");
		QueryExecution qexec = QueryExecutionFactory.create(query, dataset);
		ResultSet results = qexec.execSelect();
		ResultSetFormatter.out(results);
		dataset.end();
	}

}
