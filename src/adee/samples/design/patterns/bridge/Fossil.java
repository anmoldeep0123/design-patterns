package adee.samples.design.patterns.bridge;

public class Fossil extends Watch {

	public Fossil(Mode m) {
		super(m);
	}

	@Override
	protected void run() {
		System.out.println("Running Fossil : ");
		this.mode.run();
	}
}
