import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.ImageIcon;

/**
 * Content class hold information and methods of contents.
 * 
 * @author Emirhan Cakir
 */
public class Content {
	private String title;
	private String author;
	private String text;

	private ImageIcon image;
	private Timestamp timeStamp;
	private String location;
	private User userAuthor;

	protected static HashMap<String, Content> allContent = new HashMap<String, Content>();
	protected static HashSet<String> allContentTitles = new HashSet<String>();

	/**
	 * This constructor is coded to construct content object which have
	 * title,text,image,location and user information
	 * 
	 * @param title title of the content
	 * 
	 * @param text  text of the content
	 * 
	 * @param image image of the content which types string
	 * 
	 * @param loc   location of the content which takes argument as String
	 * 
	 * @param user  creator of the content which takes argument as User
	 */
	public Content(String title, String text, String image, String loc, User userAuthor) {
		this.title = title;
		this.author = userAuthor.getName().concat(" ").concat(userAuthor.getSurname());
		this.text = text;
		this.image = new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/" + image);
		timeStamp = new Timestamp(new Date().getTime());
		allContent.put(title, this);
		allContentTitles.add(title);
		location = loc;
		this.setUserAuthor(userAuthor);
		userAuthor.getAllContent().add(this);
		if (loc != "My Profile") {
			for (Group group : Group.allGroups) {
				if (group.getName().equals(loc)) {
					group.addContent(this);
				}
			}
		}
	}

	/**
	 * This constructor is coded to construct content object which have
	 * title,text,image,location and user information
	 * 
	 * @param title title of the content
	 * 
	 * @param text  text of the content
	 * 
	 * @param image image of the content which types Path
	 * 
	 * @param loc   location of the content which takes argument as String
	 * 
	 * @param user  creator of the content which takes argument as User
	 */
	public Content(String title, String text, Path image, String loc, User userAuthor) {
		this.title = title;
		this.author = userAuthor.getName().concat(" ").concat(userAuthor.getSurname());
		this.text = text;
		this.image = new ImageIcon(image.toString());
		timeStamp = new Timestamp(new Date().getTime());
		allContent.put(title, this);
		allContentTitles.add(title);
		location = loc;
		this.setUserAuthor(userAuthor);
		userAuthor.getAllContent().add(this);
		if (loc != "My Profile") {
			for (Group group : Group.allGroups) {
				if (group.getName().equals(loc)) {
					group.addContent(this);
				}
			}
		}
	}

	/**
	 * The difference between other constructor it enable to create content which
	 * don't have image This constructor is coded to construct content object which
	 * have title,text,location and user information
	 * 
	 * @param title title of the content
	 * 
	 * @param text  text of the content
	 * 
	 * @param loc   location of the content which takes argument as String
	 * 
	 * @param user  creator of the content which takes argument as User
	 */
	public Content(String title, String text, String loc, User userAuthor) {
		this.title = title;
		this.author = userAuthor.getName().concat(" ").concat(userAuthor.getSurname());
		this.text = text;
		timeStamp = new Timestamp(new Date().getTime());
		allContent.put(title, this);
		allContentTitles.add(title);
		location = loc;
		this.setUserAuthor(userAuthor);
		userAuthor.getAllContent().add(this);
		if (loc != "My Profile") {
			for (Group group : Group.allGroups) {
				if (group.getName().equals(loc)) {
					group.addContent(this);
				}
			}
		}
	}



	/**
	 * This method gets content where shared
	 * 
	 * @return location location is string which indicates that argument where
	 *         shared.
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * This method gets title of the content
	 * 
	 * @return title title is string which indicates that arguments title.
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method gets creator of the content
	 * 
	 * @return author author is string which indicates that creator of content.
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * This method gets text of the content
	 * 
	 * @return text text is string.
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * This method gets image of the content
	 * 
	 * @return image image is string which give location of image which is used in
	 *         content.
	 */
	public String getImage() {
		return String.valueOf(image);
	}

	public void setImage(Path image) {
		this.image = new ImageIcon(image.toString());
	}

	/**
	 * This method gets timeStamp of the content
	 * 
	 * @return timeStamp the timeStamp of type is TimeStamp. It gives the time of
	 *         creation.
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * This method gets allContent which is static because it is general parameter.
	 * 
	 * @return allContent - is a HashMap which holds title of Content as key and
	 *         content object as value.
	 */
	public static HashMap<String, Content> getAllContent() {
		return allContent;
	}


	/**
	 * This method gets allContent which is static because it is general parameter.
	 * 
	 * @return allContent - is a HashMap which holds title of Content as key and
	 *         content object as value.
	 */
	public static HashSet<String> getAllContentTitles() {
		return allContentTitles;
	}

	

	@Override
	public String toString() {
		if (this.image != null) {
		return "Content [title=" + title + ", author=" + author + ", text=" + text + ", image=" + image.toString()
				+ ", timeStamp="
				+ timeStamp + "]";
	}else {
		return "Content [title=" + title + ", author=" + author + ", text=" + text + "timeStamp=" + timeStamp + "]";
	}

}
	/**
	 * This method gets creator of the content
	 * 
	 * @return userAuthor - userAuthor is a User which created related content.
	 */
	public User getUserAuthor() {
		return userAuthor;
	}

	public void setUserAuthor(User userAuthor) {
		this.userAuthor = userAuthor;
	}

	public void setSelectedPhoto(String string) {
		this.image = new ImageIcon(string);
	}
}
