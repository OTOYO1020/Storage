package rpg.character;

import java.util.Random;

public abstract class AbstractCharacter {
	protected int attack;
	protected boolean escaped;
	private int hp, maxHp;
	private String name;
	
	protected AbstractCharacter(String name, int hp, int attack){
		this.attack = attack;
		this.hp = hp;
		this.maxHp = hp;
		this.name = name;
		this.escaped = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	private void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getAttack() {
		return this.attack;
	}
	
	private void setAttack(int i) {
		this.attack = i;
	}
	
	public int getMaxHp() {
		return this.maxHp;
	}
	
	private void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public boolean isDead() {
		if(this.hp > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean attack(AbstractParty enemies) {
		if(enemies.isAllDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = random.nextInt(this.attack) + this.attack;
		int damage = this.gotDamage(randomAttack);
		System.out.println(this.getName() + "の攻撃 nameに" + damage + "のダメージ");
		
		return true;
	}
	
	public int gotDamage(int damage) {
		this.hp -= damage;
		if(this.hp < 0) {
			this.hp = 0;
			damage = this.maxHp;
		}
		return damage;
	}
	
	public int gotHeal(int heal) {
		this.hp += heal;
		if(this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
		return heal;
	}
	
	public boolean isEscaped() {
		return false;
	}
	
	public void init() {
		//何かしら記述するんかね
	}
	
	public void actionStatus() {
		if(this.isDead()) {
			System.out.println(this.name + "は倒れた");
		}
	}
	
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		return "";
	}
}
