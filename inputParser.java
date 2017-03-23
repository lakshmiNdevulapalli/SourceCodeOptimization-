import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class inputParser {
	String line = "NULL";
	
	public void lineParser() throws FileNotFoundException, StackUnderflowException {	
		TimeComplexity tc  = new TimeComplexity();
		Scanner input = new Scanner(new File("example1.java")); // input java file
		/*Line by line parsing*/
		while (input.hasNextLine()) {
        line = input.nextLine();
        TimeComplexity.processLineInit(line);//call the method for each and every line of input
        TimeComplexity.processLineForLoop(line);//calls this method to search for for loop in the input
        
               
    }
	
	//tc.findKeyWord(line);
    input.close();
}  

} //end main method 


