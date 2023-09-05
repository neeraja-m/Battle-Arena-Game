import java.util.ArrayList;

public abstract class Team {
  private String name;

  protected ArrayList<Character> members = new ArrayList<>();
  protected Character[] arrayMembers;

  protected Team(String name){
    this.name=name;
  }

  protected void move(Character member, Team enemyTeam)throws Exception{} //Abstract method to be overridden by StudentTeam and MonsterTeam

  protected String getName(){
    return name;
  }

  protected Character[] getMembers(){ //Returns members of the team as an array
    Character[] arrayMembers = members.toArray(new Character[members.size()]); //Converts arraylist to an array
    this.arrayMembers = arrayMembers;
    return arrayMembers;
  }

  protected int addMember(Character member) {
    if (members.contains(member)) { //Returns -1 if member trying to be added is already in the team
      return -1;

    } else if (members.size() == 5) {//Returns -2 is maximum team size is reached
      return -2;

    } else {
      members.add(member); //Otherwise, adds member to the team and sets their team and returns the size
      member.setTeam(this);

      return members.size();
    }
  }

}