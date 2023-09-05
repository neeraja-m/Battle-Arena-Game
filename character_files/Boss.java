public class Boss extends Character implements Monster {

  //Constructor to initialise base attributes
  protected Boss(String name){
    super(name, 8,7,8,7);
  }

  public void strike(Character toAttack) { //Allows attack to be called depending on given probabilities for Bosses
    int x = new java.util.Random().nextInt(99);//Generates a random number x where 0<=x<=99 whenever method is called
    if ( x <= 9) { //For example, if the number x is 0<=x<=9, it had 10/100 (10%) chance of being generated so calls corresponding attack
      this.concurrentModificationException(toAttack);
    }
    else if ( x <= 24) {
      this.nullPointerException();
    }
    else if ( x <= 39) {
      this.arrayIndexOutOfBoundsException(toAttack);
    }
    else if ( x <= 49) {
      this.noneTermination();
    }
    else {
      this.syntaxError(toAttack);
    }
  }


  public void syntaxError(Character toAttack){
    toAttack.decreaseHP((100 * this.getAttack() )/ (100 + toAttack.getDefence()));
    if (toAttack.getHP() == 0) {
      System.out.println(toAttack.getName()+" is now dead:");
      toAttack.increaseEP(3);
      toAttack.setCurrentHP(0);
      toAttack.getTeam().members.remove(toAttack); //If member dies, they are removed from their team
      this.increaseEP(4);
    }
    this.increaseEP(3);
    if(toAttack.getHP()>0){toAttack.increaseEP(3);}
    if (toAttack instanceof Student && toAttack.getHP()>0) {
      ((Student) toAttack).increaseKP(3);
    }
    System.out.println("syntaxError successfully used by " + this.getName() + " to attack " + toAttack.getName());
  }

  public void nullPointerException(){
    this.increaseHP(this.getDefence());
    this.increaseEP(3);
    System.out.println("nullPointerException successfully used by "+this.getName());
  }

  public void arrayIndexOutOfBoundsException(Character toAttack){
    toAttack.decreaseHP(2 * (100 * this.getAttack()) / (100 + toAttack.getDefence()));
    if (toAttack.getHP() == 0) {
      System.out.println(toAttack.getName()+" is now dead:");
      toAttack.increaseEP(3); //Allows student to level up if target EP reached without healing them
      toAttack.setCurrentHP(0);
      toAttack.getTeam().members.remove(toAttack);
      this.increaseEP(4);
    }
    this.increaseEP(3);
    if(toAttack.getHP()>0){toAttack.increaseEP(3);}
    if (toAttack instanceof Student && toAttack.getHP()>0) {
      ((Student) toAttack).increaseKP(3);
    }
    System.out.println("arrayIndexOutOfBoundsException successfully used by " + this.getName() + " to attack " + toAttack.getName());


  }

  public void noneTermination () {
    for (Character deadmonster : deadMonsters) { //Accesses dead monsters and resurrects to maximum HP
      if(deadmonster.getHP()==0) { //HP has to be checked as resurrected monsters are not removed from the deadmonsters list
        deadmonster.increaseHP(deadmonster.getMaxHP());
        System.out.println(deadmonster.getName() + " has been resurrected");
        this.getTeam().members.add(deadmonster); //Adds now alive monster to team
      }
    }
    this.increaseEP(3);
    System.out.println("noneTermination successfully used by "+this.getName());
  }

  public void concurrentModificationException (Character toAttack) {
    for (Character enemy : toAttack.getTeam().getMembers()) { //Attacked all members of enemy's team
      enemy.decreaseHP((100 * this.getAttack()) / (100 + toAttack.getDefence()));
      if (enemy.getHP() == 0) {
        System.out.println(enemy.getName()+" is now dead:");
        enemy.increaseEP(3);
        enemy.setCurrentHP(0);
        this.increaseEP(4);
      } if (enemy instanceof Student && enemy.getHP()>0) {
        ((Student) enemy).increaseKP(3);
      }
      if(enemy.getHP()>0){enemy.increaseEP(3);}
      this.increaseEP(3);

    }
    this.toRemove(toAttack.getTeam()); // dead members must be removed after rather than directly in if statement while iterating through list
    System.out.println("concurrentModificationException successfully used by "+this.getName()+ " to attack "+toAttack.getTeam().getName());
  }
}
