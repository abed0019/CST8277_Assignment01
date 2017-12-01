/* File Name:
 * Author Name: Algonquin College
 * Modified By: Zobayed Abedin
 * Date: February 03, 2017
 * Description: Sprite class creates a sprite that moves around the 500x500 JFrame and bounces off the edges.
 */

package bouncingsprites;

// imports
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Sprite implements Runnable {

	// Random object
	public final static Random random = new Random();

	// Size of the Sprite
	final static int SIZE = 10;

	// Speed of the Sprite
	final static int MAX_SPEED = 5;

	// Object of Sprite Panel
	SpritePanel panel;

	// Sprites x asix position
	private int x;

	// Sprites y asix position
	private int y;

	// Directional X axis
	private int dx;

	// Directional Y axis
	private int dy;

	// Last position of X
	int lastX = x;

	// Last position of Y
	int lastY = y;

	// Color object for Sprite
	private Color color = Color.BLUE;

	// Default constructor
	public Sprite(SpritePanel panel) {
		this.panel = panel;
		x = random.nextInt(panel.getWidth());
		y = random.nextInt(panel.getHeight());
		dx = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
		dy = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
	}

	// Overridden void method run for runnable interface
	@Override
	public void run() {

		// boolean to determine if ball is in square

		boolean inCircle;

		while (true) {

			// Getting the last X and Y axis position of the ball
			lastX = x;
			lastY = y;
			move();

			// Checking if the ball is in the circle

			// The center of the circle from top left corner is (245,245) and
			// the radius is 200. Formula for circle was used to determine if
			// the ball is inside the circle.

			if ((lastX - 245) * (lastX - 245) + (lastY - 245) * (lastY - 245) <= 40000) {
				inCircle = true;

				try {
					panel.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			else

			// if the above condition does not satisfy the ball must be outside
			// the circle.

			{
				inCircle = false;

				try {
					panel.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(40); // wake up roughly 25 frames per second
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}

	}// end of run

	// method to draw the sprite

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, SIZE, SIZE);
	}

	// method that makes the sprite move and bounces off the edges
	public void move() {

		// check for bounce and make the ball bounce if necessary
		//
		if (x < 0 && dx < 0) {
			// bounce off the left wall
			x = 0;
			dx = -dx;
		}
		if (y < 0 && dy < 0) {
			// bounce off the top wall
			y = 0;
			dy = -dy;
		}
		if (x > panel.getWidth() - SIZE && dx > 0) {
			// bounce off the right wall
			x = panel.getWidth() - SIZE;
			dx = -dx;
		}
		if (y > panel.getHeight() - SIZE && dy > 0) {
			// bounce off the bottom wall
			y = panel.getHeight() - SIZE;
			dy = -dy;
		}

		// make the ball move
		x += dx;
		y += dy;
	}// end of move

}// end of Sprite
