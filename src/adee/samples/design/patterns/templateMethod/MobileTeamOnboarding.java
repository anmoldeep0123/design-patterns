package adee.samples.design.patterns.templateMethod;

public class MobileTeamOnboarding extends Onboarding{

	@Override
	protected void deskAllocation() {
		System.out.println("Assign desk in Bldng 5");
		
	}

	@Override
	protected void equipmentsDistribution() {
		System.out.println("Assign macBook and iphone.");
		
	}

	@Override
	protected void inductionTrainings() {
		System.out.println("Android/IOS training.");
		
	}

}
