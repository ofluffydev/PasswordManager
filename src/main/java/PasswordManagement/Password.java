package PasswordManagement;

public class Password {
    private final String username;
    private String password;

    public Password(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isStrong() {
        if (password.length() < 12)
            return false;

        if (password.contains(username))
            return false;

        if (!hasUpper())
            return false;

        if (!hasNumber())
            return false;

        return hasSpecial();
    }

    public boolean hasNumber() {
        for (int i = 0; i < password.length(); i++) {
            String numbers = "0123456789";
            if (numbers.contains(password.substring(i, i + 1)))
                return true;
        }
        return false;
    }

    public boolean hasUpper() {
        for (int j = 0; j < password.length(); j++) {
            char c = password.charAt(j);
            if (Character.isUpperCase(c))
                return true;
        }
        return false;
    }

    public boolean hasSpecial() {
        for (int x = 0; x < password.length(); x++) {
            String specialChars = "!@#$%^&*()-_=+[]{};:'\",.<>/?\\|";
            if (specialChars.indexOf(password.charAt(x)) > -1)
                return true;
        }
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
