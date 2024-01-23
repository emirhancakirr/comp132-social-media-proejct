import java.util.ArrayList;

/**
 * This class holds all informations and methods could be used groups.
 * 
 * @author Emirhan Cakir
 *
 */
public class Group {
	private String name;
	private String country;
	private String hobies;
	private User creator;

	private ArrayList<User> members = new ArrayList<User>();
	private ArrayList<Content> contents = new ArrayList<Content>();
	protected static ArrayList<Group> allGroups = new ArrayList<Group>();

	/**
	 * This constructor is used to create new Group object.
	 * 
	 * @param name    - name of the group
	 * @param country - country of the group
	 * @param hobies  - hobbies of the group
	 * @param creator - creator of the group
	 */
	public Group(String name, String country, String hobies, User creator) {
		super();
		this.name = name;
		this.country = country;
		allGroups.add(this);
		this.hobies = hobies;
		this.setCreator(creator);
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

	/**
	 * It takes the content and adds to group contents list.
	 * 
	 * @param content - content is a Content which indicates which content will be
	 *                added to list.
	 */
	public void addContent(Content content) {
		contents.add(content);

	}

	public String getHobies() {
		return hobies;
	}

	public void setHobies(String hobies) {
		this.hobies = hobies;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", country=" + country + ", hobies=" + hobies + ", members=" + members
				+ ", contents=" + contents + "]";
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
