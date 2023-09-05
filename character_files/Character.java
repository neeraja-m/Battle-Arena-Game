import java.util.ArrayList;


public class Character {
  private String name;
  private int baseHP;
  private int baseAtk;
  private int baseDef;
  private int baseSpd;
  private int level=1;
  private int currentHP;
  private int currentEP=0;
  protected Team team;
  protected ArrayList<Character> deadMonsters = new ArrayList<>();
  //Declaration of variables referring to base attributes and relevant characteristics


  protected Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd){
    this.name=name;
    this.baseHP=baseHP;
    this.baseAtk=baseAtk;
    this.baseDef=baseDef;
    this.baseSpd=baseSpd;
    currentHP = (int) Math.round(baseHP*(Math.pow(level,1.2) ));
  }
  //Constructor ensures all characters are created with base attributes

  protected String getName(){
    return name;
  }

  //Getter methods below return the current base attribute of character according to their level when called using given formula
  protected int getMaxHP(){
    int maxHP = (int) Math.round(baseHP*(Math.pow(level,1.2) ));
    return maxHP;
  }

  protected int getAttack(){
    int atk = (int) Math.round(baseAtk*(Math.pow(level,1.2)));
    return atk;
  }

  protected int getDefence(){
    int def = (int) Math.round(baseDef* (Math.pow(level,1.2)));
    return def;
  }

  protected int getSpeed(){
    int spd = (int) Math.round(baseSpd*(Math.pow(level,1.2)));
    return spd;
  }

  protected int getTargetEP(){
    int requiredEP = (int) Math.round(10*(Math.pow((level),1.5)));
    return requiredEP;
  }

  protected int getHP(){
    return currentHP;
  }

  protected int getEP(){
    return currentEP;
  }

  //Following methods are called when HP/EP are to be increased/decreased (during attacks)

  protected int increaseHP(int amount) {
    currentHP = currentHP + amount;
    if(currentHP>this.getMaxHP()) {
      currentHP = this.getMaxHP();
      return currentHP;
    }
    else{
      return currentHP;
    }
  }

  protected void decreaseHP(int amount) {
    if (currentHP-amount <= 0) {
      currentHP = 0;
    }
    else{
      currentHP = currentHP - amount;
    }
  }

  protected void increaseEP(int amount){
    currentEP= currentEP+amount;
    if(currentEP >= this.getTargetEP()) {
      level += 1;
      currentHP = this.getMaxHP();
      currentEP = 0;
    }

  }
  protected void setTeam(Team team){ //Sets team of character and adds them to their respective team
    this.team = team;
    this.team.addMember(this);
  }

  protected Team getTeam(){
    return team;
  }

  protected void setLevel(int level){
    this.level = level;
  }

  protected int getLevel(){return level;
  }
  protected int getBaseHP(){
    return baseHP;
  }

  protected void setCurrentHP(int currentHP){this.currentHP = currentHP;}

  protected void toRemove(Team toCheck){ //Checks and removes if any dead members are still remaining in their team
    toCheck.members.removeIf(tobeChecked -> tobeChecked.getHP() == 0);
  }

}