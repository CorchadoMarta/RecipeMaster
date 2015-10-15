public class CookingProcedure {
	private int code;
	private String name;
	private Ingredient ingredient;
	//the default quantity is 1
	private double quantity = 1;
	//any value below 2 means we only do it once
	private int times = -1;
	//a null value means we do the procedure with the amount of time it requires, meaning it's not a timed process
	private String time = null;
	//any value below 0 means it's something done at ambient temperature
	private int temperature = -1;
	
	public CookingProcedure(int code, String name, Ingredient ingredient, double quantity, int times, String time,
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
	
	//basic constructor for a simple task such as peeling an orange
	public CookingProcedure(int code, String name, Ingredient ingredient) {
		super();
		this.code = code;
		this.name = name;
		this.ingredient = ingredient;
	}
	
	public CookingProcedure(int code, String name, Ingredient ingredient, double quantity) {
		super();
		this.code = code;
		this.name = name;
		this.ingredient = ingredient;
		this.quantity = quantity;
	}
	
	public CookingProcedure(int code, String name, Ingredient ingredient, double quantity, String time, int temperature) {
		super();
		this.code = code;
		this.name = name;
		this.ingredient = ingredient;
		this.quantity = quantity;
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



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
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
