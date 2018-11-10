package adee.samples.design.patterns.templateMethod;

public class FGOnboarding extends Onboarding{

	@Override
	protected void deskAllocation() {
		System.out.println("Assign desk at RMZ");
		
	}

	@Override
	protected void equipmentsDistribution() {
		System.out.println("Assign Lenovo laptops only.");
		
	}

	@Override
	protected void inductionTrainings() {
		System.out.println("Application training.");
		
	}
	
}
