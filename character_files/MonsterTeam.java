public class MonsterTeam extends Team {

  //Constructor to initialise name
  protected MonsterTeam(String name){
    super(name);
  }

  public void move(Character member, Team enemyTeam) throws Exception{ //follows same structure of move() in StudentTeam
    int x=0;
    if(enemyTeam.getMembers().length >1) {
      x = new java.util.Random().nextInt(enemyTeam.getMembers().length - 1);
    }else if(enemyTeam.getMembers().length ==1){
      x= 0;
    }
    if (member.getHP() == 0){ System.out.println(member.getName()+" is dead, cannot complete turn");}
    else if(member instanceof Minion){
      ((Minion) member).strike(enemyTeam.getMembers()[x]);
    }else if(member instanceof Boss){
      ((Boss) member).strike(enemyTeam.getMembers()[x]);
    }
  }
}
