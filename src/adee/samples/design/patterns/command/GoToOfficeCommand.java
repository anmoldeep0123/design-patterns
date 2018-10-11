package adee.samples.design.patterns.command;

public class GoToOfficeCommand implements Command {

	private Office office;

	public GoToOfficeCommand(Office office) {
		this.office = office;
	}

	@Override
	public void execute() {
		this.office.go();
		this.office.goToFloor();
	}
}
