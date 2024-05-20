import Encryption.EncryptionManager;
import Encryption.EncryptionManager.EncryptionType;
import PasswordManagement.PasswordManager;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Welcome to the Password Manager!");
        PasswordManager passwordManager = new PasswordManager(true);
        boolean exit = false;
        while (!exit) {
            PrintChoices();
            out.println();
            out.print("Choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            String key = null;
            switch (option) {
                case 1:
                    out.println("Fine, one more password to remember.");
                    out.print("Enter the username: ");
                    String username = scanner.nextLine();
                    out.print("Enter the password: ");
                    String password = scanner.nextLine();
                    boolean isStrong = passwordManager.addPassword(username, password);
                    if (!isStrong) {
                        out.println("Password is not strong enough!");

                        // Print out the password strength requirements
                        out.println("Password must:");
                        out.println("1. Be at least 8 characters long");
                        out.println("2. Contain at least one uppercase letter");
                        out.println("3. Contain at least special character");
                        out.println("4. Contain at least one number");
                        out.println("5. Not contain the username");

                    } else {
                        out.println("Password added!");
                    }
                    break;
                case 2:
                    // See if there are any passwords whatsoever
                    if (passwordManager.getPasswords().isEmpty()) {
                        out.println("No passwords to remove!");
                        out.println("Maybe add one in the first place???");
                        break;
                    }
                    out.print("Enter the index of the password to remove: ");
                    out.println("Hope your memory is good. You'll never see this password again.");
                    int index = scanner.nextInt();
                    // Check if password exists before removing
                    if (index < 0 || index >= passwordManager.getPasswords().size()) {
                        out.println("Invalid index!");
                        out.println("Try entering an actual index next time???");
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
                    out.println("You might want to write this key down.");
                    out.println("If you forget your key it is impossible to decrypt the passwords!");
                    out.print("Enter a key for the encryption (Like a password for passwords): ");
                    key = scanner.nextLine();
                    out.println();
                    passwordManager.encrypt(key, EncryptionType.XOR);
                    key = null;
                    out.println("All passwords encrypted!");
                    break;
                case 5:
                    out.println("Well, hopefully you wrote this down and listened to me.");
                    out.println("Entering the wrong key will result in the passwords being lost forever, turning them to gibberish!");
                    out.print("Enter a key for the decryption: ");
                    key = scanner.nextLine();
                    passwordManager.decrypt(key, EncryptionType.XOR);
                    // Theory: Setting the key to null makes it so the program won't keep it.
                    key = null;
                    out.println("All passwords decrypted!");
                    break;
                case 6:
                    // Toggle password strength checking
                    if (!passwordManager.isCheckPasswordSecurity()) {
                        passwordManager.setCheckPasswordSecurity(true);
                        out.println("I thought so. Better not turn that off again genius.");
                        break;
                    } else {
                        out.println("Seriously? All that hard work I put in to keep you safe and you want to turn it off?");
                        out.println("(Yes/No): ");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("No")) {
                            out.println("Good choice.");
                            break;
                        } else if (response.equalsIgnoreCase("Yes")) {
                            passwordManager.setCheckPasswordSecurity(false);
                            out.println("Wow, so you like weak passwords I see.");
                            break;
                        } else {
                            out.println("Invalid response!");
                            break;
                        }
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

    private static void PrintChoices() {
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
    }
}
