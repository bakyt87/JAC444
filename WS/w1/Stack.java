/*
 * Stack.java
 * Stack class to store chars
 * 
 */
public class Stack {

	private char[] stack; // stack items
	private int size; // capacity 
	private int index; // stack top

	// make stack of specified size
	public Stack(int size) {
        index=-1;
		this.size=size;
		stack = new char[size];
	}
	// return true if stack is empty
	public boolean isEmpty() {

		return index== -1;
	}
	//push item on to stack
	public void push(char someChar) {
		index++;
		stack[index]=someChar;
	}
	// pop item from stack and return item
	public char pop() {
		char someChar=stack[index];
		index--;
		return someChar;

	}
	//return stack capacity
	public int getSize() {
		return size;
	}
	
}
