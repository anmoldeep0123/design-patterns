package adee.samples.design.patterns.visitor;

public interface BankVisitor {

	public AccountDetails visit(SavingsAccount sa);

	public AccountDetails visit(CurrentAccount ca);

	public AccountDetails visit(FixedDepositAccount fda);

	public AccountDetails visit(CreditCardAccount cca);
}
