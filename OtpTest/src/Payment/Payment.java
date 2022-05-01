package Payment;

public class Payment {
	
	private String webshopId;
	private String customerId;
	private String type;
	private int sum;
	private String accountNumber;
	private String cardNumber;
	private String date;
	
	public Payment(String webshopId, String customerId, String type, int sum, String accountNumber, String cardNumber, String date) {
		this.webshopId = webshopId;
		this.customerId = customerId;
		this.type = type;
		this.sum = sum;
		this.accountNumber = accountNumber;
		this.cardNumber = cardNumber;
		this.date = date;
	}

	public String getWebshopId() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
