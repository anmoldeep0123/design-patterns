package adee.samples.design.patterns.strategy;

public class User {

	private Context ctx;

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	public void drive() {
		this.ctx.executeDrive();
	}
}
