package it.recruiting.sviluppo.utility;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class EncodeImage {

	public String encode(String toBeEncoded) {
		byte[] fileContent;
		String encoded= null;
		try {
			fileContent = FileUtils.readFileToByteArray(new File(toBeEncoded));
			 encoded = Base64.getEncoder().encodeToString(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return encoded;
	}
}
