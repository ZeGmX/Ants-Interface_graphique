package ant.board;

import ant.object.*;

public class Cell {
	private Pos pos;
	private int food = 0;
	private int home; // -1 : not a home, 0 : black home, 1 : red home
	private Marker marker;
	private boolean rock;
	private Ant ant;
	
	public Cell(Pos pos, int food, int home, Marker marker, boolean is_rock, Ant ant) {
		this.pos = pos;
		this.food = food;
		this.home = home;
		this.marker = marker;
		this.rock = is_rock;
		this.ant = ant;
	}
	
	public Pos getPos() {
		return this.pos;
	}
	
	public boolean cellHasFood() {
		return(this.food > 0);
	}
	
	public int cellFood() {
		return this.food;
	}
	
	public int cellHome() {
		return(this.home);
	}

	
	public boolean cellIsRock() {
		return(this.rock);
	}
	
	public void cellDropFood() {
		(this.food)++;
	}
	
	public void cellGetFood() {
		if(this.food > 0) {
			this.food --;
		}
	}

	public void cellIncrFood(int n) {
		this.food += n;
	}
	
	public void setCellHome(int color) {
		this.home = color;
	}
	
	
	public Ant antOfCell() {
		return this.ant;
	}
	
	public void addAnt(Ant ant){
		this.ant = ant;
	}
	
	public void removeAnt() {
		this.ant = null;
	}
	
	public boolean hasAnt() {
		return (this.ant != null);
	}
	
	public boolean marked() {
		for(int i = 0; i < 6; i++) {
			if(this.cellMarked(true,i) ||this.cellMarked(false, i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean cellMarked(boolean color, int i) {
		if(color) {
			return (this.marker).checkRedMarker(i);
		}
		else {
			return (this.marker).checkBlackMarker(i);
		}
	}
	
	public void setMarker(boolean color, int i) {
		(this.marker).setMarker(i, color);
	}
	
	public void unsetMarker(boolean color, int i) {
		(this.marker).unsetMarker(i, color);
	}
	
	public String stringMark() {
		return this.marker.toString();
	}
	
	
}

