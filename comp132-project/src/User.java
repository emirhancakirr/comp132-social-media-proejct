import java.util.ArrayList;

import javax.swing.ImageIcon;

public class User {
	protected String nickname;
	protected String password;
	protected String name;
	protected String surname;
	protected String emailadress;
	protected String photo;
	protected ArrayList hobbies;
	protected boolean isPremium;
	protected int age;
	protected int followers = 0;
	protected int following = 0;
	protected static ArrayList<User> allusers = new ArrayList<User>();
	protected ArrayList<User> followerList = new ArrayList<User>();
	protected ArrayList<User> followingList = new ArrayList<User>();
	protected ArrayList<Group> grouplist = new ArrayList<Group>();
	private ArrayList<Content> allContent = new ArrayList<Content>();

	public User(String nickname, String password, String name, String surname, String emailadress, String photo,
			ArrayList hobbies, boolean isPremium, int age) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.emailadress = emailadress;
		this.photo = photo;
		this.hobbies = hobbies;
		this.isPremium = isPremium;
		this.age = age;
		allusers.add(this);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmailadress() {
		return emailadress;
	}

	public void setEmailadress(String emailadress) {
		this.emailadress = emailadress;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ArrayList getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList hobbies) {
		this.hobbies = hobbies;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public static ArrayList getAllusers() {
		return allusers;
	}

	public static void setAllusers(ArrayList allusers) {
		User.allusers = allusers;
	}

	public static User findUser(String password, String nickname) {
		for (User user : allusers) {
			if (user.nickname.equals(nickname)) {
				if (user.password.equals(password)) {
					return user;
				}
			}
		}
		return null;

	}

	public void createContent(String title, String author, String text, ImageIcon image) {
		Content content = new Content(title, author, text, image);
		allContent.add(content);
	}

	public ArrayList<Group> getGrouplist() {
		return grouplist;
	}

	public void setGrouplist(ArrayList<Group> grouplist) {
		this.grouplist = grouplist;
	}

	public void attendGroup(Group group) {
		group.getMembers().add(this);
		grouplist.add(group);
	}

	public void addContent(Content newContent) {
		allContent.add(newContent);
	}

	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", emailadress=" + emailadress + ", photo=" + photo + ", hobbies=" + hobbies + ", isPremium="
				+ isPremium + ", age=" + age + ", followers=" + followers + ", following=" + following
				+ ", followerList=" + followerList + ", followingList=" + followingList + ", grouplist=" + grouplist
				+ ", allContent=" + allContent + "]";
	}

}
