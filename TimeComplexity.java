import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TimeComplexity extends inputParser {
	static double complexity;

	public static void processLineInit(String wordParse) {
		//Regex to recognize all variable initializations.k
		Pattern p = Pattern.compile("\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\\"[a-zA-Z]*\\\"\\s*;|" 
		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+\\s*;|" 
		+ "\\s*([^\\s]*[a-zA-Z]*)\\s*[a-zA-Z]*\\s*=\\s*\\d+.\\d+\\s*;|\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[tT]rue\\s*;|" 
		+ "\\s*([^\\s]*boolean)\\s*[a-zA-Z]*\\s*=\\s*[fF]alse\\s*;");

		Matcher m = p.matcher(wordParse);

		if (m.matches()) {
			complexity++;

			//System.out.println(complexity);
			System.out.println(wordParse);
		}
		//System.out.println(m.matches());

		System.out.println(complexity);

	}
	public static void processLineForLoop(String wordParse) {

		Pattern p = Pattern.compile("\\s*for\\s*\\([^;]*?;[^;]*?;[^)]*?\\)");

		Matcher m = p.matcher(wordParse);

		if (m.matches()) {
			/*
			  * we should take out the value of n here*/
			System.out.println("For identified");
			complexity++;

			//int index = 0;
			System.out.println(wordParse);

			int conditionalIndex1 = 0;

			/* switch(conditionalIndex1){
			 	case '<':
			 		conditionalIndex1 = wordParse.indexOf('<');
			 		break;
			 	case '>':
			 		conditionalIndex1 = wordParse.indexOf('>');
			 		break;
			 	default:
			 		System.out.println("Couldn't find any conditional symbols");
			 		
			 		
			
			 }*/

			conditionalIndex1 = wordParse.indexOf('<');
			int secondSemiColonFinder = wordParse.indexOf(';', conditionalIndex1 + 1);
			int index = conditionalIndex1 + 1;
			String concatination = "";

			while (index < secondSemiColonFinder) {

				concatination = concatination + wordParse.charAt(index);
				index++;

				//System.out.print(concatination);

			}
			System.out.println(concatination);
			//System.out.println(wordParse.charAt(index));
			//System.out.println(wordParse.charAt(index));

		}
	}
}
