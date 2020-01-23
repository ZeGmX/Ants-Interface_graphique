package ant.board;


import ant.Simulator;
import ant.board.Cell;
import ant.object.Ant;
import ant.object.Pos;
import ant.syntax.*;

public abstract class CheckingCircled {
	
	private static Pos[] pos_to_check;
	
	private static void init_pos_list(Ant ant) {
		pos_to_check = new Pos[6];
		for(int i = 0; i < 6; i ++) {
			pos_to_check[i] = Sensedir.posAhead(ant.pos, i);	
		}
	}
	
	private static boolean is_circled(Ant ant) {
		init_pos_list(ant);
		int i = 0;
		int cmpt = 0;
		Cell tested = Simulator.board.getCell(pos_to_check[i]); 
		while(i < 6 && tested.hasAnt() && (tested.antOfCell().color == ! ant.color)) {
			i++;
			cmpt ++;
			tested = Simulator.board.getCell(pos_to_check[i]);
		}
		return (cmpt > 4);
	}
	
	private static void update_score(Ant ant) {
		int curr_home = Simulator.board.getCell(ant.pos).cellHome();
		if(ant.food && curr_home > -1) {
			Simulator.board.incrscore(curr_home == 1);
			Simulator.board.incrscore(curr_home == 1);
			Simulator.board.incrscore(curr_home == 1);
		}
	}
	
	public static void checkDead() {
		for(int i = 0; i < Simulator.antsList.size(); i++) {
			if(is_circled(Simulator.antsList.get(i))) {
				update_score(Simulator.antsList.get(i));
				Simulator.board.getCell(Simulator.antsList.get(i).pos).cellIncrFood(3);
				Simulator.board.getCell(Simulator.antsList.get(i).pos).removeAnt();
				Simulator.antsList.remove(i);
			}
		}
	}
	
}
