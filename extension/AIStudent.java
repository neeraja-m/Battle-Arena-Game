public class AIStudent extends Student {

  //Constructor initialising AIStudent's base attributes
  protected AIStudent(String name){
    super(name,6,7,7,5,(int) Math.round(3*(Math.pow(1,1.2) )));
  }

  protected void machineLearning(Character enemy) throws Exception{ //Takes monster to attack as parameter
    if(this.getcurrentKP() != this.getMaxKP()) {throw new Exception("  ILLEGAL MOVE : not enough KP for machineLearning");} //Throws exception if special ability is invoked without reaching maximum KP
    enemy.decreaseHP(2 * (100 * this.getAttack()) / (100 + enemy.getDefence()));
    if (enemy.getHP() == 0) {
      System.out.println(enemy.getName()+" is now dead:"); //When enemy has died, monster is added to ArrayList containing dead monsters
      deadMonsters.add(enemy);
      this.increaseEP(4);
    }
    this.increaseEP(4);
    this.setcurrentKP(0);
    this.toRemove(enemy.getTeam()); //Monster is removed from its team if it is dead to prevent attacks on dead member
    System.out.println("machineLearning successfully used by "+this.getName()+" to attack "+enemy.getName());
  }

  protected void naturalLanguageProcessing() throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()){ throw new Exception("  ILLEGAL MOVE : not enough KP for naturalLanguageProcessing");}

    this.increaseHP(this.getDefence()); // Increases students own HP by the amount of the students defence points
    this.increaseEP(4);
    this.setcurrentKP(0);
    System.out.println("naturalLanguageProcessing successfully used by "+this.getName());

  }

}
