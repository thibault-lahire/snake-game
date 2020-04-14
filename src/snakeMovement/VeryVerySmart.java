package snakeMovement;

import java.util.ArrayList;

import materials.Egg;
import materials.Occupy;

/**
 * This class extends the class Movement. As a consequence, it contains all the
 * necessary tools to make a very smart movement of the snake possible. The
 * snake knows its own positions and the positions of the other snake. Hence it
 * will never kill itself if it has another option. Moreover, the snake
 * concerned takes the positions of the other snake into account in its
 * movement.
 * 
 * @author t.lahire
 */
public class VeryVerySmart extends Movement {

	/**
	 * This constructor initializes the attributes of the super class Movement
	 * 
	 * @param egg
	 * @param allEggs1
	 * @param allEggs
	 */
	public VeryVerySmart(Egg egg, ArrayList<Egg> allEggs1, ArrayList<Egg> allEggs) {
		super(egg, allEggs1, allEggs);
	}

	/**
	 * This method offers a very smart snake. To choose one of the free directions
	 * among "Forward, Left, and Right", the method evaluates the distance between
	 * the head of the snake and the next position occupied in the direction right,
	 * left or forward. Then, the method chooses the maximum distance, in order to
	 * go in a zone where the possibilities seem to be the most numerous.
	 * 
	 * @param egg0 The last-but-one position occupied by the snake
	 */
	public void move(Egg egg0) {
		if (egg.alive == true) {

			double x0 = egg0.x;
			double y0 = egg0.y;
			double x1 = egg.x;
			double y1 = egg.y;

			if (x1 - x0 > 0 && y1 == y0) {
				// The snake is moving horizontally from left to right.

				double abs_right = x1;
				double ord_right = y1;
				while (Occupy.is_free(abs_right + SIZE, ord_right, allEggs) == true) {
					abs_right = abs_right + SIZE;
				}

				double abs_up = x1;
				double ord_up = y1;
				while (Occupy.is_free(abs_up, ord_up - SIZE, allEggs) == true) {
					ord_up = ord_up - SIZE;
				}

				double abs_down = x1;
				double ord_down = y1;
				while (Occupy.is_free(abs_down, ord_down + SIZE, allEggs) == true) {
					ord_down = ord_down + SIZE;
				}

				double distance_wrt_right = Math
						.sqrt((abs_right - x1) * (abs_right - x1) + (ord_right - y1) * (ord_right - y1));
				double distance_wrt_up = Math.sqrt((abs_up - x1) * (abs_up - x1) + (ord_up - y1) * (ord_up - y1));
				double distance_wrt_down = Math
						.sqrt((abs_down - x1) * (abs_down - x1) + (ord_down - y1) * (ord_down - y1));

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

				if (i == 0) {
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
						if (distance_wrt_right >= distance_wrt_down) {
							go_right();
						} else {
							go_down();
						}
					}
					if (droite == false) {
						if (distance_wrt_up >= distance_wrt_down) {
							go_up();
						} else {
							go_down();
						}
					}
					if (bas == false) {
						if (distance_wrt_right >= distance_wrt_up) {
							go_right();
						} else {
							go_up();
						}
					}
				}
				if (i == 3) {
					if (distance_wrt_right >= distance_wrt_up && distance_wrt_right >= distance_wrt_down) {
						go_right();
					} else if (distance_wrt_up >= distance_wrt_right && distance_wrt_up >= distance_wrt_down) {
						go_up();
					} else {
						go_down();
					}
				}
			}

			else if (x1 - x0 < 0 && y1 == y0) {
				// The snake is moving horizontally from right to left.

				double abs_left = x1;
				double ord_left = y1;
				while (Occupy.is_free(abs_left - SIZE, ord_left, allEggs) == true) {
					abs_left = abs_left - SIZE;
				}

				double abs_up = x1;
				double ord_up = y1;
				while (Occupy.is_free(abs_up, ord_up - SIZE, allEggs) == true) {
					ord_up = ord_up - SIZE;
				}

				double abs_down = x1;
				double ord_down = y1;
				while (Occupy.is_free(abs_down, ord_down + SIZE, allEggs) == true) {
					ord_down = ord_down + SIZE;
				}

				double distance_wrt_left = Math
						.sqrt((abs_left - x1) * (abs_left - x1) + (ord_left - y1) * (ord_left - y1));
				double distance_wrt_up = Math.sqrt((abs_up - x1) * (abs_up - x1) + (ord_up - y1) * (ord_up - y1));
				double distance_wrt_down = Math
						.sqrt((abs_down - x1) * (abs_down - x1) + (ord_down - y1) * (ord_down - y1));

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

				if (i == 0) {
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
						if (distance_wrt_left >= distance_wrt_down) {
							go_left();
						} else {
							go_down();
						}
					}
					if (gauche == false) {
						if (distance_wrt_up >= distance_wrt_down) {
							go_up();
						} else {
							go_down();
						}
					}
					if (bas == false) {
						if (distance_wrt_left >= distance_wrt_up) {
							go_left();
						} else {
							go_up();
						}
					}
				}
				if (i == 3) {
					if (distance_wrt_left >= distance_wrt_up && distance_wrt_left >= distance_wrt_down) {
						go_left();
					} else if (distance_wrt_up >= distance_wrt_left && distance_wrt_up >= distance_wrt_down) {
						go_up();
					} else {
						go_down();
					}
				}
			}

			else if (x1 == x0 && y1 > y0) {
				// The snake is moving vertically from up to down.

				double abs_left = x1;
				double ord_left = y1;
				while (Occupy.is_free(abs_left - SIZE, ord_left, allEggs) == true) {
					abs_left = abs_left - SIZE;
				}

				double abs_right = x1;
				double ord_right = y1;
				while (Occupy.is_free(abs_right + SIZE, ord_right, allEggs) == true) {
					abs_right = abs_right + SIZE;
				}

				double abs_down = x1;
				double ord_down = y1;
				while (Occupy.is_free(abs_down, ord_down + SIZE, allEggs) == true) {
					ord_down = ord_down + SIZE;
				}

				double distance_wrt_left = Math
						.sqrt((abs_left - x1) * (abs_left - x1) + (ord_left - y1) * (ord_left - y1));
				double distance_wrt_right = Math
						.sqrt((abs_right - x1) * (abs_right - x1) + (ord_right - y1) * (ord_right - y1));
				double distance_wrt_down = Math
						.sqrt((abs_down - x1) * (abs_down - x1) + (ord_down - y1) * (ord_down - y1));

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

				if (i == 0) {
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
						if (distance_wrt_left >= distance_wrt_down) {
							go_left();
						} else {
							go_down();
						}
					}
					if (gauche == false) {
						if (distance_wrt_right >= distance_wrt_down) {
							go_right();
						} else {
							go_down();
						}
					}
					if (bas == false) {
						if (distance_wrt_left >= distance_wrt_right) {
							go_left();
						} else {
							go_right();
						}
					}
				}
				if (i == 3) {
					if (distance_wrt_left >= distance_wrt_right && distance_wrt_left >= distance_wrt_down) {
						go_left();
					} else if (distance_wrt_right >= distance_wrt_left && distance_wrt_right >= distance_wrt_down) {
						go_right();
					} else {
						go_down();
					}
				}
			}

			else {
				// The snake is moving vertically from down to up.

				double abs_left = x1;
				double ord_left = y1;
				while (Occupy.is_free(abs_left - SIZE, ord_left, allEggs) == true) {
					abs_left = abs_left - SIZE;
				}

				double abs_right = x1;
				double ord_right = y1;
				while (Occupy.is_free(abs_right + SIZE, ord_right, allEggs) == true) {
					abs_right = abs_right + SIZE;
				}

				double abs_up = x1;
				double ord_up = y1;
				while (Occupy.is_free(abs_up, ord_up - SIZE, allEggs) == true) {
					ord_up = ord_up - SIZE;
				}

				double distance_wrt_left = Math
						.sqrt((abs_left - x1) * (abs_left - x1) + (ord_left - y1) * (ord_left - y1));
				double distance_wrt_right = Math
						.sqrt((abs_right - x1) * (abs_right - x1) + (ord_right - y1) * (ord_right - y1));
				double distance_wrt_up = Math.sqrt((abs_up - x1) * (abs_up - x1) + (ord_up - y1) * (ord_up - y1));

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

				if (i == 0) {
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
						if (distance_wrt_left >= distance_wrt_up) {
							go_left();
						} else {
							go_up();
						}
					}
					if (gauche == false) {
						if (distance_wrt_right >= distance_wrt_up) {
							go_right();
						} else {
							go_up();
						}
					}
					if (haut == false) {
						if (distance_wrt_left >= distance_wrt_right) {
							go_left();
						} else {
							go_right();
						}
					}
				}
				if (i == 3) {
					if (distance_wrt_left >= distance_wrt_right && distance_wrt_left >= distance_wrt_up) {
						go_left();
					} else if (distance_wrt_right >= distance_wrt_left && distance_wrt_right >= distance_wrt_up) {
						go_right();
					} else {
						go_up();
					}
				}
			}

			egg.updatePosition();

		} else {
			// If the snake is dead, nothing has to be done
		}
	}
}
