public class NanoTechStudent extends Student {

  //Constructor initialising NanoTechStudent's base attributes
  public NanoTechStudent(String name) {
    super(name, 6, 5, 8, 7, (int) Math.round(5 * (Math.pow(1, 1.2))));

  }
  protected void nanoFabrication(Character enemy) throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()) {throw new Exception("ILLEGAL MOVE : not enough KP for nanoFabrication");}//Throws exception if special ability is invoked without reaching maximum KP

    for (Character members : this.getTeam().getMembers()) { //allows all members of the team to attack enemy
      enemy.decreaseHP((100 * members.getAttack()) / (50 + enemy.getDefence()));
    }

    if (enemy.getHP() == 0) {
      System.out.println(enemy.getName()+" is now dead:");
      deadMonsters.add(enemy); //adds monster if dead to deadmonsters list and removes from team
      this.increaseEP(5);
    }
    this.increaseEP(5);
    this.setcurrentKP(0);
    this.toRemove(enemy.getTeam()); //Checks and removes dead members of enemy team
    System.out.println("nanoFabrication successfully used by "+this.getName()+" on "+enemy.getName());
  }

  protected void controlling(Team enemyTeam)throws Exception {
    if (this.getcurrentKP() != this.getMaxKP()) {
      throw new Exception("ILLEGAL MOVE : not enough KP for controlling");//Throws exception if special ability is invoked without reaching maximum KP
    }
    for (Character enemy : enemyTeam.getMembers()) { //decreases HP of enemy team members by half of previous HP
      enemy.setCurrentHP((int) (0.5 * enemy.getHP()));

      if (enemy.getHP() == 0) {
        System.out.println(enemy.getName() + " is now dead:");
        deadMonsters.add(enemy); //adds monster if dead to deadmonsters list and removes from team
        this.increaseEP(5);
      }
    }
    this.increaseEP(4);
    this.setcurrentKP(0);

    this.toRemove(enemyTeam);
    System.out.println("controlling successfully used by "+this.getName());
  }
}

