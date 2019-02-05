import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;


public class HighScore extends JFrame{
	
	List<Players> scores = new ArrayList<Players>();
		
	
	HighScore(){
					
	}
	
	public void putscore(String username, int min, int sec, int grid) {
		scores.add(new Players(username, min, sec, grid));
		
	}
	
	
	public void readfile() {
		
		try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("scores.txt")))) {
        
        while (scanner.hasNextLine()) {
        	          
            String score_data = scanner.nextLine();
            String[] array = score_data.split(",");
            String name = array[0];
            int min = Integer.parseInt(array[1]);
            int sec = Integer.parseInt(array[2]);
            int grid = Integer.parseInt(array[3]);
            scores.add(new Players(name,min,sec,grid));
            
                    
        }
        
    } catch (FileNotFoundException ex) {
        System.out.println("File Not Found");
    } catch (IOException ex) {
       System.out.println("error....");
    }
			
	}		
	
	public List<Players> getScores() {
		return scores;
	}


	public void writefile() {	
		
		Collections.sort(scores);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt"))){
			
			for(Players p : scores) {
				 writer.write(p.getName()+","+p.getMin()+","+p.getSec()+","+p.getGrid()+"\n");	
			}
	                      
	       } catch (IOException ex) {
	            System.out.println("error...");
	        }
	}




	

		
}
