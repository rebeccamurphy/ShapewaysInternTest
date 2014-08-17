/**
 * 
 */
package artistLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rebecca Murphy
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) throws IOException{
		String file_name = "Artist_lists_small.txt";
		Scanner scan = new Scanner(System.in);
		int choice =0;
		//instead choice here
		System.out.println("0 for arraylist method, 1 for hashset int method, 2 for hashset bitset method, 3 for int treeset " +
				"method, 4 for bitset treeset method.");
		choice = Integer.parseInt(scan.nextLine());
		scan.close();
		final long startTime = System.currentTimeMillis(); //start timer
		
		try {
			ReadFile rfile = new ReadFile(file_name, 1000);
			rfile.OpenFile(choice);
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total Approximate Execution Time " + (endTime- startTime)/1000.0 + " seconds");
		
	}
			
}
