public class CSProfessor extends Professor {

  //Constructor initialising CSProfessor's base attributes
  protected CSProfessor(String name) {
    super(name,8,7,8,6,(int) Math.round(8*(Math.pow(1,1.2) )));
  }

  protected void detention(Team enemyTeam){ //Takes enemy's team to attack as parameter
    for(Character enemies: enemyTeam.getMembers()){
      enemies.setLevel(1);// Sets all members of enemy's team back to 1 (main function)
      enemies.increaseHP(3);
    }
    this.increaseTP(5); //Increases Teaching Points
    this.increaseEP(4);
    System.out.println("detention successfully used by "+this.getName() +" to attack "+enemyTeam.getName());

  }

}
