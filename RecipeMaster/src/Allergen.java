import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Allergen {
	
	private int idAllergen;
	private String name;
	
	
	
	public Allergen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Allergen(int idAllergen, String name) {
		super();
		this.idAllergen = idAllergen;
		this.name = name;
	}



	public int getIdAllergen() {
		return idAllergen;
	}
	public void setIdAllergen(int idAllergen) {
		this.idAllergen = idAllergen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.length() <= 50) {
			this.name = name;
		}
	}
	
	

}
