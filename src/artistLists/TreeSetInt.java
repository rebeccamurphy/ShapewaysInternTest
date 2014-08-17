package artistLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Map;

public class TreeSetInt {
	final int min=50;
	public TreeSetInt(){};
	
	public void TreeSetIntMethod(HashMap<String, TreeSet<Integer>> artistListPop){
		//first remove artists in less than 50 lists
		ArrayList<String> artistPairs = new ArrayList<String>();
		HashMap<String, TreeSet<Integer>> artistListPopCopy = new HashMap<String, TreeSet<Integer>>(artistListPop);
		ArrayList<String> artists = new ArrayList<String>();
		
		Iterator it = artistListPop.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<String, TreeSet<Integer>> artistList = (Map.Entry<String, TreeSet<Integer>>)it.next();
			String artist = artistList.getKey();
			TreeSet<Integer> list = artistList.getValue();
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
				TreeSet<Integer> list2 = artistListPop.get(artist2);
				TreeSet<Integer> intersection = new TreeSet<Integer>(artistListPop.get(artist1));
				intersection.retainAll(list2);
			
				int listCount =intersection.size();
				if (listCount>=min)
					artistPairs.add("(" + artist1 + " , " + artist2 + ") " +listCount);
				}
			}
		
		WriteFile wr = new WriteFile("TreeSet_int_artist_pair_count.txt");
		try {
			wr.Write(artistPairs);
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	

}
