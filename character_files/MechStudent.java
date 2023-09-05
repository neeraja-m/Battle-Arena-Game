public class MechStudent extends Student {

  //Constructor initialising MechStudent's base attributes
  protected MechStudent(String name) {
    super(name, 5, 7, 7, 5, (int) Math.round(4 * (Math.pow(1, 1.2))));

  }

  protected void energyConversion(Character friend)throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()) throw new Exception("  ILLEGAL MOVE : not enough KP for energyConversion");//Throws exception if special ability is invoked without reaching maximum KP

    friend.increaseHP((2*this.getDefence())); //Increases friend's HP by 2x students defence points
    this.increaseEP(4);
    this.setcurrentKP(0);
    System.out.println("energyConversion successfully used by "+ this.getName()+ " with " + friend.getName());

  }

  protected void powerSystem(Team enemyTeam)throws Exception {
    if(this.getcurrentKP() != this.getMaxKP()) throw new Exception("  ILLEGAL MOVE : not enough KP for powerSystem");//Throws exception if special ability is invoked without reaching maximum KP
    for (Character toAttack : enemyTeam.getMembers()) {
      toAttack.decreaseHP(100 * this.getAttack() / 75); //Attacks every enemy in enemy team
      if (toAttack.getHP() == 0) {
        this.increaseEP(4);
        toAttack.setCurrentHP(0);
        this.increaseEP(4);
      }
    }
      this.increaseEP(4);
      this.setcurrentKP(0);
      this.toRemove(enemyTeam);
      System.out.println("powerSystem successfully used by "+ this.getName() + " to attack " +enemyTeam.getName());

  }
}
