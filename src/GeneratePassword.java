import java.util.ArrayList;
import java.util.Random;
public class GeneratePassword{
    private static final ArrayList<Character> characters = new ArrayList<>();

    static {
        for (char c = 'A'; c <= 'Z'; c++) {
            characters.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            characters.add(c);
        }
        for (char c = '0'; c <= '9'; c++) {
            characters.add(c);
        }
        characters.add('!');
        characters.add('@');
        characters.add('#');
        characters.add('$');
        characters.add('%');
        characters.add('^');
        characters.add('&');
        characters.add('*');
        characters.add('(');
        characters.add(')');
    }

    public static String generatePassword() {
        Random random = new Random();

        StringBuilder password = new StringBuilder();
        while (password.length() < 8) {
            int index = random.nextInt(characters.size());
            char character = characters.get(index);
            password.append(character);
        }
        boolean hasSymbol = false;
        boolean hasNumber = false;
        boolean hasCapitalLetter = false;
        boolean hasLowercaseLetter = false;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (Character.isLetter(character)) {
                if (Character.isUpperCase(character)) {
                    hasCapitalLetter = true;
                } else {
                    hasLowercaseLetter = true;
                }
            } else if (Character.isDigit(character)) {
                hasNumber = true;
            } else {
                hasSymbol = true;
            }
        }

        if (!hasSymbol || !hasNumber || !hasCapitalLetter || !hasLowercaseLetter) {
            password = new StringBuilder(generatePassword());
        }

        return password.toString();
    }
}