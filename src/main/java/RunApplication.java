import beans.Cars;
import services.CarTuning;
import services.FindWinner;
import services.ReadCSVFiles;

import java.io.IOException;
import java.util.List;

public class RunApplication {

    // Paths to input files.
    public static final String TEAMS_CSV = "src/main/resources/Teams.csv";
    public static final String CARS_CSV = "src/main/resources/Cars.csv";
    public static final String PARTS_CSV = "src/main/resources/Parts.csv";

    public static void main(String[] args) throws IOException {

        // Parsing CSV files into JAVA Beans
        ReadCSVFiles CSVObject = new ReadCSVFiles(TEAMS_CSV, CARS_CSV, PARTS_CSV);

        List<Cars> carsList = CSVObject.carsList;

        // Object of Service Class.
        CarTuning carTuningObject = new CarTuning();

        // Sort the CARS on the basis of their TOP_SPEED
        List<Cars> carsListSortedByMaxSpeed = carTuningObject.findCarWithMAXSpeed(carsList);

        // Find the winner
        FindWinner.findWinner(carsListSortedByMaxSpeed, carTuningObject, CSVObject);
    }
}