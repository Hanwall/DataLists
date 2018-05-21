package other.src.com.hafao.information.utils;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class CustomResponse {
	private static final int BUFFER_SIZE = 1024;

	public OutputStream outputStream;
	private CustomRequest request;
	private String resourceName;
	private String params;

	// 构建响应
	public CustomResponse(CustomRequest request, OutputStream outputStream) {
		this.request = request;
		this.outputStream = outputStream;
		String resource = request.args.get("resourceName");
		PrintHelper.print("resource = " + resource);
		// 刷新Chrome 请求头空 why?
		if (resource.equals("no_path")) {
			this.resourceName = "index.html";
		} else {
			this.resourceName = resource;
		}
	}

	public void response() throws IOException, ClassNotFoundException {
		if (resourceName.indexOf(".") == -1) {
			responseLogic();
		} else {
			responseFile();
		}
	}

	public void responseLogic() throws ClassNotFoundException {
		Class.forName(resourceName);
	}

	public void responseFile() throws IOException {
		String path = System.getProperty("user.dir");// 获取当前的工作目录
		byte[] buffer = new byte[BUFFER_SIZE];
		int ch;
		FileInputStream fis = null;
		if (path != null && resourceName != null) {
			File file = new File(path + "\\webroot", resourceName);
			String str = "";
			if (file.exists()) {
				fis = new FileInputStream(file);
				str = status("200");
				outputStream.write(str.getBytes());
				ch = fis.read(buffer);
				while (ch != -1) {
					outputStream.write(buffer, 0, ch);
					ch = fis.read(buffer, 0, BUFFER_SIZE);
				}
			} else {
				// Chrome 无法显示404 由于chrome 检查content-length 删除就行

				// Chrome 请求头为空？导致resource = null 工具显示Provisional headers are shown
				/*
				 * Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image
				 * /apng,*;q=0.8 Accept-Encoding:gzip, deflate Accept-Language:zh-CN,zh;q=0.9
				 * Cache-Control:max-age=0 Connection:keep-alive Host:192.168.1.101
				 * Upgrade-Insecure-Requests:1 User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64;
				 * x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36
				 */

				/*
				 * Request Headers Provisional headers are shown Upgrade-Insecure-Requests:1
				 * User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36
				 * (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36
				 * X-DevTools-Emulate-Network-Conditions-Client-Id:(
				 * 50BA68DF37436D4148ECEC383C77997A)
				 */
				str = status("404");
				outputStream.write(str.getBytes());
			}
		}
		outputStream.close();
	}

	public String status(String status) {
		String str = null;
		if (status == "404") {
			str = "HTTP/1.1 404 File Not Found \r\n" + "Content-Type: text/html\r\n" + "\r\n"
					+ "<h1>404 File Not Found!</h1>";
		} else if (status == "200") {
			str = "HTTP/1.1 200 OK \r\n" + "Content-Type: text/html\r\n" + "\r\n";
		}
		return str;
	}
}
