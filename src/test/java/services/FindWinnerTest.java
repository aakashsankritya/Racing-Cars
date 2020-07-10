package services;

import beans.Cars;
import beans.ModifiedCar;
import org.junit.Test;
import services.CarTuning;
import services.FindWinner;
import services.ReadCSVFiles;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class FindWinnerTest {

    public static final String TEAMS_CSV = "src/main/resources/Teams.csv";
    public static final String CARS_CSV = "src/main/resources/Cars.csv";
    public static final String PARTS_CSV = "src/main/resources/Parts.csv";

    ReadCSVFiles CSVObject = new ReadCSVFiles(TEAMS_CSV, CARS_CSV, PARTS_CSV);

    List<Cars> carsList = CSVObject.carsList;

    // Object of Service Class.
    CarTuning carTuningObject = new CarTuning();

    // Sort the CARS on the basis of their TOP_SPEED
    List<Cars> carsListSortedByMaxSpeed = carTuningObject.findCarWithMAXSpeed(carsList);

    public FindWinnerTest() throws IOException {
    }

    @Test
    public void findWinnerTest() {
        ModifiedCar winner = FindWinner.findWinner(carsListSortedByMaxSpeed,
                carTuningObject, CSVObject);
        assertNotNull(winner);
    }
}
