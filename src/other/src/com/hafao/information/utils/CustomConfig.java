package other.src.com.hafao.information.utils;

import java.io.IOException;
import java.util.Map;

public class CustomConfig extends CustomJson {

	public Map<String, String> configContent;
	public String configDir;
	public String serverHost;
	public String serverProt;
	public String webRootDir;
	public String resourceDir;
	public String athorPassword;

	public CustomConfig(String sfConfigFullPath) throws IOException {
		this.fileFullPath = sfConfigFullPath;
		this.serverHost = getJsonContentFromTag("serverhost");
		this.serverProt = getJsonContentFromTag("serverprot");
		this.webRootDir = getJsonContentFromTag("webrootdir");
		this.resourceDir = getJsonContentFromTag("resourcedir");
		this.athorPassword = getJsonContentFromTag("athorpassword");
		this.configContent = jsonContent;
	}

}
