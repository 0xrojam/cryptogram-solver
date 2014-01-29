import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;




public class CryptSolver {

	public static void main(String[] args) throws IOException {
		//System.out.println("hello world");
	  char[] mostFreq =   { 'E', 'T', 'A', 'O', 'I', 'N', 'S', 'R', 'H', 'L', 'D', 'C', 'U', 'M', 'F', 'P', 'G', 'W', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z'};
	  char[] alpha    =   { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	  //read puzzle
	  String puzzle = readFile();
	  
	  //get char count
	  Vector<Integer> freqVector = freqCount(puzzle); 
      //break
	  
	  for(int i = 0; i < 27; i++){
	    System.out.println(alpha[i] + ":" + freqVector.elementAt(i));	  	
	  }
	  
	}
	


	public static Vector<Integer> freqCount(String puzzle) {
		
		Vector<Integer> fv = new Vector<Integer>(26);
		for(int i = 0; i < 27; i++){
			fv.addElement(new Integer(0));
		}
		//cycle thru lines in the 
		for(int j = 0; j < puzzle.length(); j++ ){
			int c = (int) puzzle.charAt(j);
			if(c > 90){ c = c - 32;}
			if(c != 32){	
		     fv.setElementAt(fv.elementAt(c-65) + 1, c-65);			
		    }
		}
		return fv;
		
	}





	public static String readFile() throws IOException
	{	
	  Vector<String> lines = new Vector<String>();	
	  //Read in filename - then file
	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	  System.out.print("Filename: ");
	  String filename = in.readLine();
	 //System.out.println((int) filename.charAt(0));
	  in.close();
	 	 	 
	  BufferedReader fileread = new BufferedReader(new FileReader(filename)); 
	  
	  while (fileread.ready()) { 
		lines.add(fileread.readLine());
		}
	  
	  in.close();
	  
	  String str = "";
	  
	  for(int i = 0; i < lines.size(); i++)
	  {
		  str = str + (lines.elementAt(i)) + " ";
	  }
	  //System.out.println(lines.size());
	  	  
	  return str;
		
	}

}
