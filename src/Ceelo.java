import java.util.Scanner;
public class Ceelo {
    private Player player1;
    private Player player2;
    private Player player3;

    public Ceelo() { }

    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Get ready to play Ceelo Dice Game!")
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



    }
}
