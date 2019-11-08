package assignmentTwo;

import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Agrar extends GraphicsProgram {

	private GOval cell;
	private GOval pilets;
	private RandomGenerator rGen;
	
	public void run() {
		
		setup();
		createCell();
		fillRandomPelets();
		while (true) {
		checkForCollision();
		pause(40);
		}
	}

	private void fillRandomPelets() {
		
		rGen = new RandomGenerator();
		
		for (int i = 0; i < rGen.nextInt(50, 100); i++) {
			pilets = new GOval(10,10);
			pilets.setFillColor(rGen.nextColor());
			pilets.setFilled(true);
			add(pilets, rGen.nextInt(500),rGen.nextInt(500));
		}
	}

	private void createCell() {
		cell = new GOval(40,40);
		add(cell,230,230);
	}

	private void checkForCollision() {
		
		GObject collisionObj = getElementAt(cell.getX(), cell.getY());
		
		if((collisionObj != cell) && ( null != collisionObj) ) {
			remove(collisionObj);
			increaseCell();
		}
	}

	private void increaseCell() {
		cell.setSize(cell.getHeight() + 2, cell.getWidth() + 2);
	}
	
	private void setup() {
		setSize(500, 500);
		addMouseListeners();
	}
	
	@Override
	
	public void mouseMoved(MouseEvent e) {
		checkForCollision();
		cell.setLocation(e.getX(),e.getY());
	}
}
