package vicki;

import java.util.Random;
import java.util.Scanner;

public class TwentyFortyEight {

	private static int[][] t1;

	/**
	 * Constructor
	 */
	public TwentyFortyEight() {
		t1 = new int[4][4];
	}

	/**
	 * Calls respective actions when a 
	 * certain arrow key is pressed
	 */
	public static void action(String s) {

		if (s.equals("w")) {
			up();
			drop2();
			display();
		}
		if (s.equals("a")) {
			left();
			drop2();
			display();
		}
		if (s.equals("s")) {
			down();
			drop2();
			display();
		}
		if (s.equals("d")) {
			right();
			drop2();
			display();
		}

	}

	public static void up() {

		moveUp();
		
		for (int c = 0; c < t1[0].length; c++) {

			for (int r = 0; r < t1.length - 1; r++)
				if (t1[r][c] == t1[r + 1][c]) {
					t1[r][c] = 2 * t1[r][c];

					while (r + 2 < t1.length) {
						t1[r + 1][c] = t1[r + 2][c];
						r++;
					}

					t1[t1.length - 1][c] = 0;

				}

		}

	}

	public static void moveUp() {

		int [] temp = new int[t1.length];
		int x = 0;
		
		for (int c = 0; c < t1[0].length; c++) {
			for (int r = 0; r < t1.length; r++) {
				
				if (t1[r][c] != 0) {
					temp[x] = t1[r][c];
					x++;
					t1[r][c] = 0;
				}
				
			}
		
			x = 0;
			
			for (int a = 0; a < t1.length; a++){
				t1[a][c] = temp[a];
				temp[a] = 0;
			}
			
		}
		
	}

	public static void down() {
		
		moveDown();
		
		for (int c = 0; c < t1[0].length; c++) {

			for (int r = t1.length - 1; r > 0; r--)
				if (t1[r][c] == t1[r - 1][c]) {
					t1[r][c] = 2 * t1[r][c];

					while (r - 2 >= 0) {
						t1[r - 1][c] = t1[r - 2][c];
						r--;
					}

					t1[0][c] = 0;

				}

		}
	}

	public static void moveDown() {

		int [] temp = new int[t1.length];
		int x = 0;
		int y = 0;
		
		for (int c = 0; c < t1[0].length; c++) {
			for (int r = t1.length - 1; r >= 0; r--) {
				
				if (t1[r][c] != 0) {
					temp[x] = t1[r][c];
					x++;
					t1[r][c] = 0;
				}
				
			}
		
			x = 0;
			
			for (int a = t1.length - 1; a >= 0; a--) {
				t1[a][c] = temp[y];
				y++;
				temp[a] = 0;
			}
			
			y = 0;
			
		}
		
	}
	
public static void left() {
		moveLeft();
		
		for (int r = 0; r < t1.length; r++) {

			for (int c = 0; c < t1[0].length - 1; c++)
				if (t1[r][c] == t1[r][c+1]) {
					t1[r][c] = 2 * t1[r][c];

					while (c + 2 < t1[0].length) {
						t1[r][c + 1] = t1[r][c + 2];
						c++;
					}

					t1[r][t1[0].length - 1] = 0;

				}

		}
	}

	public static void moveLeft() {

		int [] temp = new int[t1[0].length];
		int x = 0;
		
		for (int r = 0; r < t1.length; r++) {
			for (int c = 0; c < t1[0].length; c++) {
				
				if (t1[r][c] != 0) {
					temp[x] = t1[r][c];
					x++;
					t1[r][c] = 0;
				}
				
			}
		
			x = 0;
			
			for (int a = 0; a < t1[0].length; a++){
				t1[r][a] = temp[a];
				temp[a] = 0;
			}
			
		}
		
		
		
	}
	
	public static void right() {
		moveRight();
		
		for (int r = 0; r < t1.length; r++) {

			for (int c = t1[0].length - 1; c > 0 ; c--){
				
				if (t1[r][c] == t1[r][c-1]) {
					t1[r][c] = 2 * t1[r][c];

					while (c - 2 >= 0) {
						t1[r][c - 1] = t1[r][c - 2];
						c--;
					}

					t1[r][0] = 0;

				}

			}
			
		}
	}

	public static void moveRight() {

		int [] temp = new int[t1[0].length];
		int x = 0, y = 0;
		
		for (int r = 0; r < t1.length; r++) {
			for (int c = t1[0].length - 1; c >= 0 ; c--){
				
				if (t1[r][c] != 0) {
					temp[x] = t1[r][c];
					x++;
					t1[r][c] = 0;
				}
				
			}
		
			x = 0;
			
			
			for (int a = t1[0].length - 1; a >= 0 ; a--){
				t1[r][a] = temp[y];
				temp[y] = 0;
				y++;
			}
			
			y = 0;
			
		}
		
		
		
	}
	
	public static boolean check2048() {

		for (int r = 0; r < t1.length; r++) {
			for (int c = 0; c < t1[0].length; c++)
				if (t1[r][c] == 2048)
					return true;

		}

		return false;

	}

	public static void drop2() {

		int tempX, tempY;
		Random gen = new Random();

		do {
			tempX = gen.nextInt(4);
			tempY = gen.nextInt(4);

			if (t1[tempX][tempY] == 0){
				t1[tempX][tempY] = 2;
				break;
			}

		} while (t1[tempX][tempY] != 0);

	}

	public static void display() {

		for (int r = 0; r < t1.length; r++) {
			for (int c = 0; c < t1[0].length; c++) {
				System.out.print(t1[r][c] + " | ");
			}
			System.out.println();
		}

	}
	
	public static void main(String[] args) {

		TwentyFortyEight asd = new TwentyFortyEight();

		Scanner n = new Scanner(System.in);

		asd.display();

		System.out.println("Press 'w' for up, 's' for down, 'a' for left, 'd' for right");

		String temp = "";

		while (!temp.equals("quit")) {
			temp = n.next();
			action(temp);
			if (check2048()){
				System.out.println("You Win!");
				break;
			}
		}

	}
	
	
}
