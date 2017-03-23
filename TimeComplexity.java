import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TimeComplexity extends inputParser {
	static double complexity;
	static int nValue=0;
 
	WellFormedExpressionChecker bb = new  WellFormedExpressionChecker();
	public static double processLineInit(String wordParse){
		//Regex to recognize all variable initializations.
		
		Pattern p = Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\\".*?\\\"\\s*;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+\\s*;|"
	 		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+.\\d+\\s*;|\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[tT]rue\\s*;|"
	 		+ "\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[fF]alse\\s*;");
 	
		Matcher m = p.matcher(wordParse);
		if(m.matches()){
    	 complexity++;
     	 //System.out.println(complexity);
    	 System.out.println(wordParse);
		}
     	//System.out.println(m.matches());
     	
     	System.out.println(complexity);
     	return complexity;
     	
	}
	/*Calculating time complexity for For loop*/
	
 	public static double processLineForLoop(String wordParse) throws FileNotFoundException, StackUnderflowException{
 		
 		Pattern p = Pattern.compile("\\s*for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)"); //regular expression to recognize for loop with no spaces in syntax
		Matcher m = p.matcher(wordParse); 	
		if(m.matches()){
			 System.out.println("For identified");
			 //WellFormedExpressionChecker.main(null); // integration of block by block parsing should be integrated here
			 //complexity++;
			 //int index = 0;
			 System.out.println(wordParse);	
			 int conditionalIndex1=0;
			 conditionalIndex1 = wordParse.indexOf('<');
			 if(conditionalIndex1 > 0){					//to make sure the value of conditionalIndex1 is not negative
				 extractN(conditionalIndex1,wordParse);
				 System.out.println("Here is the nValue bro: "+nValue); //making sure nValue hasn't changed
			 }
			 else if(conditionalIndex1 < 0){ 
				 conditionalIndex1 = wordParse.indexOf('>');
				 
				 if(conditionalIndex1 > 0)
					 extractN(conditionalIndex1,wordParse);
				 	 System.out.println("Here is the nValue bro: "+nValue); //Making sure nValue hasn't changed 
			 }
			 else
				 System.out.println("Couldn't find the special character"); 
	    	}
		
		return complexity;
		}
 	
 		/*Method to extract n value out of for loop and return nValue*/
 	
 		public static int extractN(int conditionalIndex1,String wordParse){
 			int secondSemiColonFinder = wordParse.indexOf(';',conditionalIndex1+1);
			int index = conditionalIndex1+1;
			 
			 String concatination = "";
			 
			 while(index < secondSemiColonFinder){
				 
				 concatination = concatination+wordParse.charAt(index);
				 index++;
				 //System.out.print(concatination); 
			 }
			 //System.out.println("Here is the value of n: "+concatination);
			 char equalSymbolChecker = concatination.charAt(0);
			 //System.out.println(equalSymbolChecker);
			 if(equalSymbolChecker == '='){
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

