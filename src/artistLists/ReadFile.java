package artistLists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	}

	
}
