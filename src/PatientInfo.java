import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class PatientInfo{
	String patientName;
	String address;
	int patientID;
	int patientRoom;
	String nurse;
	//med has name, dose, time
	public PatientInfo(){
		
	}
	
	public void setName(String name){
		if(name == null){
			patientName = "N/A";
		}
		else{
			patientName = name;
		}
	}
	
	public String getName(){
		return patientName;
	}
	
	public void setAdd(String add){
		if(add == null){
			address = "N/A";
		}
		else{
			address = add;
		}
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setID(String id){
		if(id == null){
			patientID = 0;
		}
		else{
			patientID = Integer.parseInt(id);
		}
	}
	
	public int getID(){
		return patientID;
	}
	
	public void setRoom(String room){
		if(room == null){
			patientRoom = 0;
		}
		else{
			patientRoom = Integer.parseInt(room);
		}
	}
	
	public int getRoom(){
		return patientRoom;
	}
	
	public void setNurse(String nurse){
		this.nurse = nurse;
	}
	
	public String getNurse(){
		return nurse;
	}
	
	public static void readFile (int patientID) throws IOException{
		FileReader fin = new FileReader("Test.txt");
		Scanner scan = new Scanner(fin);

		while(scan.hasNextLine()){
			String temp = scan.nextLine();
			String[] tokens = temp.split(",");
			
			if (Integer.parseInt(tokens[0]) ==patientID){
				System.out.println( temp);
				
			}
		}
		fin.close();
	}

	public static void main (String[] args) throws IOException{
		readFile(2);
	}

}
