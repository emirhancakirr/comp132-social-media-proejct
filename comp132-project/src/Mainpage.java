import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Mainpage implements ActionListener {

	private JButton profilebut;
	protected static User user = loginPagegui.user;
	protected static JFrame frame = loginPagegui.frame;
	protected static JPanel toppanel;
	protected static JPanel midPanel;
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

	public Mainpage() {

		try {
			frame.remove(Profile.profilePanel);
		} catch (Exception NullPointerException) {
			frame.remove(loginPagegui.loginPanel);
		}

		toppanel = new JPanel();
		toppanel.setLayout(new BoxLayout(toppanel, BoxLayout.X_AXIS));
		toppanel.setBackground(new Color(193, 11, 37));
		toppanel.setPreferredSize(new Dimension(360, 56));
		frame.getContentPane().add(toppanel, BorderLayout.PAGE_START);

		search = new JButton("🔎Search");
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

		home = new JButton("🏠 \n Home");
		home.setForeground(Color.BLACK);
		home.setBackground(Color.white);
		bottompanel.add(Box.createRigidArea(new Dimension(10, 0)));
		bottompanel.add(home);
		home.addActionListener(this);
		bottompanel.add(Box.createRigidArea(new Dimension(15, 0)));

		create = new JButton("➕ \n Create");
		create.setForeground(Color.BLACK);
		create.setBackground(Color.white);
		bottompanel.add(create);
		create.addActionListener(this);
		bottompanel.add(Box.createRigidArea(new Dimension(15, 0)));

		profilebut = new JButton("👀 \n Profile");
		profilebut.setForeground(Color.BLACK);
		profilebut.setBackground(Color.white);
		profilebut.addActionListener(this);
		bottompanel.add(profilebut);

		midPanel = new JPanel();
		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
		midPanel.setBackground(Color.black);
		frame.getContentPane().add(midPanel, BorderLayout.CENTER);

		frame.invalidate();
		frame.repaint();
		frame.setVisible(true);

	}

	private void openContent() {
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

		String[] shareoptions = new String[(user.getGrouplist().size()) + 1];
		for (int i = 0; i < user.getGrouplist().size(); i++) {
			shareoptions[i] = user.getGrouplist().get(i).getName();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == profilebut) {
			System.out.println("Profile clicked");
			Profile refreshProfile = new Profile();
		} else if (e.getSource() == create) {
			openContent();
		} else if (e.getSource() == imageField) {
			JFileChooser fileChooser = new JFileChooser();

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				image = new File(fileChooser.getSelectedFile().getAbsolutePath());
			}
		} else if (e.getSource() == submit) {
			System.out.println(Content.allContent);
			if (!(Content.allContentTitles.contains(titleField.getText()))) {
				Content newContent;
				if (image == null) {
					newContent = new Content(titleField.getText(), user.getName(), textArea.getText(),
							shareoptionList.getSelectedItem().toString());
					user.addContent(newContent);
				} else {
					newContent = new Content(titleField.getText(), user.getName(), textArea.getText(), image.toPath(),
							shareoptionList.getSelectedItem().toString());
					user.addContent(newContent);

				}
			} else {
				System.out.println("here");
				JLabel repeatedTitle = new JLabel("<htmlThis title was used. Please be creative 😁");
				repeatedTitle.setBounds(0, 300, 200, 25);
				contentCreateFrame.add(repeatedTitle);
				repeatedTitle.setVisible(true);
			}

		} else if (e.getSource() == home) {
			System.out.println("home clicked");
			Mainpage refresh = new Mainpage();
		} else if (e.getSource() == search) {
			System.out.println("search button");
		}
	}

}
