package adee.samples.design.patterns.command;

public class Car {

	public void brake() {
		System.out.println("Applying Brakes");
	}

	public void turn() {
		System.out.println("Turning");
	}

	public void getInCar() {
		System.out.println("Entering Car");
	}

	public void startCar() {
		System.out.println("Starting Car");
	}

	public void accelerate() {
		System.out.println("Accelerating");
	}
}
