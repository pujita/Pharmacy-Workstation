import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Patient{
	private String patientName;
	private String address;
	private String patientID;
	private int patientRoom;
	private String nurse;
	private HashMap<String, Medicine> meds = new HashMap<String, Medicine>();
	static HashMap<String, Patient> patientMap = new HashMap<String, Patient>();
	
	public Patient(){	
	}
	
	public Patient(String line, String delim) {
		String[] tokens = line.split(delim);
		setID(tokens[0]);
		setName(tokens[1]);
		setAddress(tokens[2]);
		setRoom(tokens[3]);
		setNurse(tokens[4]);
		String[] medID = tokens[5].split(",");
		for(int i = 0; i < medID.length; i++){
			meds.put(medID[i], Medicine.medMap.get(medID[i]));
		}
	}
	
	public Patient(String name, String address, String id, int room, String nurse) {
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
			patientID = "";
		}
		else{
			patientID = id;
		}
	}
	
	public String getID(){
		return (patientID);
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
	
	public HashMap<String, Medicine> getMeds(){
		return this.meds;
	}
	
	@Override
	public String toString() {
		return (patientID + "\n" + patientName + "\n" +
				address + "\n" + nurse + "\n" + patientRoom);
	}
	
	public static void createPatientList() {
		try {
			FileReader fin = new FileReader("Patients.txt");
			Scanner scan = new Scanner(fin);
		
			while(scan.hasNextLine()){
				String info = scan.nextLine();
				patientMap.put(info.split("\\|")[0], new Patient(info, "\\|"));
			}
			fin.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void main (String[] args) {
		//Medicine.createMedList();
		//Patient.createPatientList();
		//System.out.println(Patient.patientMap.get("1").getMeds().get("1011").getName());
	}
	
}


