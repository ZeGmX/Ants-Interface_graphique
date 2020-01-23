package ant.formes;

import ant.board.Cell;
import ant.object.Ant;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Polygon {

	private static int radius = 5;
	private static final Point[] triangleShape = {new Point(- Math.sqrt(3) * radius / 2, radius / 2), new Point(- Math.sqrt(3) * radius / 2, - radius / 2), new Point(radius, 0)};
	
	public Triangle(Point position, Color color, int angle) {
		super(triangleShape, position, angle, color, true);
	}
	
	public void changeRadius(double radius) {
		Point[] triShape = {new Point(- Math.sqrt(3) * radius / 2, radius / 2), new Point(- Math.sqrt(3) * radius / 2, - radius / 2), new Point(radius, 0)};
		this.shape = triShape; 
	}

	public void update(double radius2, GraphicsContext gc, Cell cell) {
		
		Ant newAnt = cell.antOfCell();
		this.position = new ant.formes.Point((1 + newAnt.pos.x) * radius2, (1 + newAnt.pos.y) * radius2 * 2);
		this.rotation = (newAnt.angle - 3) * 60;
		this.draw(gc);
	}

}
