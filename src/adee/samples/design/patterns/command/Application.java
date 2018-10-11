package adee.samples.design.patterns.command;

public class Application {

	public static void main(String[] args) {
		Car car = new Car();
		Office office = new Office();
		Person person = new Person();

		person.setCommand(new AccelerateCommand(car)).executeCommand();
		person.setCommand(new TurnCommand(car)).executeCommand();

		person.setCommand(new BrakeCommand(car)).executeCommand();

		person.setCommand(new GoToOfficeCommand(office)).executeCommand();
		person.setCommand(new WorkCommand(office)).executeCommand();
	}
}
