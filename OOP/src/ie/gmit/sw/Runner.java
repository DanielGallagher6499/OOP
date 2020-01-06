package ie.gmit.sw;

import java.util.*;
import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Runner.
 */
public class Runner {
	
	/** The wili. */
	private static String wili;
	
	/** The query. */
	private static String query;
	
	/** The console. */
	private static Scanner console = new Scanner(System.in);
	
	/** Number of ngrams. */
	private static int numGrams;
	
	/**
	 * The main method.
	 * Outputs a menu to the user asking for an input wili file.
	 * Then it asks the users for the amount of ngrams they would like to use.
	 * Creates the database based off of this.
	 * Outputs messages to the user along the way such as loading and completed.
	 * Outputs to the user asking for a query or test file to detect the language of.
	 * At the end this outputs the detected language to the user.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		//The below block is the output when the program it is ran
		System.out.println("***********************************************");
		System.out.println("*                                             *");
		System.out.println("*  G00360986 - Daniel Gallagher - GMIT        *");
		System.out.println("*            Language Detector!               *");
		System.out.println("*                                             *");
		System.out.println("***********************************************");
		System.out.println("Welcome!");
		System.out.println("Please follow the following instructions.");
		System.out.println("Please Enter wili File Location: ");
		wili = console.next();
		
		//Ngram options for the user
		System.out.println("Please enter the number of ngrams you would like to use (1-6)");
		numGrams = console.nextInt();
		if(numGrams == 1) {
			numGrams = 1;
		}
		
		else if (numGrams == 2) {
			numGrams = 2;
		}
		
		else if (numGrams == 3) {
			numGrams = 3;
		}
		
		else if (numGrams == 4) {
			numGrams = 4;
		}
		
		else if (numGrams == 5) {
			numGrams = 5;
		}
		
		else if (numGrams == 6) {
			numGrams = 6;
		}
		
		
		//Creating the database - it gives a loading text to the user and uses 3 ngrams for detection
		try{
		Database db = new Database();
		Parser p = new Parser(wili, numGrams);
		System.out.println("Loading Please Wait......");
		
		p.setDb(db);
		Thread t = new Thread(p);
		t.start();
		t.join();
		
		db.resize(300);
		
		//Database Loaded - output message
		System.out.println("Loading Completed Successfully!");
		
		//Asking for the Query or testing file to test and takes the user input 
		System.out.println("Please Enter Test File Location: ");
		query = console.next();
		
		//Test String
		String s = "This is an example of the english language";
		p.analyseQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
}
