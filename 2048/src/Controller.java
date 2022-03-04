import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Controller implements KeyListener {

	private int[][] field = new int[4][4];
	private static RandomGenerator rgen = RandomGenerator.getInstance();

	public static void main(String[] args) {
		Frame f = new Frame("Demo");
		f.setLayout(new FlowLayout());
		f.setSize(500, 100);
		Label l = new Label();
		l.setText("Have fun playing this game! A better version will come soon.");
		f.add(l);
		f.setVisible(true);
		Controller k = new Controller();
		f.addKeyListener(k);
		// KeyListener listener = new KeyListener();

	}

	public Controller() {

	}

	public void gamePairRight() {
		System.out.println("Yeah");
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j > 0; j--) {
				if (field[i][j] == field[i][j - 1]) {
					field[i][j] = field[i][j-1] * 2;
					field[i][j-1] = 0;
				}
			}
		}

	}

	public void gamePairLeft() {
		System.out.println("Yeah");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (field[i][j] == field[i][j + 1]) {
					field[i][j] = field[i][j] * 2;
					field[i][j + 1] = 0;
				}
			}
		}

	}

	public void gamePairUp() {
		System.out.println("Yeah");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (field[i][j] == field[i + 1][j]) {
					field[i][j] = field[i][j] * 2;
					field[i + 1][j] = 0;
				}
			}
		}
	}

	public void gamePairDown() {
		System.out.println("Yeah");
		for (int i = 3; i > 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (field[i][j] == field[i - 1][j]) {
					field[i - 1][j] = field[i][j] * 2;
					field[i][j] = 0;
				}
			}
		}
	}

	public void gameRight() {
		for (int i = 3; i >= 0; i--) {
			for (int j = 3; j > 0; j--) {
				if (field[i][j] == 0) {
					if (field[i][j - 1] != 0) {
						field[i][j] = field[i][j - 1];
						field[i][j - 1] = 0;
					}
				}
			}
		}
	}

	public void gameLeft() {
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (field[i][j] == 0) {
					if (field[i][j + 1] != 0) {
						field[i][j] = field[i][j + 1];
						field[i][j + 1] = 0;
					}
				}
			}
		}
	}

	public void gameDown() {
		for (int i = 3; i > 0; i--) {
			for (int j = 3; j >= 0; j--) {
				if (field[i][j] == 0) {
					if (field[i - 1][j] != 0) {
						field[i][j] = field[i - 1][j];
						field[i - 1][j] = 0;
					}
				}
			}
		}
	}

	public void gameUp() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= 3; j++) {
				if (field[i][j] == 0) {
					if (field[i + 1][j] != 0) {
						field[i][j] = field[i + 1][j];
						field[i + 1][j] = 0;
					}
				}
			}
		}
	}

	public void addBrick() {
		int a = 0;
		int b = 0;
		do {
			a = rgen.nextInt(0, 3);
			b = rgen.nextInt(0, 3);
		} while (field[a][b] != 0);
		field[a][b] = 2;
	}

	public void output() {
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(field[i]));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			for (int k = 0; k < 4; k++) {
				gameRight();
			}
			gamePairRight();
			gameRight();
			addBrick();
			output();
			break;
		case KeyEvent.VK_LEFT:
			for (int k = 0; k < 4; k++) {
				gameLeft();
			}
			gamePairLeft();
			gameLeft();
			addBrick();
			output();
			break;
		case KeyEvent.VK_DOWN:
			for (int k = 0; k < 4; k++) {
				gameDown();
			}
			gamePairDown();
			gameDown();
			addBrick();
			output();
			break;
		case KeyEvent.VK_UP:
			for (int k = 0; k < 4; k++) {
				gameUp();
			}
			gamePairUp();
			gameUp();
			addBrick();
			output();
			break;
		}
	}
}
