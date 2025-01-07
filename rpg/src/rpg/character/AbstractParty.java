package rpg.character;

import rpg.character.hero.Hero;

public abstract class AbstractParty {
	private AbstractCharacter[] members;
	
	public AbstractParty(AbstractCharacter[] members) {
		this.members = members;
	}
	
	protected boolean isEscapeAll(AbstractCharacter[] members) {
		boolean isEscapeAll = false;
		for(AbstractCharacter member: members) {
			if(!member.isEscaped()) {
				isEscapeAll = true;
			}
		}
		return isEscapeAll;
	}
	
	public boolean isAllDead() {
		boolean isAllDead = true;
		for(AbstractCharacter member: this.members) {
			if(!member.isDead()) {
				isAllDead = false;
			}
		}
		return isAllDead;
	}
	
	public String turn(AbstractParty enemies) {
		for(AbstractCharacter member: this.members) {
			if(!member.isDead() && !member.isEscaped()) {
				Hero hero = (Hero) member;
				hero.command(member, enemies);
			}
		}
		return "";
	}
	
	public AbstractCharacter[] getMembers() {
		return this.members;
	}
}
