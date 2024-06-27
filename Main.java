import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1: Create User");
            System.out.println("2: Create Account");
            System.out.println("3: Deposit");
            System.out.println("4: Withdraw");
            System.out.println("5: Transfer");
            System.out.println("6: View Transaction History");
            System.out.println("7: Update Personal Info");
            System.out.println("8: Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    bankingSystem.createUser(name, email, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter user email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    bankingSystem.createAccount(email, accountNumber);
                    break;
                case 3:
                    System.out.print("Enter user email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankingSystem.deposit(email, accountNumber, depositAmount);
                    break;
                case 4:
                    System.out.print("Enter user email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankingSystem.withdraw(email, accountNumber, withdrawAmount);
                    break;
                case 5:
                    System.out.print("Enter sender email: ");
                    String emailFrom = scanner.nextLine();
                    System.out.print("Enter sender account number: ");
                    String accountNumberFrom = scanner.nextLine();
                    System.out.print("Enter receiver email: ");
                    String emailTo = scanner.nextLine();
                    System.out.print("Enter receiver account number: ");
                    String accountNumberTo = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bankingSystem.transfer(emailFrom, accountNumberFrom, emailTo, accountNumberTo, transferAmount);
                    break;
                case 6:
                    System.out.print("Enter user email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    bankingSystem.viewTransactionHistory(email, accountNumber);
                    break;
                case 7:
                    System.out.print("Enter current email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter new email (leave blank if no change): ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new phone number (leave blank if no change): ");
                    String newPhoneNumber = scanner.nextLine();
                    bankingSystem.updatePersonalInfo(email, newEmail, newPhoneNumber);
                    break;
                case 8:
                    scanner.close();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
