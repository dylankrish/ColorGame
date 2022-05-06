///// Main class
package newGameOfLight;

import javax.swing.JButton;
import javax.swing.JFrame;

//package newGameOfLight;

//import practiceCode.lightsOff;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class gameOfLight extends newGameOfLight {

	private static final int x = 5;
	private static final int y = 5;
	//static int count = 0;
	public static JButton[][] lightBoard = new JButton[x][y];
	public static boolean colorSwitch = false;

	
	// creates the board
	public gameOfLight() {
		lightBoard = new JButton[x][y];
		for (int xcoord = 0; xcoord < lightBoard.length; xcoord++) {
			for (int ycoord = 0; ycoord < lightBoard[0].length; ycoord++) {
				lightBoard[x][y].setBackground(Color.pink);
				colorSwitch = false;
			}
		}
	}

	public static void whenButtonClicked(JButton button) {

	}

	public static void gamePlay(JButton button, JButton[][] lightBoard) {
		String string = button.getText();

		//Gives coordinates of the button
		int x = Character.getNumericValue(button.getName().charAt(0));
		int y = Character.getNumericValue(button.getName().charAt(2));

		//temporary buttons for the adjacent locations
		//next to the selected button.
		JButton tempSelected = new JButton(); //a temp button for the selected button
		//JButton tempTop = new JButton(); //a temp button for the button above the selected button
		JButton tempLeft = new JButton(); //a temp button for the button left to the selected button
		JButton tempRight = new JButton(); //a temp button for the button right to the selected button
		JButton tempBottom = new JButton(); //a temp button for the button below the selected button

		try {
			tempSelected = lightBoard[x][y]; //gets the current button selected and stores it in the temp.
			button.setBackground(Color.gray);
			boolean colorSwitch = false;
			if (colorSwitch = false) {
				colorSwitch = true;
				button.setBackground(Color.pink);
			}

			if (colorSwitch = true) {
				colorSwitch = false;
				button.setBackground(Color.gray);
			}
		} catch (ArrayIndexOutOfBoundsException i) {
			System.out.println("Error: Current");
		}
		//each button is attempted, but if it exceeds the Array, then it is caught and nothing is done.
		try {
			System.out.println("X: " + x + " Y: " + y);
			JButton tempTop = lightBoard[x][y+1]; //get the button that is above the selected button and stores it in temp.
			button = tempTop;
			if (tempTop.getBackground() == Color.gray) {
				button.setBackground(Color.pink);
			} else {
				button.setBackground(Color.gray);
			}
		} catch(ArrayIndexOutOfBoundsException i) {
			System.out.println("Error: Top");

		}

		try {
			tempLeft = lightBoard[x-1][y]; //get the button that is left to the selected button and stores it in temp.
			button = tempLeft;

			if (button.getBackground() == Color.gray) {
				button.setBackground(Color.pink);
			} else {
				button.setBackground(Color.gray);
			}
		} catch(ArrayIndexOutOfBoundsException i) {
			System.out.println("Error: Left");
		}
		try {
			tempRight = lightBoard[x+1][y]; //get the button that is right to th selected button and stores it in temp.
			button = tempRight;
			if (button.getBackground() == Color.gray) {
				button.setBackground(Color.pink);
			} else {
				button.setBackground(Color.gray);
			}
		} catch(ArrayIndexOutOfBoundsException i) {
			System.out.println("Error: Right ");
		}
		try {
			tempBottom = lightBoard[x][y-1]; //get the button that is below the selected button and stores it in temp.
			button = tempBottom;
			if (button.getBackground() == Color.gray) {
				button.setBackground(Color.pink);
			} else {
				button.setBackground(Color.gray);
			}
		} catch(ArrayIndexOutOfBoundsException i) {
			System.out.println("Error: Bottom");

		}
		
		
		if ( gameWon(lightBoard) == true) {
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "You Win");  
		}
	}

	public static boolean gameWon(JButton[][] lightBoard ) {
		for (int xcoord = 0; xcoord < lightBoard.length; xcoord++) {
			for (int ycoord = 0; ycoord < lightBoard[0].length; ycoord++) {
				if (lightBoard[x][y].getBackground() == Color.gray) {
					//keep going
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
///////////////////////////////////////////////////////////////////////////////////////////////////////
// not main method
package newGameOfLight;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class newGameOfLight implements ActionListener {
	public newGameOfLight() {
		final int X = 5;
		final int Y = 5;
		JFrame frame = new JFrame();
		JPanel buttonPanel = new JPanel();//a new panel to hold all of the
		//ttons on the game board.
		JButton[][] lightButtons;
		lightButtons = new JButton[X][Y]; //creates a new two dimensional
		//ray that will hold 25 buttons.
		buttonPanel.setLayout(new GridLayout(X,Y));
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new java.awt.GridLayout(X, Y));
		// gameOfLight gameOfLight = new gameOfLight();

		for (int i = 0; i < X; i++){
			for(int j = 0; j < Y; j++) {
				JButton btn = new JButton();
				lightButtons[i][j] = btn;
				btn.setText(" ");
				btn.setName(i +  " " + j);
				btn.addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
								if(eventName.equals(" ")) {
									btn.setText("   ");
									btn.setActionCommand("   ");
									btn.setBackground(Color.gray);
								} else {
									btn.setText(" ");
									btn.setActionCommand(" ");
									btn.setBackground(Color.pink);
								}
								gameOfLight.gamePlay(btn, lightButtons);
							}
						});
				btn.setBorder(BorderFactory.createLineBorder(Color.blue));
				btn.setBackground(Color.pink);
				contentPane.add(btn);
				
			}
		}

		frame.add(contentPane);
		frame.setSize(400,400);
		frame.setVisible(true);

	}

	/**
	 * Create and show the GUI.
	 */
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		newGameOfLight playLife = new newGameOfLight();
	}


	public static void main(String[] args) {
		/* Methods that create and show a GUI should be
       run from an event-dispatching thread */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
