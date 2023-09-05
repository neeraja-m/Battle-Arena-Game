
import java.io.*;

public class TowerOfMonsters {

  private BufferedReader reader;

  public static void main(String[] args) throws Exception {
    int j = 1; //Keeps track of number of levels
    StudentTeam studentsTeam;
    MonsterTeam monstersTeam;
    File toRead = new File(args[0]); //Takes file containing monsters from commandline
    String fileTocheck = toRead.toString();//Converts filename to String to check file type
    String extTocheck = fileTocheck.substring(fileTocheck.lastIndexOf(".")); //Stores String after "." in extTocheck
    if(!extTocheck.equals(".txt")){throw new Exception("Wrong file format, please provide a text file");}
    //Checks the extension of the file given is in the right format by ensuring it has .txt extension, otherwise throws exception

    TowerOfMonsters tower= new TowerOfMonsters(toRead);//Makes object with file given in commandline as file to read in constructor

    //Creates all necessary properties for battles (guild, students, teams, battle)
    Guild guild1 = new Guild();

    AIStudent ai1 = new AIStudent("Emma");
    AIStudent ai2 = new AIStudent("Eden");
    SEStudent se1 = new SEStudent("Linda");
    CSStudent css1 = new CSStudent("Jon");
    CyberStudent cs1 = new CyberStudent("Max");
    CyberStudent cs2 = new CyberStudent("Nick");
    NanoTechStudent ns1 = new NanoTechStudent("Dylan");
    NanoTechStudent ns2 = new NanoTechStudent("Lily");
    AeroStudent as1 = new AeroStudent("Luke");
    AeroStudent as2 = new AeroStudent("Sam");
    ElecProfessor ep1 = new ElecProfessor("Mr. Smith");
    CSProfessor csp1 = new CSProfessor("Ms. Brown");


    //Adds students to the guild to be made into a team
    guild1.addMember(ai1);
    guild1.addMember(ai2);
    guild1.addMember(se1);
    guild1.addMember(ns1);
    guild1.addMember(cs1);
    guild1.addMember(ns2);
    guild1.addMember(css1);
    guild1.addMember(as1);
    guild1.addMember(cs2);
    guild1.addMember(as2);



    monstersTeam = (MonsterTeam) tower.getMonsters(); // Creates an initial team of monsters
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<< TOWER OF MONSTERS >>>>>>>>>>>>>>>>>>>>>>>>");
    System.out.println("******************** LEVEL: " + j + " ********************");
    System.out.println();
    System.out.println("Monsters to battle:");
    for (Character b : monstersTeam.getMembers()) { //Prints members of the monster team
      System.out.println(b.getName());
    }
    System.out.println();

    studentsTeam = guild1.getTeam(monstersTeam); //Creates team of students from the guild for monsters to battle
    System.out.println("Members chosen from the guild for " + monstersTeam.getName() + " to battle: ");
    for (int i = 0; i < studentsTeam.getMembers().length; i++) {
      System.out.println(studentsTeam.getMembers()[i].getName()); //Prints student team
    }
    Battle b1 = new Battle(studentsTeam, monstersTeam); //Creates a new battle between previously created monster and student team
    Team outcome = b1.fight(); //Starts the battle

    while(!tower.getMonsters().members.isEmpty() && !guild1.getMembers().isEmpty()) {
      //Loops until either all monsters or all students are dead

      while (outcome == studentsTeam ) { //while the winner of a battle (representing a level) is the student team:
        if (tower.getMonsters().members.isEmpty()) {
          break;
        }
        j++;//updates level tracker
        System.out.println();
        System.out.println("*********************** LEVEL: " + j + " ***********************");
        System.out.println();
        monstersTeam = (MonsterTeam) tower.getMonsters(); //Creates new team of monsters from the current level
        System.out.println("Next level of monsters to battle:");
        for (Character b : monstersTeam.getMembers()) {
          System.out.println(b.getName());
        }
        Battle battle = new Battle(studentsTeam, monstersTeam); //Starts another battle
        outcome = battle.fight();
      }
      while (outcome == monstersTeam) { //while the winner of a battle is the monster team:
        if (guild1.getTeam(monstersTeam)==null) { //null returned when no students left in the guild
          System.out.println("-*-*-No more students available in the guild-*-*-");
          break;
        } else {
          System.out.println();
          System.out.println("******************** RESTARTING LEVEL: " + j + " ********************");
          System.out.println("....................Rebuilding " + studentsTeam.getName() + "....................");
          System.out.println("Professors turn: ");
          studentsTeam = guild1.getTeam(monstersTeam);//Uses remaining students in guild to retry the level
          int x = new java.util.Random().nextInt(4);
          //Following code chooses an attack from professor randomly to either weaken monster team or strengthen student team
          if(x==0 ){ep1.extraCredit(studentsTeam);}
          else if(x==1 ){csp1.detention(monstersTeam);}
          else if(x==2 ){csp1.marking(monstersTeam);}
          else{ep1.lecturing(studentsTeam);}
          System.out.println();
          System.out.println("Remaining members chosen from the guild for " + monstersTeam.getName() + " to battle: ");
          for (int i = 0; i < studentsTeam.getMembers().length; i++) {
            System.out.println(studentsTeam.getMembers()[i].getName()); //Prints student team
          }
          System.out.println();

          Battle battle = new Battle(studentsTeam, monstersTeam);//Starts another battle
          outcome = battle.fight();
          System.out.println();
        }
      }
      if (tower.getMonsters().members.isEmpty() || guild1.getMembers().isEmpty()) { //Check to ensure neither monsters or students are all dead
        break;
      }
    }
    if (monstersTeam.members.isEmpty()) { //If last monster team is empty (meaning all monsters have died), students defeat the monsters
      System.out.println(studentsTeam.getName() + " have defeated the Tower of Monsters!");
      System.out.println();
    }
    else if (studentsTeam.members.isEmpty()) { //If last student team is empty (meaning all students have died), monsters defeated students
      System.out.println(monstersTeam.getName() + " has won!");
    }
  }

  private TowerOfMonsters(File filename) { //Constructor takes file from commandline to read
    try {
      reader = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    }
  }


  private String getLine() { //Returns the next line of file containing monster team when called
    String line = null;
    try {
      line = reader.readLine();
      return line;

    } catch (IOException e) {
      System.out.println("error");
    }
    return line;
  }

  private Team getMonsters() { //Returns the next team of monsters to battle when called
    MonsterTeam monsterTeam = new MonsterTeam("Monster Team"); //Creates new monster team each time method is called
    String monsters = this.getLine(); //Gets the next line (next level of monsters)
    String[] monsterInfo = monsters.split("[\\W]"); //Splits line at to all symbols ( ',' , '(' , ')', ';' )
    for (int i = 0; i <= 16; i = i + 4) {//For the next 5 monsters:
      if (monsterInfo[i + 1].equals("Minion")) { //Creates minion or boss depending on second line(always the type) within a monster
        Minion minion1 = new Minion(monsterInfo[i]); //Sets name of monster depending on first line(always the name) within a monster
        minion1.setLevel(Integer.parseInt(monsterInfo[i + 2]));//Sets level of monster depending on third line(always the level) within a monster
        monsterTeam.addMember(minion1);
      } else if (monsterInfo[i + 1].equals("Boss")) {
        Boss boss1 = new Boss(monsterInfo[i]);
        boss1.setLevel(Integer.parseInt(monsterInfo[i + 2]));
        monsterTeam.addMember(boss1);
      }
    }
    return monsterTeam;
  }
}
