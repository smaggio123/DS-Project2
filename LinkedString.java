/**
 * represents a linked string
 * @author Steven Maggio
 *
 */
public class LinkedString implements LinkedStringInterface {

	private Node<Character> head; //this is the head of the doubly linked list
	
	private Node<Character> tail; //this is the tail of the doubly linked list
	
	private int count; //this counts the length of the doubly linked list
	
	
	/**
	 * this constructor sets count to zero
	 */
	public LinkedString() {
		this.head=new Node<Character>();
		//sets count to zero
		this.count=0;
	}
	
	/**
	 * constructor that makes a doubly linked list with character elements
	 * @param c
	 */
	public LinkedString(char c[]) {
		this.count=0; //sets count to zero
		
		//iterating through array
		for(int i=0;i<c.length;i++) {
			//if the doubly linked list is empty
			if(isEmpty()) {
				//sets tail to the new node
				tail=new Node<Character>(c[i]);
				//count increments because we added a node
				count++;
				//set head equal to tail because they are both at the same node
				head=tail;
			}
			//if doubly linked list is not empty
			else {
				//make a new node with the element of a character from the array and points to the tail node
				Node<Character> nextNode=new Node<Character>(c[i],null,tail);
				//set next node to the next node
				tail.setNext(nextNode);
				//increment count because we added a node
				count++;
				//set tail equal to the next node
				tail=tail.getNext();
			}
			
		}
	}
	/**
	 * calls a method that converts the string into an array of characters
	 * calls the constructor above
	 * @param str
	 */
	public LinkedString(String str) {
		//calls constructor above and calls a method that changes the string into an array of characters
		this(str.toCharArray());
	}
	
	
	/**
	 * finds the character in the linked string at a specified index
	 * @param pos
	 * @return character at specified index
	 * @throws ListException
	 */
	@Override
	public char charAt(int pos) throws ListException{
		// TODO Auto-generated method stub
		//if the linked string is empty
		if(this.count==0) {
			//throws error and prints to console that the list is empty
			throw new ListException("The list is empty");
		}
		//if pos is not within the specified bounds
		else if(pos < 0 || pos > this.length()){
			//throw an out of bounds exception
			throw new ListIndexOutOfBoundsException("The index value must be between 0 and length of list.");
		  }
		//if there is no issue
		else{
			//make a temporary node
			Node<Character>temp=head;
			//index variable
			int i=0;
			//while index is not at desired position
			while(i<pos) {
				//if index goes past length of linked string
				if(i>length()) {
					//throw out of bounds exception
					throw new ListIndexOutOfBoundsException("out of bounds dude");
				}
				//if index is in bounds
				else {
					//set temp to next node
					temp=temp.getNext();
					//increment index
					i++;
					}
			}
			//return node at specified index
			return temp.getElement();
		}
	}

	
	/**
	 * Concatenates two linked strings
	 * @param list
	 * @return concatenated linked strings
	 * @throws ListException
	 */
	@Override
	public LinkedString concat(LinkedString other) throws ListException {
		//make new linked string object
		LinkedString a=new LinkedString();
		//iterating through the this linked string
		for(int i=0;i<this.length();i++) {
			//if the linked string is empty
			if(a.isEmpty()) {
				//set tail to first node of the this linked string
				a.tail=new Node<Character>(this.charAt(0));
				//increment count because we added a node
				a.count++;
				//set head equal to tail
				a.head=a.tail;
			}
			//if linked string is not empty
			else {
				//make a new temporary node
				Node<Character> nextNode=new Node<Character>(this.charAt(i),null,a.tail);
				//sets next node to the next node
				a.tail.setNext(nextNode);
				//increment count because we added a node
				a.count++;
				//set tail equal to the next node
				a.tail=a.tail.getNext();
			}
		}
		//iterating through the other linked string
		for(int k=0;k<other.length();k++) {
			//if the linked string is empty
			if(a.isEmpty()) {
				//set the tail to the first node of the other linked string
				a.tail=new Node<Character>(other.charAt(0));
				//increment count because we are adding a node
				a.count++;
				//set head equal to tail
				a.head=a.tail;
			}
			//if the other linked string is not empty
			else {
				//make a new node with the node from the other linked string
				Node<Character> nextNode=new Node<Character>(other.charAt(k),null,null);
				//set the next node to the next node
				a.tail.setNext(nextNode);
				//increment count because we added a node
				a.count++;
				//set tail equal to the next node
				a.tail=a.tail.getNext();
			}
		}
		//return combined linked string
		return a;
	}

	
	/**
	 * returns true if linked string is empty and false if linked string is not empty
	 * @return true or false
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//returns true if count is zero or false if the count is not equal to 0
		return this.count==0;
	}

	
	/**
	 * returns length of the linked string
	 * @return length of linked string
	 */
	@Override
	public int length() {
		// TODO Auto-generated method stub
		//returns the value of count
		return this.count;
	}

	/**
	 * returns a portion of a linked string
	 * @param from
	 * @param to
	 * @return portion of a linked string
	 * @throws ListException
	 */
	@Override
	public LinkedString substring(int from, int to) throws ListException {
		//make a new linked string
		LinkedString theSubbedString=new LinkedString();
		//if the from and to variables are not within the specified bounds
		if(from>this.length()||to>this.length()+1) {
			//throws an out of bounds error
			throw new ListIndexOutOfBoundsException("You're out of bounds dude");
		}
		//if the variables are within the specified bounds
		else {
			//iterate from from to to
			for(int i=from;i<to;i++) {
				//if the linked string is empty
				if(theSubbedString.isEmpty()) {
					//set tail to the first element of the this linked string
					theSubbedString.tail=new Node<Character>(this.charAt(0));
					//increment count because a node was added
					theSubbedString.count++;
					//set head equal to tail
					theSubbedString.head=theSubbedString.tail;
				}
				//if linked string is not empty
				else {
					//make a linked string object
					Node<Character> nextNode=new Node<Character>(this.charAt(i),null,null);
					//set the next node to the next node
					theSubbedString.tail.setNext(nextNode);
					//increment the count because a node was added
					theSubbedString.count++;
					//set tail equal to the next node
					theSubbedString.tail=theSubbedString.tail.getNext();
				}
			}
			//return the subbed link string
		return theSubbedString;
		}
	}
	
	/**
	 * returns the value of the head in string form
	 */
	public String toString(){
		String str="";
		try {
		for(int i=0;i<this.length();i++) {
			str+=this.charAt(i);
		}
		}catch(ListException e){
			System.out.println("List exception");
		}
		return str;
	}
}
