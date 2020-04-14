package snakeMovement;

import java.util.ArrayList;

import materials.Egg;
import materials.Occupy;

/**
 * This class extends the class Movement. As a consequence, it contains all the
 * necessary tools to make a smart movement of the snake possible. The snake
 * always chooses a free direction : it knows its own positions and the
 * positions of the other snake.
 * 
 * @author t.lahire
 */
public class Smart extends Movement {

	/**
	 * This constructor initializes the attributes of the super class Movement
	 * 
	 * @param egg
	 * @param allEggs1
	 * @param allEggs
	 */
	public Smart(Egg egg, ArrayList<Egg> allEggs1, ArrayList<Egg> allEggs) {
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
			// positions (x0;y0) and (x1;y1), the position of its tail and the position of
			// the other snake.

			if (x1 - x0 > 0 && y1 == y0) {
				// The snake is moving horizontally from left to right.

				int i = 0; // i is the number of free directions
				boolean haut = Occupy.is_free(x1, y1 - SIZE, allEggs);
				boolean droite = Occupy.is_free(x1 + SIZE, y1, allEggs);
				boolean bas = Occupy.is_free(x1, y1 + SIZE, allEggs);

				if (haut == true) {
					i++;
				}
				if (droite == true) {
					i++;
				}
				if (bas == true) {
					i++;
				}

				if (i == 0 || i == 3) {
					Movement random = new RandomM(egg, allEggs1, allEggs);
					random.move(egg0);
				}
				if (i == 1) {
					if (haut == true) {
						go_up();
					}
					if (droite == true) {
						go_right();
					}
					if (bas == true) {
						go_down();
					}
				}
				if (i == 2) {
					if (haut == false) {
						if (rand < 0.5) {
							go_right();
						} else {
							go_down();
						}
					}
					if (droite == false) {
						if (rand < 0.5) {
							go_up();
						} else {
							go_down();
						}
					}
					if (bas == false) {
						if (rand < 0.5) {
							go_up();
						} else {
							go_right();
						}
					}
				}
			}

			else if (x1 - x0 < 0 && y1 == y0) {
				// The snake is moving horizontally from right to left.

				int i = 0; // i is the number of free directions
				boolean haut = Occupy.is_free(x1, y1 - SIZE, allEggs);
				boolean gauche = Occupy.is_free(x1 - SIZE, y1, allEggs);
				boolean bas = Occupy.is_free(x1, y1 + SIZE, allEggs);

				if (haut == true) {
					i++;
				}
				if (gauche == true) {
					i++;
				}
				if (bas == true) {
					i++;
				}

				if (i == 0 || i == 3) {
					Movement random = new RandomM(egg, allEggs1, allEggs);
					random.move(egg0);
				}
				if (i == 1) {
					if (haut == true) {
						go_up();
					}
					if (gauche == true) {
						go_left();
					}
					if (bas == true) {
						go_down();
					}
				}
				if (i == 2) {
					if (haut == false) {
						if (rand < 0.5) {
							go_left();
						} else {
							go_down();
						}
					}
					if (gauche == false) {
						if (rand < 0.5) {
							go_up();
						} else {
							go_down();
						}
					}
					if (bas == false) {
						if (rand < 0.5) {
							go_up();
						} else {
							go_left();
						}
					}
				}
			}

			else if (x1 == x0 && y1 > y0) {
				// The snake is moving vertically from up to down.

				int i = 0; // i is the number of free directions
				boolean droite = Occupy.is_free(x1 + SIZE, y1, allEggs);
				boolean gauche = Occupy.is_free(x1 - SIZE, y1, allEggs);
				boolean bas = Occupy.is_free(x1, y1 + SIZE, allEggs);

				if (droite == true) {
					i++;
				}
				if (gauche == true) {
					i++;
				}
				if (bas == true) {
					i++;
				}

				if (i == 0 || i == 3) {
					Movement random = new RandomM(egg, allEggs1, allEggs);
					random.move(egg0);
				}
				if (i == 1) {
					if (droite == true) {
						go_right();
					}
					if (gauche == true) {
						go_left();
					}
					if (bas == true) {
						go_down();
					}
				}
				if (i == 2) {
					if (droite == false) {
						if (rand < 0.5) {
							go_left();
						} else {
							go_down();
						}
					}
					if (gauche == false) {
						if (rand < 0.5) {
							go_right();
						} else {
							go_down();
						}
					}
					if (bas == false) {
						if (rand < 0.5) {
							go_right();
						} else {
							go_left();
						}
					}
				}
			}
			else {
				// The snake is moving vertically from down to up.

				int i = 0; // i is the number of free directions
				boolean droite = Occupy.is_free(x1 + SIZE, y1, allEggs);
				boolean gauche = Occupy.is_free(x1 - SIZE, y1, allEggs);
				boolean haut = Occupy.is_free(x1, y1 - SIZE, allEggs);

				if (droite == true) {
					i++;
				}
				if (gauche == true) {
					i++;
				}
				if (haut == true) {
					i++;
				}

				if (i == 0 || i == 3) {
					Movement random = new RandomM(egg, allEggs1, allEggs);
					random.move(egg0);
				}
				if (i == 1) {
					if (droite == true) {
						go_right();
					}
					if (gauche == true) {
						go_left();
					}
					if (haut == true) {
						go_up();
					}
				}
				if (i == 2) {
					if (droite == false) {
						if (rand < 0.5) {
							go_left();
						} else {
							go_up();
						}
					}
					if (gauche == false) {
						if (rand < 0.5) {
							go_right();
						} else {
							go_up();
						}
					}
					if (haut == false) {
						if (rand < 0.5) {
							go_right();
						} else {
							go_left();
						}
					}
				}
			}

			egg.updatePosition();

		} else {
			// If the snake is dead, nothing has to be done
		}
	}
}
