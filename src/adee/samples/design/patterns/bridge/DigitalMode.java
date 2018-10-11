package adee.samples.design.patterns.bridge;

public class DigitalMode implements Mode {

	@Override
	public void run() {
		System.out.println("Running in Mode : Digital");
	}
}
