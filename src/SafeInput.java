import java.util.Scanner;

public class SafeInput {
    private static Scanner in = new Scanner(System.in);


    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }


    public static String getRegExString(String prompt, String regEx) {
        String input;
        while (true) {
            System.out.print(prompt + " ");
            input = in.nextLine();
            if (input.matches(regEx)) {
                return input;
            }
            System.out.println("Invalid input. Please try again.");
        }
    }


    public static int getRangedInt(String prompt, int low, int high) {
        int input;
        while (true) {
            System.out.printf("%s [%d-%d]: ", prompt, low, high);
            if (in.hasNextInt()) {
                input = in.nextInt();
                in.nextLine(); 
                if (input >= low && input <= high) {
                    return input;
                }
            } else {
                in.nextLine();
            }
            System.out.println("Invalid input. Please enter a number within the range.");
        }
    }


    public static boolean getYNConfirm(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            input = in.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            }
            System.out.println("Invalid input. Please enter Y or N.");
        }
    }
}
