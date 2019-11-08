package assignmentTwo;

import java.awt.event.MouseEvent;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class AsteroidCreator extends GraphicsProgram {

	private GRect rect;
	private RandomGenerator rGen;

		
		public void run() {
			setup();
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			add(Asteroid(),e.getX(),e.getY());
		}
		
		
		private void setup() {
			setSize(500, 500);
			addMouseListeners();
		}
	
	private GRect Asteroid() {
		rGen = new RandomGenerator();
		rect = new GRect(rGen.nextInt(20, 50),rGen.nextInt(20, 50));
		return rect;
	}
}
