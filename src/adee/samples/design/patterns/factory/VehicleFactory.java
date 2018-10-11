package adee.samples.design.patterns.factory;

public class VehicleFactory {

	public static Vehicle getVehicle(String vehicleType) {
		if (vehicleType.equals("car")) {
			return new Car();
		} else if (vehicleType.equals("bike")) {
			return new Bike();
		} else if (vehicleType.equals("truck")) {
			return new Truck();
		} else {
			return null;
		}
	}
}
