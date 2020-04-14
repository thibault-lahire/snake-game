package launcher;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import materials.Egg;
import materials.Game;
import materials.Occupy;
import snakeMovement.Monitored;
import snakeMovement.MonitoredDuo;
import snakeMovement.Movement;
import snakeMovement.RandomM;
import snakeMovement.Smart;
import snakeMovement.UltraSmart;
import snakeMovement.VerySmart;
import snakeMovement.VeryVerySmart;

import java.io.IOException;
import java.lang.String;

/**
 * This class launches the game composed of one player that controls his/her
 * snake and an auto-controlled snake, whose smartness is chosen in the class
 * Start. When the game is finished, the result appears in the console.
 * 
 * @author t.lahire
 */
public class JeuSolo extends Game {

	/**
	 * This egg represents the head of the first snake. It will be actualized at
	 * each step of the game by the player
	 */
	private Egg egg1;

	/**
	 * This list of nodes contains all the positions occupied by the first snake. It
	 * allows the eggs to appear on the screen
	 */
	private ArrayList<Node> allNodes1;

	/**
	 * This list of eggs contains all the positions occupied by the first snake. It
	 * allows the manipulations that are not permitted by the list allNodes1
	 */
	private ArrayList<Egg> allEggs1;

	/**
	 * This egg represents the head of the second snake. It will be automatically
	 * actualized at each step of the game
	 */
	private Egg egg2;

	/**
	 * This list of nodes contains all the positions occupied by the second snake.
	 * It allows the eggs to appear on the screen
	 */
	private ArrayList<Node> allNodes2;

	/**
	 * This list of eggs contains all the positions occupied by the second snake. It
	 * allows the manipulations that are not permitted by the list allNodes2
	 */
	private ArrayList<Egg> allEggs2;

	/**
	 * This list contains all the positions occupied by the two snakes. It allows
	 * the eggs to appear on the screen
	 */
	private ArrayList<Node> allNodes = new ArrayList<Node>();

	/**
	 * This list contains all the positions occupied by the two snakes and
	 * facilitates some manipulations
	 */
	private ArrayList<Egg> allEggs = new ArrayList<Egg>();

	/**
	 * This integer from the class Start is the choice of the type of snake (first
	 * snake)
	 */
	static int snake1 = Start.snake1;

	/**
	 * This integer from the class Start is the choice of the type of snake (second
	 * snake)
	 */
	static int snake2 = Start.snake2;

	/**
	 * This constructor initializes the parameters of the game The game begins with
	 * one snake in the upper left quarter, and another one in the lower right
	 * quarter
	 * 
	 * @throws IOException
	 */
	public JeuSolo() throws IOException {
		this.allNodes1 = new ArrayList<Node>();
		this.allNodes1.add(new Egg(WINDOW_SIZE / 4, WINDOW_SIZE / 4, Color.GREEN));
		this.allEggs1 = new ArrayList<Egg>();
		this.allEggs1.add(new Egg(WINDOW_SIZE / 4, WINDOW_SIZE / 4, Color.GREEN));
		this.allNodes1.add(new Egg(WINDOW_SIZE / 4 + ELEMENT_SIZE, WINDOW_SIZE / 4, Color.AQUAMARINE));
		this.allEggs1.add(new Egg(WINDOW_SIZE / 4 + ELEMENT_SIZE, WINDOW_SIZE / 4, Color.AQUAMARINE));
		egg1 = new Egg(WINDOW_SIZE / 4 + ELEMENT_SIZE, WINDOW_SIZE / 4, Color.ORANGE);

		this.allNodes2 = new ArrayList<Node>();
		this.allNodes2.add(new Egg(3 * WINDOW_SIZE / 4, 3 * WINDOW_SIZE / 4, Color.GREEN));
		this.allEggs2 = new ArrayList<Egg>();
		this.allEggs2.add(new Egg(3 * WINDOW_SIZE / 4, 3 * WINDOW_SIZE / 4, Color.GREEN));
		this.allNodes2.add(new Egg(3 * WINDOW_SIZE / 4 - ELEMENT_SIZE, 3 * WINDOW_SIZE / 4, Color.RED));
		this.allEggs2.add(new Egg(3 * WINDOW_SIZE / 4 - ELEMENT_SIZE, 3 * WINDOW_SIZE / 4, Color.RED));
		egg2 = new Egg(3 * WINDOW_SIZE / 4 - ELEMENT_SIZE, 3 * WINDOW_SIZE / 4, Color.ORANGE);

		allNodes.addAll(allNodes1);
		allNodes.addAll(allNodes2);
		allEggs.addAll(allEggs1);
		allEggs.addAll(allEggs2);

	}

	/** Application main method */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * This is the implementation of the abstract method gameStep defined in the
	 * class Game. This method is called by the main method at each step of the game
	 * 
	 * @return a ArrayList of Node that will form the new JavaFX graph scene.
	 */
	public ArrayList<Node> gameStep() {

		if (egg1.alive == true && egg2.alive == true) {

			// The lines below computes the new position for snake 1
			Egg egg0_1 = allEggs1.get(allEggs1.size() - 2);

			if (snake1 == 0) {
				Monitored monitored = new Monitored(egg1, allEggs2, allEggs);
				monitored.move(egg0_1);
			} else if (snake1 == 1) {
				MonitoredDuo monitoredDuo = new MonitoredDuo(egg1, allEggs2, allEggs);
				monitoredDuo.move(egg0_1);
			} else if (snake1 == 2) {
				Movement random = new RandomM(egg1, allEggs2, allEggs);
				random.move(egg0_1);
			} else if (snake1 == 3) {
				Movement smart = new Smart(egg1, allEggs2, allEggs);
				smart.move(egg0_1);
			} else if (snake1 == 4) {
				Movement very_smart = new VerySmart(egg1, allEggs2, allEggs);
				very_smart.move(egg0_1);
			} else if (snake1 == 5) {
				Movement ultra_smart = new UltraSmart(egg1, allEggs2, allEggs);
				ultra_smart.move(egg0_1);
			} else {
				Movement very_very_smart = new VeryVerySmart(egg1, allEggs2, allEggs);
				very_very_smart.move(egg0_1);
			}

			// The lines below computes the new position for snake 2
			Egg egg0_2 = allEggs2.get(allEggs2.size() - 2);

			if (snake2 == 0) {
				Monitored monitored = new Monitored(egg2, allEggs1, allEggs);
				monitored.move(egg0_2);
			} else if (snake2 == 1) {
				MonitoredDuo monitoredDuo = new MonitoredDuo(egg2, allEggs1, allEggs);
				monitoredDuo.move(egg0_2);
			} else if (snake2 == 2) {
				Movement random = new RandomM(egg2, allEggs1, allEggs);
				random.move(egg0_2);
			} else if (snake2 == 3) {
				Movement smart = new Smart(egg2, allEggs1, allEggs);
				smart.move(egg0_2);
			} else if (snake2 == 4) {
				Movement very_smart = new VerySmart(egg2, allEggs1, allEggs);
				very_smart.move(egg0_2);
			} else if (snake2 == 5) {
				Movement ultra_smart = new UltraSmart(egg2, allEggs1, allEggs);
				ultra_smart.move(egg0_2);
			} else {
				Movement very_very_smart = new VeryVerySmart(egg2, allEggs1, allEggs);
				very_very_smart.move(egg0_2);
			}

			// Do the two snakes want to occupy the same position ?
			if (egg1.x == egg2.x && egg1.y == egg2.y) {
				egg1.alive = false;
				egg2.alive = false;

				// a few esthetic transformations of the final situation...
				Egg last_egg1 = allEggs1.get(allEggs1.size() - 1);
				Egg final_egg1 = new Egg(last_egg1.x, last_egg1.y, Color.BLACK);
				allNodes.add(final_egg1);

				Egg last_egg2 = allEggs2.get(allEggs2.size() - 1);
				Egg final_egg2 = new Egg(last_egg2.x, last_egg2.y, Color.BLACK);
				allNodes.add(final_egg2);

				System.out.println("Game over : Match nul : the two players want the same position");

				return allNodes;

			}

			// Is the new position for the first snake free or not ?
			if (Occupy.is_free(egg1.x, egg1.y, allEggs) == false) {
				egg1.alive = false;

				if (Occupy.is_free(egg2.x, egg2.y, allEggs) == false) {
					// If the program enters this if, then it is a "Match nul"
					egg2.alive = false;

					// a few esthetic transformations of the final situation...
					Egg last_egg1 = allEggs1.get(allEggs1.size() - 1);
					Egg final_egg1 = new Egg(last_egg1.x, last_egg1.y, Color.BLACK);
					allNodes.add(final_egg1);

					Egg last_egg2 = allEggs2.get(allEggs2.size() - 1);
					Egg final_egg2 = new Egg(last_egg2.x, last_egg2.y, Color.BLACK);
					allNodes.add(final_egg2);

					System.out.println("Game Over : Match nul");

					return allNodes;

				} else {
					// If the program enters here, it is not a "Match nul", the first snake has lost

					// a few esthetic transformations of the final situation...
					Egg last_egg = allEggs1.get(allEggs1.size() - 1);
					Egg final_egg = new Egg(last_egg.x, last_egg.y, Color.BLACK);
					allNodes.add(final_egg);

					System.out.println("Game Over : Player red wins");

					return allNodes;
				}

			} else {
				// If the new position of the first snake is free, the game continues for it.

				// Is the new position for the second snake free or not ?
				if (Occupy.is_free(egg2.x, egg2.y, allEggs) == false) {
					egg2.alive = false;

					// a few esthetic transformations of the final situation...
					Egg last_egg = allEggs2.get(allEggs2.size() - 1);
					Egg final_egg = new Egg(last_egg.x, last_egg.y, Color.BLACK);
					allNodes.add(final_egg);

					System.out.println("Game Over : Player blue wins");

					return allNodes;

				} else {
					// If the new position of the second snake is free, the game continues for it.
					// The lines below are an actualization of the color of the two snakes

					Egg last_egg_in_chain2 = allEggs2.get(allEggs2.size() - 1);
					Egg replace2 = new Egg(last_egg_in_chain2.x, last_egg_in_chain2.y, Color.RED);

					allEggs2.remove(allEggs2.size() - 1);
					allNodes2.remove(allNodes2.size() - 1);

					allEggs2.add(replace2);
					allNodes2.add(replace2);

					Egg new_egg_to_add2 = new Egg(egg2.x, egg2.y, Color.ORANGE);

					allEggs2.add(new_egg_to_add2);
					allNodes2.add(new_egg_to_add2);

					Egg last_egg_in_chain1 = allEggs1.get(allEggs1.size() - 1);
					Egg replace1 = new Egg(last_egg_in_chain1.x, last_egg_in_chain1.y, Color.AQUAMARINE);

					allEggs1.remove(allEggs1.size() - 1);
					allNodes1.remove(allNodes1.size() - 1);

					allEggs1.add(replace1);
					allNodes1.add(replace1);

					Egg new_egg_to_add1 = new Egg(egg1.x, egg1.y, Color.ORANGE);

					allEggs1.add(new_egg_to_add1);
					allNodes1.add(new_egg_to_add1);

					allEggs.clear();
					allEggs.addAll(allEggs1);
					allEggs.addAll(allEggs2);

					allNodes.clear();
					allNodes.addAll(allNodes1);
					allNodes.addAll(allNodes2);

					return allNodes;
				}

			}

		}

		return allNodes;
	}

}
