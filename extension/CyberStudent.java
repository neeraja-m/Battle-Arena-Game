
public class CyberStudent extends Student {

  //Constructor initialising CyberStudent's base attributes
  protected CyberStudent(String name) {
    super(name,7,7,5,6,(int) Math.round(3*(Math.pow(1,1.2) )));
  }

  protected void cyberAttack(Team enemyTeam)throws Exception {
    if (this.getcurrentKP() != this.getMaxKP()) {throw new Exception("  ILLEGAL MOVE : not enough KP for cyberAttack");}
    for(Character enemy: enemyTeam.getMembers()){ //Attacks all members of enemy team

      enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
      if (enemy.getHP() == 0) {
        System.out.println(enemy.getName()+" is now dead:");
        deadMonsters.add(enemy);
        this.increaseEP(4);
      }

    }
    this.increaseEP(4);
    this.setcurrentKP(0);
    this.toRemove(enemyTeam);
    System.out.println("cyberAttack successfully used by "+this.getName()+ " on " +enemyTeam.getName());

  }
}