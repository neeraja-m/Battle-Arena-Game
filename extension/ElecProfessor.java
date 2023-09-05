public class ElecProfessor extends Professor {

  //Constructor initialising CSProfessor's base attributes
  protected ElecProfessor(String name) {
    super(name,8,5,8,4,(int) Math.round(10*(Math.pow(1,1.2) )));
  }

  protected void extraCredit(Team studentTeam){ //Takes Student team as a parameter
    for(Character students: studentTeam.getMembers()){ //Increases level of every student in team (main function)
      students.setLevel(students.getLevel() + 2);
      students.increaseEP(3);
      students.increaseHP(5);
      this.increaseHP(3);
    }
    this.increaseTP(5);
    System.out.println("extraCredit successfully used by "+this.getName() +" to attack "+studentTeam.getName());
  }


}
