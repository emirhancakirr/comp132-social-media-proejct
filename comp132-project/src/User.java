import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 * This class holds all information and methods about users.
 * 
 * @author Emirhan Çakır
 *
 */
public class User {
	protected String nickname;
	protected String password;
	protected String name;
	protected String surname;
	protected String emailadress;
	protected ImageIcon photo;
	protected String hobbies;
	protected boolean isPremium;
	protected int age;
	protected int followers = 0;
	protected int following = 0;
	protected static ArrayList<User> allusers = new ArrayList<User>();
	protected static HashMap<String, User> mapUsers = new HashMap<String, User>();
	protected HashMap<String, User> followerList = new HashMap<String, User>();
	protected HashMap<String, User> followingList = new HashMap<String, User>();
	protected ArrayList<Group> grouplist = new ArrayList<Group>();
	protected ArrayList<Content> allContent = new ArrayList<Content>();

	/**
	 * This constructor takes nickname,password,name,surname,email address,path of
	 * profile photo,hobbies,information of user's subscription types and age. This
	 * method execute after register button pressed. So the registrations during
	 * execution are handled by this constructor.
	 * 
	 * @param nickname-         nickname of the user
	 * @param password-password of the user which is String.
	 * @param name              - name of the user
	 * @param surname           - surname of the user
	 * @param emailadress       - email of the user
	 * @param path              - path of the profile photo
	 * @param hobbies           - hobbies of the user as a String
	 * @param isPremium         - the indicator for subscription type
	 * @param age               - age of the user
	 */
	public User(String nickname, String password, String name, String surname, String emailadress, Path path,
			String hobbies, boolean isPremium, int age) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.emailadress = emailadress;
		if (path == null) {
			this.photo = new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/100x100 user1.png");
		} else {
			this.photo = new ImageIcon(path.toString());
		}
		this.hobbies = hobbies;
		this.isPremium = isPremium;
		this.age = age;
		allusers.add(this);
		mapUsers.put(nickname, this);
	}

	/**
	 * This constructor is used to create all user before execution. The difference
	 * between other constructor this overloaded constructor takes image as String
	 * not Path.
	 * 
	 * @param nickname          - nickname of the user
	 * @param password-password of the user which is String.
	 * @param name              - name of the user
	 * @param surname           - surname of the user
	 * @param emailadress       - email of the user
	 * @param path              - path of the profile photo
	 * @param hobbies           - hobbies of the user as a String
	 * @param isPremium         - the indicator for subscription type
	 * @param age               - age of the user
	 */
	public User(String nickname, String password, String name, String surname, String emailadress, String image,
			String hobbies, boolean isPremium, int age) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.emailadress = emailadress;
		this.photo = new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/" + image);
		this.hobbies = hobbies;
		this.isPremium = isPremium;
		this.age = age;
		allusers.add(this);
		mapUsers.put(nickname, this);
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

	public ImageIcon getPhoto() {
		return photo;
	}

	public void setPhoto(ImageIcon path) {
		this.photo = path;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
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

	public ArrayList<Content> getAllContent() {
		return allContent;
	}

	public void setAllContent(ArrayList<Content> allContent) {
		this.allContent = allContent;
	}

	/**
	 * This method is used to check password and nickname whether they are entered
	 * correct or not.
	 * 
	 * @param password - entered password in login page
	 * @param nickname - entered nickname in login page
	 * @return User or null is returned after this method. The returned User used to
	 *         hold information of logined user.
	 */
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



	public ArrayList<Group> getGrouplist() {
		return grouplist;
	}

	public void setGrouplist(ArrayList<Group> grouplist) {
		this.grouplist = grouplist;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFollowers() {
		return getFollowerList().size();
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowing() {
		return getFollowingList().size();
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public static HashMap<String, User> getMapUsers() {
		return mapUsers;
	}

	public static void setMapUsers(HashMap<String, User> mapUsers) {
		User.mapUsers = mapUsers;
	}

	public HashMap<String, User> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(HashMap<String, User> followerList) {
		this.followerList = followerList;
	}

	public HashMap<String, User> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(HashMap<String, User> followingList) {
		this.followingList = followingList;
	}

	/**
	 * User attends group via this method. Group is added into user's group list and
	 * user is added into group members' list
	 * 
	 * @param group
	 */
	public void attendGroup(Group group) {
		group.getMembers().add(this);
		grouplist.add(group);
	}

	/**
	 * It adds content in to user's contents list
	 * 
	 * @param newContent is a content which is created
	 */
	public void addContent(Content newContent) {
		allContent.add(newContent);
	}

	public void leaveGroup(Group group) {
		grouplist.remove(group);
		group.getMembers().remove(this);
	}


	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", emailadress=" + emailadress + ", photo=" + photo + ", hobbies=" + hobbies + ", isPremium="
				+ isPremium + ", age=" + age + ", followers=" + followers + ", following=" + following
				+ ", followerList=" + followerList + ", followingList=" + followingList + ", grouplist=" + grouplist
				+ ", allContent=" + allContent + "]";
	}

	/**
	 * This method is used for following operation. It takes targetUser as argument
	 * and it puts targetUser name and object to the current user following
	 * list.Also it puts current user to the follower list of target user.
	 * 
	 * @param targetuser is User who is wanted to follow.
	 */
	public void follow(User targetUser) {
		getFollowingList().put(targetUser.getNickname(), targetUser);
		targetUser.getFollowerList().put(this.getNickname(), this);
		;
	}

	/**
	 * It gets location of the photo as String than it set photo as profile photo of
	 * current user.
	 * 
	 * @param path is a string which has an address to image which is wanted to set.
	 */
	public void setSelectedPhoto(String path) {
		this.photo = new ImageIcon(path);
	}

}
