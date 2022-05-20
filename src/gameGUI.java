


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gameGUI implements ActionListener {
	public gameGUI() {
		// Creates button array
		int X = 5;
		int Y = 5;
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		// Show rules
		JOptionPane.showMessageDialog(frame, "read the damn rules");
		// Default exit on close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel buttonPanel = new JPanel();//a new panel to hold all of the //buttons on the game board.
		JButton[][] lightButtons;
		lightButtons = new JButton[X][Y]; //creates a new two dimensional //ray that will hold 25 buttons.
		buttonPanel.setLayout(new GridLayout(X,Y));
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new java.awt.GridLayout(X, Y));
		int randomRed = randomRGB();
		int randomGreen = randomRGB();
		int randomBlue = randomRGB();

		//JButton btnColor = new JButton();

		// BEGIN RANDOM COLORS:
		int IPos = 0;
		int JPos = 0;

		int newRed = randomRed + 40;
		int newGreen = randomGreen + 40;
		int newBlue = randomBlue + 40;

		// needs to be + 40 cause math
		// make it more or less depending one level
		// if user goes to each level (like 10) decrease the variation

		// this is the variation statement
		if (newRed >= 255) {
			newRed = newRed - 40;
		}

		if (newGreen >= 255) {
			newGreen = newGreen - 40;
		}

		if (newBlue >= 255) {
			newBlue = newBlue - 40;
		}

		// create a random number between 0 and X
		int randomI = (int)(Math.random() * X);
		System.out.println(randomI);

		// create a random number between 0 and Y
		int randomJ = (int)(Math.random() * Y);
		System.out.println(randomJ);
		

		// END RANDOM COLORS

		System.out.println(randomRed + " " + randomGreen + " " + randomBlue);
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				JButton btn = new JButton();

				lightButtons[i][j] = btn; // btn is the name of the button
				// btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
				btn.setBorder(BorderFactory.createLineBorder(Color.white));
				btn.setBackground(new Color(randomRed, randomGreen, randomBlue));


                String os = System.getProperty("os.name");
                if (os.equals("Mac OS X")) {
                    btn.setOpaque(true);
				    btn.setBorderPainted(false);
                }
				
				// SET RANDOM COLORS
				if (i == randomI && j == randomJ) {
					lightButtons[randomI][randomJ] = btn;
					btn.setBackground(new Color(newRed, newGreen, newBlue));
				}
				

				contentPane.add(btn);
			}
		}

		

		frame.add(contentPane);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(panel);

	}
	public int randomRGB() {
		return (int)(Math.random() * 255);
	}

    // Unused Method
    public int variationRGB(int color) {
        // choose a random number between 5 and 10
        int random = (int)(Math.random() * 5) + 5;
        // add or subtract that number from the color
        // choose a random number between 0 and 1, picks when to add or subtract
        int random2 = (int)(Math.random() * 2);
        if (random2 == 1) {
            return(color + random);
        } else {
            return(color - random);
        }
        // return (int)(Math.random() * color);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
	}
}
