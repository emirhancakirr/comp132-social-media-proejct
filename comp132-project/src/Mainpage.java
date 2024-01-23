import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class holds all informations and methods will be used in main page.
 * 
 * @author Emirhan Cakir
 *
 */
public class Mainpage implements ActionListener {

	private JButton profilebut;
	protected static User currentUser = LoginPage.user;
	protected static JFrame frame = LoginPage.frame;
	protected JPanel toppanel;
	protected static JScrollPane midPanel;
	protected JButton create;
	private JButton imageField;
	private JButton submit;
	private File image;
	private JTextField titleField;
	private JTextArea textArea;
	private JComboBox shareoptionList;
	private JButton search;
	private JButton home;
	private JFrame contentCreateFrame;
	private JFrame CreationOptionsFrame;
	private JComboBox creationOptionsBox;
	private JButton submitCreation;
	private JFrame createGroupFrame;
	private JTextField countryField;
	private JTextField hobiesField;
	private JButton createButton;
	private JButton groupCreateButton;

	/**
	 * This constructor remove possible panels on frame then puts panels which will
	 * be used in home page.
	 */
	public Mainpage() {

		try {
			frame.remove(Profile.profilePanel);
			frame.remove(Profile.profilecontents);
			frame.remove(GroupPage.groupScrollPane);
		} catch (Exception NullPointerException) {
			frame.remove(LoginPage.loginPanel);
		}

		toppanel = new JPanel();
		toppanel.setLayout(new BoxLayout(toppanel, BoxLayout.X_AXIS));
		toppanel.setBackground(new Color(193, 11, 37));
		toppanel.setPreferredSize(new Dimension(360, 56));
		frame.getContentPane().add(toppanel, BorderLayout.PAGE_START);

		search = new JButton("Search");
		search.setForeground(Color.BLACK);
		search.setBackground(Color.white);
		search.addActionListener(this);

		toppanel.add(Box.createRigidArea(new Dimension(10, 0)));
		toppanel.add(search);
		toppanel.add(Box.createRigidArea(new Dimension(10, 0)));

		JTextField searchbar = new JTextField();
		searchbar.setBackground(new Color(244, 250, 255));
		searchbar.setSize(new Dimension(200, 5));
		toppanel.add(searchbar);

		JPanel bottompanel = new JPanel();
		bottompanel.setLayout(new BoxLayout(bottompanel, BoxLayout.X_AXIS));
		bottompanel.setBackground(new Color(193, 11, 37));
		bottompanel.setPreferredSize(new Dimension(360, 56));
		frame.getContentPane().add(bottompanel, BorderLayout.PAGE_END);

		home = new JButton("Home");
		home.setForeground(Color.BLACK);
		home.setBackground(Color.white);
		bottompanel.add(Box.createRigidArea(new Dimension(10, 0)));
		bottompanel.add(home);
		home.addActionListener(this);
		bottompanel.add(Box.createRigidArea(new Dimension(15, 0)));

		create = new JButton(" \n Create");
		create.setForeground(Color.BLACK);
		create.setBackground(Color.white);
		bottompanel.add(create);
		create.addActionListener(this);
		bottompanel.add(Box.createRigidArea(new Dimension(15, 0)));

		// creates and sets profile button
		profilebut = new JButton("\n Profile");
		profilebut.setForeground(Color.BLACK);
		profilebut.setBackground(Color.white);
		bottompanel.add(profilebut);
		profilebut.addActionListener(this);

		// creates midPanel
		midPanel = new JScrollPane(putContents(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		midPanel.setPreferredSize(new Dimension(360, 528));
		frame.add(midPanel, BorderLayout.CENTER);

		frame.invalidate();
		frame.repaint();
		frame.setVisible(true);

	}

	/**
	 * This method is activating after create button pressed. It opens new frame
	 * with elements which will be used to collect the information of new content.
	 */
	private void openContent() {
		CreationOptionsFrame.dispose();
		contentCreateFrame = new JFrame();

		contentCreateFrame.setLayout(null);

		contentCreateFrame.setDefaultCloseOperation(contentCreateFrame.DISPOSE_ON_CLOSE);
		contentCreateFrame.setSize(300, 400);

		JLabel title = new JLabel("Title");
		title.setBounds(10, 10, 50, 25);
		contentCreateFrame.add(title);

		titleField = new JTextField();
		titleField.setBounds(50, 10, 200, 25);
		contentCreateFrame.add(titleField);

		JLabel textContent = new JLabel("Text");
		textContent.setBounds(10, 40, 50, 25);
		contentCreateFrame.add(textContent);

		textArea = new JTextArea();
		JScrollPane scrollableTextArea = new JScrollPane(textArea);

		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		textArea.setLineWrap(true);

		scrollableTextArea.setBounds(50, 40, 200, 200);
		contentCreateFrame.getContentPane().add(scrollableTextArea);
		contentCreateFrame.setLocationRelativeTo(null);
		contentCreateFrame.setVisible(true);

		JLabel image = new JLabel("Image");
		image.setBounds(10, 250, 50, 25);
		contentCreateFrame.add(image);

		imageField = new JButton("Select File");
		imageField.setBounds(50, 250, 100, 25);
		imageField.addActionListener(this);
		contentCreateFrame.add(imageField);

		JLabel shareoption = new JLabel("Where do you want to share?");
		shareoption.setBounds(10, 275, 200, 25);
		contentCreateFrame.add(shareoption);

		String[] shareoptions = new String[(currentUser.getGrouplist().size()) + 1];
		for (int i = 0; i < currentUser.getGrouplist().size(); i++) {
			shareoptions[i] = currentUser.getGrouplist().get(i).getName();
		}
		shareoptions[shareoptions.length - 1] = "My Profile";

		System.out.println(shareoptions);
		shareoptionList = new JComboBox(shareoptions);
		shareoptionList.setSelectedIndex(2);
		shareoptionList.setBounds(185, 275, 100, 25);
		shareoptionList.addActionListener(this);
		contentCreateFrame.add(shareoptionList);

		submit = new JButton("Submit");
		submit.setBounds(185, 310, 100, 25);
		submit.addActionListener(this);
		contentCreateFrame.add(submit);

	}

	/**
	 * This method calls when JScrollPane is started to construct. It creates a
	 * panel which includes all contents of attended group or the user which is
	 * followed by current user.
	 * 
	 * @return content- content is JPanel which holds all contents whose we follow
	 *         or attended.
	 */
	public JPanel putContents() {
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

		ArrayList<Content> allcontents = new ArrayList<Content>();
		allcontents.addAll(currentUser.getAllContent());

		for (Group group : currentUser.getGrouplist()) {
			allcontents.addAll(group.getContents());
		}

		for (User user : currentUser.getFollowingList().values()) {
			allcontents.addAll(user.getAllContent());
		}

		// It creates text area for each content and put them to content panel which
		// will be added to scroll pane
		for (Content eachcontent : allcontents) {
			JTextArea contentText = new JTextArea(String.format("Author: %s \t  %s \nTitle: %s\nText: %s \n%s",
					eachcontent.getAuthor(), eachcontent.getTimeStamp().toString().substring(0, 19),
					eachcontent.getTitle(), eachcontent.getText(), eachcontent.getLocation()));

			// arrange features of contextText
			contentText.setMargin(new Insets(0, 10, 10, 30));
			contentText.setBackground(new Color(244, 250, 255));
			contentText.setLineWrap(true);
			contentText.setWrapStyleWord(true);
			contentText.setEditable(false);

			content.add(contentText);
			if (eachcontent.getImage() != "null") {
				JLabel photo = new JLabel();
				photo.setAlignmentX(content.CENTER_ALIGNMENT);
				photo.setIcon(new ImageIcon(eachcontent.getImage()));
				content.add(photo);
			}

			JLabel line = new JLabel();
			line.setIcon(new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/line 360x13.png"));
			line.setAlignmentX(Component.CENTER_ALIGNMENT);
			content.add(line);

		}
		return content;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// It opens profile page
		if (e.getSource() == profilebut) {
			frame.remove(midPanel);
			Profile refreshProfile = new Profile();
		} // It calls openCreationOptions() method
		else if (e.getSource() == create) {
			openCreationOptions();
		} // It takes file which wanted to upload as path
		else if (e.getSource() == imageField) {
			JFileChooser fileChooser = new JFileChooser();

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				image = new File(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} // It creates new content
		else if (e.getSource() == submit) {
			if (!(Content.allContentTitles.contains(titleField.getText()))) {
				Content newContent;
				if (image == null) {
					newContent = new Content(titleField.getText(), currentUser.getNickname(), textArea.getText(),
							shareoptionList.getSelectedItem().toString(), currentUser);
				} else {
					newContent = new Content(titleField.getText(), textArea.getText(), image.toPath(),
							shareoptionList.getSelectedItem().toString(), currentUser);
					currentUser.addContent(newContent);

				}

			} // It shows this title is used
			else {
				JLabel repeatedTitle = new JLabel("This title was used. Please be creative ");
				repeatedTitle.setBounds(0, 300, 200, 25);
				contentCreateFrame.add(repeatedTitle);
				repeatedTitle.setVisible(true);
			}

		} // open home page
		else if (e.getSource() == home) {
			Mainpage refresh = new Mainpage();
		} // It checks creationOptionsBox input
		else if (e.getSource() == submitCreation) {
			if (creationOptionsBox.getSelectedItem().equals("Content")) {
				openContent();
			} else {
				openGroupCreate();
			}

		} // It creates group
		else if (e.getSource() == groupCreateButton) {
			if (currentUser.isPremium == false) {
				JOptionPane.showMessageDialog(new JFrame(), "You are not premium :(", "Dialog",
						JOptionPane.ERROR_MESSAGE);
			} else {
				Group newGroup = new Group(titleField.getText(), countryField.getText(), hobiesField.getText(),
						currentUser);
				currentUser.attendGroup(newGroup);
				createGroupFrame.dispose();
			}

		}
	}

	/**
	 * This method construct a frame which has tools to get information of group
	 * which is wanted to create.
	 */
	private void openGroupCreate() {

		CreationOptionsFrame.dispose();
		createGroupFrame = new JFrame();

		createGroupFrame.setLayout(null);

		createGroupFrame.setDefaultCloseOperation(createGroupFrame.DISPOSE_ON_CLOSE);
		createGroupFrame.setSize(300, 250);

		JLabel groupTitle = new JLabel("Name");
		groupTitle.setBounds(10, 10, 50, 25);
		createGroupFrame.add(groupTitle);

		titleField = new JTextField();
		titleField.setBounds(60, 10, 200, 25);
		createGroupFrame.add(titleField);

		JLabel country = new JLabel("Country");
		country.setBounds(10, 40, 50, 25);
		createGroupFrame.add(country);

		countryField = new JTextField();
		countryField.setBounds(60, 40, 200, 25);
		createGroupFrame.add(countryField);

		JLabel hobiesContent = new JLabel("Hobies");
		hobiesContent.setBounds(10, 70, 50, 25);
		createGroupFrame.add(hobiesContent);

		hobiesField = new JTextField();
		hobiesField.setBounds(60, 70, 200, 25);
		createGroupFrame.add(hobiesField);

		groupCreateButton = new JButton("Create");
		groupCreateButton.setBounds(60, 125, 100, 25);
		groupCreateButton.addActionListener(this);
		createGroupFrame.add(groupCreateButton);

		createGroupFrame.setVisible(true);
		createGroupFrame.setLocationRelativeTo(null);

	}

	/**
	 * This methods construct a new frame which shows options to create. They are
	 * basically contents and groups.
	 */
	private void openCreationOptions() {
		CreationOptionsFrame = new JFrame();
		CreationOptionsFrame.setLayout(null);

		CreationOptionsFrame.setDefaultCloseOperation(CreationOptionsFrame.DISPOSE_ON_CLOSE);
		CreationOptionsFrame.setSize(300, 200);

		JLabel creationOption = new JLabel("What do you want to create?");
		creationOption.setFont(new Font("Tahoma", Font.BOLD, 9));
		creationOption.setBounds(10, 50, 150, 25);
		CreationOptionsFrame.add(creationOption);

		String[] contentOptions = { "Content", "Group" };

		creationOptionsBox = new JComboBox(contentOptions);
		creationOptionsBox.setBounds(175, 50, 100, 25);
		creationOptionsBox.addActionListener(this);
		CreationOptionsFrame.add(creationOptionsBox);

		submitCreation = new JButton("Submit");
		submitCreation.setBounds(175, 100, 100, 25);
		submitCreation.addActionListener(this);
		CreationOptionsFrame.add(submitCreation);

		CreationOptionsFrame.setLocationRelativeTo(null);
		CreationOptionsFrame.setVisible(true);
	}

}
