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
		
		Iterator it = artistListPop.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, HashSet<Integer>> artistList = (Map.Entry<String, HashSet<Integer>>)it.next();
			String artist = artistList.getKey();
			HashSet<Integer> list = artistList.getValue();
			if(list.size()<min)
				it.remove();
		}
		//get itersections
		for (Map.Entry<String, HashSet<Integer>> artistList1 : artistListPop.entrySet()){
			
			String artist1 = artistList1.getKey();
			HashSet<Integer> list1 = artistList1.getValue();
			
			for (Map.Entry<String, HashSet<Integer>> artistList2 : artistListPop.entrySet()){
				
				String artist2 = artistList2.getKey();
				HashSet<Integer> list2 = artistList2.getValue();
				
				HashSet<Integer> intersection = new HashSet<Integer>(list1);
				intersection.retainAll(list2);
				int listCount =intersection.size();
				if (!(listCount<min) && !artist1.equals(artist2) )
					artistPairs.add("(" + artist1 + " , " + artist2 + ") " +listCount);
				
			}
			WriteFile wr = new WriteFile("hashset_int_artist_pair_count.txt");
			try {
				wr.Write(artistPairs);
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
			}
		}
	}
	
	

}
