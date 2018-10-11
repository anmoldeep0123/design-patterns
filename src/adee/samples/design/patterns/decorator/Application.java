package adee.samples.design.patterns.decorator;

public class Application {

	public static void main(String[] args) {
		Car brio = new Brio();
		brio.assemble();
		Car polo = new Polo();
		polo.assemble();
		Car customBrio = new CustomBRIO(brio);
		customBrio.assemble();
		Car customPolo = new CustomPolo(polo);
		customPolo.assemble();
	}
}
