//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com

import java.util.LinkedList;
import java.util.List;

public class LocalBankBranch {
	//Linked lists which will store customer, employee and manager data
	private List<Customer> customerData = new LinkedList<Customer>();
	private List<Employee> employeeData = new LinkedList<Employee>();
	private List<Manager> managerData = new LinkedList<Manager>();
	private String[] calendar = new String[1];
	private String[] calendar1 = new String[1];
	
	
	public void dataInitialization(){
		//Customer test data
		Customer customer01 = new Customer("Andy Brown", "222 Town rd L90AC", 1234, 310.12,"ATM Withdrawal: -£15\nPayment; Mortgage: -£200\nPayment; British Gas: -£30" ,"Mortgage, Loan", "cus1", "1");
		Customer customer02 = new Customer("Amber Black", "10 Someroad rd M812A", 9812, 1204.39, "ATM Withdrawal: -£20\nATM Withdrawal: -£40\nPayment; Tesco: -£21.50","n/a", "user2", "pass2");
		
		
		customerData.add(customer01);
		customerData.add(customer02);
		
		//Employee test data
		//Calendar 1 was created to ease testing of application process
		calendar1 [0] = "Rebeca Murphy - Loan -";
		Employee employee01 = new Employee("Mat Szy", "asd asd 123", "9am-3pm, Monday-Friday", "Mike Ho - Mortgage Loan - Approved\nJonathan Light - Credit Card - Approved\nLee Smith - Car Loan - Denied", "Finance",calendar, "emp1", "p1");
		Employee employee02 = new Employee("Andy Hello", "30 Love Lane PO1R90", "9am-5pm, Monday-Friday", "Mat Lee - Mortgage Loan - Denied\nEmma Hall - Car Loan - Approved", "Customer Support/Loans", calendar1, "employee2", "password");
		
		
		employeeData.add(employee01);
		employeeData.add(employee02);
		
		//Manager test data 
		Manager manager01 = new Manager("manager1", "1234");
		managerData.add(manager01);
		
		
		
		new CustomerRecordSystem().mainMenu(customerData, employeeData, managerData);
	}
	
	
	
	
	
	// TODO Declare LinkedList
	
	// TODO initialise LinkedList(Add sample data)
	
	

}
