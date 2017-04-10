import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TimeComplexity extends inputParser {
	static int forLoopComplexity;
	static int initComplexity;
	static int nValue=0;
	static int numLines =0;
	WellFormedExpressionChecker bb = new  WellFormedExpressionChecker();
	public static double processLineInit(String wordParse, int currentline){
		
		
		/*Regex to recognize all variable initializations and import statements.*/
		
		Pattern p = Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\\".*?\\\"\\s*;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+\\s*;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+.\\d+\\s*;|\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[tT]rue\\s*;|"
	 		+ "\\s*([^\\s]*boolean "
	 		+ " )\\s*[a-zA-Z]*\\s*=\\s*[fF]alse\\s*;|\\s*import\\s*.*?\\s*;");
 	
		Matcher m = p.matcher(wordParse);
		if(m.matches()){
    	 initComplexity++;	//increasing timecomplexity as the tc for initialization statements is O(1).
     	 //System.out.println(complexity);
    	 System.out.println(wordParse); //printing matched statements with the regexs 
		}
        //System.out.println(initComplexity); //printing the current complexity
     	return initComplexity;
     	
	}
	/*Calculating time complexity for For loop*/
	
	
 	public static double processLineForLoop(String wordParse, int currentline) throws FileNotFoundException, StackUnderflowException{
 		
 		Pattern p = Pattern.compile("\\s*for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)"); //regular expression to recognize for loop with no spaces in syntax
		Matcher m = p.matcher(wordParse);
		inputParser ip = new inputParser();
		if(m.matches()){
			 System.out.println("For identified");
			 
			 //System.out.println("current line value is: " +currentline);
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
	}

