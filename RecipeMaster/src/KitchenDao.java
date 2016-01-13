import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

import com.mysql.jdbc.MysqlErrorNumbers;

public class KitchenDao {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("show tables;");
			writeResultSet(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("Summary: " + summary);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
		}
	}

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	// Create a regular Statement for your class MySQLAccess()
	public void insertIngredients(int code, String name, String measurement, double kCal, double carbohydrates,
			double protein, double fat, double salt, int quantity) throws SQLException, ClassNotFoundException {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Query insert
			String sentence = "INSERT INTO kitchen.ingredient (code, name, measurement, kcal, carbohydrates, protein, fat, salt, quantity) VALUES ("
					+ code + ",'" + name + "','" + measurement + "'," + kCal + "," + carbohydrates + "," + protein + ","
					+ fat + "," + salt + "," + quantity + ")";

			statement.executeUpdate(sentence);

		} catch (SQLException e) {
			if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				System.out.println("Duplicate entry: " + name);
			} else {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				throw e;
			}
		} finally {
			close();
		}
	}

	// Method to insert our measuring methods
	public void insertMeasuringMethod(String id, String description) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			String sentencia = "INSERT INTO kitchen.measuring_method (id, description) values ('" + id + "', '"
					+ description + "')";
			statement.executeUpdate(sentencia);

		} catch (SQLException e) {
			if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				System.out.println("Duplicate entry: " + description);
			} else {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				throw e;
			}
		} finally {
			close();
		}
	}

	// Method to insert our cooking procedures
	public void insertCookingProcedure(int code, String description) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			//Insert statement
			String sentence = "INSERT INTO cooking_procedure (code, description) VALUES (?, ?)";
			PreparedStatement ps = connect.prepareStatement(sentence);
			ps.setInt(1, code);
			ps.setString(2, description);

			// Result set get the result of the SQL query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				System.out.println("Duplicate entry: " + description);
			} else {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				throw e;
			}
		} finally {
			close();
		}

	}

	// Method to insert our allergens
	public void insertAllergen(int id_Allergen, String name) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			String sentencia = "INSERT INTO allergen (id_Allergen, name) values (" + id_Allergen + ", '" + name + "')";
			statement.executeUpdate(sentencia);

		} catch (SQLException e) {
			if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				System.out.println("Duplicate entry: " + name);
			} else {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				throw e;
			}
		} finally {
			close();
		}
	}

	// Method to insert our has_allergens
	public void insertHasAllergen(int code_ingredient, String id_Allergen) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			String sentencia = "INSERT INTO has_allergens (code_ingredient, id_Allergen) values (" + code_ingredient
					+ ", '" + id_Allergen + "')";
			statement.executeUpdate(sentencia);

		} catch (SQLException e) {
			if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				System.out.println("Duplicate entry: " + code_ingredient + " " +  id_Allergen);
			} else {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				throw e;
			}
		} finally {
			close();
		}
	}

	// Method to insert our procedure recipe
	public void insertProcedureRecipe(int step, int code_recipe, int code_ingredient, double quantity,
			int code_procedure, int time, double temperature, String free) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			String sentence = "INSERT INTO procedure_recipe (step, code_recipe, code_ingredient, quantity, code_procedure, time, temperature, free) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sentence);
			ps.setInt(1, step);
			ps.setInt(2, code_recipe);
			ps.setInt(3, code_ingredient);
			ps.setDouble(4, quantity);
			ps.setInt(5, code_procedure);
			ps.setInt(6, time);
			ps.setDouble(7, temperature);
			ps.setString(8, free);
			ps.executeUpdate();

		} catch (SQLException e) {
			if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				System.out.println("Duplicate entry: " + step);
			} else {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				throw e;
			}
		} finally {
			close();
		}
	}

	// Method to insert our procedure recipe
	public void insertRefRecipe(int code_recipe, String description, int serves) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			
			String sentence = "INSERT INTO ref_recipe (code_recipe, description, serves) VALUES (?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sentence);
			ps.setInt(1, code_recipe);
			ps.setString(2, description);
			ps.setInt(3, serves);
			// Result set get the result of the SQL query
			ps.executeUpdate();

		} catch (SQLException e) {
			if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
				System.out.println("Duplicate entry: " + description);
			} else {
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				throw e;
			}
		} finally {
			close();
		}
	}
	
	
	public ArrayList<Allergen> getListAllergen(int codRecipe) throws Exception {
		//declarations
		ArrayList<Allergen> allergens = new ArrayList<Allergen>();
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select a.id_allergen, a.name from allergen a inner join has_allergen h on a.id_allergen=h.id_allergen INNER JOIN ingredient i on h.code_ing=i.code inner join procedure_recipe p on i.code=p.code_ingredient where p.code_recipe=" + codRecipe);
			while (resultSet.next()) { 
				int id = resultSet.getInt("id_allergen");
				String name = resultSet.getString("name");
				allergens.add(new Allergen(id, name));
			}
			return allergens;
		} catch (Exception e) {
			throw e;
			
		} finally {
			
			close();
		}
		
	}
	
	public HashMap<String, Double> getIngredients(int codRecipe) {
		//declarations
		HashMap<String, Double> ingredients = new HashMap<String, Double>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select i.name, p.quantity from ingredient i inner join procedure_recipe p on i.code=p.code_ingredient where p.code_recipe=" + codRecipe +  " and name!='NA';");
			while (resultSet.next()) { 
				//ingredients.put(name,);
				ingredients.put(resultSet.getString("name"), resultSet.getDouble("p.quantity"));
			}
			return ingredients;
		} catch (Exception e) {
			
		} finally {
			close();
		}

		return ingredients;
		
	}
	
	public HashMap<String, Double> getNutritionalValues(int codRecipe) {
		//declarations
		HashMap<String, Double> nutritionalValues = new HashMap<String, Double>();
		/* double kCalPerson = 0;
		double carbohydratesPerson = 0;
		double proteinPerson = 0;
		double */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			String sSQL = "select sum(i.kCal)/r.serves as kCalPerson, sum(i.carbohydrates)/r.serves as carbohydratesPerson, sum(i.protein)/r.serves as proteinPerson, ";
			sSQL += " sum(i.fat)/r.serves as fatPerson, sum(i.salt)/r.serves as saltPerson from ingredient i inner join procedure_recipe p on i.code=p.code_ingredient ";
			sSQL += " inner join ref_recipe r on r.code_recipe=p.code_recipe where p.code_recipe=" + codRecipe + " and name!='NA';";
			resultSet = statement.executeQuery(sSQL);
			while (resultSet.next()) { 
				nutritionalValues.put("kCal", resultSet.getDouble("kCalPerson"));
				nutritionalValues.put("carbohydrates", resultSet.getDouble("carbohydratesPerson"));
				nutritionalValues.put("protein", resultSet.getDouble("proteinPerson"));
				nutritionalValues.put("fat", resultSet.getDouble("fatPerson"));
				nutritionalValues.put("salt", resultSet.getDouble("saltPerson"));
			}
			return nutritionalValues;
		} catch (Exception e) {
			
		} finally {
			close();
		}

		return nutritionalValues;
		
	}
	
	public ArrayList<String> getProcedureList(int codRecipe) throws Exception {
		//declarations
		ArrayList<String> procedure = new ArrayList<String>();
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select p.step, c.description, i.name, p.time, p.temperature, p.free from procedure_recipe p inner join cooking_procedure c on p.code_procedure = c.code inner join ingredient i on p.code_ingredient = i.code where p.code_recipe = " + codRecipe + ";");
			while (resultSet.next()) { 
				int step = resultSet.getInt("p.step");
				String verb = resultSet.getString("c.description");
				String ingredient = resultSet.getString("i.name"); 
				int time = resultSet.getInt("p.time");
				String timeSolved = "";
				if (time > 0) {
					int timeSec = time % 60;
					int timeMin = (time / 60) % 60;
					int timeHour = time / 3600;
					timeSolved = timeHour + "h, " + timeMin + "m, " + timeSec + "s."; 
				}

				double temperature = resultSet.getDouble("p.temperature");
				String free = resultSet.getString("p.free");
				procedure.add(step + "- " + verb + " " + ingredient + " " + timeSolved + " " + temperature + " " + free + ".");
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		return procedure;
	}
	
	public String getRecipeText(int codRecipe) throws Exception {
		
		//declarations
		String fullRecipe = "";
		String name = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/kitchen?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select description from ref_recipe where code_recipe= " + codRecipe);
			while (resultSet.next()) { 
				name = resultSet.getString("description") + "\n";
			}
			//title (name) of the recipe
			name = Character.toString(name.charAt(0)).toUpperCase() + name.substring(1);
			fullRecipe += name + "\n";
			//ingredients
			fullRecipe += "Ingredients\n";
			HashMap<String, Double> ingreQuant = getIngredients(codRecipe);
			System.out.println(ingreQuant.size());
			for (Map.Entry<String, Double> entry : ingreQuant.entrySet()) {
				fullRecipe += entry.getKey() + ": " +  entry.getValue() + "\n";
			    //Object value = entry.getValue();
			    // ...
			}
			ArrayList<String> procedures = getProcedureList(codRecipe);
			for (String s : procedures) {
				fullRecipe += s +"\n";
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		return fullRecipe;
		
	}
	
}