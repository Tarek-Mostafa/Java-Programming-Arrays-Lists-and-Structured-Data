
/**
 * Cryptography Caesar Cipher Algorithm.
 * 
 * @author (Tarek) 
 * @version (0.1)
 */
public class CaesarCipher {
	/**
	 * This method returns a String that has been encrypted using 
	 * the Caesar Cipher algorithm explained in the videos. Assume 
	 * that all the alphabetic characters are uppercase letters.
	 */
	public String encrypt(String input, int key) {
		StringBuilder encrypted = new StringBuilder(input);		// Convert String input to StringBuilder
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";			// The alphabet
		String alphabet_shifted = alphabet.substring(key);		// The shifted portion of the alphabet by key
		alphabet_shifted += alphabet.substring(0, key);			// The shifted alphabet by key

		for(int i = 0, n = input.length(); i < n; i++) {
			char currChar = input.charAt(i);					// Current char from input
			int currCharIndex = alphabet.indexOf(currChar);		// Index of current char from input
			
			if(currCharIndex != -1) { 	// If char isn't a space or a punctuation
				char charShifted = alphabet_shifted.charAt(currCharIndex); 	// Encrypted char
				encrypted.setCharAt(i, charShifted);	// Insert encrypted char at the i'th location of encrypted string
			}
		}

		return encrypted.toString();
	}

	public void testEncrypted() {
		System.out.println(encrypt("I AM GETTING RID OF YOU", 17));
	}
}
