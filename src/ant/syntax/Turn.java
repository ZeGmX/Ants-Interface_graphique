package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public abstract class Turn extends Instruction {
	public Turn(int sourceLine) {
		super(sourceLine);
	}

	public abstract void execute(Ant ant, Board board);
}
