public class Student extends Character {
  //KP is only available to students
  private int maxKP;
  private int currentKP;

  //Constructor to initialise base attributes
  public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP){
    super(name,baseHP,baseAtk,baseDef,baseSpd);
    this.maxKP = maxKP;
  }

  protected void increaseKP(int amount){ // Used to increase KP of students only
    currentKP = currentKP + amount;
    if(currentKP>maxKP){
      currentKP = maxKP;
    }
    else if(currentKP<0){
      currentKP = 0;
    }
  }

  protected void javaProgramming(Character enemy){ //Attacks enemy of enemy team
    this.increaseEP(3);
    this.increaseKP(1);
    enemy.decreaseHP((100*this.getAttack())/(100+enemy.getDefence()));
    if(enemy.getHP()==0){
      System.out.println(enemy.getName()+" is now dead:");
      enemy.increaseEP(2);//Allows enemy to level up without healing itself
      enemy.setCurrentHP(0);
      this.increaseEP(4);
    }
    enemy.increaseEP(2);

    if(enemy instanceof Student && enemy.getHP()>0){
      ((Student) enemy).increaseKP(3);
    }

    this.toRemove(enemy.getTeam());//removes enemy from team if dead
    System.out.println("javaProgramming successfully used by "+this.getName() +" to attack "+enemy.getName());
  }

  protected void selfStudy(){
    this.increaseHP(2);
    this.increaseEP(6);
    this.increaseKP(2);
    System.out.println("selfStudy successfully used by "+this.getName());
  }

  //Following getter and setter methods allow KP to be set and used in other classes while keeping variables private

  protected int getMaxKP(){
    return maxKP;}

  protected void setcurrentKP(int currentKP){this.currentKP = currentKP;}

  protected int getcurrentKP(){
    return currentKP;}


}
