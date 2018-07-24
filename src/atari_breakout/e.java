import java.awt.Rectangle;

boolean checkBlackCollision(int ballX, int ballY) {
	for(Blocks s : Blackblocks) {
		if( s.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {
			
			
        //removeBlackBlock(Blackblocks.get(i));
		//addGreenBlock(Blackblocks.get(i));
		return true;
		} 
	}


	for(Blocks s : Greenblocks) {
	if (s.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {
		
		
		//removeGreenBlock(Greenblocks.get(i));
		//addRedBlock(Greenblocks.get(i));
		return true;
	}
	}
	for(Blocks s : Redblocks) {
		if (s.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {
	
		
		//removeRedBlock(Redblocks.get(i));
			return true;
}


______________________________________________________________________


boolean checkBlackCollision(int ballX, int ballY) {
	if(Blackblocks.size()==0) {
		return false;
	}else {
	for (Blocks s : Blackblocks) {
		if (s.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {

			// removeBlackBlock(Blackblocks.get(i));
			// addGreenBlock(Blackblocks.get(i));
			return true;
		} else {
			return false;
		}
	}}
	return false;
	
}

boolean checkGreenCollision(int ballX, int ballY) {
	for (Blocks s : Greenblocks) {
		if (s.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {

			// removeGreenBlock(Greenblocks.get(i));
			// addRedBlock(Greenblocks.get(i));
			return true;
		} else {
			return false;
		}
	}
}

boolean checkRedCollision(int ballX, int ballY) {
	for (Blocks s : Redblocks) {
		if (s.collisionBox.intersects(new Rectangle(ballX, ballY, 50, 50))) {

			// removeRedBlock(Redblocks.get(i));
			return true;
		} else {
			return false;
		}
	}
}

}


