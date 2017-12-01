# CST8277_Assignment01
CST 8277 - Assignment 1

To ecome familiar with the given bouncing sprite Java program. The user clicks the mouse inside the window to
start a blue sprite bouncing inside the window. This is an animated program, which runs an infinite loop to
repeatedly re-draw the sprite in the panel about 25 times per second, which we call the frame rate. In Swing 2D
graphics, calling repaint causes the system to invoke the paintComponent method with the appropriate
Graphics object parameter. In the paintComponent method, the programmer uses that Graphics object to
draw things on the screen. Inside the paintComponent method, the call to super.paintComponent clears the
screen (so the programmer can draw the new frame). Each time the sprite is drawn (one frame), it has moved a
little bit, so as we watch this process in real time, the sprite appears to move. This is exactly the same principle
used in a Hollywood "moving picture" (the standard Hollywood frame rate is 24 frames per second).
