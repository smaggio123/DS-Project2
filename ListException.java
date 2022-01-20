/**
 * Defines an exception that is thrown when an operataion can't be completed.
 * For example, if a list is empty, remove operation can't done. 
 */
public class ListException extends Exception {
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public ListException(String message) {
		super(message);
	}
}

