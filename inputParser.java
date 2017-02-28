import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class inputParser {
	String line = "NULL";
	
	public void lineParser() throws FileNotFoundException {	
		TimeComplexity tc  = new TimeComplexity();
		Scanner input = new Scanner(new File("example1.java")); // input java file
		/*Line by line parsing*/
		System.out.println(System.currentTimeMillis());
		while (input.hasNextLine()) {
        line = input.nextLine();
        TimeComplexity.processLineInit(line);//call the method for each and every line of input
               
    }
	System.out.println(System.currentTimeMillis());
	//tc.findKeyWord(line);
    input.close();
}  

} //end main method 


