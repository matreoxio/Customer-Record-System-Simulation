//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com

public class Employee {
	private String employeeName;
	private String employeeAddress;
	private String workHours;
	private String pastAppointments;
	private String employeeSpecialization;
	private String [] calendar = new String[1];
	private String username;
	private String password;
	
	// TODO ADD past appointments-
	
	/*
	 * Constructor
	 */
	public Employee(String employeeName, String employeeAddress, String workHours, String pastAppointments, String employeeSpecialization,String calendar[] ,String username, String password) {
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.workHours = workHours;
		this.pastAppointments = pastAppointments;
		this.employeeSpecialization = employeeSpecialization;
		this.calendar = calendar;
		this.username = username;
		this.password = password; 
	}

	/*
	 * set and get employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	
	/*
	 * set and get employeeAddress
	 */
	public void setEmployeeAddress(String employeeAddress){
		this.employeeAddress = employeeAddress;
	}
	
	public String getEmployeeAddress(){
		return employeeAddress;
	}
	
	/*
	 * set and get workHours
	 */
	public void setWorkHours(String workHours){
		this.workHours = workHours;
	}
	
	public String getWorkHours(){
		return workHours;
	}
	
	/*
	 * set and get appointments
	 */
	public void setPastAppointments(String pastAppointments){
		this.pastAppointments = pastAppointments;
	}
	
	public String getPastAppointments(){
		return pastAppointments;
	}
	
	/*
	 * set and get employeeSpecialization
	 */
	public void setEmployeeSpecialization(String employeeSpecialization){
		this.employeeSpecialization = employeeSpecialization;
	}
	
	public String getEmployeeSpecialization(){
		return employeeSpecialization;
	}
	
	
	public void setCalendar(String[] calendar){
		this.calendar = calendar;
	}
	public String[] getCalendar(){
		return calendar;
	}
	
	
	/*
	 * set and get employee Username
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	/*
	 * set and get employee password
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	/*
	 * Displays the values of objects not their memory address (non-Javadoc)
	 */
	  @Override
	   public String toString() {
	        return (this.getEmployeeName() + " " +  this.getEmployeeAddress() + " " + this.getWorkHours() + " " + this.getPastAppointments() + " " + this.getEmployeeSpecialization() + " " + this.getCalendar());
	   }
	

	
}
