package snakeMovement;

import java.util.ArrayList;

import materials.Egg;
import materials.Keyboard;

/**
 * This class extends the class Movement. As a consequence, it contains all the
 * necessary tools to make a monitored movement of the snake possible. The
 * difference with the class Monitored is that the player will use the touches
 * QSDZ of the keyboard instead of 'up', 'right', 'left', and 'down'.
 * 
 * @author t.lahire
 */
public class MonitoredDuo extends Movement {

	/**
	 * This constructor initializes the attributes of the super class Movement
	 * 
	 * @param egg
	 * @param allEggs1
	 * @param allEggs
	 */
	public MonitoredDuo(Egg egg, ArrayList<Egg> allEggs1, ArrayList<Egg> allEggs) {
		super(egg, allEggs1, allEggs);
	}

	/**
	 * This method allows the player to control his/her snake
	 * 
	 * @param egg0 The last-but-one position occupied by the snake
	 */
	public void move(Egg egg0) {
		if (egg.alive == true) {
			double abs = egg0.x;
			double ord = egg0.y;
			double x1 = egg.x;
			double y1 = egg.y;
			switch (Keyboard.getLastKeyCode()) {
			case Q:
				go_left();
				break;
			case Z:
				go_up();
				break;
			case D:
				go_right();
				break;
			case S:
				go_down();
				break;
			default:
				// When the player doesn't press any key, the snake follows the last direction.
				if (x1 - abs > 0 & y1 == ord) {
					// The snake is moving horizontally from left to right.
					go_right();
				}
				if (x1 - abs < 0 & y1 == ord) {
					// The snake is moving horizontally from right to left.
					go_left();
				}
				if (x1 == abs & y1 - ord > 0) {
					// The snake is moving vertically from up to down.
					go_down();
				}
				if (x1 == abs & y1 - ord < 0) {
					// The snake is moving vertically from down to up.
					go_up();
				}
			}

			egg.updatePosition();

		} else {
			// If the snake is dead, nothing has to be done
		}
	}
}