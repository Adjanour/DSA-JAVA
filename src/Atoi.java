
public class Atoi {

    public static boolean isDigit(char character) {
        return character >= '0' && character <= '9';
    }

    public static int charToInt(char character) {
        return character - '0';
    }

    public static int atoi(String str) {
        int result = 0;
        int n = str.length();
        int sign = 1;
        int i = 0;

        if (n == 0) return 0;

        // Skip leading spaces
        while (i < n && str.charAt(i) == ' ') i++;

        // Handle sign
        if (i < n && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert characters to integer
        while (i < n && isDigit(str.charAt(i))) {
            int digit = charToInt(str.charAt(i));

            // Overflow check
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }
}

