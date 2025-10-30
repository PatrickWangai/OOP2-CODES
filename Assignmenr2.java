import java.util.Scanner;

public class PetSelector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your pet:");
        System.out.println("Radio Button 1. Bird");
        System.out.println("Radio Button 2. Cat");
        System.out.println("Radio Button 3. Dog");
        System.out.println("Radio Button 4. Rabbit");
        System.out.println("Radio Button 5. Pig");
        System.out.print("Enter number of your choice: ");
        
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("You selected a Bird!");
        } else if (choice == 2) {
            System.out.println("You selected a Cat!");
        } else if (choice == 3) {
            System.out.println("You selected a Dog!");
        } else if (choice == 4) {
            System.out.println("You selected a Rabbit!");
        } else if (choice == 5) {
            System.out.println("You selected a Pig!");
        } else {
            System.out.println("Invalid choice!");
        }

        input.close();
    }
}
