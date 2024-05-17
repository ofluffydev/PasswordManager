import Encryption.EncryptionManager;
import Encryption.EncryptionManager.EncryptionType;
import Encryption.XOREncryption;
import PasswordManagement.Password;
import PasswordManagement.PasswordManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class EncryptionTesting {
    // This will be a very advanced test that will test the encryption and decryption of passwords

    @Test
    public void testXOR() {
        String key = "key";

        // Create a password
        Password password = new Password("test", "password");

        String encrypted = XOREncryption.encrypt(password, key);

        // Print the new password
        out.println(encrypted);

        // Check the password by making sure it isn't the same as the original password
        Assertions.assertNotEquals(password.getPassword(), encrypted);

        // Decrypt the password, make sure it's the same as the original password
        String decrypted = XOREncryption.decrypt(encrypted, key);
        out.println(decrypted);
        Assertions.assertEquals(password.getPassword(), decrypted);
    }
}
