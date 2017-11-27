import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class createInvertedIndex {
	private static Map<String, List<String>> invertedIndex = new HashMap(); 

	
	public void createIndex(List l,String sno)
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
	
	

}
