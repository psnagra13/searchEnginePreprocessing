import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class GetAllFileNames {
	
	public List readAll()
	{
		List l2 = new ArrayList();
		
		
		File folder = new File("data/");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
//		        System.out.println(file.getName());
		        l2.add(file.getName());
		    }
		}
		
		System.out.println(l2);
		
		return l2;
	}

}
