/*
 * Palindrome.java
 * class to check if the word is palindrome
 * Stack is used to store the word in reverse
 * Each letter of the word is compared to each letter pop from the stack
 * If two letters do not match isPalindrome function returns false
 * if stack is empty than the word is palindrome
 */
public class Palindrome { 
	/*
	 * Function to check if a word is palindrome
	 * returns true if word is palindrome
	 * otherwise returns false
	 */
	public boolean isPalindrome(String str) {
	        int len = str.length(); //get length of word
	        char token = 0;
	        Stack stack = new Stack(len); // make stack
            // push each letter a word into stack
	        for (int i = 0; i < len; i++) {
	            token = str.charAt(i);
	            if (token != ' ')
	                stack.push(token);
	            }
            //pop each letter from stack and check if equals letter in word
	        for (int j = 0; j < len; j++) {
	            token = str.charAt(j);
	            if (token != ' ')
	                if  (stack.pop()!= token)
	                return false;
	        }

	        return (stack.isEmpty()); // if stack empty word is palindrome
	       }
   
	public static void main (String[] args) {
		Palindrome pal = new Palindrome(); // make Palindrome object
		// check if word is palindrome
		System.out.println(pal.isPalindrome(args[0]));
		
  }
}
