import java.sql.Date;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Recipe {
	private int code;
	private String name;
	private ArrayList<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	private SortedMap<Integer, CookingProcedure> proceduresOrder = new TreeMap <Integer, CookingProcedure>();
	private double kCal;
	private double carbohydrates;
	private double protein;
	private double fat;
	private double salt;
	private ArrayList<Allergen> allergensList = new ArrayList<Allergen>();
	private Date dateOfCreation;
	private String cuisine;
	
	
	public Recipe(int code, String name, ArrayList<Ingredient> ingredientsList,
			SortedMap<Integer, CookingProcedure> proceduresOrder, double kCal, double carbohydrates, double protein,
			double fat, double salt, ArrayList<Allergen> allergensList) {
		super();
		this.code = code;
		this.name = name;
		this.ingredientsList = ingredientsList;
		this.proceduresOrder = proceduresOrder;
		this.kCal = kCal;
		this.carbohydrates = carbohydrates;
		this.protein = protein;
		this.fat = fat;
		this.salt = salt;
		this.allergensList = allergensList;
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
	public ArrayList<Ingredient> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(ArrayList<Ingredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	public SortedMap<Integer, CookingProcedure> getProceduresOrder() {
		return proceduresOrder;
	}
	public void setProceduresOrder(SortedMap<Integer, CookingProcedure> proceduresOrder) {
		this.proceduresOrder = proceduresOrder;
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
	public ArrayList<Allergen> getAllergensList() {
		return allergensList;
	}
	public void setAllergensList(ArrayList<Allergen> allergensList) {
		this.allergensList = allergensList;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	
}
