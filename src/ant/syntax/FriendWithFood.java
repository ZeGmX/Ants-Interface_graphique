package ant.syntax;

import ant.board.Cell;

public class FriendWithFood extends Cond {
	
	@Override
	public String toString() {
		return "FriendWithFood";
	}

	@Override
	public boolean test(Cell tested, boolean color) {
		return(tested.hasAnt() && color == tested.antOfCell().color && tested.antOfCell().food);
	}

}
