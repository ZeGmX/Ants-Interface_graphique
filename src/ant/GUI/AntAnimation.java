package ant.GUI;



import ant.Simulator;
import ant.board.Board;
import ant.board.Cell;
import ant.formes.*;
import ant.object.Ant;
import ant.object.Pos;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AntAnimation extends AnimationTimer{
    	
    	public int speed = 0;
    	private int cooldown = 0;
    	private Canvas canvas;
    	private Stage stage;
        private final static int SIZE = 1000;
        private GraphicsContext gc ;
        private double radius ;

		
		public AntAnimation(String[] arg, Canvas canvas, Stage stage) {
			this.canvas = canvas;
			this.stage = stage;
			Simulator.init(arg);
			drawAll(Simulator.board, stage, canvas);
		}
    	

		private void drawAll(Board board, Stage stage, Canvas canvas) {
	        gc = canvas.getGraphicsContext2D();

	        int w = board.width();
			int h = board.height();
			radius = Math.min (SIZE / (2 * w + 1), SIZE / (2 * h + 1));
			
			for (int y = 0 ; y < board.height() ; y++) {
				for (int x = y % 2 ; x < 2 * board.width() ; x += 2) {
					Pos pos = new Pos(x, y);
					Cell cell = board.getCell(pos);
					Ant ant = cell.antOfCell();
					
					double centerX = (1 + x) * radius;
					double centerY = (1 + y) * radius * 2;
					ant.formes.Point center = new ant.formes.Point(centerX, centerY);
					Hexagon hex = new ant.formes.Hexagon(center, Color.FLORALWHITE);
					if (cell.cellHome() == 0) {
						hex.color = Color.GRAY;
					} 
					if (cell.cellHome() == 1) {
						hex.color = Color.RED;
					}
					if (cell.cellIsRock()) {
						hex.color = Color.CADETBLUE;
					}
					if (cell.cellHome() == -1 && ! cell.cellIsRock() && cell.cellFood() > 0) {
						hex.color = Color.GREENYELLOW;
					}
					hex.changeRadius(radius);
					hex.draw(gc);
						
					if (cell.marked()) {
						gc.setFill(Color.SKYBLUE);
						gc.fillOval((1+x)*radius, (1 + y) * 2 * radius, radius/4, radius/2);
					}
					if (ant != null) {
						Color color;
						if (ant.color) {
							color = Color.CRIMSON;
						} else {
							color = Color.DARKGREY;
						}

						
						ant.formes.Triangle tri = new ant.formes.Triangle(new ant.formes.Point((1 + x) * radius, (1 + y) * radius * 2), color, (ant.angle - 3) * 60);
						if (ant.food) {gc.setStroke(Color.GREEN);gc.setLineWidth(3);}
						tri.changeRadius(2 * radius / 3);
						tri.draw(gc);
						gc.setLineWidth(1);
						gc.setStroke(Color.BLACK);
					}
					
					
					if (cell.cellFood() > 0) {
						gc.setFill(Color.BLACK);
						gc.fillText(String.valueOf(cell.cellFood()), (1 + x) * radius, (1 + y) * 2 * radius);
					}
				}
			}

			
			stage.show();
		}


		
		private void dispScores() {
			String s = Integer.toString(Simulator.board.scoreRed);
			AntApp.redScore.setText("Red score : " + s + " ");
			s = Integer.toString(Simulator.board.scoreBlack);
			AntApp.blackScore.setText("Black score : " + s + " ");
			
		}
		
		@Override
		public void handle(long arg0) {
			if (cooldown > 0) {
				cooldown--;

			} else {
				cooldown = speed;
				Simulator.oneTour();
				this.drawAll(Simulator.board, stage, canvas);
				dispScores();


			}
	}

		public void end() {
			this.drawAll(Simulator.board, stage, canvas);
			dispScores();
			
		}
		

}
