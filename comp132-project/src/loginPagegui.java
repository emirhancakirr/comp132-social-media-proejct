import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class loginPagegui implements ActionListener {

	protected static JPanel loginPanel;
	protected static JFrame frame;
	private static JLabel nicklabel;
	private static JTextField nickField;
	private static JLabel passwordLabel;
	private static JPasswordField passwordField;
	private static JButton loginBut;
	private static JButton signBut;
	private static JLabel successLabel;
	private static JLabel namelabel;
	private static JTextField surnameField;
	private static JPanel signinPanel;
	private static JTextField nameField;
	private static JLabel surnamelabel;
	private static JLabel emaillabel;
	private static JTextField emailField;
	private static JLabel agelabel;
	private static JTextField ageField;
	private static JButton registerBut;
	private JPanel lastRegisterPanel;
	protected static User user;


	public static void start() {
		System.out.println("her");
		loginPanel = new JPanel();
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

		loginBut = new JButton("Login🔑");
		loginBut.setBounds(189, 319, 90, 25);
		loginBut.setForeground(Color.GRAY);
		loginBut.addActionListener(new loginPagegui());
		loginPanel.add(loginBut);

		signBut = new JButton("Sign in🚀");
		signBut.setBounds(189, 355, 90, 25);
		signBut.addActionListener(new loginPagegui());
		signBut.setForeground(Color.gray);
		loginPanel.add(signBut);

		successLabel = new JLabel("");
		successLabel.setBounds(30, 130, 80, 25);
		loginPanel.add(successLabel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\emirh\\git\\comp132-social-media-proejct\\comp132-project\\img\\248x175 ku logo.png"));
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

	public static void getSigninPage() {
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

		registerBut = new JButton("Register");
		registerBut.setBounds(160, 210, 90, 25);
		registerBut.addActionListener(new loginPagegui());
		registerBut.setForeground(Color.gray);
		signinPanel.add(registerBut);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBut) {
			user = User.findUser(String.valueOf(passwordField.getPassword()), nickField.getText());
			if (!user.equals(null)) {
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
			frame.getContentPane().remove(signinPanel);
			getLastRegisterPage();
			frame.getContentPane().add(lastRegisterPanel);
			frame.invalidate();
			frame.repaint();
			frame.setVisible(true);
		}
	}

	private void getLastRegisterPage() {
		lastRegisterPanel = new JPanel();
		lastRegisterPanel.setLayout(null);

		JLabel announcment = new JLabel("Opss... \n Let's give more information");
		announcment.setBounds(80, 30, 330, 25);
		announcment.setForeground(Color.red);
		lastRegisterPanel.add(announcment);

	}
}
