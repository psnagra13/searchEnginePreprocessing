
public class insertToCassandra {
	
	public static void main(String []args)
	{
		
		
		
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("demo");
		
		
	}

}
