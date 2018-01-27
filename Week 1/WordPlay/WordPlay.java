
/**
 * A program to transform words from a file into another form, 
 * as replacing vowels with an asterix.
 * 
 * @author (Tarek Mostafa) 
 * @version (0.1)
 */
import edu.duke.*;

public class WordPlay {
    /**
     * This method returns true if @parameter ch is a vowel 
     * (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) 
     * and return false otherwise. 
     */
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        if(ch == 'i' || ch == 'e' || ch == 'a' || ch == 'o' || ch == 'u') {
           return true; 
        } else {
            return false;
        }
    }
    
    /**
     * This method should return a String that is the string phrase 
     * with all the vowels (uppercase or lowercase) replaced by @parameter ch. 
     */
    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0, n = phrase.length(); i < n; i++) {
            char currentChar = newPhrase.charAt(i);
            int currCharIndex = phrase.indexOf(currentChar, i);
            
            if(isVowel(currentChar)) {    
                newPhrase.setCharAt(currCharIndex, ch);
            }
        }
        return newPhrase.toString();
    }
    
    /**
     * This method should return a String that is the 
     * string phrase but with the Char ch (upper- or lowercase) replaced by
     * '+' if it is in an odd number location in the string
     * '*' if it is in an even number location in the string
     */
    public String emphasize(String phrase, char ch) {
       StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0, n = phrase.length(); i < n; i++) {
            char currentChar = newPhrase.charAt(i);
            int currCharIndex = phrase.indexOf(currentChar, i);
            
            if(Character.toLowerCase(currentChar) == Character.toLowerCase(ch) && (currCharIndex+1) % 2 == 0) {    
                newPhrase.setCharAt(currCharIndex, '+');
            }
            
            if(Character.toLowerCase(currentChar) == Character.toLowerCase(ch) && (currCharIndex+1) % 2 != 0) {
                newPhrase.setCharAt(currCharIndex, '*');
            }
        }
        return newPhrase.toString();
    }
    
    // Begin testing methods
    public void testIsVowel() {
        System.out.println(isVowel('e')); // true
    }
    
    public void testReplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*')); // H*ll* W*rld
    }

    public void testEmphasize() {
        System.out.println(emphasize("dna ctgaaactga", 'a')); // dn* ctg+*+ctg+
        System.out.println(emphasize("Mary Bella Abracadabra", 'a')); // M+ry Bell+ +br*c*d*br+
    }
}
