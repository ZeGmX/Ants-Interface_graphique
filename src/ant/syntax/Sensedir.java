package ant.syntax;

import ant.object.Pos;
import ant.parser.visitor.GJNoArguDepthFirst;

public abstract class Sensedir {

	public static class Parser extends GJNoArguDepthFirst<Sensedir> {
		
		public Sensedir visit(ant.parser.syntaxtree.Sensedir n) {
			return n.nodeChoice.choice.accept(this);
		}

		public Sensedir visit(ant.parser.syntaxtree.Here n) {
			return new Here();
		}

		public Sensedir visit(ant.parser.syntaxtree.Ahead n) {
			return new Ahead();
		}

		public Sensedir visit(ant.parser.syntaxtree.LeftAhead n) {
			return new LeftAhead();
		}

		public Sensedir visit(ant.parser.syntaxtree.RightAhead n) {
			return new RightAhead();
		}

	}
	
	/** Return the position ahead the position p for the
	 * angle angle
	 * @param p
	 * @param angle
	 * @return
	 */
	public static Pos posAhead(Pos p, int angle) {
		int x = p.x;
		int y = p.y;
		switch(angle) {
			case(0):
				x -= 2;
				break;
			case(1):
				x -= 1;
				y -= 1;
				break;
			case(2):
				x += 1;
				y -= 1;
				break;
			case(3):
				x += 2;
				break;
			case(4):
				x += 1;
				y += 1;
				break;
			case(5):
				x -= 1;
				y += 1;
				break;
			default :
				break;
		}
		Pos new_pos = new Pos(x, y);
		return new_pos;
	}
	
	// Retourne la position Pos de la cellule qui est pointée par notre direction
	public abstract Pos posDir(Pos p, int angle);
	

}
