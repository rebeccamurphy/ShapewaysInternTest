/**
 * 
 */
package artistLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
		ArrayList<String> artistList = new ArrayList<String>();
		ArrayList<String[]> favoritesList =  new ArrayList<String[]>();
		ArrayList<String> artistPop= new ArrayList<String>();
		ArrayList<String> artistPop1= new ArrayList<String>();
		ArrayList<String> artistPop2= new ArrayList<String>();
		
		
		ArrayList<artistCount> artistListCount= new ArrayList<artistCount>();
		ArrayList<ArtistPair> artistPairCount= new ArrayList<ArtistPair>();
		
		int count =0;
		int pairCount =0;
		final int min =50;
		
		try {
			ReadFile rfile = new ReadFile(file_name, 1000);
			rfile.OpenFile(favoritesList, artistList);
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		/*
		for (int i=0; i<artistList.size();i++){
			for (int j=0; j<favoritesList.size(); j++){
				if (Arrays.asList(favoritesList.get(j)).contains(artistList.get(i)))
					count++;
			}
			artistListCount.add(new artistCount(artistList.get(i), count));
			count=0;
		}
		*/
		//finds artists in at least 50 lists
		for (int i=0; i<artistList.size();i++){
			for (int j=0; j<favoritesList.size(); j++){
				if (count >= min){
					artistPop.add(artistList.get(i));
					i++; //move onto next artist
					count=0;
					break;
				}
				if (Arrays.asList(favoritesList.get(j)).contains(artistList.get(i)))
					count++;
			}
		}
		
		//splits artist pop into 2 lists
		for (int i=0; i<artistPop.size(); i++){
			if (i%2==0)
				artistPop1.add(artistPop.get(i));
			else
				artistPop2.add(artistPop.get(i));
		}
		System.out.println(artistPop.size());
		
		for (int i=0; i<artistPop1.size(); i++){
			for( int j=0; j< artistPop2.size(); j++){
				for (int k =0; k< favoritesList.size(); k++){
					if (pairCount>=min){
						artistPairCount.add(new ArtistPair(artistPop1.get(i), artistPop2.get(j), pairCount));
						pairCount=0;
						break;
					}
					else if (Arrays.asList(favoritesList.get(k)).contains(artistPop1.get(i)) && 
							Arrays.asList(favoritesList.get(k)).contains(artistPop2.get(j)))
						pairCount++;
							
				}
			}				
		}
		
		try {
			WriteFile wfile = new WriteFile("artist_pair_count.txt");
			wfile.Write(artistPairCount);
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
	}
			
}
