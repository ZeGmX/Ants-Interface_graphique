package ant.syntax;

import ant.board.Board;
import ant.board.Cell;
import ant.object.Ant;
import ant.object.Pos;

public class Sense extends Instruction {
	public final Sensedir sensedir;
	public final String label1;
	public final String label2;
	public final Cond cond;

	public Sense(int sourceLine, Sensedir sensedir, String label1, String label2, Cond cond) {
		super(sourceLine);
		this.sensedir = sensedir;
		this.label1 = label1;
		this.label2 = label2;
		this.cond = cond;
	}

	@Override
	public String toString() {
		return "Sense "+sensedir+" "+label1+" "+label2+" "+cond;
	}

	@Override
	public void execute(Ant ant, Board board) {
		Pos dir = sensedir.posDir(ant.pos, ant.angle);
		Cell tested = board.getCell(dir);
		if (cond.test(tested, ant.color)) {
			ant.label = label1;
		} else {
			ant.label = label2;
		}
		ant.currentLine = 0;
	}

}
