package adee.samples.design.patterns.visitor;

public class SBIBankVisitor implements BankVisitor {

	@Override
	public AccountDetails visit(SavingsAccount sa) {
		sa.printPassBook();
		AccountDetails accountDetails = sa.getAccountDetails();
		// process account details;
		return accountDetails;
	}

	@Override
	public AccountDetails visit(CurrentAccount ca) {
		ca.printPassBook();
		AccountDetails accountDetails = ca.getAccountDetails();
		// process account details;
		return accountDetails;
	}

	@Override
	public AccountDetails visit(FixedDepositAccount fda) {
		fda.printPassBook();
		AccountDetails accountDetails = fda.getAccountDetails();
		// process account details;
		return accountDetails;
	}

	@Override
	public AccountDetails visit(CreditCardAccount cca) {
		cca.printPassBook();
		AccountDetails accountDetails = cca.getAccountDetails();
		// process account details;
		return accountDetails;
	}

}
