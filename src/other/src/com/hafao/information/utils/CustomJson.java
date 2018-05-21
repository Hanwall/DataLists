package other.src.com.hafao.information.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CustomJson extends CustomFile {

	public ArrayList<String> jsonTags;
	public Map<String, String> jsonContent;

	public String getJsonContentFromTag(String JsonTag) throws IOException {
		readFileContent(fileFullPath);
		this.jsonTags = new ArrayList<String>();
		this.jsonTags.add(JsonTag);
		JsonParser jsonParser = new JsonParser();
		JsonObject object = jsonParser.parse(fileContent).getAsJsonObject();
		String jsonContentFromTag = object.get(JsonTag).getAsString();
		this.jsonContent = new HashMap<String, String>();
		this.jsonContent.put(JsonTag, jsonContentFromTag);
		return jsonContentFromTag;
	}
}
