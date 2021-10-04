package p1;

import java.util.Random;

abstract class Player {
	
	Monster monster;
	public Player (Monster monster) {
		this.monster=monster;
	}
	
	public boolean hasLost() {
		if (monster.getHp()<=0) {
			return true;
		}
		else {
			return false;
		}
	}

	public Monster getMonster() {
		return monster;
	}

	protected boolean isFasterThan(Player enemy) {
		if (this.monster.getSpeed()>enemy.getMonster().getSpeed()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void attack(Player player, int moveselected) {
		Move movesel=null;
		int damageDealt;
		double chance;
		Random rand = new Random();
		if (moveselected==1) {
			movesel=this.getMonster().getMove1();
		}
		else if (moveselected==2) {
			movesel=this.getMonster().getMove2();
		}
		else if (moveselected==3) {
			movesel=this.getMonster().getMove3();
		}
		else if (moveselected==4) {
			movesel=this.getMonster().getMove4();
		}
		chance = rand.nextFloat();
		if (chance>movesel.accuracy) {
			return;
		}
		else {
			damageDealt=this.getMonster().getAttack()+movesel.power-player.getMonster().getDefense();
			System.out.println(this.monster.name+" uses "+movesel.name);
			System.out.println(this.monster.name+" hit for "+damageDealt+" points of damage.");
			player.getMonster().setHp(player.getMonster().getHp()-damageDealt);
		}
		return;		
	}

	protected abstract int chooseMove();
	
}
