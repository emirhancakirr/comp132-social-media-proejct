import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Profile class holds all information and methods which can be used in profile
 * page.
 * 
 * @author Emirhan Cakir
 *
 */
public class Profile implements ActionListener {

	protected static User currentUser = LoginPage.user;
	protected static JFrame frame = Mainpage.frame;
	protected static JPanel profilePanel;
	protected static JScrollPane profilecontents;
	private JButton following;
	private JButton follower;
	private JButton joinedGroup;
	private JFrame groupListFrame;
	private JButton goGroup;
	private JList groupList;
	private JButton settings;
	private JFrame openSettingFrame;
	private JButton logOut;
	private JButton deleteAccount;
	private JFrame followerListFrame;
	private JFrame followingListFrame;
	private JButton editAccount;
	private JFrame editAccountFrame;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField emailField;
	private JTextField ageField;
	private JButton imageField;
	private File newImage;
	private JButton applyBut;
	private JButton editContentBut;
	private JFrame editFrame;
	private JList contentList;
	private JButton contentEditBut;
	private JFrame contentEditFrame;
	private JTextField titleField;
	private JTextArea textArea;
	private JButton submit;
	private Content editedcontent;
	private File image;
	private JButton removeContent;

	/**
	 * The constructor basically prepare system to put profile elements. Firstly it
	 * removes possible panels and adds related scroll pane.
	 */
	public Profile() {
		try {
			frame.remove(GroupPage.groupScrollPane);
		} catch (NullPointerException e) {
			frame.remove(Mainpage.midPanel);
		}

		if (!Mainpage.midPanel.equals(null)) {
		} else if (!GroupPage.groupScrollPane.equals(null)) {
		}

		// ScrollPane is created
		profilecontents = new JScrollPane(putMyContents(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(profilecontents);

		frame.invalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	/**
	 * The method is called in constructor to put all contents to the scroll pane.
	 * Firstly it creates basic panel than put information of
	 * users-name,nickname...-.After that it takes all contents of user to put
	 * panel.
	 * 
	 * @return profilePanel - this panels hold all contents,buttons,informations of
	 *         user.
	 */
	public JPanel putMyContents() {

		profilePanel = new JPanel();
		profilePanel.setBackground(new Color(244, 250, 255));
		profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));

		settings = new JButton();
		settings.setIcon(new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/settings.png"));
		settings.setSize(new Dimension(30, 30));
		settings.setHorizontalAlignment(JButton.LEFT);
		settings.setBackground(new Color(244, 250, 255));
		settings.setBorderPainted(false);
		settings.addActionListener(this);
		profilePanel.add(settings);

		JLabel pphoto = new JLabel();
		pphoto.setIcon(currentUser.getPhoto());
		profilePanel.add(pphoto);

		JLabel info = new JLabel(String.format(
				"<html><p>@%s</p> <p>%s %s</p> <p>Age:%d</p>Hobbies:%s</p> <p>%s</p>\r\n <p>Type:%s</p> </html>",
				currentUser.getNickname(), currentUser.getName(), currentUser.getSurname(), currentUser.getAge(),
				currentUser.getHobbies(), (currentUser.isPremium == true) ? "Premium" : "Standart",
				currentUser.emailadress));
		profilePanel.add(info);

		follower = new JButton(String.format("Follower %d", currentUser.getFollowers()));
		follower.setBounds(120, 11, 110, 20);
		follower.setFont(new Font("Tahoma", Font.BOLD, 10));
		follower.setBackground(new Color(193, 11, 37));
		follower.setForeground(Color.white);
		follower.addActionListener(this);
		profilePanel.add(follower);

		following = new JButton(String.format("Following %d", currentUser.getFollowing()));
		following.setFont(new Font("Tahoma", Font.BOLD, 10));
		following.setForeground(Color.white);
		following.setBounds(120, 50, 120, 20);
		following.setBackground(new Color(193, 11, 37));
		following.addActionListener(this);
		following.setAlignmentX(JButton.CENTER);
		profilePanel.add(following);

		joinedGroup = new JButton("Groups");
		joinedGroup.setFont(new Font("Tahoma", Font.BOLD, 10));
		joinedGroup.setForeground(Color.white);
		joinedGroup.setBackground(new Color(193, 11, 37));
		joinedGroup.setBounds(120, 100, 110, 20);
		joinedGroup.addActionListener(this);
		profilePanel.add(joinedGroup);

		JButton suggest = new JButton("Suggest me");
		suggest.setForeground(Color.white);
		suggest.setFont(new Font("Tahoma", Font.BOLD, 10));
		suggest.setBounds(120, 100, 110, 20);
		suggest.setBackground(new Color(193, 11, 37));
		profilePanel.add(suggest);

		editContentBut = new JButton("Edit Content");
		editContentBut.setForeground(Color.white);
		editContentBut.setFont(new Font("Tahoma", Font.BOLD, 10));
		editContentBut.setBounds(120, 130, 110, 20);
		editContentBut.setBackground(new Color(193, 11, 37));
		editContentBut.addActionListener(this);
		profilePanel.add(editContentBut);
		
		for (Content eachcontent : currentUser.getAllContent()) {
			JTextArea contentText = new JTextArea(String.format("Author: %s \t  %s \nTitle: %s\nText: %s \n%s",
					eachcontent.getAuthor(), eachcontent.getTimeStamp().toString().substring(0, 19),
					eachcontent.getTitle(), eachcontent.getText(), eachcontent.getLocation()));

			// arrange features of contextText
			contentText.setMargin(new Insets(0, 10, 10, 30));
			contentText.setBackground(Color.white);
			contentText.setLineWrap(true);
			contentText.setWrapStyleWord(true);
			contentText.setEditable(false);

			profilePanel.add(contentText);
			if (eachcontent.getImage() != "null") {
				JLabel photo = new JLabel();
				photo.setAlignmentX(Component.CENTER_ALIGNMENT);
				photo.setIcon(new ImageIcon(eachcontent.getImage()));
				photo.setMaximumSize(new Dimension(100, 100));
				profilePanel.add(photo);
			}

			JLabel line = new JLabel();
			line.setIcon(new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/line 360x13.png"));
			line.setAlignmentX(Component.CENTER_ALIGNMENT);
			profilePanel.add(line);
		}
		return profilePanel;
	}

	/**
	 * The method is overriding to manage button reactions. All cases are explained
	 * through code via comment.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// If the related button is activated it calls openGroupList which shows group
		// list which is attended.
		if (e.getSource() == joinedGroup) {
			openGroupList();
		} // If the related group button is activated, it gets selected group from JList
			// then creates Group.
		else if (e.getSource() == goGroup) {
			Group selectedGroup = null;
			// JList doesn't give group object, for loop to find group in allgroup list
			for (Group eachGroup : Group.getAllGroups()) {
				if (eachGroup.getName() == groupList.getSelectedValuesList().get(0)) {
					selectedGroup = eachGroup;
					break;
				}
			}
			groupListFrame.dispose();
			GroupPage openGroupPage = new GroupPage(selectedGroup);
		} // If the setting button is clicked, it calls openSettings() method;
		else if (e.getSource() == settings) {
			openSettings();
		} // If logout button is clicked, it close frames.
		else if (e.getSource() == logOut) {
			openSettingFrame.dispose();
			frame.dispose();
			LoginPage restart = new LoginPage();

		} // If deleteAccount is activated, it removes user from all user.
		else if (e.getSource() == deleteAccount) {
			User.allusers.remove(currentUser);

			openSettingFrame.dispose();
			frame.dispose();
			LoginPage restart = new LoginPage();

		} // It calls openfollowers() method to show follower list.
		else if (e.getSource() == follower) {
			openfollowers();
		} // It calls openfollowings() method to show following list.
		else if (e.getSource() == following) {
			openFollowings();
		} // It calls openEditAccount() method to edit account.
		else if (e.getSource() == editAccount) {
			openEditAccount();
		} // It takes path of file which is selected
		else if (e.getSource() == imageField) {
			JFileChooser fileChooser = new JFileChooser();

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				newImage = new File(fileChooser.getSelectedFile().getAbsolutePath());
			}

		} // It takes verification for changes, then sets changes.
		else if (e.getSource() == applyBut) {
			currentUser.setName(nameField.getText());
			currentUser.setSurname(surnameField.getText());
			currentUser.setAge(Integer.valueOf(ageField.getText()));
			if (newImage != null) {
				currentUser.setSelectedPhoto(newImage.toPath().toString());
			}
			editAccountFrame.dispose();
			openSettingFrame.dispose();
		} // It shows content with their names, then selected content is edited.
		else if (e.getSource() == editContentBut) {
			ArrayList<Content> contents = new ArrayList<Content>();
			ArrayList<String> contentstitle = new ArrayList<String>();

			for (Content content : currentUser.getAllContent()) {
				contents.add(content);
				contentstitle.add(content.getTitle());
			}

			editFrame = new JFrame();

			editFrame.setLayout(null);

			editFrame.setDefaultCloseOperation(openSettingFrame.DISPOSE_ON_CLOSE);
			editFrame.setSize(300, 300);

			contentList = new JList(contentstitle.toArray());
			contentList.setBounds(10, 10, 100, 100);
			editFrame.add(contentList);

			contentEditBut = new JButton("Edit!");
			contentEditBut.setBounds(150, 100, 100, 25);
			contentEditBut.addActionListener(this);
			editFrame.add(contentEditBut);

			editFrame.setVisible(true);
			editFrame.setResizable(false);
			editFrame.setLocationRelativeTo(null);

		} // It calls openeditPage method to edit content
		else if (e.getSource() == contentEditBut) {
			openeditPage(contentList.getSelectedValue());

		} // It takes all input is entered to fields for edit operation.
		else if (e.getSource() == submit) {
			if (image != null) {
				editedcontent.setSelectedPhoto(image.toPath().toString());
			}
			editedcontent.setTitle(titleField.getText());
			editedcontent.setText(textArea.getText());
			contentEditFrame.dispose();

		} // It removes content from current user and content lists in Content class
		else if (e.getSource() == removeContent) {
			currentUser.getAllContent().remove(editedcontent);
			Content.getAllContentTitles().remove(editedcontent.getTitle());
			Content.getAllContent().remove(editedcontent.getTitle());
		}
	}

	/**
	 * After the content which is wanted to edit is selected this method starts to
	 * execute. It disposes older frame and creates new frame to get information for
	 * edit operation.
	 * 
	 * @param selectedValue is object which have selected field information in
	 *                      JList. Method gets name of the selected value with
	 *                      toString() method
	 */
	private void openeditPage(Object selectedValue) {
		editedcontent = Content.getAllContent().get(selectedValue.toString());
		editFrame.dispose();
		contentEditFrame = new JFrame();

		contentEditFrame.setLayout(null);

		contentEditFrame.setDefaultCloseOperation(contentEditFrame.DISPOSE_ON_CLOSE);
		contentEditFrame.setSize(300, 400);

		JLabel title = new JLabel("Title");
		title.setBounds(10, 10, 50, 25);
		contentEditFrame.add(title);

		titleField = new JTextField(editedcontent.getTitle());
		titleField.setBounds(50, 10, 200, 25);
		contentEditFrame.add(titleField);

		JLabel textContent = new JLabel("Text");
		textContent.setBounds(10, 40, 50, 25);
		contentEditFrame.add(textContent);

		textArea = new JTextArea(editedcontent.getText());
		JScrollPane scrollableTextArea = new JScrollPane(textArea);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textArea.setLineWrap(true);

		scrollableTextArea.setBounds(50, 40, 200, 200);
		contentEditFrame.getContentPane().add(scrollableTextArea);
		contentEditFrame.setLocationRelativeTo(null);
		contentEditFrame.setVisible(true);

		JLabel image = new JLabel("Image");
		image.setBounds(10, 250, 50, 25);
		contentEditFrame.add(image);

		imageField = new JButton("Select File");
		imageField.setBounds(50, 250, 100, 25);
		imageField.addActionListener(this);
		contentEditFrame.add(imageField);

		submit = new JButton("Submit");
		submit.setBounds(185, 310, 100, 25);
		submit.addActionListener(this);
		contentEditFrame.add(submit);

		removeContent = new JButton("Remove");
		removeContent.setBounds(50, 310, 100, 25);
		removeContent.addActionListener(this);
		contentEditFrame.add(removeContent);

		contentEditFrame.invalidate();
		contentEditFrame.repaint();
		contentEditFrame.setVisible(true);

	}

	/**
	 * This method creates frame to edit account. User could change
	 * name,surname,hobbies,photo thanks to this method.
	 */
	private void openEditAccount() {
		editAccountFrame = new JFrame();
		editAccountFrame.setLayout(null);
		editAccountFrame.setDefaultCloseOperation(editAccountFrame.DISPOSE_ON_CLOSE);
		editAccountFrame.setSize(300, 400);

		JLabel namelabel = new JLabel("Name");
		namelabel.setBounds(30, 90, 120, 25);
		editAccountFrame.add(namelabel);

		nameField = new JTextField(currentUser.getName());
		nameField.setBounds(150, 90, 100, 25);
		editAccountFrame.add(nameField);

		JLabel surnamelabel = new JLabel("Surname");
		surnamelabel.setBounds(30, 120, 120, 25);
		editAccountFrame.add(surnamelabel);

		surnameField = new JTextField(currentUser.getSurname());
		surnameField.setBounds(150, 120, 100, 25);
		editAccountFrame.add(surnameField);

		JLabel emaillabel = new JLabel("E-mail");
		emaillabel.setBounds(30, 150, 120, 25);
		editAccountFrame.add(emaillabel);

		emailField = new JTextField(currentUser.getEmailadress());
		emailField.setBounds(150, 150, 100, 25);
		editAccountFrame.add(emailField);

		JLabel agelabel = new JLabel("Age");
		agelabel.setBounds(30, 180, 120, 25);
		editAccountFrame.add(agelabel);

		ageField = new JTextField(String.valueOf(currentUser.getAge()));
		ageField.setBounds(150, 180, 100, 25);
		editAccountFrame.add(ageField);

		JLabel imageLabel = new JLabel("Image");
		imageLabel.setBounds(30, 210, 120, 25);
		editAccountFrame.add(imageLabel);

		imageField = new JButton("Select File");
		imageField.setBounds(150, 210, 100, 25);
		imageField.addActionListener(this);
		editAccountFrame.add(imageField);

		applyBut = new JButton("Apply");
		applyBut.setBounds(150, 250, 90, 25);
		applyBut.addActionListener(this);
		applyBut.setForeground(Color.gray);
		applyBut.addActionListener(this);
		editAccountFrame.add(applyBut);

		editAccountFrame.setVisible(true);
		editAccountFrame.setResizable(false);
		editAccountFrame.setLocationRelativeTo(null);

	}

	/**
	 * The method constructs a new frame which have information of following list.
	 * It creates new frame firstly, then puts JList onto the frame.
	 */
	private void openFollowings() {
		followingListFrame = new JFrame("Following");
		followingListFrame.setLayout(null);

		followingListFrame.setDefaultCloseOperation(followingListFrame.DISPOSE_ON_CLOSE);
		followingListFrame.setSize(300, 200);

		groupList = new JList(currentUser.getFollowingList().keySet().toArray());
		groupList.setBounds(10, 10, 200, 100);
		followingListFrame.add(groupList);

		followingListFrame.setVisible(true);
		followingListFrame.setResizable(false);
		followingListFrame.setLocationRelativeTo(null);
	}

	/**
	 * The method constructs new frame to put the nickname of all followers. It
	 * takes nickname via followerList which is HashMap, the puts into the JList.
	 */
	private void openfollowers() {
		followerListFrame = new JFrame("Followers");
		followerListFrame.setLayout(null);

		followerListFrame.setDefaultCloseOperation(followerListFrame.DISPOSE_ON_CLOSE);
		followerListFrame.setSize(300, 200);

		groupList = new JList(currentUser.followerList.keySet().toArray());
		groupList.setBounds(10, 10, 200, 100);
		followerListFrame.add(groupList);

		followerListFrame.setVisible(true);
		followerListFrame.setResizable(false);
		followerListFrame.setLocationRelativeTo(null);
	}

	/**
	 * The method initialize a frame to put all setting options. It puts button to
	 * check reactions of the user.
	 */
	private void openSettings() {
		openSettingFrame = new JFrame();

		openSettingFrame.setLayout(null);

		openSettingFrame.setDefaultCloseOperation(openSettingFrame.DISPOSE_ON_CLOSE);
		openSettingFrame.setSize(250, 150);

		logOut = new JButton("Log out");
		logOut.setBounds(40, 20, 150, 25);
		logOut.addActionListener(this);
		openSettingFrame.add(logOut);

		deleteAccount = new JButton("Delete account");
		deleteAccount.setBounds(40, 50, 150, 25);
		deleteAccount.addActionListener(this);
		openSettingFrame.add(deleteAccount);

		editAccount = new JButton("Edit account");
		editAccount.setBounds(40, 80, 150, 25);
		editAccount.addActionListener(this);
		openSettingFrame.add(editAccount);

		openSettingFrame.setVisible(true);
		openSettingFrame.setLocationRelativeTo(null);
		openSettingFrame.setResizable(false);
	}

	/**
	 * The method creates new frame which has name of the all attended groups. It
	 * takes names with for loop and then put them into JList. Also method adds
	 * "Go!" button to visit related group.
	 */
	private void openGroupList() {
		groupListFrame = new JFrame("Groups");
		groupListFrame.setLayout(null);

		groupListFrame.setDefaultCloseOperation(groupListFrame.DISPOSE_ON_CLOSE);
		groupListFrame.setSize(300, 200);

		ArrayList<String> list = new ArrayList<>();

		for (Group eachGroup : currentUser.getGrouplist()) {
			list.add(eachGroup.getName());
		}

		groupList = new JList(list.toArray());
		groupList.setBounds(10, 10, 100, 100);
		groupListFrame.add(groupList);

		goGroup = new JButton("Go!");
		goGroup.setBounds(150, 100, 100, 25);
		goGroup.addActionListener(this);
		groupListFrame.add(goGroup);

		groupListFrame.setVisible(true);
		groupListFrame.setResizable(false);
		groupListFrame.setLocationRelativeTo(null);
	}

}
