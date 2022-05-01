package Payment;

public class Customer {
	
	private String webshopId;
	private String customerId;
	private String customerName;
	private String customerAddress;
	
	public Customer(String webshopId, String customerId, String customerName, String customerAddress) {
		this.webshopId = webshopId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	
	public String getWebsopId() {
		return webshopId;
	}
	
	public void setWebshopId(String webshopId) {
		this.webshopId = webshopId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
}
