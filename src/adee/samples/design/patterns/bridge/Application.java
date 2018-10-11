package adee.samples.design.patterns.bridge;

public class Application {

	public static void main(String[] args) {
		Mode digitalMode = new DigitalMode();
		Mode analogMode = new AnalogMode();

		Watch tommy = new TommyHilfiger(digitalMode);
		tommy.run();
		Watch titan = new Titan(analogMode);
		titan.run();
		Watch fossil = new Fossil(digitalMode);
		fossil.run();
	}

}
