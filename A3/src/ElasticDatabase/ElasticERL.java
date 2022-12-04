package A3.src.ElasticDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

import static A3.src.ElasticDatabase.main.sequenceADT;


public class ElasticERL<E>
{
	//We have an integer for the threshold and one for an array of entries. 
	protected int EINThreshold;
	protected int _size;
	private final static int LENGTHEQUIPMENT = 8;
	
	//Default Constructor (ignore for now)
	public ElasticERL() {
		this(0);
	}

	//Constructor which allows user to choose size
	public ElasticERL(int Size) {
		//Check for valid size
		if(Size < 100 || Size > 500000)
		{
			System.out.println("Unable to set the threshold, size is not within the range 100 to 500000");
			System.exit(0);
		}
		//In case of valid size, initialize the variable to that size
		else {
		this.EINThreshold = Size;
		}

		//If we have a small number of entries
		if(Size <= 1000) {
			//Initialize an array of DatabaseEntry to the size
			//Do Sequence
		}

		//if we have a larger amount of entries
		if(Size > 1000) {
			//Do hash table
		}
	}

	public int get_size() {
		return _size;
	}
	public void set_size(int _size) {
		this._size = _size;
	}

	public int getEINThreshold() 
	{
		return this.EINThreshold;
	}
	
	
	public void setEINThreshold(int Size) 
	{
		if(Size < 100 || Size > 500000)
		{
			System.out.println("Unable to set the threshold, size is not within the range 100 to 500000"); 
			System.exit(0);
		}
		else
		{
		this.EINThreshold = Size;
		}
	}
}
