import java.io.*;
package main;


public class File{
	   BufferedReader in = null;
	   try {
		   in = new BufferedReader(new FileReader("C:\\Users\\Usuario\\git\\maze-solver\\File\\File.Example.txt"));
		   String str;
		   while((str = in.readLine()) != null) {
			   System.out.println(str);
		   }
			in.close();   
	   }catch(IOException e) {
		   
	   }
}
