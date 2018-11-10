package adee.samples.design.patterns.visitor;

import java.util.Random;

public class CreditCardAccount extends AbstractAccount {

	public CreditCardAccount(String customerName) {
		// LOAD details from database ;
		this.accountDetails = new AccountDetails("C/C", String.valueOf("CC" + new Random().nextDouble()), customerName);
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	@Override
	public AccountDetails accept(BankVisitor bankVisitor) {
		return bankVisitor.visit(this);
	}

}
