
import org.apache.commons.lang.WordUtils;

public class CookingProcedure {
	private int code;
	private String name;
	private int ingredientCode;
	private int quantity;
	private int times;
	private int time;
	private int temperature;
	
	public CookingProcedure(int code, String name, int ingredientCode, int quantity, int times, int time,
			int temperature) {
		super();
		this.code = code;
		this.name = name;
		this.ingredientCode = ingredientCode;
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



	public int getIngredientCode() {
		return ingredientCode;
	}



	public void setIngredientCode(int ingredientCode) {
		this.ingredientCode = ingredientCode;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
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
		
		return "";
	}

}
