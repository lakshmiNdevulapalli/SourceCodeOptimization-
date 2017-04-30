import java.io.*;

public class mainMethod {
    public static void main(String[] args)throws FileNotFoundException{
    		/*Object creation*/
    		
    		long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            inputParser ip = new inputParser();	
            @SuppressWarnings("unused")
			TimeComplexity tc  = new TimeComplexity();
            ip.lineParser();
            long AfterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
           
           //System.out.println("Total memory used for this program : "+(AfterUsedMem-beforeUsedMem)+" bytes");
    }
} 
    	
            
    
  