package JavaActivity3;

abstract class Book {
	String title;
	abstract void setTitle(String s);
	String getTitle() {
		return title;
		
	}
	
}
class MyBook extends Book {
	public void setTitle(String s) {
		title = s;
	}
}
public class Activit2_1 {

	public static void main(String[] args) {
		String title = "Hover car racer";
		Book newNovel = new MyBook();
		newNovel.setTitle(title);
		
	System.out.println("The Title is: " + newNovel.getTitle());
	}

}
