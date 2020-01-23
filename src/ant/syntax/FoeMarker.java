package ant.syntax;

import ant.board.Cell;

public class FoeMarker extends Cond {
	
	@Override
	public String toString() {
		return "FoeMarker";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		for(int i = 0; i < 12; i++) {
			if(tested.cellMarked(!color, i)) {
				return true;
			}
		}
		return false;
	}

}
