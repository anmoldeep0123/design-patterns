package adee.samples.design.patterns.bridge;

public class TommyHilfiger extends Watch {

	public TommyHilfiger(Mode mode) {
		super(mode);
	}

	@Override
	protected void run() {
		System.out.println("Running TommyHilfiger : ");
		this.mode.run();
	}
}
