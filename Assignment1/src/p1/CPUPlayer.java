package p1;

import java.util.concurrent.ThreadLocalRandom;

public class CPUPlayer extends Player{
	
	
	public CPUPlayer(Monster monster) {
		super(monster);
	}
	
	protected int chooseMove() {
		return ThreadLocalRandom.current().nextInt(1, 4 + 1);
	}



}
