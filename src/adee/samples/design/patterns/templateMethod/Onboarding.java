package adee.samples.design.patterns.templateMethod;

public abstract class Onboarding {
	
	public final void onboardSteps() {
		employeeAccountCreation();
		collectDocuments();
		equipmentsDistribution();
		inductionTrainings();
		deskAllocation();
		display();
	}

	public void display() {
		System.out.println("Employee Onboarded.");
		
	}

	protected abstract void deskAllocation();

	protected abstract void equipmentsDistribution();

	protected abstract void inductionTrainings();

	protected void employeeAccountCreation() {
		System.out.println("Employee account created.");
	}

	protected void collectDocuments() {
		System.out.println("Documents collected at the main building.");
		
	}

	
}
