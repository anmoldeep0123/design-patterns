package adee.samples.design.patterns.visitor;

import java.util.Random;

public class CurrentAccount extends AbstractAccount {

	private AccountDetails accountDetails;

	public CurrentAccount(String customerName) {
		// LOAD details from database ;
		this.accountDetails = new AccountDetails("C/A", String.valueOf("CA" + new Random().nextInt(Integer.MAX_VALUE)),
				customerName);
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	@Override
	public AccountDetails accept(BankVisitor bankVisitor) {
		return bankVisitor.visit(this);
	}

}
