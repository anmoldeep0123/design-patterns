package adee.samples.design.patterns.templateMethod;

public class OnboardingClient {
	public static void main(String[] args) {
		Onboarding fg = new FGOnboarding();
		fg.onboardSteps();
		System.out.println("*************************");
		Onboarding mob = new MobileTeamOnboarding();
		mob.onboardSteps();
	}
}
