import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Patient{
	String patientName;
	String address;
	int patientID;
	int patientRoom;
	String nurse;
	static ArrayList<Patient> patientList = new ArrayList<Patient>();
	//med has name, dose, time
	public Patient(){	
	}
	
	public Patient(String name, String address, int id, int room, String nurse) {
		patientName = name;
		this.address = address;
		patientID = id;
		patientRoom = room;
		this.nurse = nurse;
	}
	
	private void setName(String name){
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
	
	private void setAddress(String add){
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
	
	private void setID(String id){
		id = id.trim();
		if(id == null){
			patientID = 0;
		}
		else{
			patientID = Integer.parseInt(id);
		}
	}
	
	public String getID(){
		return Integer.toString(patientID);
	}
	
	private void setRoom(String room){
		room = room.trim();
		if(room == null){
			patientRoom = 0;
		}
		else{
			patientRoom = Integer.parseInt(room);
		}
	}
	
	public String getRoom(){
		return Integer.toString(patientRoom);
	}
	
	private void setNurse(String nurse){
		this.nurse = nurse;
	}
	
	public String getNurse(){
		return nurse;
	}
	

	@Override
	public String toString() {
		return (patientID + "\n" + patientName + "\n" +
				address + "\n" + nurse + "\n" + patientRoom);
	}
	
	public static void createPatientList () throws IOException{
		FileReader fin = new FileReader("Test.txt");
		Scanner scan = new Scanner(fin);
	
		while(scan.hasNextLine()){
			String info = scan.nextLine();
			String[] tokens = info.split("\\|");
			Patient newPatient = new Patient();
			newPatient.setID(tokens[0]);
			newPatient.setName(tokens[1]);
			newPatient.setAddress(tokens[2]);
			newPatient.setRoom(tokens[3]);
			newPatient.setNurse(tokens[4]);
			patientList.add(newPatient);
		}
		fin.close();
	}

	public static void main (String[] args) throws IOException{
		createPatientList();
		System.out.println(patientList.get(2));
	}
}

/*txt
1|Pujita Vijayvargiya|333764 GAtech Station, Atlanta, GA 30332|202|Jenny
2|Sam Brown|123 Florida, 40883|306|Melissa
3|David Smith| 784 Peachtree St., Atlanta ,GA 30332| 402|Jenny 
*/
