package ant.syntax;

import ant.object.Pos;

public class LeftAhead extends Sensedir {

	@Override
	public String toString() {
		return "LeftAhead";
	}
	
	@Override
	public Pos posDir(Pos p, int angle) {
		return super.posAhead(p, (angle+5)%6);
	}

}
