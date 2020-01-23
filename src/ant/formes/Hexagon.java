package ant.formes;


import javafx.scene.paint.Color;

public class Hexagon extends Polygon {
	
	private static double radius = 20;
	private static final Point[] hexShape = {new Point(0, radius), new Point(Math.sqrt(3) / 2 * radius, radius / 2), new Point(Math.sqrt(3) / 2 * radius, - radius / 2), new Point(0, - radius), new Point(- Math.sqrt(3) / 2 * radius, - radius / 2), new Point(- Math.sqrt(3) / 2 * radius, radius / 2)};
	
	public Hexagon(Point position, Color color) {
		super(hexShape, position, 0, color, true);
	}
	
	
	public void changeRadius(double radius) {
		Point[] hexShape = {new Point(0, radius), new Point(Math.sqrt(3) / 2 * radius, radius / 2), new Point(Math.sqrt(3) / 2 * radius, - radius / 2), new Point(0, - radius), new Point(- Math.sqrt(3) / 2 * radius, - radius / 2), new Point(- Math.sqrt(3) / 2 * radius, radius / 2)};
		this.shape = hexShape; 
		
	}
}
