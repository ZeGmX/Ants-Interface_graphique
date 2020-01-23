package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public class PickUp extends Instruction {
	public final String label_error;

	public PickUp(int sourceLine, String label_error) {
		super(sourceLine);
		this.label_error = label_error;
	}	

	@Override
	public String toString() {
		return "PickUp "+label_error;
	}
	
	@Override
	public void execute(Ant ant, Board board) {
		if((!board.getCell(ant.pos).cellHasFood() )||(ant.food)) {
			ant.label = this.label_error;
			ant.currentLine = 0;
		}
		else {
			board.getCell(ant.pos).cellGetFood();
			ant.changeFood();
			if(board.getCell(ant.pos).cellHome() > -1) {
				board.decrScore(board.getCell(ant.pos).cellHome() == 1);

			}
			ant.currentLine ++;
		}
		
	}
	

}
