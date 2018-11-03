package adee.samples.java8.firstLambda;

public class Printer {

	public static void print(String documentType, DocumentPrinter printer) {
		printer.printDocument(documentType);
	}
}
