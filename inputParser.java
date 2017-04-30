import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class inputParser {
	String line = "NULL";
	
	@SuppressWarnings("static-access")
	public void lineParser() throws FileNotFoundException {
		long startTime =System.currentTimeMillis();
		int lineCounter =0;
		
		TimeComplexity tc  = new TimeComplexity();
		SpaceComplexity sc = new SpaceComplexity();
		int timeComplexity = 0;
		int spaceComplexity =0;
		
		Scanner input = new Scanner(new File("input.java")); // input java file
		/*Line by line parsing*/
		while (input.hasNextLine()) {
			line = input.nextLine();
			lineCounter++;
			//tc.processLineInit(line,lineCounter);//calls this method to recognize initial statements and import statements
			//tc.processLineForLoop(line,lineCounter);//calls this method to search for for loop in the input
			//tc.processWhileLoop(line, lineCounter);//calls this method to search for while loop in the input
			//tc.processPrints(line);//calls this method to recognize print statements in input
			tc.processIf(line, lineCounter);
			//sc.processLineInit(line);
		}
		double endTime = System.currentTimeMillis();
		
		System.out.println("===================================================\n Total time complexity of print statments : "+tc.printComplexity+"\n===============================================");

		timeComplexity = tc.initComplexity+tc.forLoopComplexity+tc.whileComplexity+tc.printComplexity+tc.ifComplexity;
		System.out.println("total time complexity is: "+timeComplexity);
		/*Space complexity loop*/
		
		spaceComplexity = sc.initSpaceComplexity;
		System.out.println("Total space complexity is: "+spaceComplexity);
		System.out.println("starting time is :"+startTime+"\t Ending time is :"+endTime);
		System.out.println("Total response time: "+(endTime-startTime));
		
		
		System.out.println();
		System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
	//tc.findKeyWord(line)
    input.close();
}  

} //end main method 

