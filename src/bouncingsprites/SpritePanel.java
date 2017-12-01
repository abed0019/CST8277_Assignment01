/* File Name:
 * Author Name: Algonquin College
 * Modified By: Zobayed Abedin
 * Date: February 03, 2017
 * Description: This panel sets up the JPanel to run the program and creates a thread for each sprite.
 */

package bouncingsprites;

// imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SpritePanel extends JPanel {

	// Eclipse auto generated serialVersionUID
	private static final long serialVersionUID = 1L;

	// Object of Sprite
	Sprite sprite;

	// ArrayList object to save Sprite objects
	private ArrayList<Sprite> sprites;

	// ArrayList object to save Thread object
	private ArrayList<Thread> threads;

	// Max number of Sprites that can move inside the circle
	private static final int MAX_SPRITES = 4;

	// Min number of Sprites that can move outside the circle
	private static final int MIN_SPRITES = 2;

	// Number of Sprites inside the circle
	private int spritesInCircle;

	// Default Constructor
	public SpritePanel() {
		addMouseListener(new Mouse());
		sprites = new ArrayList<>();
		threads = new ArrayList<>();
	}

	// Void method for the Sprite when it is entering the square i.e. consuming
	public synchronized void consume() throws InterruptedException {
		while (spritesInCircle <= MIN_SPRITES) {
			wait();
		}
		--spritesInCircle;
		notifyAll();
	}

	// Void method for the Sprite when it is leaving the square i.e. producing
	public synchronized void produce() throws InterruptedException {
		while (spritesInCircle >= MAX_SPRITES) {
			wait();
		}
		++spritesInCircle;
		notifyAll();
	}

	// Void method that creates a new sprite
	private void newSprite(MouseEvent event) {
		Sprite sprite = new Sprite(this);
		sprites.add(sprite);
		Thread thread = new Thread(sprite);
		threads.add(thread);
		thread.start();
	}

	// Void method that animates the program, uses infinite loop
	public void animate() {
		while (true) {
			repaint();
		}
	}

	// Inner class to handle mouse event
	private class Mouse extends MouseAdapter {
		@Override
		public void mousePressed(final MouseEvent event) {
			newSprite(event);
		}
	}

	// Overridden paint component method to draw the circle
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(45, 45, 400, 400);
		for (Sprite sprite : sprites) {
			sprite.draw(g);
		}
	}

}// end of SpritePanel
