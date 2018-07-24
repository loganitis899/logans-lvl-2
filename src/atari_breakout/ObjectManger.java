package atari_breakout;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ObjectManger {
	int blockX;
	int blockY;
	ArrayList<Blocks> Blackblocks = new ArrayList<Blocks>();
	ArrayList<Blocks> Greenblocks = new ArrayList<Blocks>();
	ArrayList<Blocks> Redblocks = new ArrayList<Blocks>();
	Blocks block = new Blocks(blockX, blockY, 100, 100);

	ObjectManger(Blocks block) {
		this.block = block;
	}

	void update() {

		for (Blocks s : Blackblocks) {
			s.update();
		}

		for (Blocks s : Greenblocks) {
			s.update();
		}

		for (Blocks s : Redblocks) {
			s.update();
		}

	}

	void drawBlackBlocks(Graphics g) {

		for (Blocks s : Blackblocks) {

			s.drawBlackBlock(g);

		}
	}

	void drawGreenBlocks(Graphics g) {
		for (Blocks s : Greenblocks) {

			s.drawGreenBlock(g);

		}

	}

	void drawRedBlocks(Graphics g) {
		for (Blocks s : Redblocks) {

			s.drawRedBlock(g);

		}

	}

	// Black is strongest... 3 lives left
	// Green is Middle... 2 lives left
	// Red is One Shot... 1 life left

	void addBlackBlock(Blocks block) {
		Blackblocks.add(block);

	}

	void addGreenBlock(Blocks block) {
		Greenblocks.add(block);
	}

	void addRedBlock(Blocks block) {
		Redblocks.add(block);
	}

	void removeBlackBlock(Blocks block) {
		Blackblocks.remove(block);

	}

	void removeGreenBlock(Blocks block) {
		Greenblocks.remove(block);
	}

	void removeRedBlock(Blocks block) {
		Redblocks.remove(block);
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

	boolean checkCollision(int ballX, int ballY) {
		for (int i=0; i<Blackblocks.size(); i++) {
			if (Blackblocks.get(i).collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {

				removeBlackBlock(Blackblocks.get(i));
				addGreenBlock(Blackblocks.get(i));
				return true;
			}
		}

		for (int i=0; i<Greenblocks.size(); i++) {
			if (Greenblocks.get(i).collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {

				removeGreenBlock(Greenblocks.get(i));
				 addRedBlock(Greenblocks.get(i));
				return true;
			}
		}
		for (int i=0; i<Redblocks.size(); i++) {
			if (Redblocks.get(i).collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {

				removeRedBlock(Redblocks.get(i));
				return true;
			}
		}
		
	}
}
