import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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

			int affectedRows = statement.executeUpdate(sentence);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
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
			int affectedRows = statement.executeUpdate(sentencia);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
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
					.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=jupiter");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			//Insert statement
			String sentence = "INSERT INTO cooking_procedure (code, description) VALUES (?, ?)";
			PreparedStatement ps = connect.prepareStatement(sentence);
			ps.setInt(1, code);
			ps.setString(2, description);

			// Result set get the result of the SQL query
			ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
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
			int affectedRows = statement.executeUpdate(sentencia);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
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
			int affectedRows = statement.executeUpdate(sentencia);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
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
			String sentencia = "INSERT INTO procedure_recipe (step, code_recipe, code_ingredient, quantity, code_procedure, time, temperature, free) values ("
					+ step + ", " + code_recipe + ", " + code_ingredient + ", " + quantity + ", " + ", "
					+ code_procedure + ", " + time + ", " + temperature + ", '" + free + "')";
			int affectedRows = statement.executeUpdate(sentencia);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
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
			String sentencia = "INSERT INTO procedure_recipe (code_recipe, description, serves) values ("
					+ code_recipe + ", '" + description + "', " + serves + ")";
			int affectedRows = statement.executeUpdate(sentencia);

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			close();
		}
	}
}