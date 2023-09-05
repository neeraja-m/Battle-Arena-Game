
public class SEStudent extends Student {

  //Constructor initialising SEStudent's base attributes
  protected SEStudent(String name) {
    super(name,8,5,8,4,(int) Math.round(10*(Math.pow(1,1.2) )));
  }

  protected void groupWork(Character enemy) throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()) {throw new Exception("ILLEGAL MOVE : not enough KP for groupWork");}

    for (Character members : this.getTeam().getMembers()) { //allows all (alive) members of the team to attack enemy
      if (members.getHP() > 0) {
        enemy.decreaseHP((100 * members.getAttack()) / (100 + enemy.getDefence()));
      }
    }
    if (enemy.getHP() == 0) {
      System.out.println(enemy.getName()+" is now dead:");
      deadMonsters.add(enemy); //adds monster if dead to deadmonsters list and removes from team
      this.increaseEP(4);
    }
    this.increaseEP(4);
    this.setcurrentKP(0);
    this.toRemove(enemy.getTeam()); //removes all dead members of enemy team
    System.out.println("groupWork successfully used by "+this.getName()+" on "+enemy.getName());
  }

  protected void groupDiscussion()throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()) {throw new Exception("ILLEGAL MOVE : not enough KP for groupDiscussion");}

    for (Character member : this.getTeam().getMembers()) { //student heals all alive members of their team
      if (member.getHP() > 0) {
        member.increaseHP((int) (0.5 * this.getDefence()));
      }
    }
    this.increaseEP(4);
    this.setcurrentKP(0);
    System.out.println("groupDiscussion successfully used by "+this.getName());
  }
}



