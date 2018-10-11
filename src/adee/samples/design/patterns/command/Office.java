package adee.samples.design.patterns.command;

public class Office {

	public void go() {
		System.out.println("Left home - Reaching office");
	}

	public void goToFloor() {
		System.out.println("Reach 6th floor");
	}

	public void laptop() {
		System.out.println("Setting up laptop");
	}

	public void work() {
		System.out.println("Beginning work");
	}
}
