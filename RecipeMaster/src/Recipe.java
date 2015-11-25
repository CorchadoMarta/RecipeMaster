import java.sql.Date;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Recipe {
	private int code;
	private String name;
	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private SortedMap<Integer, CookingProcedure> proceduresOrder = new TreeMap <Integer, CookingProcedure>();
	private double kCal;
	private double carbohydrates;
	private double protein;
	private double fat;
	private double salt;
	private ArrayList<Allergen> allergenList = new ArrayList<Allergen>();
	private Date dateOfCreation;
	private String cuisine;
	
	
	public Recipe(int code, String name, ArrayList<Ingredient> ingredientsList,
			SortedMap<Integer, CookingProcedure> proceduresOrder, double kCal, double carbohydrates, double protein,
			double fat, double salt, ArrayList<Allergen> allergensList) {
		super();
		this.code = code;
		this.name = name;
		this.ingredientList = ingredientsList;
		this.proceduresOrder = proceduresOrder;
		this.kCal = kCal;
		this.carbohydrates = carbohydrates;
		this.protein = protein;
		this.fat = fat;
		this.salt = salt;
		this.allergenList = allergensList;
	}
	
	public Recipe() {
		super();
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
	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(ArrayList<Ingredient> ingredientsList) {
		this.ingredientList = ingredientsList;
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
	public ArrayList<Allergen> getAllergenList() {
		return allergenList;
	}
	public void setAllergenList(ArrayList<Allergen> allergensList) {
		this.allergenList = allergensList;
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
	
	public void addIngredient(Ingredient ingredient) {
		try {
			this.ingredientList.add(ingredient);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void addProcedure(CookingProcedure procedure){
		try {
			this.getProceduresOrder().put(procedure.getCode(), procedure);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (Entry<Integer, CookingProcedure> entry : this.getProceduresOrder().entrySet()) {
			 str += entry.getValue().processIngredient() + "\n";
		}
		return str;
	}
	
	
	
}
