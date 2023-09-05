import java.util.Comparator;

public class SortSpeeds implements Comparator<Character> {

  public int compare(Character a, Character b){ //Sorts speed of characters according to speed in descending order
    return b.getSpeed() - a.getSpeed();
  }
}
