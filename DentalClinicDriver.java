//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//Assignment-4
//Written by: Harwinder Singh Mann (Student ID: 40293187)
//For COMP 248- Section W- Winter 2024
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
//program info- this program is an advanced version of the Simple Mobile Dental Clinic Management System from assignment 3 which now uses methods from Individual and Clinic
//              classes to perform taks like creating Indvidual object containing first name, last name and id of person.
//              and adding dentist, dental assistants, patients to the clinic and  charges associated to patients and displaying all these statisticss

//importing Scanner
import java.util.Scanner;

public class DentalClinicDriver {

	public static void main(String[] args) {
		// object one of Clinic class
		Clinic one = new Clinic();
		// start message and displaying task menu to user
		one.start_Message();
		// object two of Individual class
		Individual two = new Individual();

		// Scanner input to take input
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.print("Please enter a Code, from the aforementioned, that corresponds to your task: ");
		int task = input.nextInt();
		System.out.println();
		System.out.println();
		// boolean variable which will be used to validate the condtion of do while loop
		boolean validation = task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005
				|| task == 1006 || task == 1007 || task == 1008 || task == 1009 || task == 1010;

		// do- while loop to iterate through all the cases if user wants to perform
		// multiple tasks
		do {
			// switch statements to iterate through cases
			switch (task) {

			// case to assign Clinic Name, Code, Term
			case 1001: {
				System.out.println("...Define Office/Clinic...");
				System.out.println(".........................");
				System.out.println(
						"Enter Office/Clinic information (ClinicName ClinicCode Term/Permit) as a single-line entry:");
				input.nextLine();
				String office_info = input.nextLine();
				String[] parts = office_info.split(" ");

				if (parts.length >= 3)
					one.setOffice(parts[0], parts[1], parts[2]);// setOffice method to assign name, code and term

				// prompting user to enter valid input if another task is to be performed
				do {

					System.out.print(
							"Successful operation! Kindly continue by entering a Code, from the menu above, that corressponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} // case 1 closed

			// case to assign doctor to the Office/Clinic
			case 1002: {
				System.out.println("...Add Dentist for Office/Clinic...");
				System.out.println(".....................................");
				System.out.println(
						"Enter dentist's information (EmployeeID FirstnName LastName) as a single-line entry:");
				System.out.println();
				input.nextLine();
				String dentist_info = input.nextLine();
				String[] parts2 = dentist_info.split(" ");
				Individual three = new Individual(parts2[0], parts2[1], parts2[2]);
				one.setDentist(three);// to assign id, last name, first name to dentist

				// prompting user to enter valid input if another task is to be performed
				do {

					System.out.print(
							"Successful operation! Kindly continue by entering a Code, from the menu above, that corressponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} /// case 2 closed

			// case to add Dental Assitants to Office/Clinic
			case 1003: {
				task = 1003;
				System.out.println("...Add Dental Assistants (Hygienists/Clerks) to Office/Clinic...");
				System.out.println("....................................................");
				System.out.println(
						"Enter Dental Assistant(s) information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2):");
				input.nextLine();
				String deninput = input.nextLine();
				// method to append dental assistants to dental assistants array
				one.appendToIndividualArr(two.inStrToIndividualArr(deninput), task);

				// prompting user to enter valid input if another task is to be performed
				do {

					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();

				break;

			} // case 3 closed

			// case to register patients at the Office/Clinic
			case 1004: {
				task = 1004;
				System.out.println("...Register Patient(s) at Office/Clinic...");
				System.out.println("......................................");
				System.out.println("Enter Patients information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2):");
				input.nextLine();
				String patinput = input.nextLine();
				// method to append patients to patient array
				one.appendToIndividualArr(two.inStrToIndividualArr(patinput), task);

				// prompting user to enter valid input if another task is to be performed
				do {

					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;

			} // case 4 closed

			// case for degregistering dental assistants or patients from the Clinic
			case 1005: {
				System.out.println("...DeRegister Dental Assistant(s) and/or Patients(s)...");
				System.out.println(".......................................................");
				System.out
						.println("Enter '1003' to degregister Dental Assistant(s) and '1004' to deregister Patient(s)");

				int deRegisterInput = input.nextInt();
				System.out.println("Enter the information of entities (ID1;ID2): ");
				input.nextLine();
				String instr2 = input.nextLine();
				// method to delete dental assitants or patients depending upon user input
				one.deleteFromIndividualArr(instr2, deRegisterInput);

				// prompting user to enter valid input if another task is to be performed
				do {
					System.out.println();
					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} // case 5 closed

			// case for adding/updating charges to patients
			case 1006: {
				System.out.println("...Enter/Update Patient(s) Charges...");
				System.out.println("....................................");
				System.out.println("Enter Patients' Charges (ID1,Charge1;ID2,Charge2):");
				input.nextLine();
				String instr = input.nextLine();
				// method to add charges to individual charges to patients
				one.updateIndividualCharge(instr);

				// prompting user to enter valid input if another task is to be performed
				do {
					System.out.println();
					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(validation = task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005
						|| task == 1006 || task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} // case 6 closed

			// case to display patient statistics
			// different methods from individual, clinic class to display stats
			case 1007: {
				System.out.println("...Display Patients' Statistics...");
				System.out.println("..................................");
				System.out.println(two.upperCamelCase(one.getClinicName()) + "("
						+ two.upperCase(one.getClinicCode() + "): " + two.upperCamelCase(one.getClinicTerm())));
				System.out.println("dentist: Dr. " + two.upperCase(one.getDentist().getLastName()) + ", "
						+ two.upperCamelCase(one.getDentist().getFirstName()) + " (" + one.getDentist().getEntityId()
						+ ")");
				System.out.println("Dental Assitants: " + one.getDentalAsst().length + " Dental Assitant(s)");
				System.out.println(
						"The number of patients registered with the clinic: " + one.getPatient().length + " patients");
				System.out.println("..................................");
				System.out.print(one.dentistList());
				System.out.println("..................................");
				// prompting user to enter valid input if another task is to be performed
				do {
					System.out.println();
					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} // case 7 closed

			// case to display clinic stats
			case 1008: {
				one.ClinicStats();// clinic stats method from clinic class to display stats

				// prompting user to enter valid input if another task is to be performed
				do {
					System.out.println();
					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} // case 8 closed

			// case to display chargesheet
			case 1009: {
				one.chargeSheet();// chargeSheet method from clinic class to display charges associated with each
									// patient rank wise

				// prompting user to enter valid input if another task is to be performed
				do {
					System.out.println();
					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} // case 9 closed

			// case to display exit message for SMDCMS
			case 1010: {
				System.out.println();
				System.out.println("Simple SMDCMS >>> Exiting...");
				System.out.println();
				System.out
						.println("Thank you for fostering our Simple Mobile Dental Clinic Management System (SMDCMS).");
				task = 5252;// setting task=5252 to stop the do-while loop from iterating
				break;
			}

			// default case to prompt user to enter valid input if user enter invalid input
			// initially
			default: {
				do {
					System.out.print(
							"Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
					task = input.nextInt();
					System.out.println();
				} while (!(task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
						|| task == 1007 || task == 1008 || task == 1009 || task == 1010));
				System.out.println();
				break;
			} // default case closed

			}

		} while (task == 1001 || task == 1002 || task == 1003 || task == 1004 || task == 1005 || task == 1006
				|| task == 1007 || task == 1008 || task == 1009 || task == 1010);

		input.close();// keeping the scanner busy
	}
}
