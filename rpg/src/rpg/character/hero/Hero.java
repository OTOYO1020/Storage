package rpg.character.hero;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Hero extends AbstractCharacter {
	protected String job;
	
	public Hero(String name, int hp, int attack){
		super(name, hp, attack);
		this.job = "普通のヒーロー";
	}
	
	public void run() {
		System.out.println(super.getName() + "は逃げ出した");
		super.escaped = true;
	}
	
	public void rest() {
		super.gotHeal(super.getMaxHp());
	}
	
	//これらのメソッドはAbstractCharacterで抽象メソッドとして定義し、Heroで実装するとかなんとか
	protected void command(AbstractCharacter allies, AbstractParty enemies) {
		System.out.println(super.getName() + "(" + this.getJob() + ")の行動:");
		System.out.println("1: 戦う  2: 味方を回復  3: 必殺技");
		int command = ScanCommand.scan();
		if(command == 1) {  //戦う
			while(true) {
				if(super.attack(enemies)) {
					
				}
			}
		}else if(command == 2) {
			this.run();
		}
		
	}
	
	public String getJob() {
		return this.job;
	}
	
	/*protected AbstractCharacter selectTarget() {
		
	}*/
}
