
import java.util.Scanner;

public class Conflict {
    Scanner scanner = new Scanner(System.in);

    //CLASS MEMBERS
    private String enemy = "Alien";  //if UML <challenge> = alien call fight() from this class
    private int enemyHP = 100;

    private String player = "Player";
    private int playerHP = 100;

    static int dmg;
    private String playerWeapon = null; //Player weapon changes players maxDamage unless null

    private int turnCount = 0;


    //CTOR
    //Default NoARG accepts Class Member defaults

    Conflict() {
    }

    //Replaces Class Member Defaults

    Conflict(String enemy, int enemyHP, String player, int playerHP, String playerWeapon) {
        //setEnemy setPlayer from UML and cancel hardocded defaults'Alien' / 'Player
        //setEnemyHP setPlayerHP from UML and remove hardcoded '100'
        //setPlayerWeapon and from UML if player found weapon otherwise keep null
    }

    //Directly Set properties if noArg CTOR is used  Get attributes are available

    //ACCESSORS
    public String getEnemy() {

        return enemy;
    }

//    public void setEnemyName(String enemy) {
//        this.enemy = enemy;
//    }

    public int getEnemyHP() {

        return enemyHP;
    }

//    public void setEnemyHP(int enemyHP) {
//        this.enemyHP = enemyHP;
//    }

    public String getPlayer() {

        return player;
    }

//    public void setPlayerName(String player) {
//        this.player = player;
//    }
//
//    public int getPlayerHP() {
//        return playerHP;
//    }
//
//    public void setPlayerHP(int playerHP) {
//        this.playerHP = playerHP;
//    }

    //METHODS

    //Response from main to fight and call fight() or run and return to main()


    public void ConflictPrompt(){
        String responseAsString = null;
        int response = 0;

        if (turnCount == 0) {
            System.out.printf("\n\nYou have encountered a devious %s and you probably should fight it.\n", enemy);
            System.out.println("\nEnter (1) if you wish to FIGHT and any other key if you wish the RUN AWAY \n");
        } else System.out.printf("\nPress (1) to continue fighting the %s or another key to RUN AWAY!!!\n", enemy);

        try{
            responseAsString = scanner.nextLine();
            response = Integer.parseInt(responseAsString);
        } catch (NumberFormatException nfe) {
            System.out.println("\nYou needed to enter in (1) to FIGHT but you RAN AWAY!");
            turnCount = -1;
            return;
        }

        if (response == 1 && turnCount == 0) {
            System.out.println("\n****BATTLE BEGIN****\n");
            turnCount++;
            fight(getPlayer(), getEnemy());
        } else if (response ==1) {
            turnCount++;
            fight(getPlayer(), getEnemy());
        }
    }

    public void fight(String player, String enemy) {
        while(turnCount!=-1) {
            //clearConsole();

            //player uses calcdmg to determine how much to subtract enemyhp
            dmg = calcDMG();

            if (playerWeapon != null) {
                dmg += 15;       //determine if player has a weapon and add 15 dps to random gen dmg
            }

            System.out.printf("****ROUND %d****", turnCount); //Display Round

            if (dmg <= 0) {
                System.out.printf("\n\nThis %s appears to be an incredibly tough opponent which appears to be gaining health whenever it completely cancels out your attack with defense so you probably should RUN AWAY\n", enemy);
            } else {
                System.out.printf("\n%s hits %s for %d damage.\n", player, enemy, dmg);
            }

            enemyHP -= dmg;

//            if (enemyHP < 1) {
//                System.out.printf("\nThe %s won this battle and leveled up. All health is restored to full\n\n", player);
//                turnCount = -1; //Reset Counter at victory and before exit fight
//                //return to main
//                break;
//            } else {
//                System.out.printf("\nThe %s has %d %% health remaining\n", enemy, enemyHP);
//            }

            if (enemyHP < 1) {
                System.out.println("\nIn a last ditch effort, you are able to lure the injured alien\ninto the airlock and release the outer door. It tumbles out,\noozing green blood and terrible screeches follow it into the dark silence of deep space.\nYou race to the shuttle, slam the emergency codes into the console,\nand engage the Faster Than Light drive to escape this awful nightmare.");
                System.exit(0);
            } else {
                System.out.printf("\nThe %s has %d %% health remaining\n", enemy, enemyHP);
            }

            //enemy uses calcdmg to hit playerHP
            dmg = calcDMG();

            if (dmg <= 0) {
                System.out.printf("\nYou successfully dodged and defended against the %s's attack however, you do not have any items that regenerate health on success\n", enemy);
            } else {
                System.out.printf("\n%s hits %s for %d damage\n", enemy, player, dmg);
                playerHP -= dmg;
            }



            if (playerHP < 1) {
                System.out.printf("\nThe %s's four arms lift you into the air;\nyour own arms pinned to your sides, helpless.\nIt slowly brings your head to it's hungry, toothy maw.\nYour last moments are filled with pain and terror\nas you become a new delicacy for this terrible creature....\n\n****GAME OVER****\n\n", enemy);
                System.exit(0);
            } else System.out.printf("\nThe %s now has %d %% health remaining\n", player, playerHP);

            System.out.printf("\nYou survived ****ROUND %d****,\n", turnCount);

            ConflictPrompt(); // Prompt again to continue or another chance to run away each round.
        }

    }


    public int calcDMG() {  //calculate dps and possibly add counter to track how many rounds to defeat. if won in one round declare the hit as a mortal wound
         dmg = (int) (Math.random() * 50);
      //  dmg = -50;
        return dmg;
    }

    //Feature Releases
    /* TODO Feature addition call calcDEF() from CalcDMG() && subtract defense from dps to find resulting DMG
//    public void calcDEF(){
//
//    }
//
//    TODO calculate probability to run away instead of current always success
//    public void runChance(){
////        //if (runChance > X) then SUCCESS else take damage
////    }
//    TODO calculate probability to get a premptive strike
//    public void preChance(){
////        //if (preChance > X) then player catches enemy off guard and gets a free attack before player first turn
////    }
*/


//    //CLIENT TEST DRIVER   DELETE!!!
//    public static void main(String[] args) {
//        Conflict c1 = new Conflict(); //Can pass in enemy and player name / stats and if player has a weapon
//
//        c1.ConflictPrompt();
//
//        System.out.println("\nContinue in main Because you won or you chose to Do something other than fight\n");


//        c1.fight(c1.getPlayer(), c1.getEnemy());     //test fight client directly
//   }

}





