package ant.syntax;

import ant.object.Pos;

public class Ahead extends Sensedir {
	
	@Override
	public String toString() { return "Ahead"; }
	
	@Override
	public Pos posDir(Pos p, int angle) {
		return super.posAhead(p, angle);
	}
}
