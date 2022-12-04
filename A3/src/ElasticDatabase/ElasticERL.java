package A3.src.ElasticDatabase;


public class ElasticERL<E>
{
	//We have an integer for the threshold and one for an array of entries. 
	protected int EINThreshold;
	protected int _size = 0;
	
	//Default Constructor (ignore for now)
	public ElasticERL() {

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
