package A3.src.ElasticDatabase;

//This class defines an entry object that holds a integer key and a String value 
public class Equipment<E>
{
	private String equipmentNb;
	
	//Constructor
	public Equipment(String equipmentName) {
		this.equipmentNb = equipmentName;
	}
	
	public String getName() {
		return equipmentNb;
	}
	
	protected void setName(String name) {
		this.equipmentNb = name;
	}

	@Override
	public String toString() {
		return "Equipment: ";
	}
}
