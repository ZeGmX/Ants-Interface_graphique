package ant.formes;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Polygon extends Shape {
	protected Point[] shape; 
	protected double rotation; 
	protected Boolean filled; 
	protected Paint stroke;

	
	public Polygon(Point[] shape, Point position, double rotation, Color color, Boolean filled) {

		super(position,color);
		this.shape = new Point[shape.length];
		for (int i=0; i<shape.length; i++) this.shape[i] = shape[i].copy();
		this.rotation = rotation;
		this.filled = filled;

		// recherche le sommet à l'extrémité gauche-haut
		Point origin = shape[0].copy();
		for (Point p : shape) {
			if (p.getX() < origin.getX())
				origin.setX(p.getX());
			if (p.getY() < origin.getY())
				origin.setY(p.getY());
		}
		
		// ce sommet devient l'origine
		for (Point p : shape) {
			p.setX(p.getX() - origin.getX());
			p.setY(p.getY() - origin.getY());
		}

	}
	
	public void scale(double factor) {
		for (Point p: this.shape) {
			p.setX(factor*p.getX());
			p.setY(factor*p.getY());
		}
	}

	// calcule la liste des sommets du polygone, dans sa configuration suivante 
	public Point[] getPoints() {

		Point center = findCenter();
		Point[] points = new Point[shape.length];
		int i = 0;
		for (Point p : shape) {
			double x = ((p.getX() - center.getX()) * Math.cos(Math.toRadians(rotation)))
					- ((p.getY() - center.getY()) * Math.sin(Math.toRadians(rotation))) + center.getX() / 2
					+ position.getX();
			double y = ((p.getX() - center.getX()) * Math.sin(Math.toRadians(rotation)))
					+ ((p.getY() - center.getY()) * Math.cos(Math.toRadians(rotation))) + center.getY() / 2
					+ position.getY();
			points[i++] = new Point(x, y);
		}

		return points;

	}
	
	private static Point[] translatePoints(Point[] points, Point vect) {
		Point[] res = new Point[points.length];
		for (int i=0; i<points.length; i++)
			res[i] = points[i].translate(vect);
		return res;
	}
	
	private static List<Point[]> generateAllCopies(Point[] points, double height, double width) {
		List<Point[]> res = new ArrayList<>();
		res.add(points);
		assert(points.length>0);
		double min_x = points[0].getX();
		double max_x = points[0].getX();
		double min_y = points[0].getY();
		double max_y = points[0].getY();
		for (Point p: points) {
			double x = p.getX();
			double y = p.getY();
			if (min_x>x) min_x = x;
			if (max_x<x) max_x = x;
			if (min_y>y) min_y = y;
			if (max_y<y) max_y = y;
		}
		if (min_x<0) res.add(translatePoints(points,new Point(width,0)));
		if (max_x>width) res.add(translatePoints(points,new Point(-width,0)));
		if (min_y<0) res.add(translatePoints(points,new Point(0,height)));
		if (max_y>height) res.add(translatePoints(points,new Point(0,-height)));
		return res;
	}

	/**
	 * Teste si un point appartient au polygone
	 * 
	 */
	public boolean contains(Point point) {

		Point[] points = getPoints();
		double crossingNumber = 0;
		for (int i = 0, j = 1; i < shape.length; i++, j = (j + 1) % shape.length) {
			if ((((points[i].getX() < point.getX()) && (point.getX() <= points[j].getX()))
					|| ((points[j].getX() < point.getX()) && (point.getX() <= points[i].getX())))
					&& (point.getY() > points[i].getY() + (points[j].getY() - points[i].getY())
							/ (points[j].getX() - points[i].getX()) * (point.getX() - points[i].getX()))) {
				crossingNumber++;
			}
		}

		return crossingNumber % 2 == 1;

	}

	public boolean contains(Polygon polygon) {
		Point[] points = polygon.getPoints();
		for (Point p: points)
			if (this.contains(p)) return true;
		return false;
	}
	
	/**
	 * Applique une rotation 
	 */
	public void rotate(int degrees) {
		rotation = (rotation + degrees) % 360;
	}

	private double findArea() {
		double sum = 0;

		for (int i = 0, j = 1; i < shape.length; i++, j = (j + 1) % shape.length) {
			sum += shape[i].getX() * shape[j].getY() - shape[j].getX() * shape[i].getY();
		}

		return Math.abs(sum / 2);

	}

	private Point findCenter() {

		Point sum = new Point(0, 0);
		for (int i = 0, j = 1; i < shape.length; i++, j = (j + 1) % shape.length) {
			sum.setX(sum.getX() + (shape[i].getX() + shape[j].getX())
					* (shape[i].getX() * shape[j].getY() - shape[j].getX() * shape[i].getY()));
			sum.setY(sum.getY() + (shape[i].getY() + shape[j].getY())
					* (shape[i].getX() * shape[j].getY() - shape[j].getX() * shape[i].getY()));

		}
		double area = findArea();

		return new Point(Math.abs(sum.getX() / (6 * area)), Math.abs(sum.getY() / (6 * area)));

	}

	public double getRotation() {

		return rotation;

	}

	public void draw(GraphicsContext gc) {
		int temp_length;
		double width = gc.getCanvas().getWidth();
		double height = gc.getCanvas().getHeight();

		this.position.reframe(width, height);
		List<Point[]> polygons = generateAllCopies(getPoints(),height,width);
		
		for (Point[] polygon : polygons) {
			temp_length = polygon.length;
			double[] xPoints = new double[temp_length];
			double[] yPoints = new double[temp_length];

			for (int i = 0; i < temp_length; i++) {
				xPoints[i] = Math.round(polygon[i].getX());
				yPoints[i] = Math.round(polygon[i].getY());
			}

			if (filled) {
				gc.setFill(this.color);
				gc.setStroke(this.stroke);
				gc.fillPolygon(xPoints, yPoints, temp_length);
				gc.strokePolygon(xPoints, yPoints, temp_length);
			} else {
				gc.setStroke(this.stroke);
				gc.strokePolygon(xPoints, yPoints, temp_length);
			}
		}
	}

	public void setStroke(Paint stroke) {
		this.stroke = stroke;		
	}

}
