package adee.samples.design.patterns.adapter;

public class OTPICICIDeliveryImpl implements OTPICICIDelivery{

	@Override
	public boolean deliver(String phoneNumber, String message, int numberRetries) {
		System.out.println("Delivering to ICICI Account");
		return true;
	}
}
