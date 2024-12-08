package les_9;

import java.util.regex.*;

public class Task4 {
    private String password;

    public Task4(String password) {
        this.password = password;
    }

    public String validatePassword() {
        if (password.length() < 8 || password.length() > 12) {
            return "Пароль должен быть от 8 до 12 символов.";
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return "Пароль должен содержать хотя бы одну заглавную букву.";
        }
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return "Пароль должен содержать хотя бы одну строчную букву.";
        }
        if (!Pattern.compile("[#@$%^&*<>]").matcher(password).find()) {
            return "Пароль должен содержать хотя бы один специальный символ.";
        }
        return "Пароль хороший.";
    }
}