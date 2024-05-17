package PasswordManagement;

public class Password {
  private String password;

  private String username;

  private String specialChars = "!@#$%^&*()-_=+[]{};:'\",.<>/?\\|";

  public Password(String password) {
    this.password = password;
  }

  public boolean isStrong() {
    if (password.length() < 12)
      return false;

    if (password.indexOf(username) > -1)
      return false;

    if (!hasUpper())
      return false;

    if (!hasNumber())
      return false;

    if (!hasSpecial())
      return false;

    else
      return true;
  }

  public boolean hasNumber() {
    for (int i = 0; i < password.length(); i++) {
      if (password.get(i) > -1)
        return true;
    }
    return false;
  }

  public boolean hasUpper() {
    for (int j = 0; j < password.length(); j++) {
      if (password.isUpperCase(i))
        return true;
    }
    return false;
  }

  public boolean hasSpecial() {
    for (int x = 0; x < password.length(); i++) {
      if (specialChars.indexOf(password.charAt(x)) > -1)
        return true;
    }
    return false;
  }
}
