import java.sql.SQLException;

public class Main {
	
  public static void main(String[] args) throws Exception {

    
    // KITCHENNN
    
	  KitchenDao ing = new KitchenDao();
    
    try {
    	// We insert all the ingredients
		//ing.insertIngredients(7, "wheat flour", "g", 341.00, 90.60, 9.86, 1.20, 2.00, 100);
		ing.insertIngredients(8, "water", "ml", 0, 0, 0, 0, 0, 100);
		ing.insertIngredients(9, "yeast", "g", 164, 27.8, 11.8, 0, 3600, 100);
		ing.insertIngredients(10, "olive oil", "ml", 900, 0, 1, 99.90, 0, 100);
		ing.insertIngredients(11, "shredded cheese", "g", 392.84, 0.36, 25.39, 24.20, 675, 100);
		ing.insertIngredients(12, "tomato sauce", "ml", 38.1, 5.55, 2.30, 6.40, 590, 100);
		
		// We insert all the  
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    
    
  }
  
} 
