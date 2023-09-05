import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Guild {
  protected ArrayList<Character> guild;

  protected Guild(){ //Creates an arraylist representing guild when guild object is created to add members to
    this.guild = new ArrayList<>();
  }

  protected void addMember(Character membertoAdd) {//Adds member passed in parameter to the guild
    guild.add(membertoAdd);
  }

  protected Collection<Character> getMembers(){ //Ensures only alive members remain in the guild and returns this guild
    guild.removeIf(studentToCheck -> studentToCheck.getHP() == 0);
    return guild;
  }

  protected StudentTeam getTeam(Team toBattle) {

    if (this.getMembers().isEmpty()) {
      return null; // If no more members left to add to team, null is returned
    } else {
      this.getMembers(); //Ensures no dead members are added to team

      StudentTeam studentTeam = new StudentTeam("Student Team");

      Collections.sort(guild, new SortBestStudents()); //Sorts available students according to their attributes with certain attributes holding double the weight
      for (Character studentAvailable : guild) { //Adding of members after sorting allows best students to be added first
        studentTeam.addMember(studentAvailable);}

      return studentTeam;
    }
  }
}





