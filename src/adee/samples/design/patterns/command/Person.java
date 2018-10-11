package adee.samples.design.patterns.command;

public class Person {

	private Command command;

	public Person setCommand(Command command) {
		this.command = command;
		return this;
	}

	public void executeCommand() {
		this.command.execute();
	}
}
