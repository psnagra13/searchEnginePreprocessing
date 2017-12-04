import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class getTitle {

	
	public static void main(String [] args) throws IOException
	{
			Map<String, String> titleMap= new HashMap(); 
	
	 
			List l2 = readAll();
			
			for (int i=0; i<l2.size();i++)
			{
				String sno= (String) l2.get(i);
				String adress= "data/" +sno;
				String s= readFromFile(adress);

				String[] titleArray = s.split("\n");
				String title;
				try {

					title = titleArray[0];

				} catch (Exception e){

					 title="Title for this document is unavailable.";
					
					System.out.println(sno);

				}

			    
				System.out.println(title);
				
				
				titleMap.put(sno, title);
				
			
				
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
