/**
 * This is the interface to the linked string
 * @author Steven Maggio
 *
 */
public interface LinkedStringInterface {
	
	/**
	 * finds the character in the linked string at a specified index
	 * @param pos
	 * @return character at specified index
	 * @throws ListException
	 */
	public char charAt(int pos) throws ListException;
	
	/**
	 * Concatenates two linked strings
	 * @param list
	 * @return concatenated linked strings
	 * @throws ListException
	 */
	public LinkedString concat(LinkedString list) throws ListException;
	
	/**
	 * returns true if linked string is empty and false if linked string is not empty
	 * @return true or false
	 */
	public boolean isEmpty();
	
	/**
	 * returns length of the linked string
	 * @return length of linked string
	 */
	public int length();
	
	/**
	 * returns a portion of a linked string
	 * @param from
	 * @param to
	 * @return portion of a linked string
	 * @throws ListException
	 */
	public LinkedString substring(int from,int to) throws ListException;
}
