

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		String w1 = preProcess(str1);
    	String w2 = preProcess(str2);

		// בעיה בגיט והצאט המליץ לי לשים פה רווחים - בכנות לא סגור על זה
		w1 = w1.replace(" ", "");
   		w2 = w2.replace(" ", "");
		
		if (w1.length() != w2.length()) {
        	return false;
    	}
		// שומר את האותיות שהשתמשנו בהן כדי לא להכשיל את הטסט
		boolean[] used = new boolean[w2.length()];

		for (int i = 0; i < w1.length(); i++) {

        	char c = w1.charAt(i);
        	boolean foundMatch = false;

        for (int j = 0; j < w2.length(); j++) {
            if (!used[j] && w2.charAt(j) == c) {
                used[j] = true;      
                foundMatch = true;   
                break;               
            }
        }
		        if (!foundMatch) {
            return false;
        }
    }

		return true;
	}
	   
	// Returns a preprocesseda version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code

		String text = str;
		String lower = text.toLowerCase();
		String clean = "";

		for ( int i = 0; i < lower.length(); i++) {
			char c = lower.charAt(i);
			
			if ((c >= 'a' && c <= 'z') || c == ' ') {
				clean = clean + c;
			}
		}
		return clean;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String pool = str;
    	String result = ""; 

		while (pool.length() > 0) {

        int r = (int)(Math.random() * pool.length());
        char c = pool.charAt(r);
        result = result + c;

        // מחיקה של חזרתיות
        if (r == 0) {
            pool = pool.substring(1);   
        } else if (r == pool.length() - 1) {
            pool = pool.substring(0, r); 
		} else {
            pool = pool.substring(0, r) + pool.substring(r + 1);
        }
    }

		return result;
	}
}