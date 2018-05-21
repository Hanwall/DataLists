package other.src.com.hafao.information.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import other.src.com.hafao.information.utils.PrintHelper;

public class DesktopLoginPage {
	public DesktopLoginPage() {
		initialize();
	}

	private void initialize() {
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高

		JFrame jframe = new JFrame();
		jframe.setVisible(true);
		jframe.setTitle("INFORMATION");
		jframe.setBounds(100, 100, 300, 200);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.getContentPane().setLayout(null);
		int windowWidth = jframe.getWidth(); // 获得窗口宽
		int windowHeight = jframe.getHeight(); // 获得窗口高
		jframe.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
		JLabel lblNewLabel = new JLabel("密码:");
		lblNewLabel.setBounds(63, 38, 40, 40);
		jframe.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("登录");
		JPasswordField passwordField = new JPasswordField();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwd = passwordField.getText();
				PrintHelper.print(passwd);
				// 加密
				if (passwd.equals("haihua")) {
					jframe.setVisible(false);
					try {
						new DesktopListsPage();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "密码错误", "错误信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(86, 89, 117, 23);
		jframe.getContentPane().add(btnNewButton);

		passwordField.setBounds(116, 48, 99, 20);
		jframe.getContentPane().add(passwordField);
	}
}
