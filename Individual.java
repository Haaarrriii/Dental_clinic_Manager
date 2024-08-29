
public class Individual {

	// private attributes
	private String entityID;
	private String firstName;
	private String lastName;
	private double chargePercent;

	// getters/accessor methods
	public String getEntityId() {
		return entityID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getChargePercent() {
		return chargePercent;
	}

	// setter/mutator methods
	public void setEntityID(String inEntityID) {
		entityID = inEntityID;
	}

	public void setFirstName(String inFirstName) {
		firstName = inFirstName;
	}

	public void setLastName(String inLastName) {
		lastName = inLastName;
	}

	public void setChargePercent(double inChargePercent) {
		chargePercent = inChargePercent;
	}

//	/ creates an object of this class and initializes all the class private variables to some default/initial values
	public Individual() {
		Individual one;
	}

	// initializes all the class’ private variables to the values passed via this
	// constructor’s arguments
	public Individual(String inEntityID, String inFirstName, String inLastName) {
		entityID = inEntityID;
		firstName = inFirstName;
		lastName = inLastName;

	}

	// returns true only if this instance Individual and another Individual have the
	// same value for entity ID
	public boolean equals(Individual anotherIndividual) {

		return (entityID == anotherIndividual.getEntityId());
	}

	// creates a deep copy of individual object
	public Individual(Individual objIndividual) {
		Individual copy = objIndividual;

	}

	// uppercase the string passed in the argument
	public static String upperCase(String inStr) {
		return inStr.toUpperCase();
	}

	// trims the string passed in argument and capitalises its first letter
	public static String upperCamelCase(String instr) {
		String junk = instr.toUpperCase().trim();
		String upperCamel = junk.charAt(0) + instr.substring(1);
		return upperCamel;
	}

	// capitalizes the first letter of string with a space between them
	public static String multiUpperCase(String instr) {
		String[] junk = instr.split(" ");
		String multiUpper = "";
		for (int i = 0; i < junk.length; i++) {
			String a = junk[i];
			String junk2 = a.toUpperCase();
			String junk3 = junk2.charAt(0) + a.substring(1) + " ";
			multiUpper = multiUpper + junk3;
		}
		return multiUpper;
	}

	// this method takes string as an input and return an Individual array
	public static Individual[] inStrToIndividualArr(String inStr) {
		String entities[] = inStr.split(";");
		Individual[] array = new Individual[entities.length];

		for (int i = 0; i < entities.length; i++) {
			String[] particulars = entities[i].split(",");
			if (!(particulars[0].equals(array)))
				array[i] = new Individual(particulars[0].trim(), particulars[1].trim(), particulars[2].trim());

		}
		return array;
	}
}
