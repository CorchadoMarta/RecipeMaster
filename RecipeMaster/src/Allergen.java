import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Allergen {
	private SortedMap<Integer, String> allergenMap;
	
	public Allergen() {
		this.allergenMap = new TreeMap<Integer, String>();
		allergenMap.put(1, "gluten");
		allergenMap.put(2, "shellfish");
		allergenMap.put(3, "eggs");
		allergenMap.put(4, "fish");
		allergenMap.put(5, "peanuts");
		allergenMap.put(6, "soy");
		allergenMap.put(7, "dairy");
		allergenMap.put(8, "nuts");
		allergenMap.put(9, "celery");
		allergenMap.put(10, "mustard");
		allergenMap.put(11, "sesame");
		allergenMap.put(12, "sulphites");
		allergenMap.put(13, "mollusk");
		allergenMap.put(14, "lupin");
		allergenMap.put(15, "pine nuts");
	}

	public boolean addAllergen(String name){
		int code = allergenMap.size();
		String retStri = allergenMap.put(code, name);
		if (retStri == null) {
			return true;
		}
		return false;
	}
	
	
	public String getName(int code) {
		//we return the value of the entry, the name of the allergen
		return allergenMap.get(code);
	}

	public Integer getCode(String name) {
		// we set the name in lowercase letters
		String lCaseName = name.toLowerCase();
		//we go through the map and return the matching code if possible
		for (Entry<Integer, String> entry : allergenMap.entrySet()) {
	        if (entry.getValue().equals(lCaseName)) {
	        	return entry.getKey();
	        }
	    }
		//if no matching code is found, we return a -1
		return -1;
	}
	
	

}
