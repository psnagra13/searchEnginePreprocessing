import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Stream;




public class ReadAll {
	
	private static Map<String, List<String>> invertedIndex = new HashMap(); 
	private static Map<String, List<String>> invertedIndex2 = new HashMap(); 
	
	public static void main(String []args) throws IOException, ClassNotFoundException 
	{
//		 writeToFile();
		
//		 String s= readFromFile();
//		 System.out.println(s);
		 
		List l2 = readAll();
		

		
		for (int i=0; i<l2.size();i++)
		{
			String sno= (String) l2.get(i);
			String adress= "data/" +sno;
			String s= readFromFile(adress);
			s= s.toLowerCase().replace("."," ").replace(","," ");
			
			List tokens= tokenize(s);
			
			createIndex(tokens, sno );
			
			
		}
		
		
		
		for (String key : invertedIndex.keySet()) {
			
			List<String> al= invertedIndex.get(key);
			Set<String> hs = new HashSet<String>();
			hs.addAll(al);
	     	al.clear();
		    al.addAll(hs);
		    
		    invertedIndex2.put(key, al);
		    
		}
		
//		System.out.println(invertedIndex2);
		saveFile(invertedIndex2);
		
		readFile();
				
	}
	
	public static void saveFile(Map<String, List<String>> invertedIndex22)
            throws IOException
    {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("invertedIndex.txt"))) {
            os.writeObject(invertedIndex22);
            System.out.println("here");
        }
    }

    public static void readFile()
            throws ClassNotFoundException, IOException
    {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("invertedIndex.txt"))) {
            System.out.println( is.readObject());
        }
    }
	
	public static void createIndex(List l,String sno)
	{
		for (int i=0;i<l.size();i++)
		{
			String word = (String) l.get(i);
			
			 if (invertedIndex.containsKey(word)) {
				 invertedIndex.get(word).add(sno);
			    } else {
			    	invertedIndex.put(word, new ArrayList<String>());
			    	invertedIndex.get(word).add(sno);
			    }
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public static List tokenize (String s)
	{
		List l2 = new ArrayList();
		 StringTokenizer st = new StringTokenizer(s ," ");  
	     while (st.hasMoreTokens()) {  
	        
	         l2.add(st.nextToken());
	     }  
		return l2;
		
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
	
	public static void writeToFile() throws IOException
	{
		String canonicalFilename= "myfile";
		  String text = "hello this is dummy data2";
		  File file = new File (canonicalFilename);
		  BufferedWriter out = new BufferedWriter(new FileWriter(file)); 
		  out.write(text);
		  out.close();
		
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
