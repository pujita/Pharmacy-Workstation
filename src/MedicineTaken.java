import java.util.ArrayList;


public class MedicineTaken {
	
	private String medicineID;
	private String time;
	private boolean taken = false;
	
	public MedicineTaken(String medID, String t){
		medicineID = medID;
		time = t;
	}
	
	public boolean getTaken(){
		return taken;
	}
	
	public String getTime(){
		return time;
	}
	
	public String getID(){
		return medicineID;
	}
	
	public String getDose(){
		Medicine m = Medicine.medMap.get(medicineID);
		return m.getDose();
	}
	
	public String getPort(){
		Medicine m = Medicine.medMap.get(medicineID);
		return m.getModuleNo();
	}
	
	public String getAmount(){
		Medicine m = Medicine.medMap.get(medicineID);
		return m.getAmount();
	}
	
	public String getName(){
		Medicine m = Medicine.medMap.get(medicineID);
		return m.getName();
	}
	
	public void setTaken(){
		taken = true;
	}
	
	
	public static ArrayList<MedicineTaken> takenMeds(Patient p){
		ArrayList<MedicineTaken> takenMedList = new ArrayList<MedicineTaken>();
		for (String key : p.getMeds().keySet()){
			String id = Medicine.medMap.get(key).getMedID();
			ArrayList<String> time = Medicine.medMap.get(key).getTime();
			for (int i =0; i < time.size(); i++){
				takenMedList.add(new MedicineTaken(id, time.get(i)));
			}
		}
		return takenMedList;
	}

	
}
