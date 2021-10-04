package p3;

import java.util.concurrent.ThreadLocalRandom;

public class CPUPlayer extends Player{
	
	
	public CPUPlayer(Monster monster,int x, int y) {
		super(monster, x, y);
	}
	
	protected int chooseMove() {
		return ThreadLocalRandom.current().nextInt(1, 4 + 1);
	}

	public int getlocationx() {
		return x;
	}

	public int getlocationy() {
		return y;
	}



}