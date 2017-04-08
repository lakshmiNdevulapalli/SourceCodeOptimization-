import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SpaceComplexity extends inputParser {
	static double spaceComplexity =0;
	public static double processLineInit(String wordParse){
		

 	
		//System.out.println(".....................Space complexity works here......................");
		Pattern p1 =  Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\\".*?\\\"\\s*;");//String
		Pattern p2 =  Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+\\s*;");//int
		Pattern p3 =  Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+.\\d+\\s*;");//float
		Pattern p4 =  Pattern.compile("\\s*([^\\s]*char)\\s*[a-zA-Z]*\\s*=\\s*[a-zA-Z]{1}\\s*;");//char
		Pattern p5 =  Pattern.compile("\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[tT]rue\\s*;|\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[fF]alse\\s*");//boolean
		
		//Comparison method 
		
		Matcher m = p1.matcher(wordParse);
		Matcher m1 = p2.matcher(wordParse);
		Matcher m2 = p3.matcher(wordParse);
		Matcher m3 = p4.matcher(wordParse);
		Matcher m4 = p5.matcher(wordParse);
		if(m.matches())
			spaceComplexity += 4;
		else if(m1.matches())
			spaceComplexity += 4;
		else if(m2.matches())
			spaceComplexity += 4;
		else if(m3.matches())
			spaceComplexity += 2;
		else if(m4.matches())
			spaceComplexity += 1;
		else
			System.out.println("No matching found");
		//complexity += complexity;
		//System.out.println("Space complexity is: "+complexity);
		return spaceComplexity;
		
	}

}
