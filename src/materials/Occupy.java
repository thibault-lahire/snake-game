package materials;

import java.util.ArrayList;

/**
 * This class contains one static method dedicated to knowing if a position is
 * occupied or free
 * 
 * @author t.lahire
 */
public class Occupy {

	/** A constant to define the square in which the snakes live */
	public static final double WINDOW_SIZE = Game.WINDOW_SIZE;

	/**
	 * This static method tests if a position is occupied or free
	 * 
	 * @param abs     Abscissa of the point that has to be tested
	 * 
	 * @param ord     Ordinate of the point that has to be tested
	 * 
	 * @param allEggs List of all the positions occupied by the two snakes when the
	 *                method is called
	 */
	public static boolean is_free(double abs, double ord, ArrayList<Egg> allEggs) {
		boolean res = true;
		if (abs < 0 || abs > WINDOW_SIZE) {
			res = false;
		}
		if (ord < 0 || ord > WINDOW_SIZE) {
			res = false;
		}
		for (Egg egg : allEggs) {
			if (egg.x == abs && egg.y == ord) {
				res = false;
			}
		}
		return res;
	}
}
