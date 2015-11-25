public class CookingProcedure {
	private int code;
	private String name;
	private Ingredient ingredient;
	//the default quantity is 1
	private double quantity = 1;
	//any value below 2 means we only do it once
	private int times = -1;
	//a null value means we do the procedure with the amount of time it requires, meaning it's not a timed process
	private String time = "";
	//any value below 0 means it's something done at ambient temperature
	//in Celsius degrees
	private int temperature = -274;
	
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
		//declarations
		String processString = "";
		try {
			//ex: 01 add 2
			processString += String.format("%s %f ", this.name.toLowerCase(), this.quantity);
			//if we have a plural amount of the measurement we add s
			String plural = this.quantity != 1 ? "s" : "";
			if (this.ingredient.getMeasurement().toLowerCase().equals("unit")) {
				//example: 01 add 2 oranges
				processString +=  this.ingredient.getName().toLowerCase() + plural;
			} else {
				//example: 01 add 2 teaspoons of sugar
				processString += this.ingredient.getMeasurement() + plural + " of " + this.ingredient.getName().toLowerCase();
			}
			//we add the duration of the process if applicable
			if (this.time != null) {
				//example: 01 bake 1 potato for 20 minutes
				processString += " for " + this.time.toLowerCase();
				
			}
			//we add the temperature at which the process is done if necessary
			//again make sure we're using plural properly, in case some genius inputs a cooking temperature of 1
			plural = this.temperature != 1 ? "s" : "";
			if (this.temperature > -274) {
				//example: 01 bake 1 potato for 20 minutes at 250 degrees
				processString += " at " + this.temperature + " degree" + plural;
				
			}
			if (this.times > 1) {
				//we use proper adverbial
				String adverbial = "";
				switch (this.times) {
					//01 peel 2 oranges twice
					case 2:
						adverbial = "twice";
						break;
					case 3:
						adverbial = "thrice";
						break;
					default:
						adverbial = this.times + " times";
						break;
				}
				
				//example: 01 bake 1 potato for 20 minutes at 250 degrees 4 times
				processString += " " + adverbial;
				
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return processString + ".";
	}

}
