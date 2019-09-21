package copyFiles;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyUsingApache {

	public static void main(String[] args) {
		File sourceFile = new File("F:/Files/originalUsingApache/originalFile.txt");
		File targetFile = new File("F:/Files/copiedUsingApache/copied.txt");
		
		try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
