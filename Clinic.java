import java.util.Scanner;

public class Clinic {

	// private attributes
	private String clinicName;
	private String clinicCode;
	private String clinicTerm;
	private Individual dentist;
	private Individual[] dentalAsst;
	private Individual[] patient;

	// Getter/Acessor methods
	public String getClinicName() {
		return clinicName;
	}

	public String getClinicCode() {
		return clinicCode;
	}

	public String getClinicTerm() {
		return clinicTerm;
	}

	public Individual getDentist() {
		return dentist;
	}

	public Individual[] getDentalAsst() {
		return dentalAsst;
	}

	public Individual[] getPatient() {
		return patient;
	}

	// setter/mutator methods
	public void setClinicName(String inClinicName) {
		clinicName = inClinicName;
	}

	public void setClinicCode(String inClinicCode) {
		clinicCode = inClinicCode;
	}

	public void setClinicTerm(String inClinicTerm) {
		clinicTerm = inClinicTerm;
	}

	public void setDentist(Individual inDentist) {
		dentist = inDentist;
	}

	public void setDentalAsst(Individual[] inClinicAsst) {

		dentalAsst = new Individual[inClinicAsst.length];
		for (int i = 0; i < inClinicAsst.length; i++) {
			dentalAsst[i] = inClinicAsst[i];
		}
	}

	public void setPatient(Individual[] inPatient) {
		patient = new Individual[inPatient.length];
		for (int i = 0; i < inPatient.length; i++) {
			patient[i] = inPatient[i];
		}

	}

	// initializes all variables to private attributes to default values
	public Clinic() {
		Clinic one;
	};

	// initializes private variables to the values passed via the constructor’s
	// arguments
	public Clinic(String inClinicName, String inClinicCode, String inClinicTerm, Individual inDentist,
			Individual[] inDentalAsst, Individual[] inPatient) {
		clinicName = inClinicName;
		clinicCode = inClinicCode;
		clinicTerm = inClinicTerm;
		dentist = inDentist;
		dentalAsst = inDentalAsst;
		patient = inPatient;
	}

	// to string methods which return concatenated string
	public String toString() {
		return clinicName + clinicCode + clinicTerm + dentist + dentalAsst.length + patient.length;
	}

	// method which displays start message for the driver program
	public void start_Message() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+ Welcome to the Simple Mobile Dental Clinic Management System (SMDCMS) +");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("Code -> Description");
		System.out.println("+++++++++++++++++++");
		System.out.println(" 1001 -> Define Office/Clinic");
		System.out.println(" 1002 -> Add Dentist to Office/Clinic");
		System.out.println(" 1003 -> Add Dental Assistants (Hygienists/Clerks) to Office/Clinic");
		System.out.println(" 1004 -> Register Patient(s) to Office/Clinic");
		System.out.println(" 1005 -> Deregister Dental Assistant(s) and/or Patient(s)");
		System.out.println(" 1006 -> Enter/Update Patient(s) Charges");
		System.out.println(" 1007 -> Display Patients' Statistics");
		System.out.println(" 1008 -> Display Office/Clinic Statistics");
		System.out.println(" 1009 -> Display Chargesheet");
		System.out.println(" 1010 -> Exit");
	}

	// method which takes 3 strings as argument and initializes them to clinicName,
	// clinicCode, clinicTerm
	public void setOffice(String inClinicName, String inClinicCode, String inClinicTerm) {

		clinicName = inClinicName;
		clinicCode = inClinicCode;
		clinicTerm = inClinicTerm;
	}

	// method which takes menu code and individual [] and appends it to dental
	// assistant array or patient array depending upon the menu code
	public void appendToIndividualArr(Individual[] info, int task) {

		// if statement for adding dental assistants to denAsst[]
		if (task == 1003) {
			if (dentalAsst != null && dentalAsst.length != 0) {
				Individual[] copy = new Individual[dentalAsst.length];
				for (int i = 0; i < dentalAsst.length; i++) {
					copy[i] = dentalAsst[i];
				}
				dentalAsst = new Individual[copy.length + info.length];
				for (int i = 0; i < copy.length; i++) {
					dentalAsst[i] = copy[i];

				}
				int z = 0;
				// nested for loops that check if dental assitant is already in the array
				// if yes then skips to the next elements
				for (int i = 0; i < info.length; i++) {

					boolean exists = false;
					for (int j = 0; j < copy.length; j++) {
						if (dentalAsst[j] != null) {
							if (info[i].getEntityId().equals(dentalAsst[j].getEntityId())) {
								exists = true;
								System.out.println("Already Exists: " + info[i].getLastName().toUpperCase() + ", "
										+ info[i].upperCamelCase(info[i].getFirstName()) + " (" + info[i].getEntityId()
										+ ")");

							}
						}
					}
					if (!exists) {

						dentalAsst[copy.length + z] = info[i];
						System.out.println("Successfully added: " + info[i].upperCase(info[i].getLastName()) + ","
								+ info[i].upperCamelCase(info[i].getFirstName()) + " (" + info[i].getEntityId() + ").");
						z++;
					}

				} // this creates a copy off the array and clears all null elements from dental
					// assistants array
				Individual[] copy2 = new Individual[dentalAsst.length];
				for (int i = 0; i < dentalAsst.length; i++) {
					copy2[i] = dentalAsst[i];
				}
				for (int i = 0; i < copy2.length; i++) {
					if (copy2[i] != null)
						dentalAsst[i] = copy2[i];
				}

				// if dental assistants array is empty

			}
			if (dentalAsst == null || dentalAsst.length == 0) {
				setDentalAsst(info);

				for (int i = 0; i < info.length; i++) {
					System.out.println("Successfully added: " + info[i].upperCase(info[i].getLastName()) + ","
							+ info[i].upperCamelCase(info[i].getFirstName()) + " (" + info[i].getEntityId() + ").");
				}
			}
		}
		// if statement for adding patients to patient[]
		if (task == 1004) {
			if (patient != null && patient.length != 0) {
				Individual[] copy = new Individual[patient.length];
				for (int i = 0; i < patient.length; i++) {
					copy[i] = patient[i];
				}
				patient = new Individual[copy.length + info.length];
				for (int i = 0; i < copy.length; i++) {
					patient[i] = copy[i];

				}
				int w = 0;
				// nested loops to check if patient is already in the array
				// if yes then doesn't add it
				for (int i = 0; i < info.length; i++) {
					boolean exists = false;
					for (int j = 0; j < copy.length; j++) {
						if (patient[j] != null) {
							if (info[i].getEntityId().equals(patient[j].getEntityId())) {
								exists = true;
								System.out.println("Already Exists: " + info[i].getLastName().toUpperCase() + ", "
										+ info[i].upperCamelCase(info[i].getFirstName()) + " (" + info[i].getEntityId()
										+ ")");
								break;
							}
						}
					}
					if (!exists) {
						patient[copy.length + w] = info[i];
						System.out.println("Successfully added: " + info[i].upperCase(info[i].getLastName()) + ","
								+ info[i].upperCamelCase(info[i].getFirstName()) + " (" + info[i].getEntityId() + ").");

						w++;
					}
				}
				// if array is empty /adding patients for the first time

				// this creates a copy off the array and clears all null elements from patients
				// array
				Individual[] copy2 = new Individual[patient.length];
				for (int i = 0; i < patient.length; i++) {
					copy2[i] = patient[i];
				}
				for (int i = 0; i < copy2.length; i++) {
					if (copy2[i] != null)
						patient[i] = copy2[i];
				}
			}

			// if patients array is empty
			if (patient == null || patient.length == 0) {

				setPatient(info);

				for (int i = 0; i < info.length; i++) {
					System.out.println("Successfully added: " + info[i].upperCase(info[i].getLastName()) + ","
							+ info[i].upperCamelCase(info[i].getFirstName()) + " (" + info[i].getEntityId() + ").");
				}
			}
		}
	}

	// this method takes string input and deletes the corresponding patients or
	// dental assitants from array depending upon the menu code input in the
	// argument
	public void deleteFromIndividualArr(String inStr2, int task) {

		String[] info = inStr2.split(";");
		// if statement for deleting dental assistants
		if (task == 1003) {
			// check if the
			if (dentalAsst != null && dentalAsst.length != 0) {
				// if the array has only one element
				if (info.length == 1) {
					String info2[] = inStr2.split(" ");
					for (int i = 0; i < info2.length; i++) {
						boolean entityFound = false;
						for (int j = 0; j < dentalAsst.length; j++) {
							if (dentalAsst[j] != null) {
								if (info2[i].equals(dentalAsst[j].getEntityId())) {
									System.out.println("Successfully Deleted: "
											+ dentalAsst[j].upperCase(dentalAsst[j].getLastName()) + ", "
											+ dentalAsst[j].upperCamelCase(dentalAsst[j].getFirstName()) + " ("
											+ dentalAsst[j].getEntityId() + ")");
									entityFound = true;
									// Create a new array with one less element
									Individual[] newDentalAsst = new Individual[dentalAsst.length - 1];
									int b = 0;

									for (int a = 0; a < dentalAsst.length; a++) {
										if (a != j) {
											newDentalAsst[b] = dentalAsst[a];
											b++;
										}
									}
									// Update the reference to the new array
									setDentalAsst(newDentalAsst);
									break; // No need to continue searching for the current entityId
								}
							}
						}
						// if no element found to delete
						if (!(entityFound))
							System.out.println("Entity not found: " + info2[i] + ".");
					}
					// if array has more than one element
				} else {
					for (int i = 0; i < info.length; i++) {
						boolean entityFound = false;
						for (int j = 0; j < dentalAsst.length; j++) {
							if (dentalAsst[j] != null) {
								if (info[i].equals(dentalAsst[j].getEntityId())) {
									System.out.println("Successfully Deleted: "
											+ dentalAsst[j].upperCase(dentalAsst[j].getLastName()) + ", "
											+ dentalAsst[j].upperCamelCase(dentalAsst[j].getFirstName()) + " ("
											+ dentalAsst[j].getEntityId() + ")");
									entityFound = true;
									// Create a new array with one less element
									Individual[] newDentalAsst = new Individual[dentalAsst.length - 1];
									int b = 0;
									// Copy elements except the one to delete
									for (int a = 0; a < dentalAsst.length; a++) {
										if (a != j) {
											newDentalAsst[b] = dentalAsst[a];
											b++;
										}
									}
									// Update the reference to the new array
									setDentalAsst(newDentalAsst);
									break; // No need to continue searching for the current entityId
								}
							}
						}
						// if element not found to delete
						if (!(entityFound))
							System.out.println("Entity not found: " + info[i] + ".");
					}
				}

			}
			// if array is empty
			if (dentalAsst == null || dentalAsst.length == 0)
				for (int i = 0; i < info.length; i++)
					System.out.println("You cannot delete any entity from an empty array");
		}
		// if statement to delete patients
		if (task == 1004) {

			// if array is empty
			if (patient == null || patient.length == 0)
				for (int i = 0; i < info.length; i++)
					System.out.println("You cannot delete any entity from an empty array.");

			if (patient != null && patient.length != 0) {
				// if there is one patient in the array
				if (patient.length == 1) {
					String[] info2 = inStr2.split(" ");
					for (int i = 0; i < info2.length; i++) {
						boolean entityFound = false;
						for (int j = 0; j < patient.length; j++) {
							if (patient[j] != null) {
								if (info2[i].equals(patient[j].getEntityId())) {
									System.out.println(
											"Successfully Deleted: " + patient[j].upperCase(patient[j].getLastName())
													+ ", " + patient[j].upperCamelCase(patient[j].getFirstName()) + " ("
													+ patient[j].getEntityId() + ")");
									entityFound = true;
									// Create a new array with one less element
									Individual[] newPatient = new Individual[patient.length - 1];
									int b = 0;

									for (int a = 0; a < patient.length; a++) {
										if (a != j) {
											newPatient[b] = patient[a];
											b++;
										}
									}
									// Update the reference to the new array
									setPatient(newPatient);
									break; // No need to continue searching for the current entityId
								}
							}
						}
						// if no element found to delete
						if (!(entityFound))
							System.out.println("Entity not found: " + info2[i] + ".");

					}
					// if more than one patients
				} else {
					for (int i = 0; i < info.length; i++) {
						boolean entityFound = false;
						for (int j = 0; j < patient.length; j++) {
							if (patient[j] != null) {
								if (info[i].equals(patient[j].getEntityId())) {
									System.out.println(
											"Successfully Deleted: " + patient[j].upperCase(patient[j].getLastName())
													+ ", " + patient[j].upperCamelCase(patient[j].getFirstName()) + " ("
													+ patient[j].getEntityId() + ")");
									entityFound = true;
									// Create a new array with one less element
									Individual[] newPatient = new Individual[patient.length - 1];
									int b = 0;

									for (int a = 0; a < patient.length; a++) {
										if (a != j) {
											newPatient[b] = patient[a];
											b++;
										}
									}
									// Update the reference to the new array
									setPatient(newPatient);
									break; // No need to continue searching for the current entityId
								}
							}
						}
						// if no element found
						if (!(entityFound))
							System.out.println("Entity not found: " + info[i] + ".");
					}
				}

			}

		}

	}

	// method to add/update charges to patients
	public void updateIndividualCharge(String instr) {
		String info[] = instr.split(";");
		if (!(patient == null || patient.length == 0)) {

			// nested loops that check if patient in the array
			// if yes then add charges to the patient
			// if no then display no found message
			for (int i = 0; i < info.length; i++) {
				String[] info2 = info[i].split(",");
				boolean entityFound = false;

				for (int j = 0; j < patient.length; j++) {
					if (patient[j] != null) {
						if (info2[0].equals(patient[j].getEntityId())) {
							patient[j].setChargePercent(Double.parseDouble(info2[1]));
							System.out.println("Successfully Added/Updated: Charge for "
									+ patient[j].upperCase(patient[j].getLastName()) + ", "
									+ patient[j].upperCamelCase(patient[j].getFirstName()) + " ("
									+ patient[j].getEntityId() + ")");
							entityFound = true;
							break;
						}
					}
				}
				// if patient not found in the array
				if (!entityFound)
					System.out.println("Entity not found: " + info2[0] + ".");

			}
		}
		// if patient array is empty
		if (patient == null) {
			for (int i = 0; i < info.length; i++)
				System.out.println("You cannot add/update charge using an EMPTY array.");
		}

	}

	// method to display dentistList
	public String dentistList() {
		int h = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < patient.length; i++) {
			if (patient[i] != null) {
				builder.append((h + 1)).append(". ").append(patient[i].getLastName().toUpperCase()).append(", ")
						.append(patient[i].upperCamelCase(patient[i].getFirstName())).append(" (")
						.append(patient[i].getEntityId()).append(")\n");
				h++;
			}
		}
		return builder.toString();
	}

	// method to display Clinic stats for menu Code 1008
	public void ClinicStats() {
		int g = 0;
		System.out.println(".........................Office/Clinic Statistics.........................");
		System.out.println("..........................................................................");
		System.out.printf(". %-19s: %-50s.\n", "Clinic Name", clinicName.toUpperCase());
		System.out.printf(". %-19s: %-50s.\n", "Clinic Code", clinicCode.toUpperCase());
		System.out.printf(". %-19s: %-50s.\n", "Term/Permit", clinicTerm);

		System.out.printf(". %-19s: %-50s.\n", "Dentist Name", "Dr. " + dentist.getLastName().toUpperCase() + ", "
				+ dentist.upperCamelCase(dentist.getFirstName()) + " (" + dentist.getEntityId() + ")");
		for (int i = 0; i < dentalAsst.length; i++) {
			if (dentalAsst[i] != null) {
				System.out.printf(". Dental Asssitant  " + (g + 1) + ": " + "%-50s.\n",
						dentalAsst[i].getLastName().toUpperCase() + ", "
								+ dentalAsst[i].upperCamelCase(dentalAsst[i].getFirstName()) + " ("
								+ dentalAsst[i].getEntityId() + ")");
				g++;
			}
		}
		System.out.printf(". %-19s: %-50s.\n", "Registered patients", patient.length);
		System.out.println("..........................................................................");

	}

	// method to display chargeSheet for menu code 1009
	public void chargeSheet() {

		double max = 0;
		int rank = 0;

		for (int i = 0; i < patient.length; i++) {
			if (patient[i] != null) {
				if (patient[i].getChargePercent() > max) {
					max = patient[i].getChargePercent();
				}
			}
		}
		double min = max;

		// Find the minimum charge percentage
		for (int i = 0; i < patient.length; i++) {
			if (patient[i] != null) {
				if (patient[i].getChargePercent() < min) {
					min = patient[i].getChargePercent();
				}
			}
		}

		// Print the charge sheet header
		System.out.println(
				".........................Office/Clinic Chargesheet (Increasing Order).........................");
		System.out.printf(". %4s    %-18s    %-23s%-27s%8s   .\n", "P/N.", "Patient ID", "SURNAME", "First Name",
				"Charge");
		System.out.println(
				"..............................................................................................");

		// Iterate over charge percentages in increasing order
		for (int i = (int) min; i <= (int) max; i++) {

			for (int a = 0; a < patient.length; a++) {
				if (((int) patient[a].getChargePercent()) == i) {

					rank++;

					if (patient[a] != null) {
						System.out.printf(". %4s    %-18s    %-23s%-27s%8s   .\n", rank + ".", patient[a].getEntityId(),
								patient[a].getLastName().toUpperCase(),
								patient[a].upperCamelCase(patient[a].getFirstName()), patient[a].getChargePercent());

					}
				}
			}
		}

		System.out.println(
				"..............................................................................................");
	}

}
