public class Rectangle extends Polygon {

	/*
	 * The variables storing the width and height for the rectangle
	 */
	private double width;
	private double height;
	
	/**
	 * The rectangle constructor
	 * 
	 * @param id The created shape's name id.
	 * @param height The height of the rectangle.
	 * @param width The width of the rectangle
	 */
	public Rectangle(String id, double height, double width) {
		super(id);
		super.sideLengths.add(height);
		super.sideLengths.add(height);
		this.height = height;
		super.sideLengths.add(width);
		super.sideLengths.add(width);
		this.width = width;
	}
	
	/**
	 * Gets the area of the shape
	 * 
	 * Area of a rectangle = width * height
	 * 
	 * @return Area of rectangle
	 */
	@Override
	public double getArea() {
		double ret = width * height;
		return ret;
	}
	
	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Rectangle"
	 */
	@Override
	public String getShapeType() {
		return "Rectangle";
	}

}
