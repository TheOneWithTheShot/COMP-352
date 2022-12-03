package A3.src.ElasticDatabase;

//This class defines an entry object that holds a integer key and a String value 
public class DatabaseEntry 
{
	private int key;
	private String value; 
	
	//Constructor
	public DatabaseEntry(int key, String value)
	{
		this.key = key;
		this.value = value; 
	}
	
	public int getKey()
	{
		return key; 
	}
	
	public String getValue() 
	{
		return value; 
	}
	
	protected void setKey(int key)
	{
		this.key = key;
	}
	
	protected void setValue(String value)
	{
		this.value = value;
	}
	
	

}
