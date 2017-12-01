/* File Name:
 * Author Name: Algonquin College
 * Modified By: Zobayed Abedin
 * Date: February 03, 2017
 * Description: BouncingSprites implements the user interface and launches the main method.
 */

package bouncingsprites;

import javax.swing.JFrame;

public class BouncingSprites {
	// object of JFrame
	private JFrame frame;

	// object of sprite panel
	private SpritePanel panel = new SpritePanel();

	// Default constructor
	public BouncingSprites() {
		frame = new JFrame("Bouncing Sprites 2017W");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	// Main entry point to the program
	public static void main(String[] args) {
		new BouncingSprites().panel.animate();

	}// end of main
}// end of Bouncing Sprites
