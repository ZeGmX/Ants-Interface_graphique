package ant.syntax;

import ant.board.Cell;

public class Marker extends Cond {
	public final int i;

	public Marker(int i) {
		this.i = i;
	}
	
	@Override
	public String toString() {
		return "Marker "+i;
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		return tested.cellMarked(color, i);
	}

}
