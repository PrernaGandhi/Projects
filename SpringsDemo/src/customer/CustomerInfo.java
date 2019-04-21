package customer;

public class CustomerInfo {
	private int custId;
	private String custName;
	private String custCity;
	private int custAge;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public void displayInfo(){
		System.out.println("customerId :: " + custId + "\ncustName :: " + custName 
				+ "\ncustAge :: " + custAge + "\ncustCity :: " + custCity);
	}
}
