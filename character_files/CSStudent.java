public class CSStudent extends Student {

  //Constructor initialising CSStudent's base attributes
  protected CSStudent(String name) {
    super(name, 7,6,6,6,(int) Math.round(3*(Math.pow(1,1.2) )));

  }
  protected void pairWorking(Character friend, Character enemy) throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()) {throw new Exception("  ILLEGAL MOVE : not enough KP for pairWorking");}

    enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));//Enemy's attacked by both student and friend
    enemy.decreaseHP((100 * friend.getAttack()) / (100 + enemy.getDefence()));

    if (enemy.getHP() == 0) {
      System.out.println(enemy.getName()+" is now dead:");
      deadMonsters.add(enemy); // When monster is dead, they are added to list of dead monsters and removed from their team
      this.increaseEP(4);
    }

    this.increaseEP(4);
    this.setcurrentKP(0);
    this.toRemove(enemy.getTeam());
    System.out.println("pairWorking successfully used by "+this.getName()+" with "+friend.getName()+" on "+enemy.getName());
  }


  protected void support(Character friend)throws Exception{
    if(this.getcurrentKP() != this.getMaxKP()) {throw new Exception("  ILLEGAL MOVE : not enough KP for support");}

    friend.increaseHP((int) ((this.getDefence()) * 0.5)); //Increases friend's HP by half of students defence points
    this.increaseEP(4);
    this.setcurrentKP(0);

    System.out.println("support successfully used by "+this.getName()+" on "+friend.getName());
  }
}