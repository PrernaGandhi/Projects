package copyFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyUsingJava7 {

	public static void main(String[] args) {
		Path sourcePath = Paths.get("F:","Files","originalUsingJava7","originalFile.txt");
		Path targetPath = Paths.get("F:","Files","copiedUsingJava7","copiedFile.txt");
		
		try {
			Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
