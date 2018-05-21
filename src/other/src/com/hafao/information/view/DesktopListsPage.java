package other.src.com.hafao.information.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;


public class DesktopListsPage {

	public DesktopListsPage() {
		initialize();
	}

	private void initialize() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("账号信息列表");
		jFrame.setBounds(100, 100, 700, 700);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//添加选项卡
		jFrame.add(new DeaktopJTabbedPane());
		
		jFrame.setVisible(true);
	}
		
}
