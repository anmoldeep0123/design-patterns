package adee.samples.design.patterns.factory;

public class Application {

	public static void main(String[] args) {
		Vehicle vehicle = null;
		vehicle = VehicleFactory.getVehicle("bike");
		vehicle.drive();
		
		vehicle = VehicleFactory.getVehicle("car");
		vehicle.drive();
		
		vehicle = VehicleFactory.getVehicle("truck");
		vehicle.drive();
	}
}
