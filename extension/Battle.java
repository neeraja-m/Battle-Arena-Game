import java.util.ArrayList;
import java.util.Collections;


public class Battle {
  private StudentTeam studentsTeam;
  private MonsterTeam monstersTeam;

  protected Battle(StudentTeam studentsTeam, MonsterTeam monstersTeam) {
    this.studentsTeam = studentsTeam; //Teams passed as parameters are set to the class's instance variable
    this.monstersTeam = monstersTeam;
  }

  protected Team fight() {
    int i = 1;

    while (i <= 30 && !studentsTeam.members.isEmpty() && !monstersTeam.members.isEmpty()) { //Loops as long as both teams have members
      try
      {
        Thread.sleep(700); //pauses for 700 milliseconds between each round

        ArrayList<Character> combinedList = new ArrayList<>();
        combinedList.addAll(studentsTeam.members);
        combinedList.addAll(monstersTeam.members);// Adds all members partaking in the battle to another list to order their speeds

        Collections.sort(combinedList, new SortSpeeds());

        System.out.println("======================= ROUND "+i+" ========================");
        System.out.println();

        System.out.println("Order of turn for moves:");

        for (Character orderofmove : combinedList) { //Ordered list(descending) is printed to show order of moves
          System.out.println(orderofmove.getName());
        }
        System.out.println();

        for (Character orderofmove : combinedList) {
          if(monstersTeam.members.isEmpty()){break;} //Break statements ensure if all members in a team die before all
          if(studentsTeam.members.isEmpty()){break;} //members have had a turn to move, the loop is broken.
          System.out.println("--------------------------------------------------------");
          if (orderofmove.getTeam() instanceof StudentTeam) {
            try {
              orderofmove.getTeam().move(orderofmove, monstersTeam);
            } catch (Exception e) {
              System.out.println(e); //If any method within move method throws exception, i.e when illegal move performed, results in automatic forfeit
              System.out.println("---AUTOMATIC FAILURE---");
              orderofmove.getTeam().members.clear();// Members in respective team are removed to signify team has lost (loop broken)
            }
          }
          else if (orderofmove.getTeam() instanceof MonsterTeam) {
            try {
              orderofmove.getTeam().move(orderofmove, studentsTeam);
            } catch (Exception e) {
              System.out.println(e);
              System.out.println("---AUTOMATIC FAILURE---");
              orderofmove.getTeam().members.clear();
            }
          }
        }
        this.report(); //Calls method responsible for providing report of current status after each round
        i++;
      }catch(InterruptedException e){}
    }
    if (studentsTeam.members.isEmpty()) { //Prints winning team if opposite team is empty(meaning all team members died)
      System.out.println(monstersTeam.getName()+ " has won this battle!");
      return monstersTeam;
    } else if (monstersTeam.members.isEmpty()) {
      System.out.println(studentsTeam.getName()+ " has won this battle!");
      return studentsTeam;
    } else
      System.out.println("This battle is a draw!");//If neither team is empty, means its a draw
    return null;
  }

  private void report() {
    System.out.println("--------------------------------------------------------");
    if (!studentsTeam.members.isEmpty()) { //If there are members remaining in each team, prints their current status
      System.out.println("Current status of remaining members in " + studentsTeam.getName() + ":");
      for (Character student : studentsTeam.getMembers()) {
        System.out.println(student.getName() + "'s current HP: " + student.getHP());
        System.out.println(student.getName() + "'s current EP: " + student.getEP());
        System.out.println(student.getName()+"'s current defence power: "+student.getDefence() );
        System.out.println(student.getName()+"'s current attack power: "+student.getAttack() );
        System.out.println(student.getName() + "'s current level: " + student.getLevel());
        System.out.println();
      }
      System.out.println("--------------------------------------------------------");
    } else {
      System.out.println("No alive members remaining in "+studentsTeam.getName());
    }
    System.out.println("--------------------------------------------------------");
    if (!monstersTeam.members.isEmpty()) {
      System.out.println("Current status of remaining members in " + monstersTeam.getName() + ":");
      for (Character monster : monstersTeam.getMembers()) {
        System.out.println(monster.getName() + "'s current HP: " + monster.getHP());
        System.out.println(monster.getName() + "'s current EP: " + monster.getEP());
        System.out.println(monster.getName()+"'s current defence power: "+monster.getDefence() );
        System.out.println(monster.getName()+"'s current attack power: "+monster.getAttack() );
        System.out.println(monster.getName() + "'s current level: " + monster.getLevel());
        System.out.println();

      }
      System.out.println("--------------------------------------------------------");
    } else {
      System.out.println("No alive members remaining in "+monstersTeam.getName());
      System.out.println("--------------------------------------------------------");
    }
  }

}

