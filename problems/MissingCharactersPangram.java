package problems;

/**
 * Find missing characters to convert given string to pangram.
 *
 * A pangram is a sentence or verse that contains all the letters of the alphabet.
 *
 * Input: The quick brown fox jumps over the lay do
 *
 * Output: gz
 */

public class MissingCharactersPangram {
    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lay do".replace(" ", "").toLowerCase();
        boolean[] charPresent = new boolean[26];

        //Iterate through array and mark its presence
        for(char c: input.toCharArray()) {
            charPresent[c - 'a'] = true;
        }

        StringBuilder missingChars = new StringBuilder();

        for(int index = 0; index<charPresent.length; index++) {
            if(!charPresent[index]) {
                missingChars.append((char)('a' + index));
            }
        }

        System.out.println(missingChars.toString());
    }
}
