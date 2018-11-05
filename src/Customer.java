//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com
public class Customer {
	private String customerName;
	private String customerAddress;
	private int accountNumber;
	private double accountBalance;
	private String recentTransactions;
	private String financialServices;
	private String username;
	private String password;

	/*
	 * Constructor
	 */
	public Customer(String customerName, String customerAddress, int accountNumber, double accountBalance,
			String recentTransactions,String financialServices, String username, String password) {
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.recentTransactions = recentTransactions;
		this.financialServices = financialServices;
		this.username = username;
		this.password = password;
	}

	/*
	 * set and get customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	/*
	 * set and get customerAddress
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	/*
	 * set and get accountNumber
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	/*
	 * set and get accountBalance
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	/*
	 * set and get recentTransactions
	 */
	public void setRecentTransactions(String recentTransactions) {
		this.recentTransactions = recentTransactions;
	}

	public String getRecentTransactions() {
		return recentTransactions;
	}
	
	/*
	 * set and get financialServices
	 */
	
	public void setFinancialServices(String financialServices){
		this.financialServices = financialServices;
	}
	
	public String getFinancialServices(){
		return financialServices;
	}

	/*
	 * set and get username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	/*
	 * set and get password
	 */
	public void setPassword(String password) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	/*
	 * Displays the values of objects not their memory address (non-Javadoc)
	 */
	@Override
	public String toString() {
		return (this.getCustomerName() + " " + this.getCustomerAddress() + " " + this.getAccountNumber() + " "
				+ this.getAccountBalance() + this.getRecentTransactions() + this.getFinancialServices());
	}
}
