import java.util.HashMap;
import java.util.Map;

public class BankingSystem {
    private Map<String, User> users;

    public BankingSystem() {
        this.users = new HashMap<>();
    }

    public void createUser(String name, String email, String phoneNumber) {
        User user = new User(name, email, phoneNumber);
        users.put(email, user);
    }

    public User getUser(String email) {
        return users.get(email);
    }

    public void createAccount(String email, String accountNumber) {
        User user = getUser(email);
        if (user != null) {
            Account account = new Account(accountNumber);
            user.addAccount(account);
        }
    }

    public void deposit(String email, String accountNumber, double amount) {
        User user = getUser(email);
        if (user != null) {
            Account account = user.getAccount(accountNumber);
            if (account != null) {
                account.deposit(amount);
            }
        }
    }

    public void withdraw(String email, String accountNumber, double amount) {
        User user = getUser(email);
        if (user != null) {
            Account account = user.getAccount(accountNumber);
            if (account != null) {
                account.withdraw(amount);
            }
        }
    }

    public void transfer(String emailFrom, String accountNumberFrom, String emailTo, String accountNumberTo, double amount) {
        User userFrom = getUser(emailFrom);
        User userTo = getUser(emailTo);
        if (userFrom != null && userTo != null) {
            Account accountFrom = userFrom.getAccount(accountNumberFrom);
            Account accountTo = userTo.getAccount(accountNumberTo);
            if (accountFrom != null && accountTo != null) {
                accountFrom.transfer(accountTo, amount);
            }
        }
    }

    public void viewTransactionHistory(String email, String accountNumber) {
        User user = getUser(email);
        if (user != null) {
            Account account = user.getAccount(accountNumber);
            if (account != null) {
                for (Transaction transaction : account.getTransactionHistory()) {
                    System.out.println(transaction);
                }
            }
        }
    }

    public void updatePersonalInfo(String email, String newEmail, String newPhoneNumber) {
        User user = getUser(email);
        if (user != null) {
            if (newEmail != null && !newEmail.isEmpty()) {
                users.remove(email);
                user.setEmail(newEmail);
                users.put(newEmail, user);
            }
            if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
                user.setPhoneNumber(newPhoneNumber);
            }
        }
    }
}
