package A3.src.ElasticDatabase;
import java.util.Random;


public class ElasticERL<E>
{
	//We have an integer for the threshold and one for an array of entries. 
	private int EINThreshold;
	private Equipment smallEntries[];
	
	//Default Constructor (ignore for now)
	public ElasticERL()
	{

	}
	
	//Constructor which allows user to choose size
	public ElasticERL(int Size)
	{
		//Check for valid size
		if(Size <= 100 || Size >= 500000)
		{
			System.out.println("Unable to set the threshold, size is not within the range 100 to 500000"); 
			System.exit(0);
		}
		//In case of valid size, initialize the variable to that size
		else
		{
		this.EINThreshold = Size;
		}
		
		//If we have a small number of entries
		if(Size <= 1000)
		{
			//Initialize an array of DatabaseEntry to the size
			smallEntries = new Equipment[Size];
		}
		
		//if we have a larger amount of entries
		if(Size > 1000)
		{
			
		}
	}


	public int getEINThreshold() 
	{
		return this.EINThreshold;
	}
	
	
	public void setEINThreshold(int Size) 
	{
		if(Size <= 100 || Size >= 500000)
		{
			System.out.println("Unable to set the threshold, size is not within the range 100 to 500000"); 
			System.exit(0);
		}
		else
		{
		this.EINThreshold = Size;
		}
	} 
	
	//A method to generate a random 8-digit number
	public int generate() 
	{
		int myRandomNumber = (int) Math.pow(10, 8 - 1);
      	return myRandomNumber + new Random().nextInt(9 * myRandomNumber);
	}
	
	
	
	//main for testing (TEMPORARY)
	public static void main(String[] args) 
	{
		ElasticERL x = new ElasticERL(); 
		System.out.println(x.generate()); 
	}
	

}
