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
		int spaceComplexity =0;
		Scanner input = new Scanner(new File("example1.java")); // input java file
		/*Line by line parsing*/
		while (input.hasNextLine()) {
			line = input.nextLine();
			lineCounter++;
			tc.processLineInit(line,lineCounter);//call the method for each and every line of input
			tc.processLineForLoop(line,lineCounter);//calls this method to search for for loop in the input
			tc.processWhileLoop(line, lineCounter);
			tc.processPrints(line);
			sc.processLineInit(line);
		}
		System.out.println("===================================================\n Total time complexity of print statments : "+tc.printComplexity+"\n===============================================");

		timeComplexity = tc.initComplexity+tc.forLoopComplexity+tc.whileComplexity+tc.printComplexity;
		System.out.println("total time complexity is: "+timeComplexity);
		/*Space complexity loop*/
		
		spaceComplexity = sc.initSpaceComplexity;
		System.out.println("Total space complexity is: "+spaceComplexity);
	//tc.findKeyWord(line)
    input.close();
}  

} //end main method 


