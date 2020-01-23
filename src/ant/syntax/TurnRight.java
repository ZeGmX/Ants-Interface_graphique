package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public class TurnRight extends Turn {
	
	public TurnRight(int sourceLine) {
		super(sourceLine);
	}
	
	@Override
	public String toString() {
		return "Turn Right";
	}

	@Override
	public void execute(Ant ant, Board board) {
		ant.angle = (ant.angle + 1) % 6;
		ant.currentLine ++;
	}

}
