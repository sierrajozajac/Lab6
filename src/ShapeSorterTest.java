import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape e = new Circle("eCircle", 17);
		Shape d = new EquilateralTriangle("dTriangle", 20);
		Shape b = new Square("bSquare", 9);
		Shape c = new Trapezoid("cTrapezoid", 2, 2, 5, 7);
		Shape a = new Rectangle("aRectangle", 8, 14);
		
		sorter.addShape(e);
		sorter.addShape(d);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(a);
		
		sorter.sortShapes();
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(4), e);
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("a", 4, 3); //12
		Shape b = new Square("b", 9); //81
		Shape c = new Rectangle("c", 2, 1); //2
		Shape d = new Square("d", 6); //36
		
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes(new ShapeAreaComparator());
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), b);
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new EquilateralTriangle("a", 20.0); // 60
		Shape b = new Trapezoid("b", 2.0, 3.0, 3.0, 8.0); // 16
		Shape c = new Rectangle("c", 10.0, 1.0); // 21
		Shape d = new Square("d", 20.0); // 80
		
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes(new ShapePerimeterComparator());
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		Shape a = new Rectangle("a", 9.0, 2.0);
		Shape b = new Square("b", 3.0);
		
		ShapeSorter sorter = new ShapeSorter();
		
		sorter.addShape(a);
		sorter.addShape(b);
		
		String ret = "Rectangle\t" + "ID = a\t" 
				+ "area = " + 18.000 + "\t" + "perimeter = " + 22.000
				+ "\n" + "Square\t" + "ID = b\t"
				+ "area = " + 9.000 + "\t" + "perimeter = " + 12.000 + "\n";
		
		Assert.assertEquals("ToString method created wrong output.", ret, sorter.toString());
	}
}
