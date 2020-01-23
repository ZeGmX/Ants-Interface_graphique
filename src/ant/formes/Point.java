package ant.formes;


public class Point {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point copy() {
		return new Point(this.x, this.y);
	}
	
	public Point scale(double coeff) {
		return new Point(this.x*coeff,this.y*coeff);
	}

	public Point translate(Point vector) {
		return new Point(this.x+vector.x,this.y+vector.y);
	}
	
	public double length() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}

	public double distance(Point p) {
		double x = this.x - p.x;
		double y = this.y - p.y;
		return Math.sqrt(x*x + y*y);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void reframe(double width, double height) {
		if (this.getX()<0) this.setX(this.getX()+width);
		if (this.getX()>width) this.setX(this.getX()-width);
		if (this.getY()<0) this.setY(this.getY()+width);
		if (this.getY()>height) this.setY(this.getY()-width);
	}
}
