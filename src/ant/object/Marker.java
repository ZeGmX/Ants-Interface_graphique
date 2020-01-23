package ant.object;

public class Marker {
	private boolean[] redmarker; // Tableau de 6 marqueurs rouge
	private boolean[] blackmarker; // Tableau de 6 marqueurs noir
	
	public Marker() {
		boolean[] redmark = new boolean[6];
		boolean[] blackmark = new boolean[6];
		for (int k = 0 ; k < 6 ; k++) {
			redmark[k] = false;
			blackmark[k] = false;
		}
		this.redmarker = redmark;
		this.blackmarker = blackmark;
	}
	
	
	/** Return true if the marker i is red, false if he is not
	 * @param i
	 * @return
	 */
	public boolean checkRedMarker(int i) {
		return (this.redmarker[i]);
	}
	
	/** Return true if the marker i is black, false if he is not
	 * @param i
	 * @return
	 */
	public boolean checkBlackMarker(int i) {
		return (this.blackmarker[i]);
	}
	
	/** Return true if the marker i is marked (red or black), false
	 * if he is not
	 * @param i
	 * @param color
	 * @return
	 */
	public boolean checkColMarker(int i, boolean color) {
		if(color) {
			return checkRedMarker(i);
		}
		else {
			return checkBlackMarker(i);
		}
	}
	
	/** set the marker i corresponding to color at true
	 * @param i
	 * @param color
	 */
	public void setMarker(int i, boolean color) {
		if (color) {
			this.redmarker[i] = true;
		} else {
			this.blackmarker[i] = true;
		}
	}
	
	/** set the marker i corresponding to color at false
	 * @param i
	 * @param color
	 */
	public void unsetMarker(int i, boolean color) {
		if (color) {
			this.redmarker[i] = false;
		} else {
			this.blackmarker[i] = false;
		}
	}
	
	public String toString() {
		String sr = "Marqueur rouge :";
		String sb = "Marqueur noir";
		for (int k = 0 ; k < 6 ; k++) {
			sr += (this.redmarker[k] ? "1" : "0");
			sb += (this.blackmarker[k] ? "1" : "0");
		}
		return (sr + "\n" + sb);
	}
}
