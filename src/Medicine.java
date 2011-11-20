import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Medicine {

	private String name;
	private int medID;
	private String moduleNo;
	private String scientificName;
	private ArrayList<String> time = new ArrayList<String>();
	private String timeString;
	private int dose;
	private String notes;
	static HashMap<String, Medicine> medMap = new HashMap<String, Medicine>();
	
	public Medicine() {

	}
	
	public Medicine(String med, String delim){
		String[] tokens = med.split(delim);
		setMedNo(tokens[0]);
		setName(tokens[1]);
		setScientificName(tokens[2]);
		setTime(tokens[3]);
		setTimeString(tokens[3]);
		setDose(tokens[4]);
		setNotes(tokens[5]);
		setModuleNo(tokens[6]);
	}
	
	public void setName(String name){
		if (name.trim() == null){
			this.name = "N/A";
		}
		else {
			this.name = name;
		}
	}
	
	public void setModuleNo(String module){
		this.moduleNo = module;
	}
	
	public void setMedNo(String id){
		this.medID = Integer.parseInt(id.trim());
	}
	
	public void setScientificName(String name){
		if (name == null){
			this.scientificName = "N/A";
		}
		else {
			this.scientificName = name;
		}
	}
	
	public void setTime(String time){
		String[] times = time.split(",");
		for (int i = 0; i < times.length; i++){
			this.time.add(times[i]);
		}
	}
	
	public void setTimeString( String time){
		this.timeString = time;
	}
	
	public void setDose(String dose){
		if (dose.trim() == null){
			this.dose = 0;
		}
		else {
			this.dose = Integer.parseInt(dose.trim());
		}
	}
	
	public void setNotes(String note){
		if (note.trim() == null){
			this.notes = "N/A";
		}
		else{
			this.notes = note;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public String getMedID(){
		return Integer.toString(medID);
	}
	
	public String getScientificName(){
		return scientificName;
	}
	
	public ArrayList<String> getTime(){
		return time;
	}
	
	public String getTimeString(){
		return this.timeString;
	}
	
	public String getDose(){
		return Integer.toString(dose);
	}
	
	public String getNotes(){
		return this.notes;
	}
	
	public String getModuleNo(){
		return moduleNo;
	}
	
	public static void createMedList() {
		try {
			FileReader fin = new FileReader("Medicine.txt");
			Scanner scan = new Scanner(fin);
		
			while(scan.hasNextLine()){
				String med = scan.nextLine();
				medMap.put(med.split("\\|")[0], new Medicine(med, "\\|"));
			}
			fin.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
/*
	public static void editModuleNo(String medID){
	
		 try {
			FileReader fin = new FileReader("Medicine.txt");
			BufferedWriter writer = new BufferedWriter("Medicine.txt");
			Scanner scan = new Scanner(fin);
				
			while(scan.hasNextLine()){
				String med = scan.nextLine();
				if(med.split("\\|")[0].equals(medID)){	
				
				}
						//medMap.put(med.split("\\|")[0], new Medicine(med, "\\|"));
			}
			fin.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args){
		//createMedList();
		//System.out.println(Medicine.medMap.get("1011").getName());
		//System.out.println(Medicine.medMap.get("1011").getScientificName());
		//System.out.println(Medicine.medMap.get("1011").getDose());
		
	}
	
}
