package ant.syntax;
import ant.board.*;
import ant.object.Ant;

public class Drop extends Instruction {

	public Drop(int sourceLine) {
		super(sourceLine);
	}

	@Override
	public String toString() { return "Drop"; }

	@Override
	public void execute(Ant ant, Board board) {
		if(ant.food) {
			board.getCell(ant.pos).cellDropFood();
			ant.changeFood();
			if(board.getCell(ant.pos).cellHome() > -1) {
				board.incrscore(board.getCell(ant.pos).cellHome() == 1);
			}
		}
		ant.currentLine ++;
	}
}
