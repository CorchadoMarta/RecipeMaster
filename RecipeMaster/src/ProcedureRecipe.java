public class ProcedureRecipe {
	private int step;
	private int codeRecipe;
	private int codeIngr;
	private int codeProcedure;
	private String name;
	private Ingredient ingredient;
	//the default quantity is 1
	private double quantity = 1;
	//a null value means we do the procedure with the amount of time it requires, meaning it's not a timed process
	private int time;
	//any value below 0 means it's something done at ambient temperature
	//in Celsius degrees
	private double temperature = -274;
	private String free;
	
	

	public ProcedureRecipe() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getStep() {
		return step;
	}



	public void setStep(int step) {
		this.step = step;
	}



	public int getCodeRecipe() {
		return codeRecipe;
	}



	public void setCodeRecipe(int codeRecipe) {
		this.codeRecipe = codeRecipe;
	}



	public int getCodeIngr() {
		return codeIngr;
	}



	public void setCodeIngr(int codeIngr) {
		this.codeIngr = codeIngr;
	}



	public int getCodeProcedure() {
		return codeProcedure;
	}



	public void setCodeProcedure(int codeProcedure) {
		this.codeProcedure = codeProcedure;
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



	public int getTime() {
		return time;
	}



	public void setTime(int time) {
		this.time = time;
	}



	public double getTemperature() {
		return temperature;
	}



	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}



	public String getFree() {
		return free;
	}



	public void setFree(String free) {
		this.free = free;
	}



	public ProcedureRecipe(int step, int codeRecipe, int codeIngr, int codeProcedure, String name,
			Ingredient ingredient, double quantity, int time, double temperature, String free) {
		super();
		this.step = step;
		this.codeRecipe = codeRecipe;
		this.codeIngr = codeIngr;
		this.codeProcedure = codeProcedure;
		this.name = name;
		this.ingredient = ingredient;
		this.quantity = quantity;
		this.time = time;
		this.temperature = temperature;
		this.free = free;
	}

	//creates a nice string for the time
	private String convertTime() {

	    final int MINUTES_IN_AN_HOUR = 60;
	    final int SECONDS_IN_A_MINUTE = 60;

	    //int seconds = this.time % SECONDS_IN_A_MINUTE;
	    int totalMinutes = this.time / SECONDS_IN_A_MINUTE;
	    int minutes = totalMinutes % MINUTES_IN_AN_HOUR;
	    int hours = totalMinutes / MINUTES_IN_AN_HOUR;
	    
	    String timeStr = "";
	    if (hours > 0) {
	    	timeStr += hours + " hours ";
	    }
	    if (minutes > 0) {
	    	timeStr += minutes + " minutes";
	    }
	    return timeStr;
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
			if (this.time <= 0) {
				//example: 01 bake 1 potato for 20 minutes
				processString += " for " + convertTime();
				
			}
			//we add the temperature at which the process is done if necessary
			//again make sure we're using plural properly, in case some genius inputs a cooking temperature of 1
			plural = this.temperature != 1 ? "s" : "";
			if (this.temperature > -274) {
				//example: 01 bake 1 potato for 20 minutes at 250 degrees
				processString += " at " + this.temperature + " degree" + plural;
				
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return processString + ".";
	}

}
