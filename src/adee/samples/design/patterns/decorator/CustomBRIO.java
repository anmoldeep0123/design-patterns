package adee.samples.design.patterns.decorator;

public class CustomBRIO extends CarDecorator {

	public CustomBRIO(Car car) {
		super(car);
	}
	
	@Override
	public void assemble() {
		super.assemble();
		addCustomFeatures();
	}

	private void addCustomFeatures() {
		System.out.println("Adding Custom Features BRIO");	
	}
}
