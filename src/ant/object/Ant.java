package ant.object;
import ant.board.Board;
import ant.syntax.*;

public class Ant {
	public Pos pos; // position de la fourmi
	public int angle; // angle = 0 pour 0° | 1 pour 60° | 2 pour 120° | 3 pour 180° | 4 pour 240° | 5 pour 300°
	public boolean color; //red = true; black = false
	public int cooldown; // temps à attendre avant le prochain mouvement
	public String label; // nom du bloc de l'execution actuelle
	public int currentLine; // n° de la ligne dans le bloc de l'éxecution actuelle
	public boolean food; // true si la fourmi transporte de la nourriture, faux sinon
	
	public Ant(int x, int y, boolean color) {
		this.pos = new Pos(x, y);
		this.angle = 3;
		this.color = color;
		this.food = false;
		this.cooldown = 0;
		this.currentLine = 0;		
	}
	
	public void changeFood() {
		this.food = !this.food;
	}
	
	/** Initialise le premier label à executer pour this 
	 * en fonction de sa couleur 
	 * @param red_program
	 * @param black_program
	 */
	public void setLabel(Program red_program, Program black_program){
		if (color) {
			this.label = red_program.entry.label;
		} else {
			this.label = black_program.entry.label;
		}

	}
	
	/** Execute l'instruction de numero de ligne this.curr_ligne du bloc this.label
	 * pour la fourmi this en fonction de sa couleur
	 * @param red_program
	 * @param black_program
	 * @param board
	 */
	public void act(Program red_program, Program black_program, Board board) {
		if (cooldown>0) {
			cooldown--;
		} else {
			if (color) {
				red_program.blocks.get(label).instructions.get(currentLine).execute(this, board);
			} else {
				black_program.blocks.get(label).instructions.get(currentLine).execute(this, board);
			}
		}
	}
	
	public boolean foodHasChanged(Ant old) {
		return (this.food != old.food);
	}
	
	
}
