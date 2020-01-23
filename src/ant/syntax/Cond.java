package ant.syntax;

import ant.board.Cell;
import ant.parser.visitor.GJNoArguDepthFirst;

public abstract class Cond {

	public static class Parser extends GJNoArguDepthFirst<Cond> {
		
		public Cond visit(ant.parser.syntaxtree.Cond n) {
			return n.nodeChoice.choice.accept(this);		
		}

		public Cond visit(ant.parser.syntaxtree.Friend n) {
			return new Friend();
		}

		public Cond visit(ant.parser.syntaxtree.Foe n) {
			return new Foe();
		}

		public Cond visit(ant.parser.syntaxtree.FriendWithFood n) {
			return new FriendWithFood();
		}

		public Cond visit(ant.parser.syntaxtree.FoeWithFood n) {
			return new FoeWithFood();

		}

		public Cond visit(ant.parser.syntaxtree.Food n) {
			return new Food();

		}

		public Cond visit(ant.parser.syntaxtree.Rock n) {
			return new Rock();

		}

		public Cond visit(ant.parser.syntaxtree.Marker n) {
			return new Marker(Integer.parseInt(n.litInt.nodeChoice.choice.toString()));

		}

		public Cond visit(ant.parser.syntaxtree.FoeMarker n) {
			return new FoeMarker();

		}

		public Cond visit(ant.parser.syntaxtree.Home n) {
			return new Home();

		}

		public Cond visit(ant.parser.syntaxtree.FoeHome n) {
			return new FoeHome();

		}

	}

	// Chaque condition implémente une méthode vérifiant si la condition est vraie dans la cellule tested
	public abstract boolean test(Cell tested, boolean color);
}
