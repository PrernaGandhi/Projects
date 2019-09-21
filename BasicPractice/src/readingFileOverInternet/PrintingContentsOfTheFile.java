package readingFileOverInternet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PrintingContentsOfTheFile {

	public static void main(String[] args) {
		String s = "https://whatis.techtarget.com/definition/XML-Extensible-Markup-Language";
		
		InputStream inputStream = null;
		BufferedInputStream buf = null;
		try {
			URL url = new URL(s);
			inputStream = url.openStream();
			buf = new BufferedInputStream(inputStream);
			
			StringBuilder sb = new StringBuilder();
			while(true){
				int data = buf.read();
				
				if(data == -1){
					break;
				} else{
					sb.append((char)data);
				}
			}
			System.out.println(sb);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
