package other.src.com.hafao.information.view;

import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DeaktopJTabbedPane extends JPanel {
	private static final long serialVersionUID = -4727418096830902177L;
	private String[] tabNames = { "账户详情", "手机详情", "邮箱详情", "卡号详情", "用户名详情", "产品详情", "公司详情", "类别详情" };

	public DeaktopJTabbedPane() {
		 super(new GridLayout(1, 1));
		JTabbedPane tabbedPane = new JTabbedPane();
		for (int i = 0; i < tabNames.length; i++) {
			JComponent panel = makeJTablePanel(i);
			tabbedPane.addTab(tabNames[i], panel);
			
		}
		add(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	public JComponent makeJTablePanel(int tabNamesIndex) {
		if (tabNamesIndex == 0 ) {
			return (new DesktopJTablePane());
		}else {
			
			JPanel j = new JPanel();
			JLabel jl = new JLabel("HELLO WORLD");
			j.add(jl);
			return j;
		}
		
	}

}
