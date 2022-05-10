import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile {

	protected static User user = loginPagegui.user;
	protected static JFrame frame = Mainpage.frame;
	protected static JPanel profilePanel;


	/**
	 * @wbp.parser.entryPoint
	 */
	public Profile() {


		frame.remove(Mainpage.midPanel);

		profilePanel = new JPanel();
		frame.getContentPane().add(profilePanel);
		profilePanel.setBackground(new Color(244, 250, 255));
		profilePanel.setLayout(null);

		JLabel photo = new JLabel();
		photo.setBounds(5, 5, 100, 100);
		photo.setIcon(new ImageIcon(
				"C:\\\\Users\\\\emirh\\\\git\\\\comp132-social-media-proejct\\\\comp132-project\\\\img\\\\100x100 user1.png"));
		profilePanel.add(photo);

		System.out.println(user.nickname);

		JLabel info = new JLabel(String.format(
				"<html><p>%s</p> <p>%s %s</p> <p>%d</p> %s</p> <p>%s</p>\r\n <p>%s</p> </html>", user.nickname,
				user.name, user.surname, user.age, user.hobbies, (user.isPremium == true) ? "Premium⭐" : "Standart🤗",
				user.emailadress));
		info.setBounds(10, 110, 100, 100);
		profilePanel.add(info);

		JLabel follower = new JLabel(String.format("Follower %d", user.followers));
		follower.setBounds(120, 11, 110, 40);
		follower.setFont(new Font("Tahoma", Font.BOLD, 20));
		follower.setForeground(new Color(193, 11, 37));
		profilePanel.add(follower);

		JLabel following = new JLabel(String.format("Following %d", user.followers));
		following.setFont(new Font("Tahoma", Font.BOLD, 20));
		following.setForeground(new Color(193, 11, 37));
		following.setBounds(120, 50, 120, 40);
		profilePanel.add(following);

		JButton suggest = new JButton("Suggest me");
		suggest.setForeground(Color.white);
		suggest.setFont(new Font("Tahoma", Font.BOLD, 10));
		suggest.setBounds(120, 100, 110, 20);
		suggest.setBackground(new Color(193, 11, 37));
		profilePanel.add(suggest);

		JButton createGroup = new JButton("🖊Create Group");
		createGroup.setForeground(Color.white);
		createGroup.setFont(new Font("Tahoma", Font.BOLD, 10));
		createGroup.setBounds(120, 130, 110, 20);
		createGroup.setBackground(new Color(193, 11, 37));
		profilePanel.add(createGroup);

		JButton settings = new JButton();
		settings.setIcon(new ImageIcon(
				"C:\\Users\\emirh\\git\\comp132-social-media-proejct\\comp132-project\\img\\settings.png"));
		settings.setBounds(300, 5, 30, 30);
		settings.setBackground(new Color(244, 250, 255));
		settings.setBorderPainted(false);
		profilePanel.add(settings);

		frame.invalidate();
		frame.repaint();
		frame.setVisible(true);
	}
}
