package ant.syntax;

import ant.board.Cell;

public class Rock extends Cond {

	@Override
	public String toString() {
		return "Rock";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		return(tested.cellIsRock());
	}
}
