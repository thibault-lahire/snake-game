package snakeMovement;

import java.util.ArrayList;

import materials.Egg;
import materials.Game;

/**
 * This abstract class contains all the necessary tools to make the movement of
 * a snake possible
 * 
 * @author t.lahire
 */
public abstract class Movement {

	/**
	 * Standard size for the whole project. It corresponds to the dimensions of an
	 * egg
	 */
	public static final double SIZE = Game.ELEMENT_SIZE;

	/** This egg represents the head of the snake concerned by the movement */
	public Egg egg;

	/**
	 * This list of eggs contains all the positions occupied by the opponent snake
	 */
	public ArrayList<Egg> allEggs1;

	/** This list contains all the positions occupied by the two snakes */
	public ArrayList<Egg> allEggs;

	/**
	 * This constructor initializes the attributes of this abstract class
	 * 
	 * @param egg
	 * @param allEggs1
	 * @param allEggs
	 */
	public Movement(Egg egg, ArrayList<Egg> allEggs1, ArrayList<Egg> allEggs) {
		this.egg = egg;
		this.allEggs1 = allEggs1;
		this.allEggs = allEggs;
	}

	/** This method allows the snake to move left */
	public void go_left() {
		egg.x = egg.x - SIZE;
	}

	/** This method allows the snake to move right */
	public void go_right() {
		egg.x = egg.x + SIZE;
	}

	/** This method allows the snake to move up */
	public void go_up() {
		egg.y = egg.y - SIZE;
	}

	/** This method allows the snake to move down */
	public void go_down() {
		egg.y = egg.y + SIZE;
	}

	/**
	 * This abstract method will be defined in all the subclasses of Movement. This
	 * computes the way the snake moves
	 * 
	 * @param egg0 The last-but-one position occupied by the snake
	 */
	public abstract void move(Egg egg0);

}
