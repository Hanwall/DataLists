package other.src.com.hafao.information.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CustomRequest {

	InputStream inputBuffer;// SOCKET 输入
	String inputContent;// 输入解析成的字符
	Map<String, String> args;// 参数列表

	// 构造
	public CustomRequest(InputStream inputBuffer) throws IOException {
		this.inputBuffer = inputBuffer;
		getContent();
		PrintHelper.print(inputContent);
		getArgs();
	}

	// 内部
	private void getContent() throws IOException {
		StringBuffer requestBuffer = new StringBuffer();
		byte[] buffer = new byte[2048];
		int i = 0;
		try {
			i = inputBuffer.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for (int k = 0; k < i; k++) {
			requestBuffer.append((char) buffer[k]);
		}
		this.inputContent = requestBuffer.toString();
	}

	// 解析参数列表
	private void getArgs() {
		if (inputContent != null) {
			args = new HashMap<String, String>();
			int a, b, c, d;
			String method = "";
			a = inputContent.indexOf(' ');
			if (a != -1) {
				method = inputContent.substring(0, a);
				b = inputContent.indexOf('?', a + 1);
				c = inputContent.indexOf(' ', a + 1);
				if (b != -1) {
					// PrintHelper.print("1"+inputContent.substring(a+2,
					// b)+"|"+inputContent.substring(b, c));
					args.put("args", inputContent.substring(b, c));
					args.put("resourceName", inputContent.substring(a + 2, b));
				} else {
					String p = inputContent.substring(a + 2, c);
					// PrintHelper.print(p+"|"+p.equals(""));
					if (p.equals("")) {
						args.put("resourceName", "no_path");
					} else {
						args.put("resourceName", p);
						if (method.equals("GET")) {
							// PrintHelper.print("2"+inputContent.substring(a + 2, c)+"|no_args");
							args.put("args", "no_args");
						} else if (method.equals("POST")) {
							d = inputContent.lastIndexOf('\n');
							// PrintHelper.print("2"+inputContent.substring(a + 2,
							// c)+"|"+inputContent.substring(d+1, inputContent.length()));
							args.put("args", inputContent.substring(d + 1, inputContent.length()));
						} else {
							PrintHelper.print("Unrecognized request method");
						}
					}

				}

			}
		} else {
			PrintHelper.print("why request header is null ");
		}

	}

}