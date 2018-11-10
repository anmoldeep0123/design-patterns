package adee.samples.design.patterns.visitor;

public abstract class AbstractAccount implements Account {

	protected AccountDetails accountDetails;

	public abstract AccountDetails accept(BankVisitor bankVisitor);

	@Override
	public void printPassBook() {
		System.out.println("Printing Passbook : " + accountDetails.getAccountType() + " Customer ID "
				+ accountDetails.getCustomerId());
	}
}
