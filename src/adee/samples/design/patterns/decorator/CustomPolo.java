package adee.samples.design.patterns.decorator;

public class CustomPolo extends CarDecorator {

	public CustomPolo(Car car) {
		super(car);
	}
	
	@Override
	public void assemble() {
		super.assemble();
		addCustomFeatures();
	}

	private void addCustomFeatures() {
		System.out.println("Adding Custom Features POLO");	
	}
}
