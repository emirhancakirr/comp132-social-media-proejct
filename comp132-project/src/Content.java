import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Content {
	private String title;
	private String author;
	private String text;
	private Path image;
	private Timestamp timeStamp;
	protected static ArrayList<Content> allContent = new ArrayList<Content>();
	protected static HashSet<String> allContentTitles = new HashSet<String>();

	public Content(String title, String author, String text, Path image, String loc) {
		this.title = title;
		this.author = author;
		this.text = text;
		this.image = image;
		timeStamp = new Timestamp(new Date().getTime());
		allContent.add(this);
		allContentTitles.add(title);
		if (loc != "My Profile") {
			for (Group group : Group.allGroups) {
				if (group.getName().equals(loc)) {
					group.addContent(this);
				}
			}
		}
	}

	public Content(String title, String author, String text, String loc) {
		this.title = title;
		this.author = author;
		this.text = text;
		timeStamp = new Timestamp(new Date().getTime());
		allContent.add(this);
		allContentTitles.add(title);
		if (loc != "My Profile") {
			for (Group group : Group.allGroups) {
				if (group.getName().equals(loc)) {
					group.addContent(this);
				}
			}
		}
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
}
