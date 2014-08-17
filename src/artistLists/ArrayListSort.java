package artistLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListSort {
	
	public ArrayListSort(){}
	
	
	public void ArrayListMethod(ArrayList<String[]> favoritesList, ArrayList<String> artistList){
		ArrayList<String> artistPop= new ArrayList<String>();
		ArrayList<String> artistPop1= new ArrayList<String>();
		ArrayList<String> artistPop2= new ArrayList<String>();
		
		
		ArrayList<ArtistPair> artistPairCount= new ArrayList<ArtistPair>();
		
		int count =0;
		int pairCount =0;
		final int min =50;
		
		
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
			WriteFile wfile = new WriteFile("arraylist_artist_pair_count.txt");
			wfile.Write(artistPairCount);
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}
