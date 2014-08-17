package artistLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class HashSetInt {
	final int min=50;
	public HashSetInt(){};
	
	public void HashSetIntMethod(HashMap<String, HashSet<Integer>> artistListPop){
		//first remove artists in less than 50 lists
		ArrayList<String> artistPairs = new ArrayList<String>();
		HashMap<String, HashSet<Integer>> artistListPopCopy = new HashMap<String, HashSet<Integer>>(artistListPop);
		ArrayList<String> artists = new ArrayList<String>();
		
		Iterator it = artistListPop.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<String, HashSet<Integer>> artistList = (Map.Entry<String, HashSet<Integer>>)it.next();
			String artist = artistList.getKey();
			HashSet<Integer> list = artistList.getValue();
			if(list.size()<min){
				it.remove();
				//System.out.println(list.size());
			}
			else
				artists.add(artist);
		}
		
		//get intersections
		for (int i=0; i<artists.size(); i++){
			String artist1 = artists.get(i);
			for (int j=i+1; j<artists.size(); j++){
				String artist2 = artists.get(j);
				HashSet<Integer> list2 = artistListPop.get(artist2);
				HashSet<Integer> intersection = new HashSet<Integer>(artistListPop.get(artist1));
				intersection.retainAll(list2);
			
				int listCount =intersection.size();
				if (listCount>=min)
					artistPairs.add("(" + artist1 + " , " + artist2 + ") " +listCount);
				}
			}
		
		WriteFile wr = new WriteFile("hashset_int_artist_pair_count.txt");
		try {
			wr.Write(artistPairs);
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	

}
