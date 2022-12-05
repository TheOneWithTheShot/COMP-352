package A3.src.ElasticDatabase;

//This class defines an entry object that holds a integer key and a String value 
public class Equipment {
	String equipmentName;

	public Equipment(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	public String getName() {
		return equipmentName;
	}
	
	protected void setName(String name) {
		this.equipmentName = name;
	}

	@Override
	public String toString() {
		return "Equipment: " + equipmentName;
	}
}
