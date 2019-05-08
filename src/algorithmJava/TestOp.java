package algorithmJava;

public class TestOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Oprator a = new Oprator(3);
		int b = 5;
		
		int val1 = a.add(b);
		int val2 = a.Sub(b);
		int val3 = a.Multiply(b);
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
	}
}
