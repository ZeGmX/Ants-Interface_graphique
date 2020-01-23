package ant.syntax;

import ant.board.Cell;

public class FoeWithFood extends Cond {

	@Override
	public String toString() {
		return "FoeWithFood";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		return (tested.cellHasFood() && tested.hasAnt() && (tested.antOfCell().color == !color));
	}

}
