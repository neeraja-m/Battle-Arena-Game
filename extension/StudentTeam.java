public class StudentTeam extends Team {

  //Constructor to initialise with team name
  protected StudentTeam(String name) {
    super(name);
  }

  public void move(Character member, Team enemyTeam) throws Exception {
    int x = 0; //default values are 0
    int y = 0;
    if (enemyTeam.getMembers().length > 1 && member.getTeam().getMembers().length > 1) {//Condition true when theres more than one member in each team
      x = new java.util.Random().nextInt(enemyTeam.getMembers().length - 1);
      y = new java.util.Random().nextInt(member.getTeam().getMembers().length - 1);
    } else if (member.getTeam().getMembers().length == 1 && enemyTeam.getMembers().length > 1) {//Condition true when only one member left in students team
      x = new java.util.Random().nextInt(enemyTeam.getMembers().length - 1);
      y = 0;
    } else if (enemyTeam.getMembers().length == 1 && member.getTeam().getMembers().length > 1) {//Condition true when only one member left in monsters team
      y = new java.util.Random().nextInt(member.getTeam().getMembers().length - 1);
    } else if (enemyTeam.getMembers().length == 1 && member.getTeam().getMembers().length == 1) {//Condition true when both teams have one member remaining
      x = 0;
      y = 0;
    }
    if (member.getHP() == 0) {
      System.out.println(member.getName() + " is dead, cannot complete turn");
    }//Skips turn of dead character
    else if (member instanceof Student) {
      if (member instanceof AIStudent) { //If student is an AIStudent, following code is run
        if (enemyTeam.getMembers()[x].getHP() == enemyTeam.getMembers()[x].getBaseHP()) { //Ensures javaProgramming is always used first
          ((AIStudent) member).javaProgramming(enemyTeam.getMembers()[x]);
        } else if (((AIStudent) member).getcurrentKP() == ((AIStudent) member).getMaxKP()) { //If student has enough KP, special ability can be invoked
          if (member.getHP() < enemyTeam.getMembers()[x].getHP()) { //uses naturalLanguageProcessing if students HP is less than a random enemy's HP
            ((AIStudent) member).naturalLanguageProcessing();
          } else {
            ((AIStudent) member).machineLearning(enemyTeam.getMembers()[x]);
          }
        } else {
          ((AIStudent) member).selfStudy(); // selfStudy always called when no other condition is satisfied
        }
      } else if (member instanceof CSStudent) {//If student is a CSStudent, following code is run
        if (enemyTeam.getMembers()[x].getHP() == enemyTeam.getMembers()[x].getBaseHP()) {
          ((CSStudent) member).javaProgramming(enemyTeam.getMembers()[x]);
        } else if (((CSStudent) member).getcurrentKP() == ((CSStudent) member).getMaxKP()) {
          if (member.getTeam().getMembers()[y].getHP() < member.getHP()) { //If a randomly chosen member of students team is less than the student's,
            ((CSStudent) member).support(member.getTeam().getMembers()[y]);//student heals that member
          } else { //Otherwise, pairWorking is used (conditions at beginning of method allows student to pairWork with themselves if no other member left
            ((CSStudent) member).pairWorking(member.getTeam().getMembers()[y], enemyTeam.getMembers()[x]);
          }
        } else {
          ((CSStudent) member).selfStudy();
        }
      } else if (member instanceof CyberStudent) {//If student is a CyberStudent, following code is run
        if (enemyTeam.getMembers()[x].getHP() == enemyTeam.getMembers()[x].getBaseHP()) {
          ((CyberStudent) member).javaProgramming(enemyTeam.getMembers()[x]);
        } else if (((CyberStudent) member).getcurrentKP() == ((CyberStudent) member).getMaxKP()) {
          ((CyberStudent) member).cyberAttack(enemyTeam); //Calls the only special attack available for CyberStudent whenever possible
        } else {
          ((CyberStudent) member).selfStudy();
        }
      } else if (member instanceof SEStudent) {//If student is an SEStudent, following code is run
        if (enemyTeam.getMembers()[x].getHP() == enemyTeam.getMembers()[x].getBaseHP()) {
          ((SEStudent) member).javaProgramming(enemyTeam.getMembers()[x]);
        } else if (((SEStudent) member).getcurrentKP() == ((SEStudent) member).getMaxKP()) {
          if (member.getTeam().getMembers()[y].getHP() < enemyTeam.getMembers()[x].getHP()) {
            ((SEStudent) member).groupDiscussion();//Calls groupDiscussion when random member of students team has less HP than a random enemy as they can be healed
          } else {
            ((SEStudent) member).groupWork(enemyTeam.getMembers()[x]);//If there is sufficient HP, enemy team is attacked
          }
        } else {
          ((SEStudent) member).selfStudy();
        }
      } else if (member instanceof NanoTechStudent) {//If student is a NanoStudent, following code is run
        if (enemyTeam.getMembers()[x].getHP() == enemyTeam.getMembers()[x].getBaseHP()) {
          ((NanoTechStudent) member).javaProgramming(enemyTeam.getMembers()[x]);
        } else if (((NanoTechStudent) member).getcurrentKP() == ((NanoTechStudent) member).getMaxKP()) {
          if (member.getTeam().getMembers()[y].getHP() < enemyTeam.getMembers()[x].getHP()) {
            ((NanoTechStudent) member).controlling(enemyTeam);//Calls controlling when random member of students team has less HP than a random enemy
          } else {
            ((NanoTechStudent) member).nanoFabrication(enemyTeam.getMembers()[x]);//If there is sufficient HP, enemy team is attacked
          }
        } else {
          ((NanoTechStudent) member).selfStudy();
        }

      } else if (member instanceof MechStudent) {//If student is a MechStudent, following code is run
        if (enemyTeam.getMembers()[x].getHP() == enemyTeam.getMembers()[x].getBaseHP()) {
          ((MechStudent) member).javaProgramming(enemyTeam.getMembers()[x]);
        } else if (((MechStudent) member).getcurrentKP() == ((MechStudent) member).getMaxKP()) {
          if (member.getTeam().getMembers()[y].getHP() < enemyTeam.getMembers()[x].getHP()) {
            ((MechStudent) member).energyConversion(member.getTeam().getMembers()[y]);//Calls energyConversion when random member of students team has less HP than a random enemy as they can be healed
          } else {
            ((MechStudent) member).powerSystem(enemyTeam);//If there is sufficient HP, enemy team is attacked
          }
        } else {
          ((MechStudent) member).selfStudy();
        }
      } else if (member instanceof AeroStudent) {//If student is an AeroStudent, following code is run
        if (enemyTeam.getMembers()[x].getHP() == enemyTeam.getMembers()[x].getBaseHP()) {
          ((AeroStudent) member).javaProgramming(enemyTeam.getMembers()[x]);
        } else if (((AeroStudent) member).getcurrentKP() == ((AeroStudent) member).getMaxKP()) {
          if (member.getHP() < enemyTeam.getMembers()[x].getHP()) {
            ((AeroStudent) member).radarTechnique();//Calls radarTechnique when student  has less HP than a random enemy as they can be healed
          } else {
            ((AeroStudent) member).signalProcessing(enemyTeam.getMembers()[x]);//If there is sufficient HP, enemy team is attacked
          }
        } else {
          ((AeroStudent) member).selfStudy();
        }
      }

    }

  }
}



