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
        this.checkPasswordSecurity = checkPasswordSecurity;
    }

    public PasswordManager(Collection<Password> passwords, boolean checkPasswordSecurity) {
        this(checkPasswordSecurity);
        this.passwords.addAll(passwords);
    }

    public void addPassword(String username, String password) {
        passwords.add(new Password(username, password));
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
}
