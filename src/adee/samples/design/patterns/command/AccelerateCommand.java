package adee.samples.design.patterns.command;

public class AccelerateCommand implements Command {

	private Car car;

	public AccelerateCommand(Car car) {
		this.car = car;
	}

	@Override
	public void execute() {
		this.car.getInCar();
		this.car.startCar();
		this.car.accelerate();
	}
}
