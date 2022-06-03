
import javax.swing.*;
import java.net.*;
import java.lang.Thread;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameGUI implements ActionListener {
	int X = 10;
	int Y = 10;
	int randomX;
	int randomY;
	// int xRand = 0;
	// int yRand = 0;
	boolean recursionFinished = false;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton[][] lightButtons;

	
	public gameGUI() {
		// Show rules
		JOptionPane.showMessageDialog(frame, "read the damn rules");
		createGameGUI();
	}

	public int randomRGB() {
		return (int) (Math.random() * 255);
	}

	public void createGameGUI() {

		
		// Default exit on close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creates button array
		JPanel buttonPanel = new JPanel(); // a new panel to hold all of the //buttons on the game board.
		lightButtons = new JButton[X][Y]; // creates a new two dimensional array that will hold 25 buttons.
		buttonPanel.setLayout(new GridLayout(X, Y));
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new java.awt.GridLayout(X, Y));
		int randomRed = randomRGB();
		int randomGreen = randomRGB();
		int randomBlue = randomRGB();
		int newRed = variationRGB(randomRed);
		int newGreen = variationRGB(randomGreen);
		int newBlue = variationRGB(randomBlue);

		// JButton btnColor = new JButton();

		// BEGIN RANDOM COLORS:
		// xRand = 0;
		// yRand = 0;

		// int newRed = randomRed + 40;
		// int newGreen = randomGreen + 40;
		// int newBlue = randomBlue + 40;

		// needs to be + 40 cause math
		// make it more or less depending on level
		// if user goes to each level (like 10) decrease the variation

		// this is the variation statement
		// if (newRed >= 255) {
		// newRed = newRed - 40;
		// }
		//
		// if (newGreen >= 255) {
		// newGreen = newGreen - 40;
		// }
		//
		// if (newBlue >= 255) {
		// newBlue = newBlue - 40;
		// }

		// END RANDOM COLORS

		// create a random number between 0 and X
		randomX = (int) (Math.random() * X);
		System.out.println(randomX);

		// create a random number between 0 and Y
		randomY = (int) (Math.random() * Y);
		System.out.println(randomY);



		System.out.println(randomRed + " " + randomGreen + " " + randomBlue);
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				JButton btn = new JButton();

				lightButtons[i][j] = btn; // btn is the name of the button
				lightButtons[i][j].setActionCommand("no.");
				lightButtons[i][j].addActionListener(this);
				// btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
				btn.setBorder(BorderFactory.createLineBorder(Color.white));
				btn.setBackground(new Color(randomRed, randomGreen, randomBlue));

				String os = System.getProperty("os.name");
				if (os.equals("Mac OS X")) {
					btn.setOpaque(true);
					btn.setBorderPainted(false);
				}

				// SET RANDOM COLORS
				if (i == randomY && j == randomY) {
					lightButtons[randomX][randomY] = btn;
					btn.setBackground(new Color(newRed, newGreen, newBlue));
					lightButtons[i][j].setActionCommand("randomclicked");
					lightButtons[i][j].addActionListener(this);
				}

				contentPane.add(btn);
			}
		}

		frame.add(contentPane);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(panel);
	}

	public int variationRGB(int color) {
		// choose a random number between 10 and 20
		int random = (int) (Math.random() * 10) + 10;
		// add or subtract that number from the color
		// choose a random number between 0 and 1, picks when to add or subtract
		int random2 = (int) (Math.random() * 2);
		if (random2 == 1) {
			if (color + random > 255) {
				return color - random;
			} else {
				return color + random;
			}
		} else {
			if (color - random < 0) {
				return color + random;
			} else {
				return color - random;
			}
		}
		// return (int)(Math.random() * color);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		System.out.println(event);
		if (eventName.equals("randomclicked")) {
			System.out.println("random clicked");

			Thread thread = new Thread() {
				public void run() {
				  	System.out.println("Recursive thread running");
					System.out.println("CLICKED AT " + randomX + " " + randomY);
				  	recursiveAnimation(randomX, randomY);
				}
			};

			Thread thread2 = new Thread() {
				public void run() {
				  	System.out.println("Post recusion thread running (check)");
				  	postRecursion();
				}
			};

			thread.start();
			thread2.start();
			// createGameGUI();

		} else if (eventName.equals("no.")) {
			System.out.println("no.");
			try {
				Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ").toURI());
			} catch (Exception e) {
			}
			System.exit(0);
		}
	}

	public void recursiveAnimation(int inputX, int inputY) {
		System.out.println("Starting recursive animation at " + System.currentTimeMillis() + " ms on position " + inputX + " " + inputY);

		// change inputX - 1, inputY + 1 button to black
		// check to see if inputX - 1, inputY + 1 is black or out of bounds
		// if black or out of bounds, do nothing
		// if not black, change to black and call recursiveAnimation on that button

		// X - 1, Y + 1
		if (inputX - 1 >= 0 && inputY + 1 < Y) {
			if (!lightButtons[inputX - 1][inputY + 1].getBackground().equals(Color.black)) {
				lightButtons[inputX - 1][inputY + 1].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();
				
				Thread thread = new Thread(){
					public void run(){
						  recursiveAnimation(inputX - 1, inputY + 1);
					}
				};

				thread.run();
			}
		}

		// X, Y + 1
		if (inputY + 1 < Y) {
			if (!lightButtons[inputX][inputY + 1].getBackground().equals(Color.black)) {
				lightButtons[inputX][inputY + 1].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();
				
				Thread thread = new Thread(){
					public void run(){
						  recursiveAnimation(inputX, inputY + 1);
					}
				};

				thread.run();
			}
		}

		// X + 1, Y + 1
		if (inputX + 1 < X && inputY + 1 < Y) {
			if (!lightButtons[inputX + 1][inputY + 1].getBackground().equals(Color.black)) {
				lightButtons[inputX + 1][inputY + 1].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();
				Thread thread = new Thread(){
					public void run(){
						  recursiveAnimation(inputX + 1, inputY + 1);
					}
				};
				
				thread.run();
			}
		}

		// X - 1, Y
		if (inputX - 1 >= 0) {
			if (!lightButtons[inputX - 1][inputY].getBackground().equals(Color.black)) {
				lightButtons[inputX - 1][inputY].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();
				
				Thread thread = new Thread(){
					public void run(){
						  recursiveAnimation(inputX - 1, inputY);
					}
				};

				thread.run();
			}
		}

		// X + 1, Y
		if (inputX + 1 < X) {
			if (!lightButtons[inputX + 1][inputY].getBackground().equals(Color.black)) {
				lightButtons[inputX + 1][inputY].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();

				Thread thread = new Thread(){
					public void run(){
						  recursiveAnimation(inputX + 1, inputY);
					}
				};

				thread.run();
			}
		}

		// X - 1, Y - 1
		if (inputX - 1 >= 0 && inputY - 1 >= 0) {
			if (!lightButtons[inputX - 1][inputY - 1].getBackground().equals(Color.black)) {
				lightButtons[inputX - 1][inputY - 1].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();
				Thread thread = new Thread() {
					public void run() {
						  recursiveAnimation(inputX - 1, inputY - 1);
					}
				};

				thread.run();
			}
		}

		// X, Y - 1
		if (inputY - 1 >= 0) {
			if (!lightButtons[inputX][inputY - 1].getBackground().equals(Color.black)) {
				lightButtons[inputX][inputY - 1].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();
				
				Thread thread = new Thread(){
					public void run(){
						  recursiveAnimation(inputX, inputY - 1);
					}
				};

				thread.run();
			}
		}

		// X + 1, Y - 1
		if (inputX + 1 < X && inputY - 1 >= 0) {
			if (!lightButtons[inputX + 1][inputY - 1].getBackground().equals(Color.black)) {
				lightButtons[inputX + 1][inputY - 1].setBackground(Color.black);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				frame.repaint();
				frame.revalidate();
				Thread thread = new Thread(){
					public void run(){
						  recursiveAnimation(inputX + 1, inputY - 1);
					}
				};

				thread.run();
			}

			if (inputX == X && inputY == Y) {
				System.out.println("Finished Recursion");
				recursionFinished = true;
				return;
			}
		}

		System.out.println("Ending recursive animation at " + System.currentTimeMillis() + " ms on position " + inputX + " " + inputY);
	}
	public void postRecursion() {
		for (int i = 0; i < 1;) {
			if (recursionFinished == true) {
				recursionFinished = false;
				System.out.println("Re-creating GUI");
				createGameGUI();
				frame.repaint();
				frame.revalidate();
				return;
			}
		}
		
	}

}
