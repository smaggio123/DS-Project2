import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Steven Maggio
 *
 */
public class Helper {
	
	/**
	 * This void method is decomposed.
	 * It creates an empty array list that can be used to store a list of LinkedString objects.
	 * It calls create with a reference to the array list.
	 * @throws FileNotFoundException
	 * @throws ListException
	 */
	public static void start() throws FileNotFoundException, ListException {
		//make an array list
		ArrayList<LinkedString> list=new ArrayList<LinkedString>();
		//calls create method
		create(list);
		
	}
	
	/**
	 * Uses data stored in text files to make LinkedString objects.
	 * Adds the LinkedString objects into the array list.
	 * @param a
	 * @throws FileNotFoundException
	 * @throws ListException
	 */
	public static void create(ArrayList<LinkedString> a) throws FileNotFoundException, ListException {
		//System.out.println("Adding items from file");
		//getting testing data from a file
		File file= new File("C:\\Users\\cptna\\Data Structures\\Project 2\\src\\testingItems");
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			LinkedString obj=new LinkedString(line);
			a.add(obj);
		}
		sc.close();
		
		//calls display method
		display(a);
	}
	
	/**
	 * For every two adjacent Linked strings in the list, if they are not empty(isEmpty returns false),
	 * Calls length and print the returned length of each linked string.
	 * Calls charAt and print the returned first character of each linked string.
	 * Calls substring to get the first character and print the returned string of each linked string.
	 * Calls concat to concatenate and print the length of each concatenated linked string
	 * @param a
	 * @throws ListException
	 */
	public static void display(ArrayList<LinkedString> a) throws ListException {
		//iterating through array list
		for(int i=1;i<a.size();i++) {
			//string of name before name
			String nameB=a.get(i-1).toString();
			//string of name in every other line
			String name=a.get(i).toString();
			//String of name after name
			String nameA="";
			//testing to make sure that a next word exists in testing data
			if(i+1<a.size()) {
				//set the next name to the next name
				nameA=a.get(i+1).toString();
			}
			
			//for odd index or every other index
			if(i%2==1) {
				//print name
				System.out.println("Word is: "+name);
				
				//determines/prints if linked string is empty
				System.out.print("Is LinkedList empty: ");
				if(a.get(i).isEmpty()) System.out.println("yes");
				else System.out.println("no");
				
				//prints length of string
				System.out.println("Length of LinkedString is: "+a.get(i).length());
				
				int position=0;
				//tests to make position is within the proper bounds
				if(position<a.get(i).length()&&position>=0) {
				//prints char at the position in linked string
				System.out.println("char at pos "+ position +" is: "+a.get(i).charAt(position));
				}
				//if position is not within proper bounds
				else {
					System.out.println("position is not within proper bounds");
				}
				
				int start=0;//starting index
				int end=3;//ending index
				//check to make sure that start is less than end and they are within proper bounds
				if(start<end&&end<=name.length()&&start>=0&&end>=0) {
				//subbed linked string
				LinkedString subbedString=a.get(i).substring(start,end);
				//printing the substring
				System.out.println("The substring from "+start+" to "+end+" is: "+subbedString);
				}
				//if end is not within proper bounds
				else if(end>name.length()) {
					System.out.println("end is greater than length, cannot sub linked string");
				}
				//if start is greater than end
				else if(start>end){
					System.out.println("Since start is greater than end, cannot sub the linked string");
				}
				//if any other problem occurs
				else {
					System.out.println("cannot sub the linked strings");
				}
				
				//concatenating the word with the word before it in testing data
				System.out.println("\nConcatenating word with the previous word in testing data");
				//printing names that will be concatenated
				System.out.println("Concatting "+nameB+ " and "+ name);
				//makes linked string of concatenated linked strings
				LinkedString concatenatedWord=a.get(i-1).concat(a.get(i));
				
				//prints length of the linked strings
				System.out.println("Length of concattenated word is: "+concatenatedWord.length());
				//prints concatenated word
				System.out.println("The concatenated word is: "+ concatenatedWord);
				
				//makes linked string of concatenated linked strings in reverse
				LinkedString reversedConcatenatedWord=a.get(i).concat(a.get(i-1));
				//prints the reversed concatenated word
				System.out.println("The reversed word is: "+ reversedConcatenatedWord);
				
				
				//testing to make sure that a next word exists in testing data
				if(i+1<a.size()) {
					//concatenating the word with the word that comes next in testing data
					System.out.println("\nConcatenating word with the following word in testing data");
					//printing names that will be concatenated
					System.out.println("Concatting "+name+ " and "+ nameA);
					//makes linked string of concatenated linked strings
					concatenatedWord=a.get(i).concat(a.get(i+1));
					
					//prints length of the linked strings
					System.out.println("Length of concattenated word is: "+concatenatedWord.length());
					//prints concatenated word
					System.out.println("The concatenated word is: "+ concatenatedWord);
					
					//makes linked string of concatenated linked strings in reverse
					reversedConcatenatedWord=a.get(i+1).concat(a.get(i));
					
					//prints the reversed concatenated word
					System.out.println("The reversed word is: "+ reversedConcatenatedWord+"\n");
					System.out.println("\n");
				}
				else {
					//if there is no word after the word, prints that there is no next word to concatenate
					System.out.println("\nThere is no next word to concatenate\n");
					System.out.println("\n");
				}
			}
		}
		
	}
}
