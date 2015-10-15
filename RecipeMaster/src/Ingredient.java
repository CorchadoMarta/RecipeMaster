import java.util.ArrayList;

public class Ingredient {
	private int code;
	private String name;
	private String measurement;
	private double kCal;
	private double carbohydrates;
	private double protein;
	private double fat;
	private double salt;
	private ArrayList<Allergen> allergens;
	
	
	
	public Ingredient(int code, String name, String measurement, double kCal, double carbohydrates, double protein,
			double fat, double salt) {
		super();
		this.code = code;
		this.name = name;
		this.measurement = measurement;
		this.kCal = kCal;
		this.carbohydrates = carbohydrates;
		this.protein = protein;
		this.fat = fat;
		this.salt = salt;
		this.allergens = new ArrayList<Allergen>();
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	public double getkCal() {
		return kCal;
	}
	public void setkCal(double kCal) {
		this.kCal = kCal;
	}
	public double getCarbohydrates() {
		return carbohydrates;
	}
	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSalt() {
		return salt;
	}
	public void setSalt(double salt) {
		this.salt = salt;
	}
	public ArrayList<Allergen> getAllergens() {
		return allergens;
	}
	public void setAllergens(ArrayList<Allergen> allergens) {
		this.allergens = allergens;
	}
	
}
