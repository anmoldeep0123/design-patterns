package adee.samples.design.patterns.bridge;

public class Titan extends Watch {

	public Titan(Mode m) {
		super(m);
	}

	@Override
	protected void run() {
		System.out.println("Running Titan : ");
		this.mode.run();
	}
}
