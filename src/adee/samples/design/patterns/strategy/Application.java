package adee.samples.design.patterns.strategy;

public class Application {

	public static void main(String[] args) {
		Context c = new Context();
		c.setDrivingStrategy(new TwoWheelerStrategy());

		User[] users = new User[5];
		for (int i = 0; i < 5; i++) {
			users[i] = new User();
			users[i].setCtx(c);
		}

		// drive two wheelers
		drive(users);
		c.setDrivingStrategy(new ThreeWheelerStrategy());
		// drive two wheelers
		drive(users);
		c.setDrivingStrategy(new FourWheelerStrategy());
		// drive four wheelers
		drive(users);
	}

	private static void drive(User[] twoWheelers) {
		for (User u : twoWheelers) {
			u.drive();
		}
	}
}
