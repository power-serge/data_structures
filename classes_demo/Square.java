package classes_demo;

public class Square extends Shape implements ShapeInter{
	private int side;
	private String color;
	private String type;
	
	public Square() {
		super();
	}
	
	public Square(int side, String color, String type) {
		this.side = side;
		this.color = color;
		this.type = type;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int perimeter() {
		return side * side;
	}
	
	@Override
	public String toString() {
		return type + " ," + color + ", Perimeter: " + this.perimeter(); 
	}
	
}
