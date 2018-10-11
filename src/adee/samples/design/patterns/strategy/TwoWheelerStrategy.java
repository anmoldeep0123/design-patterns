package adee.samples.design.patterns.strategy;

public class TwoWheelerStrategy implements DrivingStrategy {

	@Override
	public void drive() {
		System.out.println("Driving a 2 wheeler");
	}
}
