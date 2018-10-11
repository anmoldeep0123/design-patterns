package adee.samples.design.patterns.adapter;

import java.util.List;

public class OTPAdapterForICICI implements OTPHDFCDelivery {

	private OTPICICIDelivery otpICICIDelivery = new OTPICICIDeliveryImpl();

	public boolean deliver(List<String> phoneNumbers, String message, String numberOfRetries) {
		boolean success = true;
		for (String phoneNumber : phoneNumbers) {
			boolean _success = otpICICIDelivery.deliver(phoneNumber, message, Integer.parseInt(numberOfRetries));
			if (!_success) {
				success = false;
			}
		}
		return success;
	}

}
