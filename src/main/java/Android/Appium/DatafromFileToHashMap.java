package Android.Appium;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;

public class DatafromFileToHashMap {

	
	private AndroidDriver driver;

	public DatafromFileToHashMap(AndroidDriver driver) {
		this.driver = driver;

	}
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		//System.getProperty("user.dir") + "src\\test\\java\\Android\\Appium\\jsondata\\data.json"
	    // convert json file content to json string
	    String jsonContent = FileUtils.readFileToString(new File (jsonFilePath),StandardCharsets.UTF_8);

	    ObjectMapper mapper = new ObjectMapper();
	    List<HashMap<String, String>> data = mapper.readValue(jsonContent,
	        new TypeReference<List<HashMap<String, String>>>() {
	        });

	    return data;
	}
}
