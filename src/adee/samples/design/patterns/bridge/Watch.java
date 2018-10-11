package adee.samples.design.patterns.bridge;

public abstract class Watch {

	protected Mode mode;

	protected Watch(Mode mode) {
		this.mode = mode;
	}
	
	abstract protected void run(); 
}
