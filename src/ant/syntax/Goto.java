package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public class Goto extends Instruction {
	public final String label;

	public Goto(int sourceLine, String label) {
		super(sourceLine);
		this.label = label;
	}	

	@Override
	public String toString() {
		return "Goto "+label;
	}

	@Override
	public void execute(Ant ant, Board board) {
		ant.label = label;
		ant.currentLine = 0;
	}

}
