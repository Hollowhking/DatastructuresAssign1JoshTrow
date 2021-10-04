package p3;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameDriver {
	public static void Battle (Player player, Player enemy) {
		while ((!player.hasLost()) && (!enemy.hasLost())) {
			// print both monsters' HP
			System.out.println("");
			System.out.printf("%s has %d HP\n",
	                                player.getMonster().getName(),
	                                player.getMonster().getHp());
			System.out.printf("%s has %d HP\n",                
	                                enemy.getMonster().getName(),
	                                enemy.getMonster().getHp());
	
			// decide the next move
			int playerMove = player.chooseMove();
			int enemyMove = enemy.chooseMove();
	
			// execute the next move
			if (player.isFasterThan(enemy)) {
				player.attack(enemy, playerMove);
				if (!enemy.hasLost()) {
					enemy.attack(player, enemyMove);
				}
			} else {
				enemy.attack(player, enemyMove);
				if (!player.hasLost()) {
					player.attack(enemy, playerMove);
				}
			}
		}
	
		if (player.hasLost()) {
			System.out.printf("You and %s have lost the battle.\n",
	                                player.getMonster().getName());
		} else {
			System.out.printf("You and %s are victorious!\n",
	                                player.getMonster().getName());
		}
	}
	
	//For the additional portion i decided to add a little mock overworld you can explore, and have a 1/4 chance of having a wild encounter in the grass. 
	
	public static void main(String[] args) {
		//init the map
		char[][] map = new char[10][10];
		map[0][0]='T'; map [0][1]='T'; map [0][2]='T'; map [0][3]='T'; map[0][4]='E'; map[0][5]='T'; map[0][6]='T'; map[0][7]='T'; map[0][8]='T'; map[0][9]='T';
		map[1][0]='T'; map [1][1]='H'; map [1][2]='-'; map [1][3]='-'; map[1][4]='-'; map[1][5]='-'; map[1][6]='-'; map[1][7]='-'; map[1][8]='G'; map[1][9]='T';
		map[2][0]='T'; map [2][1]='G'; map [2][2]='-'; map [2][3]='-'; map[2][4]='-'; map[2][5]='-'; map[2][6]='-'; map[2][7]='G'; map[2][8]='G'; map[2][9]='T';
		map[3][0]='T'; map [3][1]='G'; map [3][2]='-'; map [3][3]='-'; map[3][4]='-'; map[3][5]='-'; map[3][6]='-'; map[3][7]='G'; map[3][8]='G'; map[3][9]='T';
		map[4][0]='T'; map [4][1]='G'; map [4][2]='-'; map [4][3]='-'; map[4][4]='-'; map[4][5]='-'; map[4][6]='-'; map[4][7]='G'; map[4][8]='G'; map[4][9]='T';
		map[5][0]='T'; map [5][1]='G'; map [5][2]='-'; map [5][3]='-'; map[5][4]='-'; map[5][5]='-'; map[5][6]='-'; map[5][7]='G'; map[5][8]='G'; map[5][9]='T';
		map[6][0]='T'; map [6][1]='G'; map [6][2]='G'; map [6][3]='-'; map[6][4]='-'; map[6][5]='-'; map[6][6]='G'; map[6][7]='G'; map[6][8]='G'; map[6][9]='T';
		map[7][0]='T'; map [7][1]='G'; map [7][2]='G'; map [7][3]='-'; map[7][4]='-'; map[7][5]='-'; map[7][6]='G'; map[7][7]='G'; map[7][8]='G'; map[7][9]='T';
		map[8][0]='T'; map [8][1]='G'; map [8][2]='G'; map [8][3]='-'; map[8][4]='B'; map[8][5]='-'; map[8][6]='G'; map[8][7]='G'; map[8][8]='G'; map[8][9]='T';
		map[9][0]='T'; map [9][1]='T'; map [9][2]='T'; map [9][3]='T'; map[9][4]='T'; map[9][5]='T'; map[9][6]='T'; map[9][7]='T'; map[9][8]='T'; map[9][9]='T';

		/* T=tree(wall), - normal ground, B = CPU BOSS, P player location, G grass(possible wild encounter), H=health center(refill pokemon health)
		 * T T T T T T T T T T 9
		 * T G G - B - G G G T 8
		 * T G G - - - G G G T 7
		 * T G G - - - G G G T 6
		 * T G - - - - - G G T 5
		 * T G - - - - - G G T 4
		 * T G - - - - - G G T 3
		 * T G - - - - - G G T 2
		 * T H - - P - - - G T 1
		 * T T T T E T T T T T 0
		 * 0 1 2 3 4 5 6 7 8 9
		 */// E = end game
		//10 different monsters with 4 on each person 
		Scanner in = new Scanner(System.in);
		Move move1 = new Move("Vine Whip", "Grass", 45, 1.0f);
		Move move2 = new Move("Tackle", "Normal", 50, 1.0f);
		Move move3 = new Move("Take Down", "Normal", 90, 0.85f);
		Move move4 = new Move("Razor Leaf", "Grass", 55, 0.95f);
		Monster monster = new Monster("Bulbasaur", "Grass", 240, 45, 49, 49, move1, move2, move3, move4);
		Player player = new HumanPlayer(monster,4,1);

		move1 = new Move("Scratch", "Normal", 40, 1.0f);
		move2 = new Move("Ember", "Fire", 40, 1.0f);
		move3 = new Move("Peck", "Flying", 35, 1.0f);
		move4 = new Move("Fire Spin", "Fire", 35, 0.85f);
		monster = new Monster("Torchic", "Fire", 240, 45, 60, 40, move1, move2, move3, move4); 
		Player enemy = new CPUPlayer(monster,10,5);
		
		Player wild = new CPUPlayer(monster,0,0);
		
		
		while (true) {
			System.out.println(map[player.getlocationy()][player.getlocationx()]);
			for (int i=9; i>=0;i--) {
				for (int j=0; j<10;j++) {
					if (i==player.getlocationy()&&j==player.getlocationx()) {
						System.out.print("P ");
					}
					else {
						System.out.print(map[i][j]+" ");
					}
				}
				System.out.print("\n");
			}
			System.out.println("Where would you like to go: "+"\n"+"1. North"+"\n"+"2.East"+"\n"+"3.South"+"\n"+"4.West");
			String s = in.nextLine();
			switch(s) {
				case("1"):
					player.setlocationy(player.getlocationy()+1);
					break;
				case("2"):
					player.setlocationx(player.getlocationx()+1);
					break;
				case("3"):
					player.setlocationy(player.getlocationy()-1);
					break;
				case("4"):
					player.setlocationx(player.getlocationx()-1);
					break;
			}
			switch (map[player.getlocationy()][player.getlocationx()]) {
				case('T'):
					System.out.println("Oh theres a tree blocking the path");
					switch(s) {
						case("1"):
							player.setlocationy(player.getlocationy()-1);
							break;
						case("2"):
							player.setlocationx(player.getlocationx()-1);
							break;
						case("3"):
							player.setlocationy(player.getlocationy()+1);
							break;
						case("4"):
							player.setlocationx(player.getlocationx()+1);
							break;
					}
					break;
				case('H'):
					player.monster.heal();
					System.out.println("Your monster has been healed to: "+player.monster.hp);
					break;
				case('G'):
					System.out.println("grass");
					if (ThreadLocalRandom.current().nextInt(1, 4 + 1)==4) {
						System.out.println("WILD ENCOUNTER");
						Battle(player,wild);
					}
					break;
				case('B'):
					System.out.println("BOSS");
					Battle(player,enemy);
					break;
				case('E'):
					System.out.println("Goodbye");
					System.exit(0);

			}
				
		}
	}
}