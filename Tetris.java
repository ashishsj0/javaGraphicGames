package assignmentTwo;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tetris extends GraphicsProgram {

	private static final int BRICK_SIZE = 20;
	private static final int FRAMEWIDTH = 400;
	private GRect brick;
	
	public void run() {
		
		setup();
		
		while (true) {
			
			moveBrick();
			checkForCollision();
			pause(100);
		}
		
	}

	private void checkForCollision() {
		
		GObject obj = getElementAt(brick.getX() + brick.getHeight(),brick.getY() + brick.getHeight());
		GObject obj1 = getElementAt(brick.getX(),brick.getY() + brick.getHeight());
		
		if (((brick.getY() + brick.getHeight()) == FRAMEWIDTH)) {
			createBrick();
		}
		
		if (obj != null || obj1 != null) {
			System.out.println("object found");
			createBrick();
		}
		
		else {
			
		}
	}

	private void createBrick() {
		RandomGenerator randomY = new RandomGenerator();
		RandomGenerator randomX = new RandomGenerator();
		
		switch(randomX.nextInt(0,3)) {
		
		case 0:
			brick = new GRect(BRICK_SIZE,BRICK_SIZE);
			break;
		case 1:
			brick = new GRect(40,40);
			break;
		case 2:
			brick = new GRect(20,40);
			break;
		case 3:
			brick = new GRect(10,30);
			break;
	
		}
		brick.setFilled(true);
		brick.setFillColor(randomY.nextColor());
		add(brick,randomY.nextDouble(0, FRAMEWIDTH - 20),0);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		
		int keyCode = key.getKeyCode();

		if (brick.getX() > 0 && (brick.getX() + brick.getWidth()) < FRAMEWIDTH ) {
		switch (keyCode) {
		
			case 37:
				//left
				brick.move(-BRICK_SIZE, 0);
				break;
			case 39: //right
				brick.move(BRICK_SIZE, 0);
				break;
			default: 
				break;
		}
	}
	}
	
	private void moveBrick() {
		if (brick.getY() <= (FRAMEWIDTH - brick.getHeight())) {
			brick.move(0, 10);
		}
	}

	private void setup() {
		setSize(FRAMEWIDTH,FRAMEWIDTH);
		addKeyListeners();
		createBrick();
	}	
}
