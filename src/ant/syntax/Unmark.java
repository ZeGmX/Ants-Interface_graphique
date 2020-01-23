package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public class Unmark extends Instruction {
	public final int i;

	public Unmark(int sourceLine, int i) {
		super(sourceLine);
		this.i = i;
	}	

	@Override
	public String toString() {
		return "Unmark "+i;
	}

	@Override
	public void execute(Ant ant, Board board) {
		(board.getCell(ant.pos)).unsetMarker(ant.color, i);
		ant.currentLine ++;
	}

}
