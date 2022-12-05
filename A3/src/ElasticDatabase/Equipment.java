//-----------------------------------------------------------------
//Assignment 3
//Written by: Bayazeed Rahman (40190096) and Xavier Guertin (40213535)
//-----------------------------------------------------------------

package A3.src.ElasticDatabase;


public class Equipment {
	String equipmentName;

	/**
	 * parameterized constructor
	 * @param equipmentName - takes equipment name and assigns it to obj of type Equipment
	 */
	public Equipment(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	/**
	 * gets name
	 * @return - returns name
	 */
	public String getName() {
		return equipmentName;
	}

	/**
	 * set name
	 * @param name - takes string as a parameter
	 */
	protected void setName(String name) {
		this.equipmentName = name;
	}
}
