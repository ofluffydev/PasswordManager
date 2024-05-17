import Encryption.EncryptionManager;
import Encryption.EncryptionManager.EncryptionType;
import PasswordManagement.PasswordManager;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String... args) {
        // Start the password Manager
        Scanner scanner = new Scanner(System.in);
        out.println("Welcome to the Password Manager!");
        out.print("Please enter a key to use: ");
        String key = scanner.nextLine();

        PasswordManager passwordManager = new PasswordManager(true);

        boolean exit = false;
        while (!exit) {
            out.println("--------------------");
            out.println("Select an option:");
            out.println("1. Add a password");
            out.println("2. Remove a password");
            out.println("3. List all passwords");
            out.println("4. Encrypt all passwords");
            out.println("5. Decrypt all passwords");
            out.println("6. Disable password strength checking (DANGEROUS)");
            out.println("7. Exit");
            out.println("--------------------");
            out.println();
            out.print("Choice: ");
            int option = scanner.nextInt();

            // Eat the newline character
            scanner.nextLine();

            switch (option) {
                case 1:
                    out.print("Enter the username: ");
                    String username = scanner.nextLine();
                    out.print("Enter the password: ");
                    String password = scanner.nextLine();
                    boolean isStrong = passwordManager.addPassword(username, password);
                    if (!isStrong) {
                        out.println("Password is not strong enough!");
                    } else {
                        out.println("Password added!");
                    }
                    break;
                case 2:
                    // See if there are any passwords whatsoever
                    if (passwordManager.getPasswords().isEmpty()) {
                        out.println("No passwords to remove!");
                        break;
                    }
                    out.print("Enter the index of the password to remove: ");
                    int index = scanner.nextInt();
                    // Check if password exists before removing
                    if (index < 0 || index >= passwordManager.getPasswords().size()) {
                        out.println("Invalid index!");
                        break;
                    }
                    passwordManager.removePassword(index);
                    break;
                case 3:
                    out.println("All passwords:");
                    for (int i = 0; i < passwordManager.getPasswords().size(); i++) {
                        out.println(i + ". Username: " + passwordManager.getPasswords().get(i).getUsername() + " Password: " + passwordManager.getPasswords().get(i).getPassword());
                    }
                    break;
                case 4:
                    out.print("Enter a key for the encryption (Like a password for passwords): ");
                    key = scanner.nextLine();
                    passwordManager.encrypt(key, EncryptionType.XOR);
                    out.println("All passwords encrypted!");
                    break;
                case 5:
                    passwordManager.decrypt(key, EncryptionType.XOR);
                    out.println("All passwords decrypted!");
                    break;
                case 6:
                    // Toggle password strength checking
                    if (!passwordManager.isCheckPasswordSecurity()) {
                        passwordManager.setCheckPasswordSecurity(true);
                        out.println("I thought so. Better not turn that off again you weakling.");
                        break;
                    }
                    else {
                        passwordManager.setCheckPasswordSecurity(false);
                        out.println("Wow, so you like weak ass passwords I see.");
                        break;
                    }
                case 7:
                    exit = true;
                    break;
                default:
                    out.println("Invalid option!");
                    break;
            }
        }
    }
}
