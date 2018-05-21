package other.src.com.hafao.information.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomServer {
	public String sfRootPath;

	public CustomConfig sfConfig;
	public CustomRequest sfrequest;
	public CustomResponse sfresponse;

	public CustomServer() throws IOException {
		String rootPath = System.getProperty("user.dir");
		this.sfRootPath = rootPath;
		String configName = "server.conf";
		String sfConfigFullPath = rootPath + "\\src\\" + configName;
		CustomConfig config = new CustomConfig(sfConfigFullPath);
		this.sfConfig = config;
	}

	public void start() {
		ServerSocket server = null;
		Socket s = null;
		startsystem();
		try {
			server = new ServerSocket((int) Integer.parseInt(sfConfig.serverProt), 3,
					InetAddress.getByName(sfConfig.serverHost));

		} catch (Exception e) {
			e.printStackTrace();
			exitsystem();
		}
		while (true) {
			try {
				s = server.accept();
				InputStream inputStream = s.getInputStream();
				OutputStream outputStream = s.getOutputStream();
				CustomRequest request = new CustomRequest(inputStream);
				this.sfrequest = request;
				CustomResponse response = new CustomResponse(request, outputStream);
				this.sfresponse = response;
				response.response();
			} catch (Exception e) {
				e.printStackTrace();
				exitsystem();
			}
		}
	}

	public static void exitsystem() {
		PrintHelper.print("==========service stop by error========");
		System.exit(0);
	}

	public static void startsystem() {
		PrintHelper.print("=============service start=============");
	}
}
