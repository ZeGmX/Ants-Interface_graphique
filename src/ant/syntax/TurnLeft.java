package ant.syntax;
import ant.board.Board;

import ant.object.Ant;

public class TurnLeft extends Turn {

	public TurnLeft(int sourceLine) {
		super(sourceLine);
	}

	@Override
	public String toString() {
		return "Turn Left";
	}
	
	@Override 
	public void execute(Ant ant, Board board) {
		ant.angle = (ant.angle + 5) % 6;
		ant.currentLine ++;
	}
}
