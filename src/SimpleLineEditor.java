import java.util.ArrayList;

public class SimpleLineEditor {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        boolean running = true;

        while (running) {
            displayMenu();
            String choice = SafeInput.getRegExString("Enter a command (A, D, I, P, Q):", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(list);
                    break;
                case "D":
                    deleteItem(list);
                    break;
                case "I":
                    insertItem(list);
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":
                    running = quitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }


    private static void addItem(ArrayList<String> list) {
        String item = SafeInput.getString("Enter the item to add:");
        list.add(item);
        System.out.println("Item added.");
    }


    private static void deleteItem(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printList(list);
        int index = SafeInput.getRangedInt("Enter the item number to delete:", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted.");
    }


    private static void insertItem(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding as the first item.");
            addItem(list);
            return;
        }
        printList(list);
        int index = SafeInput.getRangedInt("Enter the position to insert the item:", 1, list.size() + 1) - 1;
        String item = SafeInput.getString("Enter the item to insert:");
        list.add(index, item);
        System.out.println("Item inserted.");
    }


    private static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }
        System.out.println("\nCurrent List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d: %s%n", i + 1, list.get(i));
        }
    }

    private static boolean quitProgram() {
        boolean confirm = SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N)");
        if (confirm) {
            System.out.println("Goodbye!");
        }
        return !confirm;
    }
}

