package snakeMovement;

import java.util.ArrayList;

import materials.Egg;

/**
 * This class extends the class Movement. As a consequence, it contains all the
 * necessary tools to make a random movement of the snake possible. The snake
 * chooses a random direction Forward, left, and right are chosen with
 * probability 1/3. The snake cannot kills itself with a turn back, but it
 * doesn't know where the rest of its tail is located.
 * 
 * @author t.lahire
 */
public class RandomM extends Movement {

	/**
	 * This constructor initializes the attributes of the super class Movement
	 * 
	 * @param egg
	 * @param allEggs1
	 * @param allEggs
	 */
	public RandomM(Egg egg, ArrayList<Egg> allEggs1, ArrayList<Egg> allEggs) {
		super(egg, allEggs1, allEggs);
	}

	/**
	 * This method computes a random movement for the snake
	 * 
	 * @param egg0 The last-but-one position occupied by the snake
	 */
	public void move(Egg egg0) {

		if (egg.alive == true) {

			double rand = Math.random();

			double x0 = egg0.x;
			double y0 = egg0.y;
			double x1 = egg.x;
			double y1 = egg.y;

			// The following code computes the new position of the snake given its two last
			// positions (x0;y0) and (x1;y1)

			if (x1 - x0 >= 0 && y1 == y0) {
				// The snake is moving horizontally from left to right.

				if (rand < 0.33) {
					go_right();
				} else if (rand >= 0.33 && rand < 0.66) {
					go_down();
				} else {
					go_up();
				}
			} else if (x1 - x0 <= 0 && y1 == y0) {
				// The snake is moving horizontally from right to left.

				if (rand < 0.33) {
					go_left();
				} else if (rand >= 0.33 && rand < 0.66) {
					go_down();
				} else {
					go_up();
				}
			} else if (x1 == x0 && y1 >= y0) {
				// The snake is moving vertically from up to down.

				if (rand < 0.33) {
					go_down();
				} else if (rand >= 0.33 && rand < 0.66) {
					go_right();
				} else {
					go_left();
				}
			} else {
				// The snake is moving vertically from down to up.

				if (rand < 0.33) {
					go_up();
				} else if (rand >= 0.33 && rand < 0.66) {
					go_right();
				} else {
					go_left();
				}
			}
			egg.updatePosition();

		} else {
			// If the snake is dead, nothing has to be done
		}
	}
}
