package ant.syntax;

import ant.board.Board;
import ant.object.Ant;
import ant.object.Pos;

public class Move extends Instruction {
	public final String label_error;

	public Move(int sourceLine, String label_error) {
		super(sourceLine);
		this.label_error = label_error;
	}	

	@Override
	public String toString() {
		return "Move "+label_error;
	}

	@Override
	public void execute(Ant ant, Board board) {
		Pos dir = Sensedir.posAhead(ant.pos, ant.angle);
		if (board.getCell(dir).cellIsRock() || board.getCell(dir).antOfCell() != null) {
			ant.label = label_error;
			ant.currentLine = 0;
		} else {
			Pos old_pos = ant.pos;
			ant.pos = dir;
			board.getCell(ant.pos).addAnt(ant);
			board.getCell(old_pos).removeAnt();
			ant.currentLine ++;
		}
		ant.cooldown += 12;
	}

}
