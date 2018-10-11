package adee.samples.design.patterns.adapter;

public interface OTPICICIDelivery {

	public boolean deliver(String phoneNumber , String message , int numberRetries);
}
