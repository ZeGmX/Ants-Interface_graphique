package ant.syntax;

import ant.board.Cell;

public class Friend extends Cond {
	
	@Override
	public String toString() {
		return "Friend";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		return (tested.hasAnt() && color == tested.antOfCell().color);
	}

}
