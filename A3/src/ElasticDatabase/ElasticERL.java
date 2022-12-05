//-----------------------------------------------------------------
//Assignment 3
//Written by: Bayazeed Rahman (40190096) and Xavier Guertin (40213535)
//-----------------------------------------------------------------

package A3.src.ElasticDatabase;

public class ElasticERL
{
	//We have an integer for the threshold and one for an array of entries. 
	protected int EINThreshold;
	protected int _size = 0;

	/**
	 * Default Constructor
	 */
	public ElasticERL() {

	}

	/**
	 * parameterized constructor
	 * @param Size - size of ElasticERL
	 */
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

	/**
	 * get size
	 * @return - return size
	 */
	public int get_size() {
		return _size;
	}

	/**
	 * set size
	 * @param _size - size
	 */
	public void set_size(int _size) {
		this._size = _size;
	}


	/**
	 * get Threshold
	 * @return - returns threshold
	 */
	public int getEINThreshold() 
	{
		return this.EINThreshold;
	}

	/**
	 * set Threshold
	 */
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
