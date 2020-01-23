package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public class Flip extends Instruction {
	public final int p;
	public final String label1;
	public final String label2;

	public Flip(int sourceLine, int p, String label1, String label2) {
		super(sourceLine);
		this.p = p;
		this.label1 = label1;
		this.label2 = label2;
	}

	@Override
	public String toString() {
		return "Flip "+p+" "+label1+" "+label2;
	}
	
	@Override
	public void execute(Ant ant, Board board) {
		int n = (int)(Math.random() * this.p);
		if(n == 0) {
			ant.label = this.label1;
		}
		else {
			ant.label = this.label2;
		}
		ant.currentLine = 0;
	}
}
