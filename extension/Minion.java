public class Minion extends Character implements Monster {

  //Constructor to initialise base attributes
  protected Minion(String name){
    super(name,5,5,5,5);
  }

  public void strike(Character toAttack) { //Allows attack to be called depending on given probabilities for Minions
    int x = new java.util.Random().nextInt(99);//Generates a random number x where 0<=x<=99 whenever method is called
    if( x<=9){//For example, if the number x is 0<=x<=9, it had 10/100 (10%) chance of being generated so calls corresponding attack
      this.arrayIndexOutOfBoundsException(toAttack);
    }
    else if(x<=24){
      this.nullPointerException();
    }
    else{
      this.syntaxError(toAttack);
    }
  }
  public void syntaxError(Character toAttack){
    toAttack.decreaseHP((100 * this.getAttack() )/ (100 + toAttack.getDefence()));
    if (toAttack.getHP() == 0) {
      System.out.println(toAttack.getName()+" is now dead:");
      toAttack.increaseEP(3);
      toAttack.setCurrentHP(0);
      this.increaseEP(4);
    }
    this.increaseEP(3);
    if(toAttack.getHP()>0){toAttack.increaseEP(3);}
    if (toAttack instanceof Student && toAttack.getHP()>0) {
      ((Student) toAttack).increaseKP(3);
    }
    this.toRemove(toAttack.getTeam());
    System.out.println("syntaxError successfully used by " + this.getName() + " to attack " + toAttack.getName());

  }

  public void nullPointerException(){
    this.increaseHP(this.getDefence());
    this.increaseEP(3);
    System.out.println("nullPointerException successfully used by "+this.getName());
  }

  public void arrayIndexOutOfBoundsException(Character toAttack) {
    toAttack.decreaseHP(2 * (100 * this.getAttack()) / (100 + toAttack.getDefence()));
    if (toAttack.getHP() == 0) {
      System.out.println(toAttack.getName()+" is now dead:");
      toAttack.increaseEP(3);
      toAttack.setCurrentHP(0);
      this.increaseEP(4);
    }
    this.increaseEP(3);
    if(toAttack.getHP()>0){toAttack.increaseEP(3);}
    if (toAttack instanceof Student && toAttack.getHP()>0) {
      ((Student) toAttack).increaseKP(3);
    }
    this.toRemove(toAttack.getTeam());
    System.out.println("arrayIndexOutOfBoundsException successfully used by " + this.getName() + " to attack " + toAttack.getName());
  }

  public void noneTermination() {}

  public void concurrentModificationException (Character toAttack){}

}
