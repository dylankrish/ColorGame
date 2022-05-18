
package finalExam;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gameGUI implements ActionListener {
    public gameGUI() {
        int X = 5;
        int Y = 5;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
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
        
        JButton btnColor = new JButton();
        
        System.out.println(randomRed + " " + randomGreen + " " + randomBlue);
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                JButton btn = new JButton();
               
                lightButtons[i][j] = btn; // tells the position of the buttons ? 
               // btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                btn.setBorder(BorderFactory.createLineBorder(Color.white));
                btn.setBackground(new Color(randomRed, randomGreen, randomBlue));
               // btn.setOpaque(true);
               // btn.setBorderPainted(false);
                contentPane.add(btn);
                int IPos = 0;
                int JPos = 0;
                
                int newPosJ = JPos;
                int newPosI = IPos;
                
            
                
//                for (int k = 0; k < IPos; k++) {
//                	for (int g = 0; g < JPos; g++) {
//                		btn.setBackground(Color.pink);	
//                	}
//                }
                System.out.print( i + "," + j + " ");
                
                // ok so once this is figured out make if statements where after the user clicks on this 
                // and gets it right multiple times (like five ups the addition of the ability to differentiate the 
                // colors
                // use the variationRGB to make it work with that method
                if (lightButtons[i][j] == lightButtons[1][2]) {
                	btn.setBackground(new Color(randomRed + 40 , randomGreen + 40, randomBlue + 40));	
                }
                /* Ok so if I use the random method the buttons do change colors, however sometimes it changes two or three
                 * or other times none at all. However when I simply input the numbers myself (like choose the position myself
                 * then it only changes in that position like this: 
                 * if (lightButtons[i][j] == lightButtons[3)][(int)(3]) {
                	btn.setBackground(Color.pink);	
                	instead of this:
                	if (lightButtons[i][j] == lightButtons[(int)(Math.random() * 3)][(int)(Math.random() * 3)]) {
                	btn.setBackground(Color.pink); -- this is used to test to see if the color position can change	
                }
                }
                in order to change the color slightly just have to use this
                new Color(randomRed, randomGreen, randomBlue) and add to it with random numbers
                however there are times when an error is given when this is used
                 */
                //
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
    public int variationRGB(int color) {
        // choose a random number between 5 and 10
        int random = (int)(Math.random() * 5) + 5;
        // add or subtract that number from the color
        // choose a random number between 0 and 1
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
