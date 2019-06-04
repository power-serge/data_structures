package Project1;

public class TestComplex {
	public static void main(String[] args) {
		Complex c1 = new Complex(3, -5);
		Complex c2 = new Complex(8, 7);
		Complex sum = new Complex();
		sum.add(c1, c2);
		Complex diff = new Complex();
		diff.subtract(c1, c2);
		System.out.println("The sum is ");
		Complex.printResult(sum);
		System.out.println("The difference is ");
		Complex.printResult(diff);
	}

}
