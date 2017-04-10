import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class inputParser {
	String line = "NULL";
	
	public void lineParser() throws FileNotFoundException, StackUnderflowException {
		int lineCounter =0;
		TimeComplexity tc  = new TimeComplexity();
		SpaceComplexity sc = new SpaceComplexity();
		int timeComplexity = 0;
		Scanner input = new Scanner(new File("example1.java")); // input java file
		/*Line by line parsing*/
		while (input.hasNextLine()) {
			line = input.nextLine();
			lineCounter++;
			TimeComplexity.processLineInit(line,lineCounter);//call the method for each and every line of input
			//System.out.println("Testing at input parser"+tc.initComplexity);
			
			TimeComplexity.processLineForLoop(line,lineCounter);//calls this method to search for for loop in the input
			
			
			
			//sc.processLineInit(line);
        
               
    }
		timeComplexity = tc.initComplexity+tc.forLoopComplexity;
		System.out.println("total time complexity is: "+timeComplexity);
	//tc.findKeyWord(line)
    input.close();
}  

} //end main method 


