package materials;

import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

import java.util.ArrayList;

import javafx.scene.Node;

/**
 * This class defines what is an egg. An egg can be viewed as the head of the
 * snake, as well as an element of its body. This class implements
 * "Serializable" for networking purposes
 * 
 * @author t.lahire
 */
public class Egg extends Rectangle implements Serializable {

	/** Attribute dedicated to the implementation of "Serializable" */
	private static final long serialVersionUID = 1L;

	/**
	 * Standard size for the whole project. It corresponds to the dimensions of an
	 * egg
	 */
	private static final double SIZE = Game.ELEMENT_SIZE;

	/** Attribute for displaying purposes */
	private ArrayList<Node> allParts;

	/** Coordinates of the egg */
	public double x, y;

	/**
	 * Boolean that says if the snake is dead or alive. If true, the snake is alive
	 */
	public boolean alive = true;

	/**
	 * A constructor that initializes the egg with a certain position and a certain
	 * color
	 * 
	 * @param x     Abscissa of the egg
	 * 
	 * @param y     Ordinate of the egg
	 * 
	 * @param color Color of the egg
	 */
	public Egg(double x, double y, Color color) {
		super(SIZE, SIZE, color);
		this.x = x;
		this.y = y;
		this.allParts = new ArrayList<Node>();
		updatePosition();

		allParts.add(this);

		// a few unnecessary esthetic calls
		setArcWidth(SIZE / 2);
		setArcHeight(SIZE / 2);
		setStroke(Color.BLACK);
		setStrokeWidth(3.0);
		setStrokeLineCap(StrokeLineCap.ROUND);
	}

	/**
	 * A method for displaying purposes
	 */
	public void updatePosition() {
		// these are the methods that actually position the Node on screen
		setTranslateX(x);
		setTranslateY(y);
	}

}
