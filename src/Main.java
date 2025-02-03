import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("abcdeabcdwderthsbvcabcdabcd");
        System.out.println("Length of longest substring: " + length);

        MedianArray medianArray = new MedianArray();

        int[] arr1 = {1,3};
        int[] arr2 = {2,4};

        int[] merged = medianArray.merge(arr1, arr2);
        double median  = medianArray.median(arr1, arr2);
        System.out.println(median);

        System.out.println(Arrays.toString(merged));
        for (int i = 0; i < merged.length; i++) {
            System.out.println(merged[i]);
        }
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
}