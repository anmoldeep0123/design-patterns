package adee.samples.design.patterns.strategy;

public class Context {

	private DrivingStrategy drivingStrategy;

	public DrivingStrategy getDrivingStrategy() {
		return drivingStrategy;
	}

	public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
		this.drivingStrategy = drivingStrategy;
	}

	public void executeDrive() {
		this.drivingStrategy.drive();
	}
}
