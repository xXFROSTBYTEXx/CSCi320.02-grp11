import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;

public class Jena {

	public static void main(String[] args){
		
		Dataset dataset =  TDBFactory.createDataset("socialnet(Jena)");
		dataset.begin(ReadWrite.WRITE);
		
		Model model = dataset.getDefaultModel();
		//try{
			model.read("data.n3");
			//model.read(new FileInputStream(new File("data.n3")), "", "N3");
			dataset.commit();
		//}
		//catch(){
			//dataset.abort();
		//}
		dataset.end();
	}
}
