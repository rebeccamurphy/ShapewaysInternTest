package artistLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListSort {
	
	public ArrayListSort(){}
	
	
	public void ArrayListMethod(ArrayList<String[]> favoritesList, ArrayList<String> artistList){
		ArrayList<String> artistPop= new ArrayList<String>();
		ArrayList<String> artistPop1= new ArrayList<String>();
		ArrayList<String> artistPop2= new ArrayList<String>();
		
		
		ArrayList<String> artistPairCount= new ArrayList<String>();
		
		int count =0;
		int pairCount =0;
		final int min =50;
		
		System.out.println(artistList.size());
		for (int i=0; i<artistList.size();i++){
			for (int j=0; j<favoritesList.size(); j++){
				if (Arrays.asList(favoritesList.get(j)).contains(artistList.get(i)))
					count++;
				if (count >= min){
					artistPop.add(artistList.get(i));
					count=0;
					break;
				}
			}
			count=0;
		}
		System.out.println(artistPop.size());
		//splits artist pop into 2 lists
		for (int i=0; i<artistPop.size(); i++){
			if (i%2==0)
				artistPop1.add(artistPop.get(i));
			else
				artistPop2.add(artistPop.get(i));
		}
		for (int i=0; i<artistPop.size(); i++){
			for( int j=i+1; j< artistPop.size(); j++){
				for (int k =0; k< favoritesList.size(); k++){
					if (Arrays.asList(favoritesList.get(k)).contains(artistPop.get(i)) && 
							Arrays.asList(favoritesList.get(k)).contains(artistPop.get(j)))
						pairCount++;
					
					if (pairCount>=min){
						artistPairCount.add( "( " +artistPop.get(i) + " , " +artistPop.get(j) +" ) " + pairCount);
						break;
					}	
				}
				pairCount=0;
			}
			
		}
		
		try {
			WriteFile wfile = new WriteFile("arraylist_artist_pair_count.txt");
			Collections.sort(artistPairCount);
			wfile.Write(artistPairCount);
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		try {
			WriteFile wfile = new WriteFile("arraylist_artist_unique_count.txt");
			Collections.sort(artistPop);
			wfile.Write(artistPop);
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}
