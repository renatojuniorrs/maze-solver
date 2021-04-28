package main;

import java.io.*;

 /**
  * Declares and reads a string stack, checking if it is empty, if not add a line in the maze, through a Class Constructor.
  * 
  * @return FileContent   Return FileContent after reading the file          
  */

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
