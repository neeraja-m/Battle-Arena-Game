import java.util.Comparator;

public class SortBestStudents implements Comparator<Character> {
  //Following method adds values of base attributes while giving double the weight to the most relevant attributes
  //Attack and defence are weighted more as this affects strength of when attacked and when attacking
  //Speed is weighted more as this is what decides order of moves, so providing members with highest speeds ensures students
  //have a better chance of moving and attacking first

  public int compare(Character a, Character b) {
    int totalofAttributesA = (2*a.getAttack()) + a.getHP() + (2*a.getDefence()) + a.getEP() + (2*a.getSpeed()) + a.getLevel();
    int totalofAttributesB = (2*b.getAttack()) + b.getHP() + (2*b.getDefence()) + b.getEP() + (2*b.getSpeed()) + b.getLevel();

    return totalofAttributesB - totalofAttributesA; //Returns students in descending order
  }

}


