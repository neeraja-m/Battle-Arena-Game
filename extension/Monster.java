
public interface Monster {
  // Declares public abstract methods for Minion and Boss to implement according to their own probabilities
  void strike(Character toAttack);
  void syntaxError(Character toAttack);
  void nullPointerException();
  void arrayIndexOutOfBoundsException(Character toAttack);
  void noneTermination();
  void concurrentModificationException (Character toAttack);
}
