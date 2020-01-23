package ant.syntax;

import ant.board.Cell;

public class FoeHome extends Cond {
	
	@Override
	public String toString() {
		return "FoeHome";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		if (color) {
			return (tested.cellHome() == 0);
		}
		return (tested.cellHome() == 1);
	}

}
