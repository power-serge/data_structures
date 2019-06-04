package classes_demo;

public class SquareClient {
	public static void main(String[] args) {
		Square square = new Square();
		square.setColor("Blue");
		square.setSide(5);
		square.setType("Square");
		
		System.out.println(square);
		
		square.setColor("Black");
		square.setSide(10);
		square.setType("Square");
		
		System.out.println(square);
	}

}
