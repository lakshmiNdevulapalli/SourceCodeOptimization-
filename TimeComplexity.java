
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TimeComplexity extends inputParser {
	static double complexity;
 
 	
	public static void processLineInit(String wordParse){
		//Regex to recognize all variable initializations.k
		Pattern p = Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\\"[a-zA-Z]*\\\"\\s*;|"
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
     	
	}
 	public static void processLineForLoop(String wordParse){
 		Pattern p = Pattern.compile("\\s*for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)");
	 	
		Matcher m = p.matcher(wordParse);
	     	
		if(m.matches()){
			 
			 System.out.println("For identified");
			 complexity++;
			 
			 //int index = 0;
			 System.out.println(wordParse);	
			 int conditionalIndex1=0;
			 
			 conditionalIndex1 = wordParse.indexOf('<');
			 
			 if(conditionalIndex1 > 0){								//to make sure the value of conditionalIndex1 is not negative
				 extractN(conditionalIndex1,wordParse);   
			 }
			 else if(conditionalIndex1 < 0){
				 conditionalIndex1 = wordParse.indexOf('>');
				 if(conditionalIndex1 > 0)
					 extractN(conditionalIndex1,wordParse);
			 }
			 else
				 System.out.println("Couldn't find the special character");
				 
	    	}
		}
 		public static void extractN(int conditionalIndex1,String wordParse){
 			int secondSemiColonFinder = wordParse.indexOf(';',conditionalIndex1+1);
			 int index = conditionalIndex1+1;
			 String concatination = "";
			 
			 while(index < secondSemiColonFinder){
				 
				 concatination = concatination+wordParse.charAt(index);
				 index++;
				 
				 //System.out.print(concatination);
				 
			 }
			 System.out.println("Here is the value of n: "+concatination);
			 char equalSymbolChecker = concatination.charAt(0);
			 //System.out.println(equalSymbolChecker);
			 if(equalSymbolChecker == '='){
				 String trimmedString = concatination.substring(1); //to remove = in the extracted string
				 //System.out.println(trimmedString);
				 int nValue = Integer.parseInt(trimmedString); //to convert extracted string to integer
				 // System.out.println(nValue+20); //cross check				 
				 
			 }
			 else{
				 int nValue = Integer.parseInt(concatination);
				 System.out.println(nValue+20); //cross check
				 
			 }
			
 		}
	}

