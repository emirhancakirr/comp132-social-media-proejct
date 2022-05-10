import java.util.ArrayList;

public class launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList hobbies1 = new ArrayList();
		hobbies1.add("basketball");
		hobbies1.add("guitar");
		hobbies1.add("film");

		ArrayList<String> sheldoonhobbies = new ArrayList<String>();
		sheldoonhobbies.add("comic-books");
		sheldoonhobbies.add("physics");

		ArrayList<String> howardhobbies = new ArrayList<String>();
		howardhobbies.add("music");
		howardhobbies.add("astronomy");

		User emirhan = new User("", "", "Emirhan", "Çakır", "alsdm@gmail.com", "user1.png", hobbies1, true, 20);
		User sheldon = new User("sheldoonCopper", "", "Sheldoon", "Cooper", "sheldoon@gmail.com", "sheldoon.png",
				sheldoonhobbies, true, 30);
		User howard = new User("howardWolowitz", "", "Howard", "Wolowitz", "howard@gmail.com", "howard.png",
				howardhobbies, true, 30);

		Group pyhsicLover = new Group("Pyhsich Lovers", "USA");
		Group musicLover = new Group("Music Lovers", "USA");

		emirhan.attendGroup(pyhsicLover);
		emirhan.attendGroup(musicLover);

		sheldon.attendGroup(pyhsicLover);
		howard.attendGroup(musicLover);

		loginPagegui.start();
	}

}
