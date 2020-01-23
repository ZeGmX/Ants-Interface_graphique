package ant.formes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape extends javafx.scene.Node {

	protected Point position;
	public Color color;
	
	
	public Shape(Point position, Color color) {
		this.position = position;
		this.color = color;
	}
	
	public void translate(Point vector) {
		this.position.setX(this.position.getX()+vector.getX());
		this.position.setY(this.position.getY()+vector.getY());
	}	

	public abstract void draw(GraphicsContext gc);
	

}
