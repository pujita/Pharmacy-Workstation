import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class PatientInfo{

	public static void readFile(String fileName, int patientID) throws IOException{
		FileReader fin = new FileReader(fileName);
		Scanner scan = new Scanner(fin);

		while(scan.hasNextLine()){
			String temp = scan.nextLine();
			String[] tokens = temp.split(",");
			
			if (Integer.parseInt(tokens[0]) ==patientID){
				System.out.println(temp);
			}
		}
		fin.close();
	}

	public static void main (String[] args) throws IOException{
		readFile("Test.txt",2);
	}

}
