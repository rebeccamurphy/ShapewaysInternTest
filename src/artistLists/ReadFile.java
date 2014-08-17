package artistLists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ReadFile {
	private String path;
	private int numLines;
	
	public ReadFile(String file_path, int num_lines){
		path = file_path;
		numLines = num_lines;
	}
	
	public void OpenFile(int choice) throws IOException{
		if (choice==0)
		{
			
			ArrayList<String> artistList = new ArrayList<String>();
			ArrayList<String[]> favoritesList =  new ArrayList<String[]>();
			
			FileReader fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader(fr);
			
			for(int i =0; i<numLines; i++){
				favoritesList.add(textReader.readLine().split(","));
				for(int j =0; j<favoritesList.get(i).length; j++){
					if (!artistList.contains(favoritesList.get(i)[j]))
						artistList.add(favoritesList.get(i)[j]);
				}
			}
			textReader.close();
			
			ArrayListSort sort = new ArrayListSort();
			sort.ArrayListMethod(favoritesList, artistList);
			
			
		}
		else if (choice==1)
		{
			FileReader fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader(fr);
			HashMap<String, HashSet<Integer>> artistListPop = new HashMap<String, HashSet<Integer>>();
			String[] list;
			String artist;
			int listNum;
			for(int i =0; i<numLines; i++){
				list = textReader.readLine().split(",");
				
				listNum=i;
				for(int j =0; j<list.length; j++){
					artist = list[j];
					System.out.println(artist);
					if (!artistListPop.containsKey(artist)){
						artistListPop.put(artist, new HashSet<Integer>());
					}
					
					if(artistListPop.containsKey(artist)){
						artistListPop.get(artist).add(listNum);
					}
				}
				break;
			}
			textReader.close();
			
			HashSetInt sort = new HashSetInt();
			sort.HashSetIntMethod(artistListPop);
			
		}
	}

	
}
