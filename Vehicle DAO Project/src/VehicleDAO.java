import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleDAO {

	private static Connection getDBConnection() { //Start a connection to SQLite Database
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			String url = "jdbc:sqlite:vehicles.sqlite";
			connection = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return connection;
	}

	public ArrayList<Vehicle> getAllVehicles() throws SQLException { //Method for retrieving all vehicles from the database
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		String query = "SELECT * FROM vehicles;";

		ArrayList<Vehicle> vehicles = new ArrayList<>();
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			resultset = statement.executeQuery(query); // execute SQL query
			while (resultset.next()) {
				int vehicle_id = resultset.getInt("vehicle_id");
				String make = resultset.getString("make");
				String model = resultset.getString("model");
				int year = resultset.getInt("year");
				int price = resultset.getInt("price");
				String license_number = resultset.getString("license_number");
				String colour = resultset.getString("colour");
				int number_doors = resultset.getInt("number_doors");
				String transmission = resultset.getString("transmission");
				int mileage = resultset.getInt("mileage");
				String fuel_type = resultset.getString("fuel_type");
				int engine_size = resultset.getInt("engine_size");
				String body_style = resultset.getString("body_style");
				String condition = resultset.getString("condition");
				String notes = resultset.getString("Notes");
				vehicles.add(new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return vehicles;
	}

	public void getVehicle(int vehicle_id) throws SQLException { //Method for retrieving a vehicle from the database
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		String query = "SELECT * FROM vehicles WHERE vehicle_id = " + vehicle_id + ";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				System.out.println(resultset.getString("vehicle_id") + " " + resultset.getString("make") + " "
						+ resultset.getString("model") + " " + resultset.getString("year") + " "
						+ resultset.getString("price") + " " + resultset.getString("license_number") + " "
						+ resultset.getString("colour") + " " + resultset.getString("number_doors") + " "
						+ resultset.getString("transmission") + " " + resultset.getString("mileage") + " "
						+ resultset.getString("fuel_type") + " " + resultset.getString("engine_size") + " "
						+ resultset.getString("body_style") + " " + resultset.getString("condition") + " "
						+ resultset.getString("Notes"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	public void deleteVehicle(int vehicle_id) throws SQLException {//Method for deleting a vehicle from the database
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		String query = "DELETE FROM vehicles WHERE vehicle_id = " + vehicle_id + ";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				System.out.println(resultset.getString("vehicle_id") + " " + resultset.getString("make") + " "
						+ resultset.getString("model") + " " + resultset.getString("year") + " "
						+ resultset.getString("price") + " " + resultset.getString("license_number") + " "
						+ resultset.getString("colour") + " " + resultset.getString("number_doors") + " "
						+ resultset.getString("transmission") + " " + resultset.getString("mileage") + " "
						+ resultset.getString("fuel_type") + " " + resultset.getString("engine_size") + " "
						+ resultset.getString("body_style") + " " + resultset.getString("condition") + " "
						+ resultset.getString("Notes"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	public void insertVehicle(int vehicle_id, String make, String model, int year, int price, String license_number,
			String colour, int number_doors, String transmission, int mileage, String fuel_type, int engine_size,
			String body_style, String condition, String notes) throws SQLException { //method for inserting vehicle into the database
		Connection dbConnection = null;
		Statement statement = null;
		String query = "INSERT INTO vehicles (vehicle_id, make, model, year, price, license_number, colour, "
				+ "number_doors, transmission, mileage, fuel_type, engine_size, body_style, "
				+ "condition, Notes) VALUES (" + vehicle_id + ", '" + make + "', '" + model + "', " + year + ", "
				+ price + ", '" + license_number + "', '" + colour + "', " + number_doors + ", '" + transmission + "', "
				+ mileage + ", '" + fuel_type + "', " + engine_size + ", '" + body_style + "', '" + condition + "', '" + notes + "'"
				+ ");";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				getVehicle(vehicle_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateVehicle(int vehicle_id, String make, String model, int year, int price, String license_number,
			String colour, int number_doors, String transmission, int mileage, String fuel_type, int engine_size,
			String body_style, String condition, String notes) throws SQLException { //method for inserting vehicle into the database
		Connection dbConnection = null;
		Statement statement = null;
		String query = "UPDATE vehicles SET vehicle_id = " + vehicle_id + ", make = " + make + ", model = "
				 + model + ", year = " + year + ", price = " + price + ", license_number = " + license_number + ", colour = "
				 + colour + ", number_doors = " + number_doors + ", transmission = " + transmission + ", mileage = "
				 + mileage + ", fuel_type = " + fuel_type + ", engine_size = " + engine_size + ", body_style = "
				 + body_style + ", condition = " + condition + ", notes = " + notes + ";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				getVehicle(vehicle_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

//Mohammad Abdullah Iqbal, 17024135