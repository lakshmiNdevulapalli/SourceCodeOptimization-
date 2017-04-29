import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.file.FileStore;
import java.util.Scanner;

public class mainMethod {
    public static void main(String[] args)throws FileNotFoundException, StackUnderflowException {
    		/*Object creation*/
    		
    		long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            inputParser ip = new inputParser();	
            TimeComplexity tc  = new TimeComplexity();
            ip.lineParser();
            long AfterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
           
           System.out.println("Total memory used for this program : "+(AfterUsedMem-beforeUsedMem)+" bytes");
    }
} 
    	
            
    
  
