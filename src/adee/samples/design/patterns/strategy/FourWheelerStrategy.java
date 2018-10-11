package adee.samples.design.patterns.strategy;

public class FourWheelerStrategy implements DrivingStrategy {

	@Override
	public void drive() {
		System.out.println("Driving a 4 wheeler");
	}

}