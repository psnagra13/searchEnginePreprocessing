import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class getsnippet {

	
	public static void main(String [] args) throws IOException
	{
			Map<String, String> snippetMap= new HashMap(); 
	
	 
			List l2 = readAll();
			
			for (int i=0; i<l2.size();i++)
			{
				String sno= (String) l2.get(i);
				String adress= "data/" +sno;
				String s= readFromFile(adress);
				s= s.replace("\n", " ");
				String snippet = s.substring(100, 500);
				
				
				
				snippetMap.put(sno,snippet);
				
			
				
			}
			
	
			
			
		
		
		
		
		
		
	}
	

	
	public static String  readFromFile(String adress) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(adress));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
		    return (everything);
		    
		} finally {
		    br.close();
		}
		
		
		
	}
	
	
	public static List readAll()
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

		
		return l2;
	}
	
}
