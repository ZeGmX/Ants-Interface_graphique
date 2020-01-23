package ant.syntax;

import ant.board.Cell;

public class Food extends Cond {
	
	@Override
	public String toString() {
		return "Food";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		return tested.cellHasFood();
	}

}
