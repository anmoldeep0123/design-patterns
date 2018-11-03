package adee.samples.java8.firstLambda;

public class Application {

	public static void main(String[] args) {
		Printer.print("B & W Paper", (documentType) -> System.out.println("Printing " + documentType));
		Printer.print("Colored A4 Sheet", (documentType) -> System.out.println("Printing " + documentType));
	}
}
