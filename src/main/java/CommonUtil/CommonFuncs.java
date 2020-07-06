package CommonUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonFuncs {
	public static Properties prop;
	public static Properties readPropData(String prop_file_path) throws IOException {
		String propFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\"+prop_file_path;
		FileInputStream fis = new FileInputStream(propFilePath);
		prop = new Properties();
		prop.load(fis);
		return prop;
	}
	
	public static String readXmlData(String xmlFilePath) throws IOException {
		Path path = Paths.get(xmlFilePath);
		byte[] byteData = Files.readAllBytes(path);
		String xmlPldStr = new String(byteData);
		return xmlPldStr;
	}
	
	public static String getRandomStr(int chCount) {
		
		return RandomStringUtils.randomAlphabetic(chCount);
	}
	
	
}
