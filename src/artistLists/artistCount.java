package artistLists;

public class artistCount {
	private String artist;
	private int count;
	final int min = 50;
	public artistCount(){
		artist="";
		count=0;
	}
	
	public artistCount(String a, int num){
		artist =a;
		count = num;
	}
	
	public void addCount(){
		count++;
	}
	
	public boolean in50Lists(){
		return count>=min;
	}
	
	@Override
	public String toString(){
		return artist + " " + count;
	}
}
