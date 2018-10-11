package adee.samples.design.patterns.adapter;

import java.util.List;

public class OTPHDFCDeliveryImpl implements OTPHDFCDelivery{

	@Override
	public boolean deliver(List<String> phoneNumbers, String message, String numberOfRetries) {
		System.out.println("Delivering to HDFC Account");
		return true;
	}

}
