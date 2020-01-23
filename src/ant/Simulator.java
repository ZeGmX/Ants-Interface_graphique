package ant;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import ant.board.Board;
import ant.board.Cell;
import ant.board.CheckingCircled;
import ant.object.Ant;
import ant.object.Pos;
import ant.syntax.Program;

public abstract class Simulator {

	public static final int turnNumber = 100000;
	public static Program prog1;
	public static Program prog2;
	public static Board board;
	public static int currNbTurn = 0;

	public static List<Ant> antsList;
	
	/** "Parse" les deux fichiers .brain dont le nom
	 * est passé en ligne de commande, affiche un message
	 * d'erreur en cas d'echec et initialise board avec
	 * le constructeur de la classe Board en lui donnant
	 * en paramètre le nom du fichier .world
	 * @param arg
	 */
	public static void init(String[] arg) {
		
		try {
			
			java.io.InputStream in2 = new FileInputStream(arg[1]);
            prog1 = ant.parser.Parser.run(in2);

           
            java.io.InputStream in3 = new FileInputStream(arg[2]);
            prog2 = ant.parser.Parser.run(in3);
			
			
		} catch (Throwable e) {
			System.out.println("Ant Main failed: " + e.getMessage());
		}
		
		board = new Board(arg[0]);
		antsList = new ArrayList<Ant>();
		launchSimul();
	}
	
	
	/** point d'entrée du programme qui prend
	 *  en argument la liste de chaines de caractères
	 *  écrites en ligne de commande directement après
	 *  le nom du fichier.java. Simule une partie entre
	 *  les deux programmes .brain
	 * @param arg
	 */
	public static void main(String[] arg) {
		init(arg);
		oneGame();
		board.disp_scores();
	}
	
	
	/** Lance la simulation d'une partie pour le 
	 * tableau board ; initialise la liste ants_list
	 * avec toutes les fourmis présentes sur le board
	 * et pour chaque fourmis, lui donne le bon point 
	 * d'entrée du programme
	 * @param board
	 */
	public static void launchSimul() {
		antsList = new ArrayList<Ant>();
		int w = board.width();
		int h = board.height();
		for(int y = 0; y < h; y++) {
			for(int x = (y%2); x < 2 * w; x+=2) {
				Cell c = board.getCell(new Pos(x,y));
				if(c != null && c.hasAnt()) {	
					Ant ant = c.antOfCell();
					antsList.add(ant);
					ant.setLabel(prog1, prog2);
				}
			}
		}
	}
	
	
	/** Simule une partie de turnNumber tours
	 * pour le tableau board et les fourmis de
	 * ants_list
	 */
	public static void oneGame() {
		Ant[] arr = new Ant[antsList.size()];
		for(int i = 0; i < antsList.size(); i++) {
			arr[i] = antsList.get(i);
		}
		for(int i = 0; i < turnNumber; i++) {
			oneTour();
		}
	}
	
	public static void oneGameFrom(int currTour) {
		Ant[] arr = new Ant[antsList.size()];
		for(int i = currTour; i < antsList.size(); i++) {
			arr[i] = antsList.get(i);
		}
		for(int i = 0; i < turnNumber; i++) {
			oneTour();
		}
	}
	
	/** Simule un tour pour le tableau board 
	 * et les fourmis de ants_list
	 */
	public static void oneTour() {
		for(int j = 0; j < antsList.size(); j++) {
			oneExecForOneAnt(j);
		}
		currNbTurn++;
	}

	/** Simule un tour pour le tableau board 
	 * et la fourmi numero ant_id de ants_list
	 */
	public static void oneExecForOneAnt(int ant_id) {
		antsList.get(ant_id).act(prog1, prog2, board);
		CheckingCircled.checkDead();
	}

}

