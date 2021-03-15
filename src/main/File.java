package main;

import java.io.*;

public class File {
	private Stack<String> FileContent = new Stack<String>();

	/*
	 * Default Class Constructor
	 **/
	public File(String Name) throws Exception {
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(Name));
			String line;

			while ((line = fileReader.readLine()) != null) {
				FileContent.push(line);
			}
			fileReader.close();
		} catch (IOException e) {
			throw new Exception(e);
		}
	}
	
	public Stack<String> getFileContent() {
		return FileContent;
	}

}
