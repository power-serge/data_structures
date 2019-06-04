package classes_demo;

public class Shape implements ShapeInter {
	private String color;
	private String type;
	

	// tell the color of the shape
	public void color() {
		System.out.println(color);

	}

	// says which type of shape
	public void type() {
		System.out.println(type);
	}

	public int perimeter() {
		return 0;
	}

}
