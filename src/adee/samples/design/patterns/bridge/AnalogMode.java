package adee.samples.design.patterns.bridge;

public class AnalogMode implements Mode {

	@Override
	public void run() {
		System.out.println("Running in Mode : Analog");
	}
}
