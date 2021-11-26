import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	

	
	public static void main(String[] args) {
		int insertVehicleID;
		String insertMake;
		String insertModel;
		int insertYear;
		int insertPrice;
		String insertLicense_number;
		String insertColour;
		int insertNumber_doors;
		String insertTransmission;
		int insertMileage;
		String insertFuel_type;
		int insertEngine_size;
		String insertBody_style;
		String insertCondition;
		String insertNotes;
		
		VehicleDAO dao = new VehicleDAO();
		Scanner in = new Scanner(System.in);
		menu(); //Initiates the menu system
		try {
			switch(in.nextInt()) {
			case 1: //Retrieve all vehicles
				System.out.println("Retrieving all vehicles: ");
				ArrayList<Vehicle> allVehicles = null;
				allVehicles = dao.getAllVehicles();
				for(Vehicle v : allVehicles) {
					System.out.println("---------------------");
					System.out.println(v);
				}
				break;
			case 2: //Retrieve a vehicle using Vehicle ID
				System.out.println("Please type a Vehicle ID > ");
				dao.getVehicle(in.nextInt());
				menu();
				break;
			case 3: //Delete a vehicle using Vehicle ID
				System.out.println("Please type a Vehicle ID > ");
				dao.deleteVehicle(in.nextInt());
				System.out.println("Vehicle has been deleted from the database");
			case 4: //Insert a vehicle
				System.out.println("Insert Vehicle ID > ");
				insertVehicleID = Integer.parseInt(in.next());
				System.out.println("Insert Make > ");
				insertMake = in.next();
				System.out.println("Insert Model > ");
				insertModel = in.next();
				System.out.println("Insert Year > ");
				insertYear = Integer.parseInt(in.next());
				System.out.println("Insert Price > ");
				insertPrice = Integer.parseInt(in.next());
				System.out.println("Insert Licence Number > ");
				insertLicense_number = in.next();
				System.out.println("Insert Colour > ");
				insertColour = in.next();
				System.out.println("Insert Number of Doors > ");
				insertNumber_doors = Integer.parseInt(in.next());
				System.out.println("Insert Transmission > ");
				insertTransmission = in.next();
				System.out.println("Insert Mileage > ");
				insertMileage = Integer.parseInt(in.next());
				System.out.println("Insert Fuel Type > ");
				insertFuel_type = in.next();
				System.out.println("Insert Engine Size > ");
				insertEngine_size = Integer.parseInt(in.next());
				System.out.println("Insert Body Style > ");
				insertBody_style = in.next();
				System.out.println("Insert Condition > ");
				insertCondition = in.next();
				System.out.println("Insert Notes > ");
				insertNotes = in.next();
				dao.insertVehicle(insertVehicleID, insertMake, insertModel, insertYear, insertPrice, insertLicense_number, insertColour, insertNumber_doors, insertTransmission, insertMileage, insertFuel_type, insertEngine_size, insertBody_style, insertCondition, insertNotes);
				System.out.println("Vehicle has been inserted into the database");
				break;
			case 5: //Update a vehicle
				System.out.println("Please type a Vehicle ID > ");
				insertMake = in.next();
			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void menu() { //Menu
	    System.out.println("------------------------");
		System.out.println("Vehicle Inventory System");
		System.out.println("Choose from the options below");
		System.out.println("------------------------");
		System.out.println("1 - Retrieve all vehicles");
		System.out.println("2 - Search for vehicle");
		System.out.println("3 - Delete vehicle from database");
		System.out.println("4 - Insert vehicle into database");
		System.out.println("Enter choice > ");
	}

}

//Mohammad Abdullah Iqbal, 17024135