package PasswordManagement;

import Encryption.EncryptionManager;
import Encryption.EncryptionManager.EncryptionType;

import java.util.ArrayList;
import java.util.Collection;

public class PasswordManager {
    private boolean checkPasswordSecurity;
    private ArrayList<Password> passwords;

    public PasswordManager() {
        // Check the security by default
        checkPasswordSecurity = true;
        passwords = new ArrayList<>();
    }

    public PasswordManager(Collection<Password> passwords) {
        this();
        this.passwords.addAll(passwords);
    }

    public PasswordManager(boolean checkPasswordSecurity) {
        // Choose whether to check the security
        this();
        this.checkPasswordSecurity = checkPasswordSecurity;
    }

    public PasswordManager(Collection<Password> passwords, boolean checkPasswordSecurity) {
        this(checkPasswordSecurity);
        this.passwords.addAll(passwords);
    }

    public boolean addPassword(String username, String passwordString) {
        if (checkPasswordSecurity) {
            Password password = new Password(username, passwordString);
            if (!password.isStrong()) {
                return false;
            }
            else {
                passwords.add(new Password(username, passwordString));
                return true;
            }
        } else
            passwords.add(new Password(username, passwordString));
        return true;
    }

    public void setCheckPasswordSecurity(boolean b) {
        checkPasswordSecurity = b;
    }

    public ArrayList<Password> getPasswords() {
        return passwords;
    }

    public void removePassword(int i) {
        passwords.remove(i);
    }

    public void encrypt(String key, EncryptionType encryptionType) {
        // Encrypt all the passwords
        for (Password password : passwords) {
            password.setPassword(EncryptionManager.encrypt(password.getPassword(), key, encryptionType));
        }
    }

    public void decrypt(String key, EncryptionType encryptionType) {
        // Decrypt all the passwords
        for (Password password : passwords) {
            password.setPassword(EncryptionManager.decrypt(password.getPassword(), key, encryptionType));
        }
    }

    public boolean isCheckPasswordSecurity() {
        return checkPasswordSecurity;
    }
}
