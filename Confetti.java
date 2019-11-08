package assignmentTwo;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Confetti extends GraphicsProgram {

	private GOval circle;
	private RandomGenerator rGen;
	public void run() {
		setup();
		addMultipleConfetti();
		
	}

	private void addMultipleConfetti() {
		RandomGenerator	numGen = new RandomGenerator();
		
		for (int i = 0; i < numGen.nextInt(100,200); i++) {
			add(getCircle(),numGen.nextInt(490),numGen.nextInt(490));
		}
	}
	
	private void setup() {
		setSize(500, 500);
	}

	public GOval getCircle() {
		
		rGen = new RandomGenerator();
		circle = new GOval(20, 20);
		circle.setFillColor(rGen.nextColor());
		circle.setFilled(true);
		return circle;
	}
}
