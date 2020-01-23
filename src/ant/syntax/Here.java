package ant.syntax;

import ant.object.Pos;

public class Here extends Sensedir {

	@Override
	public String toString() {
		return "Here";
	}
	
	@Override
	public Pos posDir(Pos p, int angle) {
		return p;
	}

}
