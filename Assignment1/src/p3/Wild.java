package p3;

import java.util.concurrent.ThreadLocalRandom;

public class Wild {
	public Wild(Monster monster,int x, int y) {
		super();
	}
	
	protected int chooseMove() {
		return ThreadLocalRandom.current().nextInt(1, 4 + 1);
	}


}
