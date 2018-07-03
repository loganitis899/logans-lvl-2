package atari_breakout;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManger {
	ArrayList<Blocks> blocks = new ArrayList<Blocks>();
	Blocks block = new Blocks(500, 500, 100, 100);

	ObjectManger(Blocks block) {
		this.block = block;
	}

	void update() {

		for (Blocks s : blocks) {
			s.update();

		}
	}

	void draw(Graphics g) {

		for (Blocks s : blocks) {
			s.draw(g);

		}
	}

	// Black is strongest... 3 lives left
	// Green is Middle... 2 lives left
	// Red is One Shot... 1 life left

	void addBlackBlock(Blocks block) {
		blocks.add(block);

	}

	void addGreenBlock(Blocks block) {
		blocks.add(block);
	}

	void addRedBlock(Blocks block) {
		blocks.add(block);
	}

	void removeBlackBlock(Blocks block) {
		blocks.remove(block);

	}

	void removeGreenBlock(Blocks block) {
		blocks.remove(block);
	}

	void removeRedBlock(Blocks block) {
		blocks.remove(block);
	}

	public void spawnBricks() {
		{
			addBlackBlock(new Blocks(500, 500, 50, 50));

		}
	}

}
