/**
 * represents a node
 * @author Steven Maggio
 *
 * @param <E>
 */
public class Node<E> {
	
	private E item; //element of the node
	
	private Node<E> next; //next node
	
	private Node<E> previous; //previous node
	
	/**
	 * constructor of a node with no data so it sets everything to null
	 */
	public Node() {
		//element set to null
		item=null;
		//the next node is set to null
		next=null;
		//the previous node is set to null
		previous=null;
	}
	
	/**
	 * constructor of a node with a parameter of the element of the node
	 * @param obj
	 */
	public Node(E obj) {
		//sets element of node to obj
		this.item=obj;
		//sets next node to null
		this.next=null;
		//sets previous node to null
		this.previous=null;
	}
	/**
	 * constructor with parameters of element and pointers of the node
	 * @param obj
	 * @param n
	 * @param prev
	 */
	public Node(E obj,Node<E> n, Node<E> prev) {
		//sets element to obj
		this.item=obj;
		//sets next node to n
		this.next=n;
		//sets previous node to prev
		this.previous=prev;
	}
	
	/**
	 * This method returns the element of the node
	 * @return
	 */
	public E getElement() {
		try {
			//returns element of the node
			return this.item;
		}
		//if there is a pointer exception
		catch(NullPointerException e) {
			//print message
			System.out.println("no node dude");
		}
		//return null
		return null;
	}
	
	/**
	 * sets element to the parameter obj
	 * @param obj
	 */
	public void setElement(E obj) {
		//sets item to obj
		this.item=obj;
	}
	
	/**
	 * gets the previous node
	 * @return
	 */
	public Node<E> getPrevious() {
		//returns previous node
		return this.previous;
	}
	
	/**
	 * sets the previous node to the parameter node
	 * @param node
	 */
	public void setPrevious(Node<E> node) {
		//sets the previous node to the parameter node
		this.previous=node;
	}
	
	/**
	 * gets the next node
	 * @return
	 */
	public Node<E> getNext() {
		//returns the next node
		return this.next;
	}
	
	/**
	 * sets the next node
	 * @param node
	 */
	public void setNext(Node<E> node) {
		//sets the next node to the node from the parameter
		this.next=node;
	}
	
	/**
	 * returns the element of the node in string form
	 */
	public String toString(){
		//return the string form of the element of the node
		return ""+getElement();
	}
	
	
}
