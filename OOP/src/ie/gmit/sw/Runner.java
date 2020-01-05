package ie.gmit.sw;

import java.util.*;
import java.io.*;

public class Runner {
	
	private static String wili;
	private static String query;
	private static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
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
		
		try{
		Database db = new Database();
		Parser p = new Parser(wili, 3);
		System.out.println("Loading Please Wait......");
		
		p.setDb(db);
		Thread t = new Thread(p);
		t.start();
		t.join();
		
		db.resize(300);
		
		System.out.println("Loading Completed Successfully!");
		
		System.out.println("Please Enter Test File Location: ");
		query = console.next();
		
		String s = "This is an example of the english language";
		p.analyseQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
}
