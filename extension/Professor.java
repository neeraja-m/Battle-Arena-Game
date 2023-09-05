public class Professor extends Character {
  //TP (Teaching Points) is only available to professors
  private int maxTP;
  private int currentTP;

  //Constructor to initialise base attributes
  public Professor(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxTP){
    super(name,baseHP,baseAtk,baseDef,baseSpd);
    this.maxTP = maxTP;
  }

  protected void increaseTP(int amount){ // Used to increase TP of professors only
    currentTP = currentTP + amount;
    if(currentTP>maxTP){
      currentTP = maxTP;
    }
    else if(currentTP<0){
      currentTP = 0;
    }
  }

  protected void marking(Team enemyTeam){ //Used to weaken enemy team members
    this.increaseEP(5);
    this.increaseTP(6);
    for(Character enemy: enemyTeam.getMembers()) { //Attacks every member of enemy team
      enemy.decreaseHP((100 * this.getAttack()) / ((50 + enemy.getDefence())));
      if (enemy.getHP() == 0) {
        System.out.println(enemy.getName() + " is now dead:");
        enemy.increaseEP(3);
        enemy.setCurrentHP(0);
        this.increaseEP(4);
      }
    }
    this.increaseEP(3);
    this.toRemove(enemyTeam);
    System.out.println("marking successfully used by "+this.getName() +" to attack "+enemyTeam.getName());
  }

  protected void lecturing(Team studentTeam){//Used to strengthen student team members
    for(Character students: studentTeam.getMembers()){
    students.increaseHP(5);
    students.increaseEP(6);
    this.increaseTP(2);}
    System.out.println("lecturing  successfully used by "+this.getName()+ " on " + studentTeam.getName() );
  }

  //Following getter and setter methods allow TP to be set and used in other classes while keeping variables private

  protected int getMaxTP(){
    return maxTP;}

  protected void setcurrentTP(int currentTP){this.currentTP = currentTP;}

}

