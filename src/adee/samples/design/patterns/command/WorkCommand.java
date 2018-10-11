package adee.samples.design.patterns.command;

public class WorkCommand implements Command {

	private Office office;

	public WorkCommand(Office office) {
		this.office = office;
	}

	@Override
	public void execute() {
		this.office.laptop();
		this.office.work();
	}
}
