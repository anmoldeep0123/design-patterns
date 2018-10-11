package adee.samples.design.patterns.command;

public class BrakeCommand implements Command {

	private Car car;

	public BrakeCommand(Car car) {
		this.car = car;
	}

	@Override
	public void execute() {
		this.car.brake();
	}
}
