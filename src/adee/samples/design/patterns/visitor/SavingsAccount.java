package adee.samples.design.patterns.visitor;

import java.util.Random;

public class SavingsAccount extends AbstractAccount {

	public SavingsAccount(String customerName) {
		// LOAD details from database ;
		this.accountDetails = new AccountDetails("S/A", "SA" + String.valueOf(new Random().nextLong()), customerName);
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	@Override
	public AccountDetails accept(BankVisitor bankVisitor) {
		return bankVisitor.visit(this);
	}
}
