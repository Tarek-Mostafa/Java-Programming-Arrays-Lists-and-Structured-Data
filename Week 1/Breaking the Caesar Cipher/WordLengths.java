/**
 * Retruns the word lenghts in a text file
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class WordLengths {
	// Main function
    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            int wordLength = getWordLength(word);
            counts[wordLength] += 1;
        }
        
        for(int i = 1, n = counts.length; i < n; i++) {
            if(counts[i] > 0) {
                System.out.println(counts[i] + " words of length " + i);
            }
        }
    }
    
    /*
     * Returns the word length of a word
     * and checks if a not valid char like (, " . -) should be counted or not 
     */
    public int getWordLength(String word) {
        char[] notValidChars = {',', '-', '"', '.', '\''};
        int wordLength = 0;
        for(int i = 0, n = word.length(); i < n; i++) {
            char currentChar = word.charAt(i);
            boolean isCharFirstOrLast = word.indexOf(currentChar) == 0 || word.indexOf(currentChar) == n-1;
            boolean isNotChar = arrayContainsChar(notValidChars, currentChar);
            
            // if char is valid char, or an invalid char that's not the starting or ending of the word
            if(Character.isLetter(currentChar) || (isNotChar && !isCharFirstOrLast) ) {
                wordLength++;
            }
        }
        return wordLength;
    }
    
    /*
     * Returns boolean if a character exists in an array of characters
     */
    public boolean arrayContainsChar(char[] arr, char targetValue) {
        for(char s: arr){
            if(s == targetValue) {
                return true;
            }
        }
        return false;
    }
    
    /*
	 * Start the program here
     */
    public void testCountWordLengths() {
        FileResource fr = new FileResource("data/smallHamlet.txt");
        int[] counts = new int[31];
        countWordLengths(fr, counts);
    }
}
