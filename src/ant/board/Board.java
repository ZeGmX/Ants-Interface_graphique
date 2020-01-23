package ant.board;
import ant.object.Ant;
import ant.object.Pos;
import ant.object.Marker;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Board {
	public int scoreRed; // Score de la premiere équipe
	public int scoreBlack; // Score de la deuxième équipe 
	public Cell[][] tab; // Tableau de cellules décrivant world et l'état actuel du jeu
	
	// Taille de la fenêtre
	private int width; 
	private int height;
	
	/** Initialise un tableau selon le world du fichier de nom file
	 * @param file
	 */
	public Board(String file) {
		
		// Lecture du fichier 
		ArrayList<String[]> linesList = new ArrayList<String[]>();
		try {
			java.io.InputStream in1 = new FileInputStream(file);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(in1))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] separated = line.split(" ");
					linesList.add(separated);
					//System.out.println(separated.length);
				}
			}
		} catch (Throwable e) {
			System.out.println("Ant Main failed: " + e.getMessage());
		}
		
		String[] widthStr = (String[]) linesList.get(1); //l'indice 0 correspond au zoom
		String[] heightStr = (String[]) linesList.get(2);
		int width = (int) Integer.parseInt(widthStr[0]); 
		int height = (int) Integer.parseInt(heightStr[0]);
		
		// Initialisation des différents champs
		this.tab = new Cell[2 * width][height];
		this.width = width;
		this.height = height;
		this.scoreBlack = 0;
		this.scoreRed = 0;
	
		// Objets permettant d'initialiser les cellules
		Pos pos;
		int home ; //-1 pour une case normale, 0 pour une base noire, 1 pour une base rouge
		Marker marker;
		boolean rock;
		Ant ant;
		int nbFood;
		
		// Parcours du tableau
		for (int y = 0 ; y < height ; y++) { 
			String[] separated = (String[]) linesList.get(y + 3);	
			for (int x = 0 ; x < width ; x++) {

				// Initialisation d'une cellule :
				home = -1; //-1 pour une case normale, 0 pour une base noire, 1 pour une base rouge
				marker = new Marker();
				rock = false;
				ant = null;
				nbFood = 0;
				
				String caseChar;
				
				// Ecriture d'une case sur deux en fonction de la parité de y
				// (permettant de représenter les hexagones)
				if (y % 2 == 1) {
					caseChar = separated[x + 1];
					pos = new Pos(2 * x + 1, y);
				} else {
					caseChar = separated[x];
					pos = new Pos(2 * x, y);
				}
				
				
				switch(caseChar) {
				case ".": // il n'y a rien
					break;
				case "+": //base rouge
					home = 1;
					if (y % 2 == 0) {
						ant = new Ant(2 * x, y, true);
					} else {
						ant = new Ant(2 * x + 1, y, true);
					}
					break;
				case "-": //base noire
					home = 0;
					if (y % 2 == 0) {
						ant = new Ant(2 * x, y, false);
					} else {
						ant = new Ant(2 * x + 1, y, false);
					}
					break;
				case "#": // rock
					rock = true;
					break;
				default: // case contenant de la nourriture
					nbFood = Integer.parseInt(caseChar);
					break;
				}
				
				
				Cell currentCell = new Cell(pos, nbFood, home, marker, rock, ant);
				
				// On place la cellule au bon endroit
				if (y % 2 == 0) {
					this.tab[2 * x][y] = currentCell;
				} else {
					this.tab[2 * x + 1][y] = currentCell;
				}
				
			}
		}
	}
	
	/** Renvoie la fourmi présente sur la 
	 * cellule si il y en a une, null sinon
	 * @param ant
	 * @return
	 */
	public Cell antToCell(Ant ant) {
		if (ant != null) {
			Pos pos = ant.pos;
			return this.getCell(pos);
		}
		return null;
	}
	
	/** Renvoie la cellule de coordonnée
	 * pos
	 * @param pos
	 * @return
	 */
	public Cell getCell(Pos pos) {
		int x = pos.x;
		int y = pos.y;
		return this.tab[x][y];
		
	}
	
	
	public int width() {
		return this.width;
	}
	
	public int height() {
		return this.height;
	}
	
	public void incrscore(boolean color) {
		if(color) {
			this.scoreRed += 1;
		}
		else {
			this.scoreBlack += 1;
		}
	}
	
	public void decrScore(boolean color) {
		if(color) {
			this.scoreRed -= 1;
		}
		else {
			this.scoreBlack -= 1;
		}
	}
	

	
	public void disp_scores() {
		System.out.println("Red Score:");
		System.out.println(this.scoreRed);
		System.out.println("Black Score:");
		System.out.println(this.scoreBlack);
		
	}
		
}
