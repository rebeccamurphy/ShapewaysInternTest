package artistLists;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteFile {
	private String file_path;
	
	public WriteFile(String filePath){
		file_path= filePath;
	}
	
	public void Write(ArrayList list) throws IOException{
		PrintWriter writer = new PrintWriter(file_path);
		for(int i =0; i< list.size(); i++)
			writer.println(list.get(i).toString());
		writer.close();
	}

}
