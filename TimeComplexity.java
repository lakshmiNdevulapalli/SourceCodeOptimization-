
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
 	  + "\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[fF]alse\\s*;|\\s*([^\\s]*for)*");
 	
	 Matcher m = p.matcher(wordParse);
     	
	 if(m.matches()){
    	 complexity++;
    	 
     	 //System.out.println(complexity);
    	}
     	//System.out.println(m.matches());
     	System.out.println(wordParse);
     	System.out.println(complexity);
     	
	}
  public String findKeyWord(String wordParse){
	 String match ="NULL";
	 //System.out.println(complexity);
	 ArrayList<String>keywords = new ArrayList<String>();
	 keywords.add("if");
	 keywords.add("for");
	 keywords.add("while");
	 keywords.add("do");
	 
	 
	 
	return match;
	 
 }
 
  
}

