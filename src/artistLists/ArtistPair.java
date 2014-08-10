package artistLists;

public class ArtistPair {
	private String artist1;
	private String artist2;
	private int count;
	
	public ArtistPair(){
		artist1="";
		artist2="";
		count=0;
	}
	
	public ArtistPair(String a1, String a2, int num){
		artist1= a1;
		artist2= a2;
		count =num;
	}
	
	public void addCount(){
		count++;
	}
	@Override
	public String toString(){
		return artist1 +" "+ artist2+ " " + count;
	}
}
