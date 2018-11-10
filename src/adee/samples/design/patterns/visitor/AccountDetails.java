package adee.samples.design.patterns.visitor;

public class AccountDetails {

	private String accountType;
	private String customerId;
	private String customerName;
	

	public AccountDetails(String accountType, String customerId, String customerName) {
		this.accountType = accountType;
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
}
