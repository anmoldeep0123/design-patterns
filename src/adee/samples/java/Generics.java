package adee.samples.java;

public interface Generics<Q, R, S> {

	public R method1(Q q1, S s1);

	public S method2(R r1, Q q1);
}
