import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class inputParser {
	String line = "NULL";
	
	public void lineParser() throws FileNotFoundException, StackUnderflowException {
		int lineCounter =0;
		TimeComplexity tc  = new TimeComplexity();
		SpaceComplexity sc = new SpaceComplexity();
		Scanner input = new Scanner(new File("example1.java")); // input java file
		/*Line by line parsing*/
		while (input.hasNextLine()) {
			line = input.nextLine();
			lineCounter++;
			TimeComplexity.processLineInit(line,lineCounter);//call the method for each and every line of input
			TimeComplexity.processLineForLoop(line,lineCounter);//calls this method to search for for loop in the input
			sc.processLineInit(line);
        
               
    }
	
	//tc.findKeyWord(line);
    input.close();
}  

} //end main method 


