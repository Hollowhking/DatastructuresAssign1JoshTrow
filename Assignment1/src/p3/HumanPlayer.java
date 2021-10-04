package p3;

import java.util.Scanner;

public class HumanPlayer extends Player{

	public HumanPlayer(Monster monster, int x, int y) {
		super(monster, x, y);
	}

	protected int chooseMove() {
		System.out.println("1. "+this.monster.move1.name+"\n"+"2. "+this.monster.move2.name+"\n"+"3. "+this.monster.move3.name+"\n"+"4. "+this.monster.move4.name+"\n"+"whichMove? ");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		return Integer.parseInt(s);
	}


}
