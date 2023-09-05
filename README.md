** Battle Arena coursework **

** Part 1 **
Character and Team class has been created according to the specification.
The classes contain the required methods and variables.

No additional variables or methods were added at this part.

** Part 2 **
Student,AIStudent, CSStudent, CyberStudent, SEStudent classes have been created according to the specification.
The classes contain the required methods and variables.

Additional getter and setter methods were added in the Character class and Student class to set and get currentHP,MaxHP, and currentHP.
These are used in each attack methods in Student class and in each attack within separate types of student classes.


** Part 3 **
Monster interface, Minion and Boss Class has been created according to the specification.
The classes and interface contain the required methods and variables.

Additional arraylist was created in Character class to add dead monsters to for Boss to access when resurrecting fallen members.
Additional method was added in Character class to remove dead members from the team passed in the method when called.


** Part 4 **
StudentTeam and MonsterTeam, Guild classes have been created according to the specification.
The classes contain the required methods and variables.

The strategy is as follows:

For all students, javaProgramming is the default attack. This will always be tried to use first as it requires no KP and instantly causes damage to the enemy team.
For all students, once javaProgramming is used, and their KP has not reached its maximum, selfStudy is always used. This allows many points to be gained.
For all students, enemies being attacked are random, but condition of this enemy is always checked first to see if it favours the student team, or if it is dangerous, how high its HP is, etc.
More specifically for each student, if maximum KP is reached:

-AIStudent: Since HP needs to stay positive to stay in the game, check this first. If the students HP is less than a member from the enemy team that's randomly chosen, it uses naturalLanguangeProcessing to heal themselves. If not, use an attack: they will use machineLearning to attack on a random enemy.

-CSStudent: Since HP needs to stay positive to stay in the game, check this first. If a randomly chosen member of the students team has less HP than the students HP, the student uses support to heal this member. If not, use an attack: they will use pairWorking to attack a random enemy with a student friend.

-CyberStudent: Since cyberStudent only has one special attack, it will use cyberAttack when maximum HP is reached.

-SEStudent: Since HP needs to stay positive to stay in the game, check this first. If a randomly chosen member of the students team has less HP than a random enemy chosen, the student will choose groupDiscussion to heal all the members in the students team. If not, use an attack: groupWork is used to attack a randomly chosen enemy



*** Part 5 ***
Battle class has been created according to the specification.
The class contains the required methods and variables.

Battle class has an additional method report() which is called after each round to provide the current status all fighting teams.

** Part 6 **
TowerOfMonsters class has been created according to the specification.
The class contains the required methods and variables.

It contains additional getLine and getMonsters methods to take each line of the file and make a monster team from it for each level.
Once all members of student team has died, it uses remaining members in the guild to restart the battle lost. 

** Extension **

3 new student types and 2 professors have been added: MechStudent, NanoTechStudent, AeroStudent, ElecProfessor, CSProfessor.
A new Professor class has been added which extends character, and ElecProfessor and CSProfessor both extend Professor.

Each new student type has additional methods which follow basic structure as student attacks in coursework specification with minor changes. (Methods function explained in comments)
Each professor type has its own special attack and Professor class has 2 abilities. Their implementation in move() follows a similar structure where generally, HP is checked first, and if sufficient, chooses to attack.

Professors have the ability to weaken monster teams or strengthen student teams.
In the TowerOfMonsters, there has been a strategy added: every battle where the student team loses, the professors have the turn to either strengthen student team members or weaken enemy team members. 
-marking() weakens enemy members
-lecturing() strengthens student members
-extraCredit() strengthens student members
-detention() weakens enemy members

More students have also been added to the guild.

To run the program with the extension, please use the same command as to run the original program.


