
import java.util.Scanner;

public class ARRAY {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int capacity;

        System.out.print("Enter the maximum capacity of the shelf: ");
        capacity = input.nextInt();

        int[] books = new int[capacity];
        int size = 0;
        int choice;

        do {
            System.out.println("\n----- ARRAY MENU -----");
            System.out.println("1. Add value");
            System.out.println("2. Insert at index");
            System.out.println("3. Fill array");
            System.out.println("4. Delete last element");
            System.out.println("5. Delete by index");
            System.out.println("6. Display");
            System.out.println("7. Search value");
            System.out.println("8. Get value at index");
            System.out.println("9. Replace/Update value at index");
            System.out.println("10. Size");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    // Add value at the end
                    if (size == capacity) {
                        System.out.println("Array is full!");
                    } else {
                        System.out.print("Enter book ID: ");
                        books[size] = input.nextInt();
                        size++;
                        System.out.println("Book ID added successfully.");
                    }
                    break;

                case 2:
                    // Insert value at a specific index
                    if (size == capacity) {
                        System.out.println("Array is full!");
                    } else {
                        System.out.print("Enter index (0 to "
                                + size + "): ");
                        int index = input.nextInt();

                        if (index < 0 || index > size) {
                            System.out.println("Invalid index!");
                        } else {
                            System.out.print("Enter book ID: ");
                            int value = input.nextInt();

                            for (int i = size; i > index; i--) {
                                books[i] = books[i - 1];
                            }

                            books[index] = value;
                            size++;

                            System.out.println("Value inserted successfully.");
                        }
                    }
                    break;

                case 3:
                    // Fill array with multiple values
                    while (size < capacity) {
                        System.out.print("Enter book ID: ");
                        books[size] = input.nextInt();
                        size++;

                        if (size == capacity) {
                            System.out.println("Array is full!");
                            break;
                        }

                        System.out.print("Add another value? (1 = Yes, 0 = No): ");
                        int more = input.nextInt();

                        if (more != 1) {
                            break;
                        }
                    }
                    break;

                case 4:
                    // Delete last element
                    if (size == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        int deleted = books[size - 1];
                        size--;
                        System.out.println("Deleted book ID: " + deleted);
                    }
                    break;

                case 5:
                    // Delete value by index
                    if (size == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.print("Enter index (0 to "
                                + (size - 1) + "): ");
                        int index = input.nextInt();

                        if (index < 0 || index >= size) {
                            System.out.println("Invalid index!");
                        } else {
                            int deleted = books[index];

                            for (int i = index; i < size - 1; i++) {
                                books[i] = books[i + 1];
                            }

                            size--;
                            System.out.println("Deleted book ID: " + deleted);
                        }
                    }
                    break;

                case 6:
                    // Display all elements
                    if (size == 0) {
                        System.out.println("Array is empty!");
                    } else {
                        System.out.println("Book IDs on the shelf:");
                        for (int i = 0; i < size; i++) {
                            System.out.println(
                                    "Index " + i + ": " + books[i]);
                        }
                    }
                    break;

                case 7:
                    // Search for a value
                    System.out.print("Enter book ID to search: ");
                    int search = input.nextInt();
                    boolean found = false;

                    for (int i = 0; i < size; i++) {
                        if (books[i] == search) {
                            System.out.println(
                                    "Book ID found at index " + i);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Book ID not found.");
                    }
                    break;

                case 8:
                    // Get value at an index
                    System.out.print("Enter index: ");
                    int getIndex = input.nextInt();

                    if (getIndex < 0 || getIndex >= size) {
                        System.out.println("Invalid index!");
                    } else {
                        System.out.println(
                                "Value at index " + getIndex
                                + " is " + books[getIndex]);
                    }
                    break;

                case 9:
                    // Replace or update value
                    System.out.print("Enter index to update: ");
                    int updateIndex = input.nextInt();

                    if (updateIndex < 0 || updateIndex >= size) {
                        System.out.println("Invalid index!");
                    } else {
                        System.out.print("Enter new book ID: ");
                        books[updateIndex] = input.nextInt();

                        System.out.println("Value updated successfully.");
                    }
                    break;

                case 10:
                    // Show current size
                    System.out.println("Current size: " + size);
                    System.out.println("Maximum capacity: " + capacity);
                    break;

                case 11:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 11);

        input.close();
    }
}
