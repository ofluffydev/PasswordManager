package Encryption;

import PasswordManagement.Password;

public class XOREncryption {
    public static String encrypt(String password, String key) {
        // Make a byte array of the password and key
        byte[] passwordChars = password.getBytes();

        // Make the key into a byte array
        byte[] keyChars = key.getBytes();

        /*
        Check if the key is at least as long as the plaintext.
        If the key is shorter, you can extend it by repeating the key bytes until it's long enough.
        */

        if (keyChars.length < passwordChars.length) {
            // Make a new byte array to store the new key
            byte[] newKey = new byte[passwordChars.length];

            // Copy the key into the new key array
            for (int i = 0; i < passwordChars.length; i++) {
                newKey[i] = keyChars[i % keyChars.length];
            }

            // Set the key to the new key
            keyChars = newKey;
        }

        // Now, once that's finally done, finally we can encrypt the password using xor
        for (int i = 0; i < passwordChars.length; i++) {
            passwordChars[i] = (byte) (passwordChars[i] ^ keyChars[i]);
        }

        // Return the encrypted password
        return new String(passwordChars);
    }

    public static String encrypt(Password password, String key) {
        return encrypt(password.getPassword(), key);
    }

    public static String decrypt(String password, String key) {
        ByteArrays result = getByteArrays(password, key);

        // Now, decrypt the password using xor
        for (int i = 0; i < result.passwordChars().length; i++) {
            result.passwordChars()[i] = (byte) (result.passwordChars()[i] ^ result.keyChars()[i]);
        }

        // Return the decrypted password
        return new String(result.passwordChars());
    }

    private static ByteArrays getByteArrays(String password, String key) {
        // Make a byte array of the password and key
        byte[] passwordChars = password.getBytes();

        // Make the key into a byte array
        byte[] keyChars = key.getBytes();

        /*
        Check if the key is at least as long as the plaintext.
        If the key is shorter, you can extend it by repeating the key bytes until it's long enough.
        */

        if (keyChars.length < passwordChars.length) {
            // Make a new byte array to store the new key
            byte[] newKey = new byte[passwordChars.length];

            // Copy the key into the new key array
            for (int i = 0; i < passwordChars.length; i++) {
                newKey[i] = keyChars[i % keyChars.length];
            }

            // Set the key to the new key
            keyChars = newKey;
        }
        ByteArrays result = new ByteArrays(passwordChars, keyChars);
        return result;
    }

    private record ByteArrays(byte[] passwordChars, byte[] keyChars) {
    }
}
