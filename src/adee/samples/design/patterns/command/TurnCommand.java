package adee.samples.design.patterns.command;

public class TurnCommand implements Command {

	private Car car;

	public TurnCommand(Car car) {
		this.car = car;
	}

	@Override
	public void execute() {
		this.car.turn();
	}
}
