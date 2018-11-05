//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class CustomerRecordSystem {
	private List<Customer> currentCustomer = new LinkedList<Customer>();
	private List<Employee> currentEmployee = new LinkedList<Employee>();
	private String managerApplication[] = new String[1];

	/*
	 * Starting point
	 */
	public static void main(String[] args) {
		// TODO Menu for customer
		// TODO menu for employee
		// TODO menu for manager

		new LocalBankBranch().dataInitialization();
	}

	/*
	 * DONE Main Menu, user can choose to login or exit the program
	 */
	public void mainMenu(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData) {
		displayMessage("\n--Main Menu--\n1.Login\n2.Exit\n");
		int menuOption = inputInt();

		switch (menuOption) {

		// Case 1: Login
		case 1:
			clearScreen();
			authenticateUser(customerData, employeeData, managerData);
			break;

		// Case 2: Exit
		case 2:
			System.exit(0);

			// Default: If incorrect value is entered an Error will be displayed
		default:
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			clearScreen();
			mainMenu(customerData, employeeData, managerData);
		}

	}

	/*
	 * Customer menu
	 */
	public void customerMenu(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData,
			List<Customer> currentCustomer) {
		// Customer menu options
		clearScreen();
		String customerNameDisplay = null;
		for (Customer customerName : currentCustomer) {
			customerNameDisplay = customerName.getCustomerName();
		}
		System.out.println("Welcome " + customerNameDisplay + "\nPlease select one of the following options:\n\n"
				+ "1.View balance\n2.View recent transactions\n3.Edit personal details\n4.Request an appoitment"
				+ "\n5.Log out");
		int menuOption = inputInt();
		clearScreen();
		switch (menuOption) {

		// Case 1: View current balance
		case 1:
			// iterate through currentCusotomer to get account balance
			for (Customer customerBalance : currentCustomer) {
				System.out.println("Current Balance: £" + customerBalance.getAccountBalance());
				pressEnterToReturn();
				clearScreen();
				customerMenu(customerData, employeeData, managerData, currentCustomer);
			}

			// Case 2: View recent transactions
		case 2:
			// iterate through currentCustomer to get recent transactions
			for (Customer customerTransactions : currentCustomer) {
				System.out.println("Recent Transactions:\n" + customerTransactions.getRecentTransactions());
				pressEnterToReturn();
				clearScreen();
				customerMenu(customerData, employeeData, managerData, currentCustomer);
			}

			// Case 3: Edit personal details
		case 3:
			customerDataEdit(customerData, employeeData, managerData, currentCustomer);
			break;

		// Case 4: Request an appointment
		case 4:
			requestAppointment(customerData, employeeData, managerData, currentCustomer);

			break;

		// Case 5: Log out
		case 5:
			// Save customer data
			int indexof = 0;
			String usern = "error";
			Customer customerTemp;
			customerTemp = new Customer(usern, usern, indexof, indexof, usern, usern, usern, usern);
			displayMessage("Logging out.....");
			for (Customer currentcusUsername : currentCustomer) {
				usern = currentcusUsername.getUsername();
				customerTemp = new Customer(currentcusUsername.getCustomerName(),
						currentcusUsername.getCustomerAddress(), currentcusUsername.getAccountNumber(),
						currentcusUsername.getAccountBalance(), currentcusUsername.getRecentTransactions(),
						currentcusUsername.getFinancialServices(), currentcusUsername.getUsername(),
						currentcusUsername.getPassword());
			}
			for (Customer customerSave : customerData) {
				if (usern.equals(customerSave.getUsername())) {
					customerData.set(indexof, customerTemp);
				} else {
					indexof++;
				}
			}
			pressEnterToContinue();
			mainMenu(customerData, employeeData, managerData);

			// default: menuOption not found
		default:
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			customerMenu(customerData, employeeData, managerData, currentCustomer);

		}

	}

	/*
	 * Employee menu TODO NOT DONE********************************************
	 */
	public void employeeMenu(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData,
			List<Employee> currentEmployee) {
		clearScreen();
		// Employee menu options
		String currentEmployeeName = null;
		for (Employee employeeName : currentEmployee) {
			System.out.println(
					"Welcome " + employeeName.getEmployeeName() + "\nPlease select one of the following options:\n\n"
							+ "1.View calendar\n2.View past appointments\n3.Process customer applications\n4.Log out");
			currentEmployeeName = employeeName.getEmployeeName();
		}
		int menuOption = inputInt();
		clearScreen();
		switch (menuOption) {

		// Case 1: View Calendar
		case 1:
			for (Employee employeeCalendar : currentEmployee) {
				displayMessage("\nUpcoming Appointments: \n");
				for (int i = 0; i < employeeCalendar.getCalendar().length; i++) {
					if (employeeCalendar.getCalendar()[i] != null) {
						System.out.println(employeeCalendar.getCalendar()[i]);
					} else {
						displayMessage("No appointments found");
					}
				}
			}
			displayMessage("\n\nReturning to " + currentEmployeeName + " Menu");
			pressEnterToContinue();
			clearScreen();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);

			// Case 2: View Past appointments
		case 2:
			for (Employee employeeCalendar : currentEmployee) {
				System.out.println("\nPast Appointments: \n" + employeeCalendar.getPastAppointments());
			}
			displayMessage("\n\nReturning to " + currentEmployeeName + " Menu");
			pressEnterToContinue();
			clearScreen();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);

			// Case 3: Process customer applications
			// TODO DO THIS
		case 3:
			processApplications(customerData, employeeData, managerData, currentEmployee);
			break;

		// Case 4: Log Out
		case 4:
			// Save employee data
			int indexof = 0;
			String employeen = "error";
			Employee employeeTemp;
			employeeTemp = new Employee(employeen, employeen, employeen, employeen, employeen, null, employeen,
					employeen);
			for (Employee currentEmployeeSave : currentEmployee) {
				employeen = currentEmployeeSave.getUsername();
				employeeTemp = new Employee(currentEmployeeSave.getEmployeeName(),
						currentEmployeeSave.getEmployeeAddress(), currentEmployeeSave.getWorkHours(),
						currentEmployeeSave.getPastAppointments(), currentEmployeeSave.getEmployeeSpecialization(),
						currentEmployeeSave.getCalendar(), currentEmployeeSave.getUsername(),
						currentEmployeeSave.getPassword());
			}
			for (Employee employeeSave : employeeData) {
				if (employeen.equals(employeeSave.getUsername())) {
					employeeData.set(indexof, employeeTemp);
				} else {
					indexof++;
				}
			}
			displayMessage("Logging out.....");
			pressEnterToContinue();
			mainMenu(customerData, employeeData, managerData);

			// default: menuOption not found
		default:
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);
		}
	}

	/*
	 * Manager menu TODO NOT
	 * DONE**************************************************
	 */
	public void managerMenu(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData) {
		clearScreen();

		// Employee menu options
		for (Manager ManagerName : managerData) {
			displayMessage("Welcome Manager\nPlease select one of the following options:\n\n"
					+ "1.List current employees and appointments\n2.View customer accounts\n3.List outstanding customer applications\n"
					+ "4.Add/Remove customer account\n5.Add/Remove employee account\n6.Process customer applications\n7.Log out\n");
		}
		int menuOption = inputInt();
		clearScreen();
		switch (menuOption) {

		// Case 1: List current employees and appointments
		// TODO - NEED TO ADD
		// APPOINTMENTS********************************************************
		case 1:
			for (Employee employeeAccounts : employeeData) {
				System.out.println("\nEmployee Name: " + employeeAccounts.getEmployeeName() + "\nWorking Hours: "
						+ employeeAccounts.getWorkHours() + "\nAppointments:\n" + "\n\n");
			}
			displayMessage("Returning to Manager Menu...");
			pressEnterToContinue();
			clearScreen();
			managerMenu(customerData, employeeData, managerData);

			// Case 2: View customer accounts (Account number/Name/Address)

		case 2:
			for (Customer customerAccounts : customerData) {
				System.out.println("Account Number: " + customerAccounts.getAccountNumber() + "\nName: "
						+ customerAccounts.getCustomerName() + "\nAddress: " + customerAccounts.getCustomerAddress()
						+ "\n\n");
			}
			displayMessage("Returning to Manager Menu");
			pressEnterToContinue();
			clearScreen();
			managerMenu(customerData, employeeData, managerData);

			// Case 3: List outstanding customer applications
			// TODO: Create an array of outstanding
			// applications********************************

		case 3:
			clearScreen();
			for(Employee employee1 : employeeData){
				//Makes sure appointment is not equal to null
				String check = Arrays.toString(employee1.getCalendar());
				if(check.equals("[null]")){
					System.out.println("");
				}
				else{
					System.out.println("Upcomming ppointments:\n" + Arrays.toString(employee1.getCalendar()));
				}
				
			}
			pressEnterToReturn();
			managerMenu(customerData, employeeData, managerData);
			break;

		// Case 4: Add/Remove customer account

		case 4:
			// Used to remove and add customer accounts
			addRemoveCustomer(customerData, employeeData, managerData);
			break;

		// Case 5:Add/Remove employee
		case 5:
			addRemoveEmployee(customerData, employeeData, managerData);
			break;

		// Case 6:Process customer application

		case 6:
			managerProcessApplications(customerData, employeeData, managerData);
			break;

		// Case 7:Log out

		case 7:
			displayMessage("Logging out.....");
			pressEnterToContinue();
			mainMenu(customerData, employeeData, managerData);

			// default: menuOption not found

		default:
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			managerMenu(customerData, employeeData, managerData);
		}

	}
	
	public void managerProcessApplications(List<Customer> customerData, List<Employee> employeeData,
			List<Manager> managerData){
		int option = 0;
		String decision;
		CharSequence test1;
		test1 = Arrays.toString(managerApplication);
		String test[] = new String [1];
		System.out.println("Application:\n" + Arrays.toString(managerApplication) + "\n\nSelect one of the available option:\n1.Approve\n2.Decline\n3.Return to manager menu\n");
		option = inputInt();
		
		switch(option){
		case 1:
			decision = "\n" + Arrays.toString(managerApplication) + " Approved";
			System.out.println(decision);
			pressEnterToReturn();
			managerMenu(customerData, employeeData, managerData);
		case 2:
			clearScreen();
			decision = "\n" + Arrays.toString(managerApplication) + " Declined";
			//Look through the employeeData object
			/*for(Employee lookForMatch : employeeData){
				//Look for a match
				if(lookForMatch.getPastAppointments().contains(test1)){
					lookForMatch.getPastAppointments().replace("Refered to Manager", "Declined");
					System.out.println(lookForMatch.getPastAppointments());
				}else {}}
				*/
				System.out.println(decision);
				pressEnterToReturn();
				managerMenu(customerData, employeeData, managerData);
				
				
			
			
		case 3:
			displayMessage("Returning to manager menu");
			pressEnterToReturn();
			managerMenu(customerData, employeeData, managerData);
		default:
		}
	}

	/*
	 * DONE Add/Remove employee account TODO Check if employee already exists
	 * when adding
	 */
	private void addRemoveEmployee(List<Customer> customerData, List<Employee> employeeData,
			List<Manager> managerData) {
		// Declare all variables that are needed to create a new employee
		// account
		int option = 0;
		String employeeFirstName;
		String employeeSurname;
		String addressFirstLine;
		String postcode;
		String employeeWorkTime;
		String employeesWorkDays;
		String pastAppointments;
		String employeeSpecialisation;
		String[] calendar = new String[2];
		String username;
		String password;

		clearScreen();
		displayMessage(
				"\nSelect one of the following options:\n1.Add employee account\n2.Remove employee account\n3.Return\n");
		option = inputInt();

		// Add employee account
		if (option == 1) {
			clearScreen();
			// Get all of the necessary information to create a new employee
			// account
			// Input employees first name
			displayMessage("\nCreating a new employee account\nPlease input employees first name:\n");
			employeeFirstName = inputString();
			// Input employees surname
			displayMessage("\nPlease input employees surname:\n");
			employeeSurname = inputString();
			// Input employees first line of address
			displayMessage("\nPlease input the first line of employee address(e.g. 20 Example Rd):\n");
			addressFirstLine = inputStringWithSpaces();
			// Input postcode
			displayMessage("\nPlease input the postcode\n");
			postcode = inputStringWithSpaces();
			// Input employees work hours
			displayMessage("\nPlease input employees work hours e.g.9am-3pm\n");
			employeeWorkTime = inputString();
			// Input employees work days
			displayMessage("\nPlease input employees work days e.g. Mon - Fri\n");
			employeesWorkDays = inputString();
			// Past appointments
			pastAppointments = "";
			// Input employee specialisation
			displayMessage("\nPlease input employees specialisation e.g.Accounting/Finance/Support\n");
			employeeSpecialisation = inputString();
			// Username
			displayMessage("\nPlease input employees username:\n");
			username = inputString();
			// Password
			displayMessage("\nPlease input employees password\n");
			password = inputString();
			displayMessage("\nPlease re-enter the password\n");
			String checkPassword = inputString();
			if(password.equals(checkPassword)){
				
			}
			else {
				displayMessage("\n**ERROR: Passwords do not match**:\n");
				pressEnterToReturn();
				managerMenu(customerData, employeeData, managerData);
			}
			clearScreen();

			// Confirm all of the information before creating an employees
			// account
			displayMessage("\nNew employee account is about to be created, please confirm all of the details");
			System.out.println("\nEmployee Name: " + employeeFirstName + " " + employeeSurname + "\nEmployee address:\n"
					+ addressFirstLine + " " + postcode + "\nEmployee work hours: " + employeeWorkTime + ", "
					+ employeesWorkDays + "\nPast appointments: n/a\n" + "Employee specialisation: "
					+ employeeSpecialisation + "\nEmployee username: " + username + "\nEmployee password: " + password);
			displayMessage(
					"\n\nSelect one of the following options\n1.Create employee accoun\n2.Cancel account creation\n");
			option = inputInt();
			// Create new employee account
			if (option == 1) {
				Employee employee01 = new Employee(employeeFirstName + " " + employeeSurname,
						addressFirstLine + " " + postcode, employeeWorkTime + " " + employeesWorkDays, pastAppointments,
						employeeSpecialisation, calendar, username, password);
				employeeData.add(employee01);
				displayMessage("\nEmployee account created successfully");
				pressEnterToContinue();
				managerMenu(customerData, employeeData, managerData);
			}
			// Cancel account creation
			else if (option == 2) {
				clearScreen();
				displayMessage("\nEmployee account creation cancelled");
				pressEnterToContinue();
				managerMenu(customerData, employeeData, managerData);
			}
			// Input not recognised, cancel account creation
			else {
				displayMessage("	**ERROR: Input not recognised**\n   Employee account creation cancelled");
				pressEnterToContinue();
				managerMenu(customerData, employeeData, managerData);
			}

		}

		// Remove employee account
		else if (option == 2) {
			String employeeUsername;
			String employeeAddress;
			// Get employee name
			displayMessage("To remove employee account please enter his/her username:\n");
			employeeUsername = inputStringWithSpaces();

			// Iterating through employeeData list
			for (Employee employeeName : employeeData) {
				// Searching for entered employee name
				if (employeeName.getUsername().equals(employeeUsername)) {
					clearScreen();
					// if employee name found look if the address matches
						employeeData.remove(employeeName);
						// if employee information matches remove the account
						System.out.println("\nEmployee account removed:\nUsername:" + employeeName.getUsername() + "\nName:" + employeeName.getEmployeeName() + "\nAddress:"
								+ employeeName.getEmployeeAddress());
						pressEnterToContinue();
						clearScreen();
						managerMenu(customerData, employeeData, managerData);


					// Employee name not found
				} else {
					displayMessage("**ERROR: Account not found**\nReturning to manager menu...");
					pressEnterToContinue();
					managerMenu(customerData, employeeData, managerData);
				}
			}

		}
		// Return to manager menu
		else if (option == 3) {
			displayMessage("Returning to Manager Menu\n");
			pressEnterToContinue();
			clearScreen();
			managerMenu(customerData, employeeData, managerData);
		}
		// Input not recognised
		else {
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			addRemoveCustomer(customerData, employeeData, managerData);
		}
	}

	/*
	 * DONE Add/Remove Customer account TODO Add checks for account number and
	 * if the same customer exists
	 */
	private void addRemoveCustomer(List<Customer> customerData, List<Employee> employeeData,
			List<Manager> managerData) {
		// Declare variables that are needed to create a new customer account
		int customerAccNum;
		int option = 0;
		String customerFirstName;
		String customerSurname;
		String addressFirstLine;
		String postCode;
		int customerAccountNum;
		double accountBalance;
		String pastTransactions;
		String services;
		String username;
		String password;

		clearScreen();
		displayMessage(
				"\nSelect one of the following options:\n1.Add customer account\n2.Remove customer account\n3.Return\n");
		option = inputInt();

		// Add customer account
		if (option == 1) {
			clearScreen();
			// Get all of the necessary details to create a new customer account
			// and initialise the variables
			// Input customers first name
			displayMessage("\nCreating a new user account...\nPlease input customers first name:\n");
			customerFirstName = inputString();
			// Input surname
			displayMessage("\nPlese input customers surname\n");
			customerSurname = inputString();
			// Input first line of address
			displayMessage("\nPlease input the first line of customers address(e.g. 20 Example Rd):\n");
			addressFirstLine = inputStringWithSpaces();
			// Input postcode
			displayMessage("\nPlease input the postcode\n");
			postCode = inputStringWithSpaces();
			// Auto generate random number between 1000 - 9999, this will act as
			// the account number
			displayMessage("\nAuto generating cusotmers account number...");
			pressEnterToContinue();
			Random rand = new Random();
			customerAccountNum = rand.nextInt(9999) + 1000;
			// Initialise accountBallance, pastTransactions and services
			accountBalance = 0;
			pastTransactions = "";
			services = "n/a";
			// Input username
			displayMessage("\nPlease input customers username(No spaces):\n");
			username = inputString();
			// Input password
			displayMessage("\nPlease input customers password:\n");
			password = inputString();
			displayMessage("\nPlease re-enter the password:\n");
			String checkPassword = inputString();
			if(password.equals(checkPassword)){
				
			}
			else {
				displayMessage("\n**ERROR: Passwords do not match**:\n");
				pressEnterToReturn();
				managerMenu(customerData, employeeData, managerData);
			}
			clearScreen();

			// Confirm all of the details
			displayMessage("New cusomter account is about to be created, please confirm all of the details");
			System.out.println("\nFull name: " + customerFirstName + " " + customerSurname + "\nFull address: "
					+ addressFirstLine + " " + postCode + "\nAccount number: " + customerAccountNum + "\nUsername: "
					+ username + "\nPassword: " + password);
			displayMessage(
					"\n\nSelect one of the following options\n1.Create customer account\n2.Cancel account creation\n");
			option = inputInt();

			// Customer account added
			if (option == 1) {
				Customer customer01 = new Customer(customerFirstName + " " + customerSurname,
						addressFirstLine + " " + postCode, customerAccountNum, accountBalance, pastTransactions,
						services, username, password);
				customerData.add(customer01);
				displayMessage("Customer account created successfully");
				pressEnterToContinue();
				managerMenu(customerData, employeeData, managerData);

			}
			// Account creation cancelled
			else if (option == 2) {
				clearScreen();
				displayMessage("\nCustomer account creation cancelled");
				pressEnterToContinue();
				managerMenu(customerData, employeeData, managerData);
			}
			// Input not recognised, cancel account creation
			else {
				displayMessage("	**ERROR: Input not recognised**\n   Customer account creation cancelled");
				pressEnterToContinue();
				managerMenu(customerData, employeeData, managerData);
			}

		}
		// Remove customer account
		else if (option == 2) {
			displayMessage("To remove customer account please enter his/her account number:\n");
			customerAccNum = inputInt();
			// Searching for entered Account Number
			for (Customer accountNum : customerData) {
				if (accountNum.getAccountNumber() == customerAccNum) {
					customerData.remove(accountNum);
					clearScreen();
					System.out.println("\nCustomer removed:\n" + accountNum.getCustomerName() + "\n"
							+ accountNum.getAccountNumber() + "\n" + accountNum.getCustomerAddress());
					pressEnterToContinue();
					clearScreen();
					managerMenu(customerData, employeeData, managerData);

				}
				// Customer account number not found
				else {
					clearScreen();
					displayMessage("**ERROR: Account not found**\nReturning to manager menu...");
					pressEnterToContinue();
					managerMenu(customerData, employeeData, managerData);
				}
			}

		}
		// Return to Manager Menu
		else if (option == 3) {
			displayMessage("Returning to Manager Menu\n");
			pressEnterToContinue();
			clearScreen();
			managerMenu(customerData, employeeData, managerData);
		} else {
			// Input not recognised
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			addRemoveCustomer(customerData, employeeData, managerData);

		}
	}

	/*
	 * Authentication process TODO - Secure this, instead of retrieving the
	 * password just send it to LocalBankBranch and authenticate there
	 */
	private void authenticateUser(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData) {
		String username;
		String password;
		displayMessage("\nPlease enter your username:\n");
		username = inputString();
		displayMessage("\nPlease enter your password\n");
		password = inputString();
		// Checks if entered details match any of the customer login details
		for (Customer customer : customerData) {
			if (customer.getUsername().equals(username)) {
				if (customer.getPassword().equals(password)) {
					currentCustomer.clear();
					currentCustomer.add(customer);
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				} else {
				}
			} else {
			}
		}

		// Checks if entered details match any of the employee login details
		for (Employee employee : employeeData) {
			if (employee.getUsername().equals(username)) {
				if (employee.getPassword().equals(password)) {
					currentEmployee.clear();
					currentEmployee.add(employee);
					employeeMenu(customerData, employeeData, managerData, currentEmployee);
				} else {
				}
			} else {
			}
		}

		// Checks if entered details match any of the manager login details
		for (Manager manager : managerData) {
			if (manager.getUsername().equals(username)) {
				if (manager.getPassword().equals(password)) {
					managerMenu(customerData, employeeData, managerData);
				}
			} else {
			}
		}

		// User not found
		clearScreen();
		displayMessage("**ERROR: User not found please try again**");
		pressEnterToContinue();
		mainMenu(customerData, employeeData, managerData);
	}

	/*
	 * Used by the customer to request an appointment
	 * 
	 */
	public void requestAppointment(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData,
			List<Customer> currentCustomer) {
		clearScreen();
		displayMessage("Please select the purpose of your appointment\n1.Loan\n2.Credit Card\n3.Mortgage\n4.Return\n ");
		int option = 0;
		String appointment[] = new String[1];
		String dataTogether;
		option = inputInt();
		String customerName;
		Employee employeeTemp = null;
		int indexof = 0;

		switch (option) {
		case 1:
			// Retrieves the name of current customer and attaches the purpose
			// of the appointment
			for (Customer currenCusName : currentCustomer) {
				customerName = currenCusName.getCustomerName();
				dataTogether = customerName + " - Loan - ";
				appointment[0] = dataTogether;
			}

			// Finds employee and adds a calendar note
			for (Employee currentEmployeeSave : employeeData) {
				if (currentEmployeeSave.getUsername().equals("emp1")) {
					employeeTemp = new Employee(currentEmployeeSave.getEmployeeName(),
							currentEmployeeSave.getEmployeeAddress(), currentEmployeeSave.getWorkHours(),
							currentEmployeeSave.getPastAppointments(), currentEmployeeSave.getEmployeeSpecialization(),
							appointment, currentEmployeeSave.getUsername(), currentEmployeeSave.getPassword());

					System.out.println("Appointment request added: " + Arrays.toString(employeeTemp.getCalendar()));
					employeeData.set(indexof, employeeTemp);
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				} else if (currentEmployeeSave.getUsername().equals("employee2")) {
					employeeTemp = new Employee(currentEmployeeSave.getEmployeeName(),
							currentEmployeeSave.getEmployeeAddress(), currentEmployeeSave.getWorkHours(),
							currentEmployeeSave.getPastAppointments(), currentEmployeeSave.getEmployeeSpecialization(),
							appointment, currentEmployeeSave.getUsername(), currentEmployeeSave.getPassword());
					
					clearScreen();
					System.out.println("Appointment request added: " + Arrays.toString(employeeTemp.getCalendar()));
					employeeData.set(indexof, employeeTemp);
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				} else {
					// If employee not found
					displayMessage("**ERROR: Employees not available**");
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				}
			}

		case 2:
			// Retrieves the name of current customer and attaches the purpose
			// of the appointment
			for (Customer currenCusName : currentCustomer) {
				customerName = currenCusName.getCustomerName();
				dataTogether = customerName + " - Credit Card - ";
				appointment[0] = dataTogether;
			}

			// Finds employee and adds a calendar note
			for (Employee currentEmployeeSave : employeeData) {
				if (currentEmployeeSave.getUsername().equals("emp1")) {
					employeeTemp = new Employee(currentEmployeeSave.getEmployeeName(),
							currentEmployeeSave.getEmployeeAddress(), currentEmployeeSave.getWorkHours(),
							currentEmployeeSave.getPastAppointments(), currentEmployeeSave.getEmployeeSpecialization(),
							appointment, currentEmployeeSave.getUsername(), currentEmployeeSave.getPassword());

					clearScreen();
					System.out.println("Appointment request added: " + Arrays.toString(employeeTemp.getCalendar()));
					employeeData.set(indexof, employeeTemp);
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				} else if (currentEmployeeSave.getUsername().equals("employee2")) {
					employeeTemp = new Employee(currentEmployeeSave.getEmployeeName(),
							currentEmployeeSave.getEmployeeAddress(), currentEmployeeSave.getWorkHours(),
							currentEmployeeSave.getPastAppointments(), currentEmployeeSave.getEmployeeSpecialization(),
							appointment, currentEmployeeSave.getUsername(), currentEmployeeSave.getPassword());

					System.out.println("Appointment request added: " + Arrays.toString(employeeTemp.getCalendar()));
					employeeData.set(indexof, employeeTemp);
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				} else {
					// If employee not found
					displayMessage("**ERROR: Employees not available**");
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				}
			}
		case 3:
			// Retrieves the name of current customer and attaches the purpose
			// of the appointment
			for (Customer currenCusName : currentCustomer) {
				customerName = currenCusName.getCustomerName();
				dataTogether = customerName + " - Mortgage - ";
				appointment[0] = dataTogether;
			}

			// Finds employee and adds a calendar note
			for (Employee currentEmployeeSave : employeeData) {
				if (currentEmployeeSave.getUsername().equals("emp1")) {
					employeeTemp = new Employee(currentEmployeeSave.getEmployeeName(),
							currentEmployeeSave.getEmployeeAddress(), currentEmployeeSave.getWorkHours(),
							currentEmployeeSave.getPastAppointments(), currentEmployeeSave.getEmployeeSpecialization(),
							appointment, currentEmployeeSave.getUsername(), currentEmployeeSave.getPassword());

					clearScreen();
					System.out.println("Appointment request added: " + Arrays.toString(employeeTemp.getCalendar()));
					employeeData.set(indexof, employeeTemp);
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				} else if (currentEmployeeSave.getUsername().equals("employee2")) {
					employeeTemp = new Employee(currentEmployeeSave.getEmployeeName(),
							currentEmployeeSave.getEmployeeAddress(), currentEmployeeSave.getWorkHours(),
							currentEmployeeSave.getPastAppointments(), currentEmployeeSave.getEmployeeSpecialization(),
							appointment, currentEmployeeSave.getUsername(), currentEmployeeSave.getPassword());

					System.out.println("Appointment request added: " + Arrays.toString(employeeTemp.getCalendar()));
					employeeData.set(indexof, employeeTemp);
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				} else {
					// If employee not found
					displayMessage("**ERROR: Employees not available**");
					pressEnterToReturn();
					customerMenu(customerData, employeeData, managerData, currentCustomer);
				}
			}

		case 4:
			displayMessage("Returning to main menu\n");
			pressEnterToReturn();
			customerMenu(customerData, employeeData, managerData, currentCustomer);

		default:
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			requestAppointment(customerData, employeeData, managerData, currentCustomer);
		}

	}

	/*
	 * Employee processes customer applications
	 */
	public void processApplications(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData,
			List<Employee> currentEmployee) {
		clearScreen();
		int option = 0;
		Employee employeeTemp = null;
		String[] calendar = null;
		String[] clearField = new String[1];
		clearField[0] = null;
		String temp = null;
		// Getting a calendar entry and assigning it to a temporary value
		for (Employee calendarData : currentEmployee) {
			calendar = calendarData.getCalendar();
			temp = Arrays.toString(calendar);
		}
		// Makes sure that there is an application waiting to be processed
		if (temp.equals("[null]")) {
			displayMessage("**ERROR: No applications found**");
			pressEnterToReturn();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);

		} else {
		}
		System.out.print("Application:\n" + Arrays.toString(calendar)
				+ "\n\nSelect one of the available option:\n1.Approve\n2.Decline\n3.Refer to manager\n");
		option = inputInt();

		switch (option) {
		// Approve application
		case 1:
			clearScreen();
			// Get current employee data to retrieve the calendar
			for (Employee employeeApprove : currentEmployee) {
				calendar = employeeApprove.getCalendar();
				temp = Arrays.toString(calendar);

				// Assign past appointments and current resolved appointment to
				// an array
				String pastAppointments = employeeApprove.getPastAppointments();
				pastAppointments = pastAppointments + "\n" + temp + "Approved";

				// Add array with past appointments and current resolved
				// appointment
				// Clear calendar
				employeeTemp = new Employee(employeeApprove.getEmployeeName(), employeeApprove.getEmployeeAddress(),
						employeeApprove.getWorkHours(), pastAppointments, employeeApprove.getEmployeeSpecialization(),
						clearField, employeeApprove.getUsername(), employeeApprove.getPassword());
				currentEmployee.clear();
				currentEmployee.add(employeeTemp);
				clearScreen();
				System.out.println("Application approved: \n" + temp + "Approved");
			}
			pressEnterToContinue();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);

			// Decline application
		case 2:
			clearScreen();
			// Search through curentEmployee to get his calendar
			for (Employee employeeDecline : currentEmployee) {
				calendar = employeeDecline.getCalendar();
				temp = Arrays.toString(calendar);

				// Assign past appointments and current resolved appointment to
				// an array
				String pastAppointments = employeeDecline.getPastAppointments();
				pastAppointments = pastAppointments + "\n" + temp + "Declined";

				// Add array with past appointments and current resolved
				// appointment
				// Clear calendar
				employeeTemp = new Employee(employeeDecline.getEmployeeName(), employeeDecline.getEmployeeAddress(),
						employeeDecline.getWorkHours(), pastAppointments, employeeDecline.getEmployeeSpecialization(),
						clearField, employeeDecline.getUsername(), employeeDecline.getPassword());
				currentEmployee.clear();
				currentEmployee.add(employeeTemp);
				clearScreen();
				System.out.println("Application Declined: \n" + temp + "Declined");
			}
			pressEnterToContinue();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);

			// Refer application to manager
		case 3:
			clearScreen();
			// Search for the customer application and assign it to manager
			for (Employee employeeRefer : currentEmployee) {
				calendar = employeeRefer.getCalendar();
				managerApplication = calendar;
			}
			System.out.println("Application: " + Arrays.toString(calendar) + " referred to manager\n");

			// Clear employees calendar
			for (Employee employeeDecline : currentEmployee) {
				String pastAppointments = employeeDecline.getPastAppointments();
				pastAppointments = pastAppointments + "\n" + temp + "Refered to Manager";
				
				employeeTemp = new Employee(employeeDecline.getEmployeeName(), employeeDecline.getEmployeeAddress(),
						employeeDecline.getWorkHours(), pastAppointments,
						employeeDecline.getEmployeeSpecialization(), clearField, employeeDecline.getUsername(),
						employeeDecline.getPassword());
				currentEmployee.clear();
				currentEmployee.add(employeeTemp);
			}

			pressEnterToContinue();
			clearScreen();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);
			// Incorrect input
		default:
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			pressEnterToContinue();
			employeeMenu(customerData, employeeData, managerData, currentEmployee);
		}
	}

	/*
	 * Used by the customer to edit his/her personal details TODO CAN MAKE
	 * EDITING MORE EFFICENT
	 */
	public void customerDataEdit(List<Customer> customerData, List<Employee> employeeData, List<Manager> managerData,
			List<Customer> currentCustomer) {
		int option = 0;

		displayMessage(
				"\nPlease select one of the available options:\n1.Edit name\n2.Edit current address\n3.Change password\n4.Return\n");
		option = inputInt();
		switch (option) {

		// Case 1: Change First name and surname
		// TODO ADD a verification system empty name or contains numbers no good
		// TODO Auto format name and surname
		case 1:
			clearScreen();
			displayMessage("Please input your first name:\n");
			String firstName = inputString();
			displayMessage("Please input your surname:\n");
			String surname = inputString();

			// Search through current user
			for (Customer currentCustomerData : currentCustomer) {
				// Adding first name and surname to new linked list and
				// replacing the old one with it
				Customer customer01 = new Customer(firstName + " " + surname, currentCustomerData.getCustomerAddress(),
						currentCustomerData.getAccountNumber(), currentCustomerData.getAccountBalance(),
						currentCustomerData.getRecentTransactions(), currentCustomerData.getFinancialServices(),
						currentCustomerData.getUsername(), currentCustomerData.getPassword());
				currentCustomer.remove(0);
				currentCustomer.add(customer01);
			}
			clearScreen();
			System.out.println("Name change successful\nNew Name:" + firstName + " " + surname);
			pressEnterToReturn();
			customerMenu(customerData, employeeData, managerData, currentCustomer);

			// Case 2: Address Change
		case 2:
			String addressFirstLine;
			String postCode;
			clearScreen();
			displayMessage("Please input the first line of your address(e.g. 20 Town Rd):\n");
			addressFirstLine = inputStringWithSpaces();
			displayMessage("Please input your postcode:\n");
			postCode = inputStringWithSpaces();

			// Search through current user
			for (Customer currentCustomerAddress : currentCustomer) {
				// Adding address to new linked list and replacing the old one
				// with it
				Customer customer01 = new Customer(currentCustomerAddress.getCustomerName(),
						addressFirstLine + " " + postCode, currentCustomerAddress.getAccountNumber(),
						currentCustomerAddress.getAccountBalance(), currentCustomerAddress.getRecentTransactions(),
						currentCustomerAddress.getFinancialServices(), currentCustomerAddress.getUsername(),
						currentCustomerAddress.getPassword());
				currentCustomer.remove(0);
				currentCustomer.add(customer01);
			}
			System.out.println("\n\nAddress change successful\nNew address: \n" + addressFirstLine + " " + postCode);
			pressEnterToContinue();
			customerMenu(customerData, employeeData, managerData, currentCustomer);

			// Case 3: Change current user password
		case 3:
			// Search through current user
			// TODO Input current password before being allows to change it ? ?
			// ?
			clearScreen();
			String password;
			String password2;
			displayMessage("Please input your new password:\n");
			password = inputString();
			displayMessage("Please re-enter your password:\n");
			password2 = inputString();
			if (password.equals(password2)) {
				for (Customer currentCustomerAddress : currentCustomer) {
					// Replacing the old password
					Customer customer01 = new Customer(currentCustomerAddress.getCustomerName(),
							currentCustomerAddress.getCustomerAddress(), currentCustomerAddress.getAccountNumber(),
							currentCustomerAddress.getAccountBalance(), currentCustomerAddress.getRecentTransactions(),
							currentCustomerAddress.getFinancialServices(), currentCustomerAddress.getUsername(),
							password);
					currentCustomer.remove(0);
					currentCustomer.add(customer01);
				}
				displayMessage("Your password has been changed successfully ");
				pressEnterToContinue();
				clearScreen();
				customerMenu(customerData, employeeData, managerData, currentCustomer);

			} else {
				displayMessage("**ERROR: Entered passwords are different**\n");
				pressEnterToReturn();
				customerDataEdit(customerData, employeeData, managerData, currentCustomer);
			}

			// case 4: Return customer to customerMenu
		case 4:
			displayMessage("Returning to your menu screen");
			pressEnterToContinue();
			clearScreen();
			customerMenu(customerData, employeeData, managerData, currentCustomer);

			// User Input not recognised
		default:
			displayMessage("**ERROR: Input not recognised**\n      Please try again");
			customerDataEdit(customerData, employeeData, managerData, currentCustomer);
		}
	}

	/*
	 * Used to output messages
	 */
	public static void displayMessage(String message) {
		System.out.print(message);
	}

	/*
	 * Used to get user input in String form
	 */
	public static String inputString() {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.next();
		return userInput;
	}

	/*
	 * Used to get user input in integer form
	 */
	public static int inputInt() {
		Scanner scan = new Scanner(System.in);
		if (scan.hasNextInt()) {// Checks if user input is in integer form
			int userInput = scan.nextInt();
			return userInput;
		} else {
			int userInput = 0;
			return userInput;

		}
	}

	/*
	 * Used to get user input in String form and allows spaces
	 */
	public static String inputStringWithSpaces() {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		return userInput;
	}

	/*
	 * Pauses the system and waits for user input
	 */
	public static void pressEnterToContinue() {
		displayMessage("\nPress ENTER to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	/*
	 * Pauses the system and waits for user input
	 */
	public static void pressEnterToReturn() {
		displayMessage("\nPress ENTER to return...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	/*
	 * Gives the impression of clearing the screen
	 */
	public static void clearScreen() {
		for (int i = 0; i < 25; ++i)
			System.out.println();
	}

}
