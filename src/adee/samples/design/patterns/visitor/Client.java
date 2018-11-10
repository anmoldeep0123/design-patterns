package adee.samples.design.patterns.visitor;

public class Client {

	public static void main(String[] args) {
		BankVisitor visitor = new SBIBankVisitor();

		// new customer form from UI

		Account[] accounts = new Account[] { new SavingsAccount("Anmol Deep"), new CreditCardAccount("Anmol Deep") };
		for (Account account : accounts) {
			account.accept(visitor);
		}
	}
}
