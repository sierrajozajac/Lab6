public class Square extends Rectangle {

	/**
	 * The square constructor
	 * 
	 * @param id The created shape's name id.
	 * @param size The square's sides length.
	 */
	public Square(String id, double size) {
		super(id, size, size);
	}
	
	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Square"
	 */
	@Override
	public String getShapeType() {
		return "Square";
	}

}
