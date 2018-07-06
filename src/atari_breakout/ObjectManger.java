package atari_breakout;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ObjectManger {
	int blockX;
	int blockY;
	ArrayList<Blocks> blocks = new ArrayList<Blocks>();
	Blocks block = new Blocks(blockX, blockY, 100, 100);

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
			blockX = blockX + 100;
			if (blockX > 1000) {
				blockX = 0;
				blockY = blockY + 100;
			}
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
			addBlackBlock(new Blocks(blockX, blockY, 50, 50));

		}
	}

	void setUp() {
		for (int i = 0; i < 18 * 3; i++) {

			Blocks block = new Blocks(blockX, blockY, 100, 100);
			blockX = blockX + 103;

			addBlackBlock(block);

			if (blockX > atariBreakout.frameXSize - 100) {
				blockX = 0;
				blockY = blockY + 103;

			}
		}
	}

	void checkCollision(int ballX, int ballY, int speedY) {
		for (Blocks s : blocks)
			if (s.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {
				speedY = -speedY;
				System.out.println("workerd");
			}
	}

}
