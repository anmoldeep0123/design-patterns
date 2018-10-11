package adee.samples.design.patterns.adapter;

import java.util.List;

public interface OTPHDFCDelivery {

	public boolean deliver(List<String> phoneNumbers , String message , String numberOfRetries);
}
