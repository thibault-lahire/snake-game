package launcher;

import java.io.IOException;

import java.util.Scanner;

/**
 * A class that sets all the parameters of the game the user wants
 * 
 * @author t.lahire
 */
public class Start {

	/** Speed of the game */
	static public long delay = 800L;

	/** Type of the first snake */
	static public int snake1;

	/** Type of the second snake */
	static public int snake2;

	/**
	 * This main method reads the keyboard inputs of the user to launch the right
	 * program
	 */
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String speed = "";
		String play = "";
		String type = "";
		System.out.println("Choose the speed of the game : '0' for slow, '1' for medium, '2' for fast \n");

		speed = sc.nextLine();
		if (speed.equals("0")) {
			delay = 1200L;
		} else if (speed.equals("1")) {
			delay = 800L;
		} else if (speed.equals("2")) {
			delay = 400L;
		} else {
			sc.close();
			throw new IllegalArgumentException("ERROR : Please select 0, 1, or 2 \n");
		}

		System.out.println("Do you want t play in a network ?");
		System.out.println("Press '0' to launch the server");
		System.out.println("Press '1' to launch the client");
		System.out.println("Press '2' if you don't want to play with another machine");

		play = sc.nextLine();
		int game = Integer.parseInt(play);
		if (game == 0) {

			System.out.println("What type of snake do you want for the first snake ?");
			System.out.println("Press '0' if you want to control the snake with LEFT, UP, RIGHT, DOWN ");
			System.out.println("Press '1' if you want to control the snake with QSDZ ");
			System.out.println("Press '2' if you want a random snake ");
			System.out.println("Press '3' if you want a smart snake ");
			System.out.println(
					"Press '4' if you want a very smart snake that tries to be even closer from the head of the other snake ");
			System.out.println(
					"Press '5' if you want a very smart snake that goes in the opposite direction of the barycenter of the other snake");
			System.out.println(
					"Press '6' if you want a very smart snake that goes in the direction where the largest distance can be travelled");

			type = sc.nextLine();
			snake1 = Integer.parseInt(type);
			if (snake1 < 0 || snake1 > 6) {
				sc.close();
				throw new IllegalArgumentException("ERROR : Please select 0, 1, 2, 3, 4, 5, or 6 \n");
			}

			JeuServeur.main(args);

		} else if (game == 1) {

			System.out.println("What type of snake do you want for the second snake ?");
			System.out.println("Press '0' if you want to control the snake with LEFT, UP, RIGHT, DOWN ");
			System.out.println("Press '1' if you want to control the snake with QSDZ ");
			System.out.println("Press '2' if you want a random snake ");
			System.out.println("Press '3' if you want a smart snake ");
			System.out.println(
					"Press '4' if you want a very smart snake that tries to be even closer from the head of the other snake ");
			System.out.println(
					"Press '5' if you want a very smart snake that goes in the opposite direction of the barycenter of the other snake");
			System.out.println(
					"Press '6' if you want a very smart snake that goes in the direction where the largest distance can be travelled");

			type = sc.nextLine();
			snake2 = Integer.parseInt(type);
			if (snake2 < 0 || snake2 > 6) {
				sc.close();
				throw new IllegalArgumentException("ERROR : Please select 0, 1, 2, 3, 4, 5, or 6 \n");
			}

			JeuClient.main(args);

		} else if (game == 2) {
			System.out.println("What type of snake do you want for the first snake ?");
			System.out.println("Press '0' if you want to control the snake with LEFT, UP, RIGHT, DOWN ");
			System.out.println("Press '1' if you want to control the snake with QSDZ ");
			System.out.println("Press '2' if you want a random snake ");
			System.out.println("Press '3' if you want a smart snake ");
			System.out.println(
					"Press '4' if you want a very smart snake that tries to be even closer from the head of the other snake ");
			System.out.println(
					"Press '5' if you want a very smart snake that goes in the opposite direction of the barycenter of the other snake");
			System.out.println(
					"Press '6' if you want a very smart snake that goes in the direction where the largest distance can be travelled");

			type = sc.nextLine();
			snake1 = Integer.parseInt(type);
			if (snake1 < 0 || snake1 > 6) {
				sc.close();
				throw new IllegalArgumentException("ERROR : Please select 0, 1, 2, 3, 4, 5, or 6 \n");
			}

			System.out.println("What type of snake do you want for the second snake ?");
			System.out.println("Press '0' if you want to control the snake with LEFT, UP, RIGHT, DOWN ");
			System.out.println("Press '1' if you want to control the snake with QSDZ ");
			System.out.println("Press '2' if you want a random snake ");
			System.out.println("Press '3' if you want a smart snake ");
			System.out.println(
					"Press '4' if you want a very smart snake that tries to be even closer from the head of the other snake ");
			System.out.println(
					"Press '5' if you want a very smart snake that goes in the opposite direction of the barycenter of the other snake");
			System.out.println(
					"Press '6' if you want a very smart snake that goes in the direction where the largest distance can be travelled");

			type = sc.nextLine();
			snake2 = Integer.parseInt(type);
			if (snake2 < 0 || snake2 > 6) {
				sc.close();
				throw new IllegalArgumentException("ERROR : Please select 0, 1, 2, 3, 4, 5, or 6 \n");
			}

			JeuSolo.main(args);

		} else {
			sc.close();
			throw new IllegalArgumentException("ERROR : Please select 0, 1, or 2 \n");
		}

		sc.close();
	}
}