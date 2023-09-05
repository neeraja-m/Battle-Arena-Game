public class AeroStudent extends Student {

  //Constructor initialising AeroStudent's base attributes
  protected AeroStudent(String name){
    super(name,5,7,6,8,(int) Math.round(4*(Math.pow(1,1.2) )));
  }

  protected void signalProcessing(Character enemy) throws Exception{ //Takes monster to attack as parameter
    if(this.getcurrentKP() != this.getMaxKP()) {throw new Exception("  ILLEGAL MOVE : not enough KP for signalProcessing");} //Throws exception if special ability is invoked without reaching maximum KP
    enemy.decreaseHP(3 * (100 * this.getAttack()) / (100 + enemy.getDefence()));
    if (enemy.getHP() == 0) {
      System.out.println(enemy.getName()+" is now dead:"); //When enemy has died, monster is added to ArrayList containing dead monsters
      deadMonsters.add(enemy);
    }
    this.increaseEP(4);
    this.setcurrentKP(0);
    this.toRemove(enemy.getTeam());//Monster is removed from its team once dead to prevent attacks on dead member
    System.out.println("signalProcessing successfully used by "+this.getName()+" to attack "+enemy.getName());
  }

  protected void radarTechnique() throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()){ throw new Exception("  ILLEGAL MOVE : not enough KP for radarTechnique");}

    this.increaseHP(this.getAttack()); // Increases students own HP by the amount of the students attack points
    this.increaseEP(4);
    this.setcurrentKP(0);
    System.out.println("radarTechnique successfully used by "+this.getName());

  }

}

