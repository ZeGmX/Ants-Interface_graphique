package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public class Mark extends Instruction {
	public final int i;

	public Mark(int sourceLine, int i) {
		super(sourceLine);
		this.i = i;
	}	
	
	@Override
	public String toString() {
		return "Mark "+i;
	}

	@Override
	public void execute(Ant ant, Board board) {
		(board.getCell(ant.pos)).setMarker(ant.color, i);
		ant.currentLine ++;
	}

}
