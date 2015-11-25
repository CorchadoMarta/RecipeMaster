
public class arrel {

	public static void main(String[] args) {
		
		Ingredient banana = new Ingredient(1, "banana", "unit", 110.0, 30.0, 1.0, 0.0, 0.0);
		Ingredient kiwi = new Ingredient(2, "kiwi", "unit", 46.0, 11.14, 0.87, 0.4, 2.0);
		Ingredient apple = new Ingredient(3, "apple", "unit", 72.0, 19.06, 0.36, 0.23, 1.0);
		Ingredient sugar = new Ingredient(100, "sugar", "g", 0.387, 0.99, 0, 0, 0);
		Ingredient oj = new Ingredient(500, "orange juice", "ml", 0.41, 0.095, 0.006, 0.001, 0);
		
		CookingProcedure procedure1 = new CookingProcedure(1, "slice", banana);
		CookingProcedure procedure2 = new CookingProcedure(2, "cut into cubes", kiwi);
		CookingProcedure procedure3 = new CookingProcedure(3, "cut into cubes", apple);
		CookingProcedure procedure4 = new CookingProcedure(4, "add into a bowl", banana);
		CookingProcedure procedure5 = new CookingProcedure(5, "add into a bowl", kiwi);
		CookingProcedure procedure6 = new CookingProcedure(6, "add into a bowl", apple);
		CookingProcedure procedure7 = new CookingProcedure(7, "add into a bowl", sugar);
		CookingProcedure procedure8 = new CookingProcedure(8, "add into a bowl", oj);
		
		Recipe recipe1 = new Recipe();
		
		try {
			recipe1.addIngredient(banana);
			recipe1.addIngredient(kiwi);
			recipe1.addIngredient(apple);
			recipe1.addIngredient(sugar);
			recipe1.addIngredient(oj);
			
			recipe1.addProcedure(procedure1);
			recipe1.addProcedure(procedure2);
			recipe1.addProcedure(procedure3);
			recipe1.addProcedure(procedure4);
			recipe1.addProcedure(procedure5);
			recipe1.addProcedure(procedure6);
			recipe1.addProcedure(procedure7);
			recipe1.addProcedure(procedure8);
			
			
			System.out.println(recipe1.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
