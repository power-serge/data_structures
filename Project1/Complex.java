package Project1;

public class Complex {

	private int real;
	private int imaginary;

	Complex() {
		real = 0;
		imaginary = 1;

	}

	Complex(int x, int y) {
		// TODO initialize real and imaginary with the inputs x and y respectively
		real = x;
		imaginary = y;

	}

	public Complex add(Complex x, Complex y) {
		real = x.real + y.real;
		imaginary = x.imaginary + y.imaginary;
		return this;
	}

	public Complex subtract(Complex x, Complex y) {
		real = x.real - y.real;
		imaginary = x.imaginary - y.imaginary;		
		return this;
	}

	public void display() {
		// Display the real and imaginary parts of the given complex number.
		System.out.println("(" + real + "," + imaginary + ")");

	}

	public static void printResult(Complex sum) {
		sum.display(); 		
	}	

}
