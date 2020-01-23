package ant.syntax;

import ant.board.Board;
import ant.object.Ant;

public abstract class Instruction {
	public final int sourceLine;
	public Instruction(int sourceLine) {
		this.sourceLine = sourceLine;
	}
	
	// Chaque instruction implémente une méthode ayant pour objectif de modifier 
	// l’état de notre fourmi suite à une action précise
	public abstract void execute(Ant ant, Board board) ;
}
