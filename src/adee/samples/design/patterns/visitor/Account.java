package adee.samples.design.patterns.visitor;

public interface Account {

	public AccountDetails accept(BankVisitor bankVisitor);
	
	public void printPassBook();
}
