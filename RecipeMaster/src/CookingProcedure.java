public class CookingProcedure {
	private int code;
	private String name;
	private Ingredient ingredient;
	private double quantity;
	private int times;
	private int time;
	private int temperature;
	
	public CookingProcedure(int code, String name, Ingredient ingredient, double quantity, int times, int time,
			int temperature) {
		super();
		this.code = code;
		this.name = name;
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.times = times;
		this.time = time;
		this.temperature = temperature;
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



	public Ingredient getIngredient() {
		return ingredient;
	}



	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}



	public double getQuantity() {
		return quantity;
	}



	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}



	public int getTimes() {
		return times;
	}



	public void setTimes(int times) {
		this.times = times;
	}



	public int getTime() {
		return time;
	}



	public void setTime(int time) {
		this.time = time;
	}



	public int getTemperature() {
		return temperature;
	}



	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}



	public String processIngredient() {
		//ex: 01 add 2
		String processString = String.format("%02d %s %f ", this.code, this.name.toLowerCase(), this.quantity);
		//if we have a plural amount of the measurement we add s
		String plurIngredient = this.quantity != 1 ? "s" : "";
		if (this.ingredient.getMeasurement().toLowerCase().equals("unit")) {
			//example: 01 add 2 oranges
			processString +=  this.ingredient.getName().toLowerCase() + plurIngredient;
		} else {
			//example 01 add 2 teaspoons of sugar
			processString += this.ingredient.getMeasurement() + plurIngredient + " of " + this.ingredient.getName().toLowerCase();
		}
		   
		return processString;
			// ;
	}

}
