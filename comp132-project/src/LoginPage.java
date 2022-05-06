import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField nicknameText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 406);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nickname = new JLabel("nickname");
		nickname.setForeground(Color.BLACK);
		nickname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nickname.setBounds(231, 140, 79, 25);
		contentPane.add(nickname);

		nicknameText = new JTextField();
		nicknameText.setBounds(329, 144, 95, 20);
		contentPane.add(nicknameText);
		nicknameText.setColumns(10);

		JLabel password = new JLabel("password");
		password.setBackground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(231, 196, 79, 25);
		contentPane.add(password);

		JButton login = new JButton("Login\uD83D\uDD11");
		login.setBorder(new Border(15));
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.setBounds(336, 247, 95, 23);
		contentPane.add(login);

		JButton btnSignUp = new JButton("Sign Up \uD83D\uDE80");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignUp.setBounds(336, 293, 95, 23);
		contentPane.add(btnSignUp);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\emirh\\eclipse-workspace\\comp132-project\\img\\kisspng-ko-university-logo-ko-niversitesi-research-summer-program-ko-university-international-su-5ba4334cbdf0b9.024332931537487692778.png"));
		lblNewLabel.setBounds(116, 8, 222, 97);
		contentPane.add(lblNewLabel);

		JLabel lblWelcomeToKusocial = new JLabel("<html>Welcome to the KUSocial!<br/>Let's log in👉</html>");
		lblWelcomeToKusocial.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeToKusocial.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblWelcomeToKusocial.setForeground(new Color(178, 34, 34));
		lblWelcomeToKusocial.setBounds(20, 113, 209, 205);
		contentPane.add(lblWelcomeToKusocial);

		passwordField = new JPasswordField();
		passwordField.setBounds(329, 200, 95, 25);
		contentPane.add(passwordField);
	}
}
