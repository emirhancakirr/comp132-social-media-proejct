import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * GroupPage class has all information and methods could be used in group pages.
 * 
 * @author Emirhan Cakir
 *
 */
public class GroupPage implements ActionListener {
	Group currentGroup;
	private JPanel groupPane;
	private JButton settings;
	private JFrame openSettingFrame;
	private JButton editBut;
	private JButton deleteGroupBut;
	private JButton editGroupBut;
	private JList contentList;
	private JFrame editFrame;
	private JButton contentEditBut;
	private JFrame contentEditFrame;
	private JTextField titleField;
	private JTextArea editedText;
	private JButton imageField;
	private JButton submit;
	private File image;
	private Content selectedContent;
	private JFrame editGroupFrame;
	private JTextField countryField;
	private JTextField hobiesField;
	private JButton groupCreateButton;
	private JList membersList;
	private JList nomembersList;
	private JButton groupEditDoneButton;
	private JButton userRemoveButton;
	private JButton userAddButton;
	private JButton leaveBut;
	private JButton joinBut;
	protected static JScrollPane groupScrollPane;
	protected static JFrame frame = Mainpage.frame;
	protected static User currentUser = LoginPage.user;

	/**
	 * This constructor takes Group object to build group page. It removes potential
	 * panels with build() method, then initialize pane to holds elements of the
	 * group.
	 * 
	 * @param selectedGroup - selectedGroup parameter indicates which group is
	 *                      wanted to open.
	 */
	public GroupPage(Group selectedGroup) {

		currentGroup = selectedGroup;
		build();

		groupScrollPane = new JScrollPane(addGroupElements(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.add(groupScrollPane);

		frame.invalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	/**
	 * ActionPerformed method is coded to manage button reactions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// It opens settings option of group with openSettings()
		if (e.getSource() == settings) {
			openSettings();
		} // It opens a frame which includes content titles to edit.
		else if (e.getSource() == editBut) {
			editContents();
		} // It finds content which wanted to edit via title.
		else if (e.getSource() == contentEditBut) {
			for (Content content : currentGroup.getContents()) {
				if (contentList.getSelectedValue().equals(content.getTitle())) {
					selectedContent = content;
					openeditPage(content);
					break;
				}
			}
		} // It takes the path of the image is wanted to upload.
		else if (e.getSource() == imageField) {
			JFileChooser fileChooser = new JFileChooser();

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				image = new File(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} // It takes all input of text field then set them content to edit.
		else if (e.getSource() == submit) {
			System.out.println(Content.allContent);
			if (!Content.allContentTitles.contains(titleField.getText())
					|| selectedContent.getTitle().equals(titleField.getText())) {
				if (image == null) {
					selectedContent.setTitle(titleField.getText());
					selectedContent.setText(editedText.getText());
				} else {
					selectedContent.setTitle(titleField.getText());
					selectedContent.setText(editedText.getText());
					selectedContent.setImage(image.toPath());
				}
			}
		} // It facilitates group administrator to delete group
		else if (e.getSource() == deleteGroupBut) {
			if (currentUser.equals(currentGroup.getCreator())) {
				openSettingFrame.dispose();
				removeAllMembers();
				Group.allGroups.remove(currentGroup);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "You are not creator :(", "Dialog",
						JOptionPane.ERROR_MESSAGE);
			}

		} // It enables group creator to edit group
		else if (e.getSource() == editGroupBut) {
			if (currentUser.equals(currentGroup.getCreator())) {
				openEditGroupPage();
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "You are not creator :(", "Dialog",
						JOptionPane.ERROR_MESSAGE);
			}
		} // It enables creator to add user
		else if (e.getSource() == userAddButton) {
			User.mapUsers.get(nomembersList.getSelectedValue()).attendGroup(currentGroup);
			openEditGroupPage();
		} // Remove option is provided with this code
		else if (e.getSource() == userRemoveButton) {
			User.mapUsers.get(membersList.getSelectedValue()).leaveGroup(currentGroup);
			openEditGroupPage();
		} // It takes verification to edit
		else if (e.getSource() == groupEditDoneButton) {
			currentGroup.setName(titleField.getText());
			currentGroup.setCountry(countryField.getText());
			currentGroup.setHobies(hobiesField.getText());
			editGroupFrame.dispose();
		} // Users join groups
		else if (e.getSource() == joinBut) {
			currentUser.attendGroup(currentGroup);
		} // Users leave groups with this button
		else if (e.getSource() == leaveBut) {
			if (!currentUser.equals(currentGroup.getCreator())) {
				currentUser.leaveGroup(currentGroup);
			}else {
				JOptionPane.showMessageDialog(new JFrame(), "You are the creator :(", "Dialog",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * It initialize panel to elements. Then add firstly buttons and information of
	 * groups. After that contents which is shared in this group placed onto panel.
	 * JScrollPane uses this method generally.
	 * 
	 * @return groupPane - groupPane holds all buttons,labels,fields will be used
	 *         Panel
	 */
	private JPanel addGroupElements() {
		groupPane = new JPanel();
		groupPane.setBackground(new Color(244, 250, 255));
		groupPane.setLayout(new BoxLayout(groupPane, BoxLayout.PAGE_AXIS));

		settings = new JButton();
		settings.setIcon(new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/settings.png"));
		settings.setBounds(300, 5, 30, 30);
		settings.setBackground(new Color(244, 250, 255));
		settings.setBorderPainted(false);
		settings.addActionListener(this);
		groupPane.add(settings);

		if (currentGroup.getMembers().contains(currentUser)) {
			leaveBut = new JButton("Leave");
			leaveBut.setSize(new Dimension(50, 30));
			leaveBut.addActionListener(this);
			groupPane.add(leaveBut);
		} else {
			joinBut = new JButton("Join");
			joinBut.setSize(new Dimension(50, 30));
			leaveBut.addActionListener(this);
			groupPane.add(joinBut);
		}

		JLabel info = new JLabel(String.format("<html><p>Name:%s</p> <p>Country: %s</p> <p>Hobies:%s</p><html>",
				currentGroup.getName(),
				currentGroup.getCountry(), currentGroup.getHobies()));
		groupPane.add(info);

		if (currentGroup.getMembers().contains(currentUser)) {
			for (Content eachContent : currentGroup.getContents()) {
				JTextArea contentText = new JTextArea(
						String.format("Author: %s \t  %s \nTitle: %s\nText: %s \n Location:%s", eachContent.getAuthor(),
								eachContent.getTimeStamp().toString().substring(0, 19), eachContent.getTitle(),
								eachContent.getText(),eachContent.getLocation()));

				// arrange features of contextText
				contentText.setMargin(new Insets(0, 10, 10, 30));
				contentText.setBackground(new Color(244, 250, 255));
				contentText.setLineWrap(true);
				contentText.setWrapStyleWord(true);

				groupPane.add(contentText);
				if (eachContent.getImage() != "null") {
					JLabel photo = new JLabel();
					photo.setAlignmentX(Component.CENTER_ALIGNMENT);
					photo.setIcon(new ImageIcon(eachContent.getImage()));
					groupPane.add(photo);
				}

				JLabel line = new JLabel();
				line.setIcon(new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/line 360x13.png"));
				line.setAlignmentX(Component.CENTER_ALIGNMENT);
				groupPane.add(line);

			}
		}

		return groupPane;
	}

	/**
	 * The method removes all panel to prepare frame to add new panel.
	 */
	private void build() {
		frame.remove(Profile.profilecontents);

		frame.invalidate();
		frame.repaint();
		frame.setVisible(true);
	}

	public static JScrollPane getGroupScrollPane() {
		return groupScrollPane;
	}


	private void removeAllMembers() {
		for (User user : currentGroup.getMembers()) {
			user.leaveGroup(currentGroup);
		}
	}

	/**
	 * The method creates new frame to edit selected content. Selected content
	 * indicates via content paramaters.
	 * 
	 * @param content - content is a Content which indicates which content is wanted
	 *                to edit.
	 */
	private void openeditPage(Content content) {
		editFrame.dispose();
		contentEditFrame = new JFrame();

		contentEditFrame.setLayout(null);

		contentEditFrame.setDefaultCloseOperation(contentEditFrame.DISPOSE_ON_CLOSE);
		contentEditFrame.setSize(300, 400);

		JLabel title = new JLabel("Title");
		title.setBounds(10, 10, 50, 25);
		contentEditFrame.add(title);

		titleField = new JTextField(content.getTitle());
		titleField.setBounds(50, 10, 200, 25);
		contentEditFrame.add(titleField);

		JLabel textContent = new JLabel("Text");
		textContent.setBounds(10, 40, 50, 25);
		contentEditFrame.add(textContent);

		editedText = new JTextArea(content.getText());
		JScrollPane scrollableTextArea = new JScrollPane(editedText);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		editedText.setLineWrap(true);

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

		contentEditFrame.invalidate();
		contentEditFrame.repaint();
		contentEditFrame.setVisible(true);

	}

	/**
	 * It takes all contents in group.Show by title and give ability to edit
	 * 
	 */
	private void editContents() {

		ArrayList<Content> contentInGroup = new ArrayList<Content>();
		ArrayList<String> contentInGroupTitles = new ArrayList<String>();

		for (Content content : currentGroup.getContents()) {
			if (content.getUserAuthor().equals(currentUser)) {
				contentInGroup.add(content);
				contentInGroupTitles.add(content.getTitle());
			}
		}

		editFrame = new JFrame();

		editFrame.setLayout(null);

		editFrame.setDefaultCloseOperation(openSettingFrame.DISPOSE_ON_CLOSE);
		editFrame.setSize(300, 300);

		contentList = new JList(contentInGroupTitles.toArray());
		contentList.setBounds(10, 10, 100, 100);
		editFrame.add(contentList);

		contentEditBut = new JButton("Edit!");
		contentEditBut.setBounds(150, 100, 100, 25);
		contentEditBut.addActionListener(this);
		editFrame.add(contentEditBut);

		openSettingFrame.dispose();
		editFrame.setVisible(true);
		editFrame.setResizable(false);
		editFrame.setLocationRelativeTo(null);
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

		editBut = new JButton("Edit contents");
		editBut.setBounds(40, 20, 150, 25);
		editBut.addActionListener(this);
		openSettingFrame.add(editBut);

		deleteGroupBut = new JButton("Delete group");
		deleteGroupBut.setBounds(40, 50, 150, 25);
		deleteGroupBut.addActionListener(this);
		openSettingFrame.add(deleteGroupBut);

		editGroupBut = new JButton("Edit Group");
		editGroupBut.setBounds(40, 80, 150, 25);
		editGroupBut.addActionListener(this);
		openSettingFrame.add(editGroupBut);

		openSettingFrame.setVisible(true);
		openSettingFrame.setLocationRelativeTo(null);
		openSettingFrame.setResizable(false);
	}

	/**
	 * It creates new frame to edit group. Before that close frames to make easier
	 * to use program for user.
	 */
	private void openEditGroupPage() {
		try {
			editGroupFrame.dispose();
		} catch (NullPointerException e) {
			openSettingFrame.dispose();
		}
		editGroupFrame = new JFrame();
		editGroupFrame.setLayout(null);
		editGroupFrame.setDefaultCloseOperation(editGroupFrame.DISPOSE_ON_CLOSE);
		editGroupFrame.setSize(300, 400);

		JLabel groupTitle = new JLabel("Name");
		groupTitle.setBounds(10, 10, 50, 25);
		editGroupFrame.add(groupTitle);

		titleField = new JTextField(currentGroup.getName());
		titleField.setBounds(60, 10, 200, 25);
		editGroupFrame.add(titleField);

		JLabel country = new JLabel("Country");
		country.setBounds(10, 40, 50, 25);
		editGroupFrame.add(country);

		countryField = new JTextField(currentGroup.getCountry());
		countryField.setBounds(60, 40, 200, 25);
		editGroupFrame.add(countryField);

		JLabel hobiesContent = new JLabel("Hobies");
		hobiesContent.setBounds(10, 70, 50, 25);
		editGroupFrame.add(hobiesContent);

		hobiesField = new JTextField(currentGroup.getHobies());
		hobiesField.setBounds(60, 70, 200, 25);
		editGroupFrame.add(hobiesField);

		userAddButton = new JButton("Add");
		userAddButton.setBounds(150, 150, 100, 25);
		userAddButton.addActionListener(this);
		editGroupFrame.add(userAddButton);

		userRemoveButton = new JButton("Remove");
		userRemoveButton.setBounds(150, 260, 100, 25);
		userRemoveButton.addActionListener(this);
		editGroupFrame.add(userRemoveButton);

		groupEditDoneButton = new JButton("Done");
		groupEditDoneButton.setBounds(150, 320, 100, 25);
		groupEditDoneButton.addActionListener(this);
		editGroupFrame.add(groupEditDoneButton);

		ArrayList<String> namesOfMembers = new ArrayList<String>();
		for (User member : currentGroup.getMembers()) {
			namesOfMembers.add(member.getNickname());
		}

		ArrayList<String> namesOfNomembers = new ArrayList<String>();

		for (User user : User.allusers) {
			if (!currentGroup.getMembers().contains(user)) {
				namesOfNomembers.add(user.getNickname());
			}
		}
		JLabel members = new JLabel("Members");
		members.setBounds(10, 100, 100, 25);
		editGroupFrame.add(members);

		membersList = new JList(namesOfMembers.toArray());
		JScrollPane memberscroll = new JScrollPane(membersList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		memberscroll.setBounds(10, 130, 100, 100);
		editGroupFrame.add(memberscroll);

		JLabel nonmembers = new JLabel("Potantial Members");
		nonmembers.setBounds(10, 230, 100, 25);
		editGroupFrame.add(nonmembers);

		nomembersList = new JList(namesOfNomembers.toArray());
		JScrollPane nonmemberscroll = new JScrollPane(nomembersList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		nonmemberscroll.setBounds(10, 250, 100, 100);
		editGroupFrame.add(nonmemberscroll);

		editGroupFrame.setVisible(true);
		editGroupFrame.setLocationRelativeTo(null);

	}

}
