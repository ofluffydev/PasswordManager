import PasswordManagement.Password;
import PasswordManagement.PasswordManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTests {
    // Using JUnit Jupiter for testing

    // Test that the PasswordManager class can be instantiated
    @Test
    public void testPasswordManagerInstantiation() {
        PasswordManager passwordManager = new PasswordManager();
        Assertions.assertNotNull(passwordManager);
    }

    // Try creating 10 random passwords and adding them to the PasswordManager class using the addPassword method
    @Test
    public void testAddPassword() {
        // Create a new PasswordManager object without checking the security
        PasswordManager passwordManager = new PasswordManager(false);
        for (int i = 0; i < 10; i++) {
            passwordManager.addPassword("username" + i, "password" + i);
        }
        Assertions.assertEquals(10, passwordManager.getPasswords().size());

        // Print all the passwords using the getPasswords method
        for (Password password : passwordManager.getPasswords()) {
            System.out.println("Username: " + password.getUsername() + " Password: " + password.getPassword());
        }
    }

    // Test removing passwords from the PasswordManager class by creating 10 random passwords and removing one by index
    @Test
    public void testRemovePassword() {
        // Create a new PasswordManager object without checking the security
        PasswordManager passwordManager = new PasswordManager(false);
        for (int i = 0; i < 10; i++) {
            passwordManager.addPassword("username" + i, "password" + i);
        }
        Assertions.assertEquals(10, passwordManager.getPasswords().size());

        // Remove the password at index 5
        passwordManager.removePassword(5);
        Assertions.assertEquals(9, passwordManager.getPasswords().size());

        // Print all the passwords using the getPasswords method
        for (Password password : passwordManager.getPasswords()) {
            System.out.println("Username: " + password.getUsername() + " Password: " + password.getPassword());
        }
    }
}
