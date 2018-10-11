package adee.samples.design.patterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public final static String NUM_RETRIES = "3";
	private static OTPHDFCDelivery otpHDFC = null;

	public static void main(String[] args) {
		List<String> phoneNumbers = new ArrayList<>();
		phoneNumbers.add("9632538096");
		phoneNumbers.add("9980199801");
		String message = "SOME DUMMY MESSAGE";
		sendOTPForHDFC(phoneNumbers, message);
		sendOTPForICICI(phoneNumbers, message);

	}

	private static void sendOTPForHDFC(List<String> phoneNumbers, String message) {
		otpHDFC = new OTPHDFCDeliveryImpl();
		otpHDFC.deliver(phoneNumbers, message, NUM_RETRIES);
	}

	private static void sendOTPForICICI(List<String> phoneNumbers, String message) {
		otpHDFC = new OTPAdapterForICICI();
		otpHDFC.deliver(phoneNumbers, message, NUM_RETRIES);
	}
}
