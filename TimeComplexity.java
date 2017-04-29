import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TimeComplexity extends inputParser {
	static int forLoopComplexity;
	static int initComplexity;
	static int whileComplexity;
	static int printComplexity;
	static int ifComplexity;
	static int nValue=0;
	static int numLines =0;
	
	/*module to calculate time complexity of initial statemets*/
	public static double processLineInit(String wordParse, int currentline){
		
		long startTime =System.currentTimeMillis();
		
		/*Regex to recognize all variable initializations and import statements and math expressions and arrays.*/
		
		Pattern p = Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\\".*?\\\"\\s*;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+\\s*;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+.\\d+\\s*;|\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[tT]rue\\s*;|"
	 		+ "\\s*([^\\s]*boolean "
	 		+ " )\\s*[a-zA-Z]*\\s*=\\s*[fF]alse\\s*;|"
	 		+ "\\s*import\\s*.*?\\s*;|"
	 		+ "\\s*([^\\s]*double)\\s*[a-zA-Z]*\\s*=\\s*[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*.*?\\s*;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*\\[.*?\\]\\s*=\\s*\\{.*?\\}\\s*;|\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*\\[\\]\\s*=\\s*\\{.*?\\}\\s*;");
 	
		Matcher m = p.matcher(wordParse);
		if(m.matches()){
    	 initComplexity++;	//increasing time complexity as the tc for initialization statements is O(1).
     	 //System.out.println(complexity);
    	 System.out.println(wordParse); //printing matched statements with the regex 
    	 
		}
		
        //System.out.println(initComplexity); //printing the current complexity
     	return initComplexity;
     	
     	
	}
	/*Calculating time complexity for For loop*/
	
	
 	/*Module to calculate time complexity of fro loop*/
	public static double processLineForLoop(String wordParse, int currentline) throws FileNotFoundException, StackUnderflowException{
		long startTime =System.currentTimeMillis();
 		
 		Pattern p = Pattern.compile("\\s*for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)"); //regular expression to recognize for loop with no spaces in syntax
		Matcher m = p.matcher(wordParse);
		inputParser ip = new inputParser();
		if(m.matches()){
			 System.out.println("For identified");
			 /*call a method to calculate number of lines within for loop*/
		 		countLinesInLoop(currentline);
		 		System.out.println();
		 		System.out.println("======================================== \n number of lines in for loop: "+ numLines+"\n========================================   \n");
		 		
			 System.out.println(wordParse);	
			 int conditionalIndex1=0;
			 conditionalIndex1 = wordParse.indexOf('<');	//to get the position of '<'
			 if(conditionalIndex1 > 0){					//to make sure the value of conditionalIndex1 is not negative
				 extractN(conditionalIndex1,wordParse);
				 System.out.println("for loop's sentinel value: "+nValue); //making sure nValue hasn't changed
				 forLoopComplexity = nValue*numLines;
					System.out.println("=========================================== \n Time complexity of For loop is : " +forLoopComplexity+"\n==========================================");
			 }
			 else if(conditionalIndex1 < 0){ 
				 conditionalIndex1 = wordParse.indexOf('>');//to get the position of '>'
				 
				 if(conditionalIndex1 > 0)
					 extractN(conditionalIndex1,wordParse); //calling exctractN value method
				 	 System.out.println("for loop's sentinel value: "+nValue); //Making sure nValue hasn't changed 
				 	forLoopComplexity = nValue*numLines;
					System.out.println("=========================================== \n Time complexity of For loop is : " +forLoopComplexity+"\n==========================================");
			 }
			 else
				 System.out.println("Couldn't find the special character"); 
			
	    	}
		
		
		
		return forLoopComplexity;
		}
 		/*Method to count number of lines within the loop*/
	/*Module to count number of lines in loops*/
	public static int countLinesInLoop(int currentline) throws FileNotFoundException {
 			//int numLines=0;	//initial number of lines in for loop
 			String line = "NULL";
 			int tempCounter =0; //temp counter to count till we reach current position 
 			@SuppressWarnings("resource")
			Scanner input = new Scanner(new File("example1.java")); //input file
 			Pattern p =  Pattern.compile("\\s*[}]"); //pattern to recognize close brace }
 			outerloop:	//label for outer loop 
 			while (input.hasNextLine()){ 
 				line= input.nextLine();
 				tempCounter++; //counts number of lines 
 				if(tempCounter >= currentline){ //if the current line reaches for loop
 					boolean flag = true; //true the flag
 					while(flag){
 						Matcher m = p.matcher(line); //if the line is }
 						if(m.matches()){ //if matches to the pattern
 							flag = false;	//flag turns to false
 							numLines = numLines-2; //avoid open and close braces.
 							//System.out.println("number of lines in for loop is : "+ numLines);
 							break outerloop; //to come out of all loops
 						}
 						else{
 							numLines++; //if it doesn't match with } it goes for the next line
 							break;
 						}
 			}
 			
		// TODO Auto-generated method stub
		
		}
	}
 			return numLines;
 }
		/*Method to extract n value out of for loop and return nValue*/
 	
 	/*Module to extract n value in for loop*/	
		public static int extractN(int conditionalIndex1,String wordParse){
 			int secondSemiColonFinder = wordParse.indexOf(';',conditionalIndex1+1); // to identify the position of second semicolon in for loop
			int index = conditionalIndex1+1;
			 
			 String concatination = "";
			 
			 while(index < secondSemiColonFinder){ //loops till it reach the second semicolon 
				 
				 concatination = concatination+wordParse.charAt(index); //concatinate the characters and makes the final word
				 index++;
				 //System.out.print(concatination); 
			 }
			 //System.out.println("Here is the value of n: "+concatination);
			 char equalSymbolChecker = concatination.charAt(0);
			 //System.out.println(equalSymbolChecker);
			 if(equalSymbolChecker == '='){		//checking for <= and >=
				 String trimmedString = concatination.substring(1); //to remove = in the extracted string
				 //System.out.println(trimmedString);
				 nValue = Integer.parseInt(trimmedString); //to convert extracted string to integer
				 // System.out.println(nValue+20); //cross checking nValue				 
			 }
			 else{
				 nValue = Integer.parseInt(concatination);
				 //System.out.println(nValue+20); //cross check nValue
				 
			 }
			return nValue;
			
 		}
 		/*method to calculate time complexity for WHILE loop*/
 		public static double processWhileLoop(String wordParse, int currentline) throws FileNotFoundException{
 			Pattern p = Pattern.compile("\\s*while\\(.*?\\)"); //regular expression to recognize while loop with no spaces in syntax
 			Matcher m = p.matcher(wordParse);
 			inputParser ip = new inputParser();
 			if(m.matches()){
 				 System.out.println("While identified");
 				 numLines =0;
 				 /*call a method to calculate number of lines within for loop*/
 		 		countLinesInLoop(currentline);
 		 		System.out.println();
 		 		System.out.println("======================================== \n number of lines in while loop: "+ numLines+"\n========================================   \n");
 		 		System.out.println(wordParse);	
 				 int conditionalIndex1=0;
 				 conditionalIndex1 = wordParse.indexOf('>');	//to get the position of '>'
 				 
 				 if(conditionalIndex1 > 0){					//to make sure the value of conditionalIndex1 is not negative
 					extractNWhile(conditionalIndex1,wordParse);
 					 System.out.println("while loop's sentinel value: "+nValue); //making sure nValue hasn't changed
 					 whileComplexity = nValue*numLines;
 						System.out.println("=========================================== \n Time complexity of while loop is : " +whileComplexity+"\n==========================================");
 				 }
 				 else if(conditionalIndex1 < 0){ 
 					 conditionalIndex1 = wordParse.indexOf('<');//to get the position of '>'
 					 
 					 if(conditionalIndex1 > 0)
 						extractNWhile(conditionalIndex1,wordParse); //calling exctractN value method
 					 	 System.out.println("while loop's sentinel value: "+nValue); //Making sure nValue hasn't changed 
 					 	whileComplexity = nValue*numLines;
 						System.out.println("=========================================== \n Time complexity of while loop is : " +whileComplexity+"\n==========================================");
 				 }
 				 else
 					 System.out.println("Couldn't find the special character"); 
 		    	}
 			
 			
 			return whileComplexity;
 		}
 		/*Method to extract nValue in while loop*/
 		/*Module to extract n value in while loop*/
 			public static int extractNWhile(int conditionalIndex1,String wordParse){
 			int conditioner = wordParse.indexOf(')'); // to identify the position of ) in while loop
			int index = conditionalIndex1+1;
			 
			 String concatination = "";
			 
			 while(index < conditioner){ //loops till it reach the closing paranthesis  
				 
				 concatination = concatination+wordParse.charAt(index); //concatinate the characters and makes the final word
				 index++;
				 //System.out.print(concatination); 
			 }
			 //System.out.println("Here is the value of n: "+concatination);
			 char equalSymbolChecker = concatination.charAt(0);
			 //System.out.println(equalSymbolChecker);
			 if(equalSymbolChecker == '='){		//checking for <= and >=
				 String trimmedString = concatination.substring(1); //to remove = in the extracted string
				 //System.out.println(trimmedString);
				 nValue = Integer.parseInt(trimmedString); //to convert extracted string to integer
				 // System.out.println(nValue+20); //cross checking nValue				 
			 }
			 else{
				 nValue = Integer.parseInt(concatination);
				 //System.out.println(nValue+20); //cross check nValue
				 
			 }
			return nValue;
			
 		}
 		/*Module to calculate time complexity of print statements*/
 	/*Module to calculate time complexity of print statements*/
 	public static int processPrints(String wordParse){
 			Pattern p = Pattern.compile("\\s*System.out.println\\(([^;].*\\)*);|\\s*System.out.print\\(([^;].*\\)*);"); //to identify print statements 
 			Matcher m = p.matcher(wordParse);
 			if(m.matches()){
 				printComplexity++;
 				System.out.println(wordParse);
 			}
			return printComplexity;
 			
 	}
 	/*module to calculate time complexity of IF*/
 		/*Module to calculate time complexity of if block*/
 	public static int processIf(String wordParse, int currentline) throws FileNotFoundException{
 			Pattern p = Pattern.compile("\\s*if\\(.*?\\)"); //regular expression to recognize if loop with no spaces in syntax
 			Matcher m = p.matcher(wordParse);
 			inputParser ip = new inputParser();
 			if(m.matches()){
 				 System.out.println("if identified");
 				 numLines =0;
 				 countLinesInLoop(currentline); //method gives number of lines within if  				
 		 		 System.out.println("\n======================================== \n number of lines in if condition: "+ numLines+"\n========================================   \n");
 		 		 ifComplexity = numLines; //since it executes only once 
 		 		 System.out.println("if complexity : "+ifComplexity);
 			}
 			return ifComplexity;
 		
 	
 	}
 	
}
