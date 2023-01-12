import java.util.Scanner;
public class Ceelo {
    private Player player1;
    private Player player2;
    private Player player3;
    private Banker banker;

    public Ceelo() { }

    public void play() {
        Scanner scan = new Scanner(System.in);
        banker = new Banker();
        System.out.println("Get ready to play Ceelo Dice Game!");
        System.out.println("Before we begin, please enter your names.");
        System.out.print("Player 1's Name:");
        String name1 = scan.nextLine();
        System.out.print("Player 2's Name:");
        String name2 = scan.nextLine();
        System.out.print("Player 3's Name:");
        String name3 = scan.nextLine();
        player1 = new Player(name1);
        player2 = new Player(name2);
        player3 = new Player(name3);

        System.out.println("-----------------------------------");
        System.out.println("Welcome, " + player1.getName() + ", " + player2.getName() + ", and " + player3.getName() + "!");
        mainMenu();
        System.out.print("Type in your choice: ");
        int choice = scan.nextInt();
        scan.nextLine();

        while (choice != 3) {
            if (choice == 1) {
                System.out.print(player1.getName() + ", please enter your wager: ");
                int wager1 = scan.nextInt();
                scan.nextLine();
                player1.setWager(wager1);
                System.out.print(player2.getName() + ", please enter your wager: ");
                int wager2 = scan.nextInt();
                scan.nextLine();
                player2.setWager(wager2);
                System.out.print(player3.getName() + ", please enter your wager: ");
                int wager3 = scan.nextInt();
                scan.nextLine();
                player3.setWager(wager3);


                System.out.println("Banker rolls first.");
                banker.rollDice();
                banker.printRolls();
                if (banker.getBankerStatus() == 1) {
                    banker.addChips(player1.getChipWager());
                    banker.addChips(player2.getChipWager());
                    banker.addChips(player3.getChipWager());
                    player1.removeChips(player1.getChipWager());
                    player2.removeChips(player2.getChipWager());
                    player3.removeChips(player3.getChipWager());
                    System.out.println("Banker automatically wins.");
                } else if (banker.getBankerStatus() == 2) {

                }

            } else {

            }
        }

        System.out.println("Not eager to indulge in gambling habits? We understand. Thanks for playing!");


    }

    public void mainMenu() {
        System.out.println("-----------------------------------");
        System.out.println("Main Menu:");
        System.out.println("New Game (1)");
        System.out.println("View Top Score (2)");
        System.out.println("Quit (3)");
    }
}
