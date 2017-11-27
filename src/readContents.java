import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class readContents {

	public  void readFromFile() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("myfile"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
		    System.out.print(everything);
		    
		} finally {
		    br.close();
		}
		
		
		
	}
	

}
