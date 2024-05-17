package Encryption;

public class EncryptionManager {
    public static String encrypt(String password, String key, EncryptionType encryptionType) {
        // Encrypt the password
        switch (encryptionType) {
            case AES:
                return AESEncryption.encrypt(password, key);
            case DES:
                return DESEncryption.encrypt(password, key);
            case RSA:
                return RSAEncryption.encrypt(password, key);
            case XOR:
                return XOREncryption.encrypt(password, key);
            default:
                return null;
        }
    }

    public static String decrypt(String password, String key, EncryptionType encryptionType) {
        switch (encryptionType) {
//            case AES:
//                return AESEncryption.decrypt(password, key);
//            case DES:
//                return DESEncryption.decrypt(password, key);
//            case RSA:
//                return RSAEncryption.decrypt(password, key);
            case XOR:
                return XOREncryption.decrypt(password, key);
            default:
                return null;
        }
    }

    // Enum for the different types of encryption
    public enum EncryptionType {
        AES,
        DES,
        RSA,
        XOR
    }
}
