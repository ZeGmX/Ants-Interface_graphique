package ant.syntax;

import ant.board.Cell;

public class Home extends Cond {

	@Override
	public String toString() {
		return "Home";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		if (color) {
			return (tested.cellHome() == 1);
		}
		return (tested.cellHome() == 0);
	}
	
}
