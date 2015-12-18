import java.sql.SQLException;

public class Main {
	
  public static void main(String[] args) throws Exception {

    
    // KITCHENNN
    
	  KitchenDao ing = new KitchenDao();
    
    try {
    	// We insert all the ingredients
		//ing.insertIngredients(7, "wheat flour", "g", 341.00, 90.60, 9.86, 1.20, 2.00, 100);
		//ing.insertIngredients(8, "water", "ml", 0, 0, 0, 0, 0, 100);
		//ing.insertIngredients(9, "yeast", "g", 164, 27.8, 11.8, 0, 3600, 100);
		//ing.insertIngredients(10, "olive oil", "ml", 900, 0, 1, 99.90, 0, 100);
		//ing.insertIngredients(11, "shredded cheese", "g", 392.84, 0.36, 25.39, 24.20, 675, 100);
		//ing.insertIngredients(12, "tomato sauce", "ml", 38.1, 5.55, 2.30, 6.40, 590, 100);
		
		// We insert all the procedures
		//ing.insertRefRecipe(1, "pizza", 2);
		
		//we insert all the cooking procedures
//		ing.insertCookingProcedure(1, "add");
//		ing.insertCookingProcedure(2, "knead");
//		ing.insertCookingProcedure(3, "let rise");
//		ing.insertCookingProcedure(4, "lay");
//		ing.insertCookingProcedure(5, "add");
//		ing.insertCookingProcedure(6, "bake");
		
		//we insert all
		//ing.insertProcedureRecipe(step, code_recipe, code_ingredient, quantity, code_procedure, time, temperature, free);
//		ing.insertProcedureRecipe(1, 1, 7, 250, 1, 0, 0, "in a bowl");
//		ing.insertProcedureRecipe(2, 1, 8, 200, 1, 0, 0, "in a bowl");
//		ing.insertProcedureRecipe(3, 1, 10, 20, 1, 0, 0, "in a bowl");
		//ing.insertProcedureRecipe(4, 1, 9, 15, 1, 0, 0, "in a bowl");
		//ing.insertProcedureRecipe(5, 1, -1, 0, 2, 0, 0, "until firm");
		//ing.insertProcedureRecipe(6, 1, -1, 0, 3, 2700, 0, "");
//		ing.insertProcedureRecipe(7, 1, -1, 0, 2, 0, 0, "");
//		ing.insertProcedureRecipe(8, 1, -1, 0, 4, 0, 0, "on oven tray");
//		ing.insertProcedureRecipe(9, 1, 11, 150, 1, 0, 0, "");
//		ing.insertProcedureRecipe(10, 1, 12, 200, 1, 0, 0, "");
		ing.insertProcedureRecipe(11, 1, -1, 0, 6, 1200, 220, "in oven");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    
    
  }
  
} 
