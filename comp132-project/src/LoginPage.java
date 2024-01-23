import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * LoginPage class holds all information and methods of launch page It enables
 * to login or sign in.
 * 
 * @author Emirhan Cakir
 *
 */
public class LoginPage implements ActionListener {

	protected static JPanel loginPanel;
	private JPanel signinPanel;
	private JPanel lastRegisterPanel;
	protected static JFrame frame;
	private JLabel nicklabel;
	private JTextField nickField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JButton loginBut;
	private JButton signBut;
	private JLabel successLabel;
	private JLabel namelabel;
	private JTextField surnameField;
	private JTextField nameField;
	private JLabel surnamelabel;
	private JLabel emaillabel;
	private JTextField emailField;
	private JLabel agelabel;
	private JTextField ageField;
	private JButton registerBut;
	protected static User user;
	private JLabel hobieslabel;
	private JTextField hobiesField;
	private JComboBox<String> premiumOrBasic;
	private JLabel accountType;
	private JButton selectPhotoBut;
	private File ppImage;

	/**
	 * LoginPage constructor prepare program to add elements. Basically it prepare
	 * to use methods and then calls start() function
	 */
	public LoginPage() {
		frame = new JFrame();
		loginPanel = new JPanel();
		frame.setSize(360, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(loginPanel);
		frame.setResizable(false);
		start();
	}

	/**
	 * Start method launch page to log in or sign in.
	 */
	public void start() {
		frame = new JFrame();
		frame.setSize(360, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(loginPanel);
		frame.setResizable(false);

		loginPanel.setLayout(null);
		loginPanel.setBackground(new Color(193, 11, 37));

		nicklabel = new JLabel("Nickname");
		nicklabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		nicklabel.setHorizontalAlignment(SwingConstants.LEFT);
		nicklabel.setBounds(59, 253, 120, 25);
		loginPanel.add(nicklabel);

		nickField = new JTextField();
		nickField.setBounds(179, 253, 100, 25);
		loginPanel.add(nickField);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		passwordLabel.setBounds(59, 283, 120, 25);
		loginPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(179, 283, 100, 25);
		loginPanel.add(passwordField);

		loginBut = new JButton("Login");
		loginBut.setBounds(189, 319, 90, 25);
		loginBut.setForeground(Color.GRAY);
		loginBut.addActionListener(this);
		loginPanel.add(loginBut);

		signBut = new JButton("Sign in");
		signBut.setBounds(189, 355, 90, 25);
		signBut.addActionListener(this);
		signBut.setForeground(Color.gray);
		loginPanel.add(signBut);

		successLabel = new JLabel("");
		successLabel.setBounds(50, 400, 80, 25);
		loginPanel.add(successLabel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(System.getProperty("user.dir") + "/comp132-project/img/" + "248x175 ku logo.png"));
		lblNewLabel.setBounds(52, 32, 248, 175);
		loginPanel.add(lblNewLabel);

		JLabel welcomemessage = new JLabel("<html>Welcome to the <br/> KUSocial!</html>");
		welcomemessage.setForeground(Color.WHITE);
		welcomemessage.setHorizontalAlignment(SwingConstants.CENTER);
		welcomemessage.setFont(new Font("Tahoma", Font.BOLD, 24));
		welcomemessage.setBounds(10, 420, 317, 109);
		loginPanel.add(welcomemessage);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * getSigninPage()- method prepare the frame for sign in operations.
	 */
	public void getSigninPage() {
		signinPanel = new JPanel();
		signinPanel.setLayout(null);

		nicklabel = new JLabel("Nickname");
		nicklabel.setBounds(30, 60, 120, 25);
		signinPanel.add(nicklabel);

		nickField = new JTextField();
		nickField.setBounds(150, 60, 100, 25);
		signinPanel.add(nickField);

		namelabel = new JLabel("Name");
		namelabel.setBounds(30, 90, 120, 25);
		signinPanel.add(namelabel);

		nameField = new JTextField();
		nameField.setBounds(150, 90, 100, 25);
		signinPanel.add(nameField);

		surnamelabel = new JLabel("Surname");
		surnamelabel.setBounds(30, 120, 120, 25);
		signinPanel.add(surnamelabel);

		surnameField = new JTextField();
		surnameField.setBounds(150, 120, 100, 25);
		signinPanel.add(surnameField);

		emaillabel = new JLabel("E-mail");
		emaillabel.setBounds(30, 150, 120, 25);
		signinPanel.add(emaillabel);

		emailField = new JTextField();
		emailField.setBounds(150, 150, 100, 25);
		signinPanel.add(emailField);

		agelabel = new JLabel("Age");
		agelabel.setBounds(30, 180, 120, 25);
		signinPanel.add(agelabel);

		ageField = new JTextField();
		ageField.setBounds(150, 180, 100, 25);
		signinPanel.add(ageField);

		hobieslabel = new JLabel("Hobies");
		hobieslabel.setBounds(30, 210, 120, 25);
		signinPanel.add(hobieslabel);

		hobiesField = new JTextField();
		hobiesField.setBounds(150, 210, 100, 25);
		signinPanel.add(hobiesField);

		accountType = new JLabel("Account Type:");
		accountType.setBounds(30, 240, 120, 25);
		signinPanel.add(accountType);

		String[] accountType = { "Basic", "Premium" };
		premiumOrBasic = new JComboBox<String>(accountType);
		premiumOrBasic.setBounds(150, 240, 120, 25);
		signinPanel.add(premiumOrBasic);

		JLabel selectPhotoLabel = new JLabel("Select Photo:");
		selectPhotoLabel.setBounds(30, 270, 120, 25);
		signinPanel.add(selectPhotoLabel);

		selectPhotoBut = new JButton("Select");
		selectPhotoBut.setBounds(150, 270, 120, 25);
		selectPhotoBut.addActionListener(this);
		signinPanel.add(selectPhotoBut);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(30, 300, 120, 25);
		signinPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(150, 300, 120, 25);
		signinPanel.add(passwordField);

		registerBut = new JButton("Register");
		registerBut.setBounds(160, 330, 90, 25);
		registerBut.addActionListener(this);
		registerBut.setForeground(Color.gray);
		signinPanel.add(registerBut);
	}

	/**
	 * This method takes ActionEvent method and checks action. Different actions
	 * leads to different executions.
	 * 
	 * @param e e is ActionEvent object which enables to check source of action in
	 *          this method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBut) {
			user = User.findUser(String.valueOf(passwordField.getPassword()), nickField.getText());
			if (user != null) {
				successLabel.setText("Succesfull");
				Mainpage mainframe = new Mainpage();

			} else {
				successLabel.setText("Try again!");
			}
		} else if (e.getSource() == signBut) {

			frame.getContentPane().remove(loginPanel);
			getSigninPage();
			frame.getContentPane().add(signinPanel);
			frame.invalidate();
			frame.repaint();
			frame.setVisible(true);

		} else if (e.getSource() == registerBut) {
			if (ppImage != null) {
				User signUser = new User(nickField.getText(), String.valueOf(passwordField.getPassword()),
						nameField.getText(), surnameField.getText(), emailField.getText(), ppImage.toPath(),
						hobiesField.getText(), false, Integer.parseInt(ageField.getText()));
			} else {
				User signUser = new User(nickField.getText(), String.valueOf(passwordField.getPassword()),
						nameField.getText(), surnameField.getText(), emailField.getText(), "100x100 user1.png",
						hobiesField.getText(), false, Integer.parseInt(ageField.getText()));
			}

			frame.getContentPane().remove(signinPanel);
			frame.add(loginPanel);
			frame.invalidate();
			frame.repaint();
			frame.setVisible(true);

		} else if (e.getSource() == selectPhotoBut) {
			JFileChooser fileChooser = new JFileChooser();

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				ppImage = new File(fileChooser.getSelectedFile().getAbsolutePath());
			}
		}
	}
}
