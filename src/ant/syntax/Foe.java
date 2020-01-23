package ant.syntax;

import ant.board.Cell;

public class Foe extends Cond {

	@Override
	public String toString() {
		return "Foe";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		return (tested.hasAnt() && color != tested.antOfCell().color);
	}
}
