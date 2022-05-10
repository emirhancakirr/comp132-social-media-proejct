import java.util.ArrayList;

public class Group {
	private String name;
	private String country;
	private ArrayList<User> members = new ArrayList<User>();
	private ArrayList<Content> contents = new ArrayList<Content>();
	protected static ArrayList<Group> allGroups = new ArrayList<Group>();

	public Group(String name, String country) {
		super();
		this.name = name;
		this.country = country;
		allGroups.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<User> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}

	public ArrayList<Content> getContents() {
		return contents;
	}

	public void setContents(ArrayList<Content> contents) {
		this.contents = contents;
	}

	public static ArrayList<Group> getAllGroups() {
		return allGroups;
	}

	public static void setAllGroups(ArrayList<Group> allGroups) {
		Group.allGroups = allGroups;
	}

	public void addContent(Content content) {
		contents.add(content);

	}

}
