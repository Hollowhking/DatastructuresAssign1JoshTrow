package p3;

public class Monster {
	String name, type;
	int hp,speed,attack,defense, maxhp;
	Move move1,move2,move3,move4;

	public Monster(String name, String type, int hp, int speed, int attack, int defense, Move move1, Move move2, Move move3,Move move4) {
		this.name=name;
		this.type=type;
		this.hp=hp;
		this.maxhp=hp;
		this.speed=speed;
		this.attack=attack;
		this.defense=defense;
		this.move1=move1;
		this.move2=move2;
		this.move3=move3;
		this.move4=move4;
	}

	public void heal() {
		this.hp=maxhp;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}


	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp=hp;
	}

	public int getSpeed() {
		return speed;
	}

	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}

	public Move getMove1() {
		return move1;
	}

	public Move getMove2() {
		return move2;
	}

	public Move getMove3() {
		return move3;
	}


	public Move getMove4() {
		return move4;
	}

	
	

}