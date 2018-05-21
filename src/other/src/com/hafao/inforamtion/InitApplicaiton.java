package other.src.com.hafao.inforamtion;

import java.awt.EventQueue;
import java.io.IOException;
import other.src.com.hafao.information.view.DesktopListsPage;

public class InitApplicaiton {
	public static final String DEBUGSTATUS = "YES";

	public static void main(String[] args) throws IOException {

		// 初始化基本环境

		// 启动桌面
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new DesktopListsPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// 启动web服务
		/*
		 * SelfServer sf = new SelfServer(); sf.start();
		 */
	}

}