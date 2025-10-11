package at.spengergasse.diplo3entities.validation;

import java.util.Objects;
import java.util.regex.Pattern;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.nulabinc.zxcvbn.Strength;

public final class Guard {

    private static final String[] FORBIDDEN_WORDS = {
            "password", "admin", "user", "qwerty"
    };

    private static final Zxcvbn ZXCVBN = new Zxcvbn();

    public static String textLength(String text, int maxLength, String message) {
        Objects.requireNonNull(text);

        String trimmedText = checkMaxLength(text, maxLength, message);
        if (trimmedText.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return trimmedText;
    }

    public static String textLength(String text, int minLength, int maxLength, String message) {
        Objects.requireNonNull(text);

        String trimmedText = checkLength(text, minLength, maxLength, message);
        if (trimmedText.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return trimmedText;
    }

    public static String validatePassword(String password, int minLength, int maxLength, String message) {
        Objects.requireNonNull(password, "Password must not be null");

        String trimmed = checkLength(password, minLength, maxLength, message);

        // Keine verbotenen Wörter (case insensitive)
        for (String word : FORBIDDEN_WORDS) {
            if (trimmed.toLowerCase().contains(word)) {
                throw new IllegalArgumentException("Password contains forbidden word: " + word);
            }
        }

        // zxcvbn Score prüfen (0 = schwach, 4 = sehr stark)
        Strength strength = ZXCVBN.measure(trimmed);
        if (strength.getScore() < 3) { // Score 0,1,2 = zu schwach
            throw new IllegalArgumentException("Password is too weak: " + strength.getFeedback().getWarning());
        }

        return trimmed;
    }

    public static String checkLength(String text, int minLength, int maxLength, String message) {
        Objects.requireNonNull(text, "Text must not be null");
        String trimmed = text.trim();

        if (trimmed.length() < minLength || trimmed.length() > maxLength) {
            throw new IllegalArgumentException(message);
        }

        return trimmed;
    }

    public static String checkMaxLength(String text, int maxLength, String message) {
        Objects.requireNonNull(text, "Text must not be null");
        String trimmed = text.trim();

        if (trimmed.length() > maxLength) {
            throw new IllegalArgumentException(message);
        }

        return trimmed;
    }

    public static int checkMinMax(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}