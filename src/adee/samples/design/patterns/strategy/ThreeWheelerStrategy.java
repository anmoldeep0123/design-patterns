package adee.samples.design.patterns.strategy;

public class ThreeWheelerStrategy implements DrivingStrategy{

	@Override
	public void drive() {
		System.out.println("Driving a 3 wheeler");	
	}

}