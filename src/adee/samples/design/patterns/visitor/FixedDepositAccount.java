package adee.samples.design.patterns.visitor;

import java.util.Random;

public class FixedDepositAccount extends AbstractAccount {

	private AccountDetails accountDetails;

	public FixedDepositAccount(String customerName) {
		// LOAD details from database ;
		this.accountDetails = new AccountDetails("F/D", String.valueOf(new Random().nextInt(Integer.MAX_VALUE)),
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
