import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WellFormedExpressionChecker {

	public static void main(String[] args) throws StackUnderflowException, FileNotFoundException {
		String line = null;
		Scanner input = new Scanner(new File("input.java"));
		while(input.hasNextLine()){
			line = input.nextLine();
			System.out.println(line);
			
			System.out.println(wellFormed(line));
		}
		input.close();
	}
	
	//check whether the symbol is open symbol
	private static boolean isOpen(String set){
		return set.equals("(")||set.equals("[")||set.equals("{");	
		
	}
	//check whether is close symbol
	private static boolean isClose(String set){
		return set.equals(")")||set.equals("]")||set.equals("}");
	}
	//check if the 
	private static boolean match(String open, String close){
		if(open.equals("(")&&close.equals(")"))
			return true;
		else if(open.equals("[")&&close.equals("]"))
			return true;
		else if(open.equals("{")&&close.equals("}"))
			return true;
		else 
			return false;
	}
	
	private static boolean wellFormed(String expr ) throws StackUnderflowException{
		//check whether the expression is well formed
		//if element is open symbol,push it into stack
		Stack<String> stack = new LinkedStack<String>();
		boolean checker = false; 
		String[] expression =expr.split("");
		//to count the number of open symbol;
		for(int i=0;i<expression.length;i++) {
			//if it is open symbol push to stack
			//count plus 1
			if(isOpen(expression[i]))
				stack.push(expression[i]);
			//close element compares the last open element
			if(isClose(expression[i])){
				//if there is no open symbol previous, return false and stop the loop
				if(stack.isEmpty()){
					checker =true;
				}
				else {
					//if the last symbol not  match the last symbol return false
					
					if(!match(stack.peek(),expression[i])){
						checker =true;
					}
					//if match pop the top open symbol, pop the last open symbol
					else
						stack.pop();
				}
			}
							
		}//end loop
	
		//when stack is empty return true
		if(stack.isEmpty())
			return checker;
		
		return true;
		
	}

}
