package other.src.com.hafao.information.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CustomFile {

	public String fileName;
	public String filePath;
	public String fileFullPath;
	public String fileContent;

	public void readFileContent(String fileFullPath) throws IOException {
		this.fileContent = "";
		Stream<String> stream = Files.lines(Paths.get(fileFullPath));
		stream.forEach(content -> fileContent += content);
		stream.close();
	}
}
