import java.util.*;


public class Main {
    public static void main(String[] args) {
        String input = "adadmadam";
        System.out.println(longestPalindrome(input));

        int num = 4568859;
        System.out.println(ReverseInteger.reverse(num));

            System.out.println(Atoi.atoi("   -42")); // Output: -42
            System.out.println(Atoi.atoi("4193 with words")); // Output: 4193
            System.out.println(Atoi.atoi("words and 987")); // Output: 0
            System.out.println(Atoi.atoi("-91283472332")); // Output: -2147483648

    }

    public static int lengthOfLongestSubstring(String s) {
        ArrayList<String> substrings = new ArrayList<>();
        String[] arr = s.split("");
        StringBuilder currentSubstring = new StringBuilder();

        // Build substrings
        for (String string : arr) {
            if (stringContainsString(string, currentSubstring)) {
                substrings.add(currentSubstring.toString());
                currentSubstring = new StringBuilder();
            }
            currentSubstring.append(string);
        }

        // Add the last substring if it exists
        if (!currentSubstring.isEmpty()) {
            substrings.add(currentSubstring.toString());
        }

        // Print all substrings
        System.out.println("All substrings:");
        for (String substring : substrings) {
            System.out.println(substring);
        }

        // Define a comparator to sort substrings by length (descending order)
        Comparator<String> lengthComparator = (s1, s2) -> {
            return Integer.compare(s2.length(), s1.length()); // Descending order
        };

        // Sort substrings using the comparator
        substrings.sort(lengthComparator);

        // Print sorted substrings
        System.out.println("Substrings sorted by length (descending):");
        for (String substring : substrings) {
            System.out.println(substring);
        }

        // Return the length of the longest substring
        if (!substrings.isEmpty()) {
            return substrings.getFirst().length(); // The first substring is the longest
        }
        return 0; // If no substrings exist
    }

    public static boolean stringContainsString(String s, StringBuilder substring) {
        String[] arr = substring.toString().split("");
        for (String string : arr) {
            if (string.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static String longestPalindrome(String s) {

//        HashMap<Character, Integer> charIndexMap = new HashMap<>();
//        int currentIndex = 0;
//        int left = 0;
//        String longestPalindrome = "";
//
//        for (int right = 0; right < s.length(); right++) {
//            char currentChar = s.charAt(right);
//
//            charIndexMap.put(currentChar, right);
//            String currentWindow = s.substring(left,right);
//            if (isPalindrome(currentWindow)) {
//                if (currentWindow.length() > longestPalindrome.length()) {
//                    longestPalindrome = currentWindow;
//                }
//            }
//        }

        ArrayList<String> palindromes = new ArrayList<>();

        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                if (isPalindrome(s.substring(left, right))) {
                    palindromes.add(s.substring(left, right));
                }
            }

        }
        Comparator<String> lengthComparator = (s1,s2) -> Integer.compare(s2.length(), s1.length());
        palindromes.sort(lengthComparator);





        return palindromes.toArray().length > 0 ? palindromes.toArray()[0].toString() : s;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() > 1 ) {
            String reversed = new StringBuilder(s).reverse().toString();
            return reversed.equals(s);
        }
        return false;
    }
}

