package ant.syntax;

import ant.object.Pos;

public class RightAhead extends Sensedir {

	@Override
	public String toString() {
		return "RightAhead";
	}

	@Override
	public Pos posDir(Pos p, int angle) {
		return super.posAhead(p, (angle+1)%6);
	}
	
}
