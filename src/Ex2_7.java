import java.util.ArrayList;
import java.util.List;

public class Ex2_7 {


} 
 interface Damageable{
	public void takeDamage(int damage);
	public void takeHealing(int healing) ;
	public boolean isAlive();
		
	
}
 interface Caster{
	public void castSpell(Damageable target);
	public void learnSpell(Spell spell);
	
}

interface Combat extends Damageable{
	void attack(Damageable target);
    void lootWeapon(Weapon weapon);
	
}
interface Useable{
	public int use();
}
class Spell implements Useable{
	private int minHeal;
	private int maxHeal;
	private String name;
	public Spell(int minHeal, int maxHeal, String name) {
		this.minHeal = minHeal;
		this.maxHeal = maxHeal;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int heal() {
		return (int) ((Math.random()*maxHeal-minHeal+1)+minHeal);
	}
	public int use() {
		return heal(); 
		
	}  
}
class Weapon implements Useable{
	private int minDamage;
	private int maxDamage;
	private String name;
	public Weapon(int minDamage, int maxDamage, String name) {
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int attack() {
		return (int) ((Math.random()*maxDamage-minDamage+1)+minDamage);

	}
	public int use() {
		return attack();
	}
	
}

class Attributes{
	 public int strength;
	public int intelligence;
	public Attributes(int strength, int intelligence) {
		this.strength = strength;
		this.intelligence = intelligence;
	}
	public Attributes() {}
	public void increaseStrength(int amount) {
		strength-=amount;
	}
	public void increaseIntelligence(int amount) {
		intelligence-=amount;
	}
	public int getStrength() {
		return strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public String toString() {
		return "Attributes [Strength= " + strength + ", intelligence= " + intelligence +
				"]";
	}
}

abstract class Character implements Comparable{
	private String name;
	protected int level;
	protected Attributes attributes;
	protected int health;
	public Character(String name, Attributes attributes) {
		this.name = name;
		this.attributes = attributes;
	}
	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	
	public abstract void levelUp();
	public String toString() {
		return getName() + " LvL: " + level + " – " + attributes;
	}
	
	
}
	abstract class PlayableCharacter extends Character implements Damageable{
		private boolean inParty;
		private Party party;
		public PlayableCharacter(String name, Attributes attributes) {
	        super(name, attributes);
	        this.inParty=true;
		}
		
		public boolean isInParty()
		{
			return inParty;
		}
		public void joinParty(Party party) throws PartyLimitReachedException, AlreadyInPartyException {
			try {
				party.addCharacter(this);
	            inParty=true;
	            this.party=party;}
				catch(AlreadyInPartyException e){
			           System.out.println(e);
	             } 
			}
		
		public void quitParty() throws CharacterIsNotInPartyException {
			try {
			  party.removeCharacter(this);
			      inParty=false; 
			      party=null;
			  }
			 catch( CharacterIsNotInPartyException e){
				 System.out.println(e);
			 }
		    } 
	  }

	abstract class NonPlayableCharacter extends Character{

		public NonPlayableCharacter(String name, Attributes attributes) {
			super(name, attributes);
		}
	}
	
	class Merchant extends NonPlayableCharacter{

		public Merchant(String name){
		   super(name,new Attributes(0,0));
		  
	  }
		public void levelUp() {}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		}
	class Skeleton extends NonPlayableCharacter implements Combat{
		public Skeleton(String name, Attributes attributes) {
			super(name, attributes);
		}

		public void lootWeapon(Weapon weapon) {}
		
		public void levelUp() {
			level++;
	        attributes.increaseStrength(1);
	        attributes.increaseIntelligence(1);
		
		}
		public void takeHealing(int healing) {
			health+=healing;;
		}

		@Override
		public void takeDamage(int damage) {
			health -= damage;
		}

		@Override
		public boolean isAlive() {
			if(health>0) 
				return true;
			else
				return false;
		}


	

		@Override
		public void attack(Damageable target) {
			 int totalAttributes = attributes.getStrength() + attributes.getIntelligence();
	            target.takeDamage(totalAttributes);
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
		class Warrior extends PlayableCharacter implements Combat{

			public Warrior(String name) {
				super(name, new Attributes(2,4));
				this.health=35;
			}
			public void levelUp() {
				level++;
		        attributes.increaseStrength(2);
		        attributes.increaseIntelligence(1);
			}
			@Override
			public void takeDamage(int damage) {
				health -= damage;
				
			}
			@Override
			public void takeHealing(int healing) {
				health += healing;
				
			}
			@Override
			public boolean isAlive() {
				if(health>0) 
					return true;
				else
					return false;
			}
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public void attack(Damageable target) {
				int totalAttributes = attributes.getStrength();
	            target.takeDamage(totalAttributes);
				
			}
			@Override
			public void lootWeapon(Weapon weapon) {
				this.lootWeapon(weapon);
				
			}
			
		}
		class Cleric extends PlayableCharacter implements Caster{
			private Useable spell;
			public Cleric(String name) {
				super(name, new Attributes(2,4));
				this.health=25;
			}
			public void levelUp() {
				attributes.increaseIntelligence(2);
				attributes.increaseStrength(1);
				level++;
				
			}
			@Override
			public void takeDamage(int damage) {
				health -= damage;
				
			}
			@Override
			public void takeHealing(int healing) {
                health+=healing;				
			}
			@Override
			public boolean isAlive() {
				if(health>0) 
					return true;
				else
					return false;
			}
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public void castSpell(Damageable target) {
				if(spell!=null){
		           target.takeHealing(attributes.getIntelligence()+spell.use());
		        }
				
			}
			@Override
			public void learnSpell(Spell spell) {
				this.spell=spell;
				
			}
		}
		class Paladin extends PlayableCharacter implements Combat,Caster{
			private Useable weapon;
			private Useable spell;
			public Paladin(String name) {
				super(name, new Attributes());
				this.health=30;
		}
			public void levelUp() {
				attributes.increaseIntelligence(1);
				attributes.increaseStrength(2);
				if(level%2!=0) {
					level++;
				}
				
			}
			@Override
			public void takeDamage(int damage) {
				health -= damage;
				
			}
			@Override
			public void takeHealing(int healing) {
				health+=healing;
				
			}
			@Override
			public boolean isAlive() {
				if(health>0) 
					return true;
				else
					return false;
			}
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public void castSpell(Damageable target) {
				if(spell!=null){
		          target.takeHealing(attributes.getIntelligence()+spell.use());
		        }				
			}
			@Override
			public void learnSpell(Spell spell) {
				this.spell=spell;
				
			}
			@Override
			public void attack(Damageable target) {
				 target.takeDamage(health);
			}
			@Override
			public void lootWeapon(Weapon weapon) {
			this.weapon=weapon;
				
			}
		}
		class Party{
			private static final int partyLimit=8;
			 private List<Combat> fighters;
			 private List<Caster> healers;
			 private int mixedCount;
			 public void addCharacter (PlayableCharacter character)throws PartyLimitReachedException,AlreadyInPartyException
			 {
				 if (character instanceof Combat) {
			            fighters.add((Combat) character);
			        }
			         if (character instanceof Caster) {
			            healers.add((Caster) character);
			            if (character instanceof Paladin) {
			                mixedCount++;
			            }} 
			      if(fighters.contains(character)||healers.contains(character)) {
			          throw new AlreadyInPartyException("character in party");
			          
			        }
			      if(fighters.size()+healers.size()>=partyLimit) {
				       throw new PartyLimitReachedException("party is full");
				        }
			 }
			 public void removeCharacter(PlayableCharacter character) throws CharacterIsNotInPartyException{
				 if (character instanceof Combat) {
			            fighters.remove(character);
			      if (character instanceof Caster) {
			             healers.remove(character);
			             if (character instanceof Paladin) {
			              mixedCount--;
			                }
			             }
				     }
			      }
			 public void partyLevelUp() {
			    for (Combat character:fighters) {
			    	//character.levelUp();
			        }
			    for (Caster character:healers) {
			            if(!(character instanceof Paladin)) {
			              //  character.levelUp();
			            }
			        }
			 }
			 public String toString() {
				    String result= "";
				    for (Combat character:fighters ){
							result+= character+ "\n";
						}
				    for(Caster character:healers) {
				    	result+=character+"\n";
				    }
				    return result;
		}
		}
		class Barrel implements Damageable{
			private int health=30;
			private int capacity=10;
			public void explode() {
				 System.out.println("Explodes");
			}
			public void repair() {
				System.out.println("Repairing");
			}
			public void takeDamage(int damage) {
				if(health<=0) {
					explode();
				}
			}
			public void takeHealing(int healing) {
				health+=healing;
				repair();
			}
			@Override
			public boolean isAlive() {
				if(health>0) {
				return true;
			}
				else 
					return false;
			}
		}
		class TrainingDummy implements Damageable{
			private int health=25;

			@Override
			public void takeDamage(int damage) {
				
				health-=damage;
			}

			@Override
			public void takeHealing(int healing) {
				health+=healing;
			}

			@Override
			public boolean isAlive() {
				if(health>0) 
					return true;
				else 
					return false;
			}
		}
		
	class PartyLimitReachedException extends Exception{
		public PartyLimitReachedException(String message) {
	        super(message);
	    }
	}
	class AlreadyInPartyException extends Exception{
		 public AlreadyInPartyException(String message) {
		        super(message);
		    }
		}
	
	class CharacterIsNotInPartyException extends Exception{
		public CharacterIsNotInPartyException(String message) {
	        super(message);
	    }
	}
		
	
	
	
	
	
	
	
	
	