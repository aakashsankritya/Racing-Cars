package services;

import beans.Cars;
import beans.ModifiedCar;
import beans.Parts;
import beans.Teams;

import org.junit.Test;
import org.mockito.Mock;

import services.CarTuning;
import services.ReadCSVFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarTuningTest {

    public static final String TEAMS_CSV = "src/main/resources/Teams.csv";
    public static final String CARS_CSV = "src/main/resources/Cars.csv";
    public static final String PARTS_CSV = "src/main/resources/Parts.csv";

    @Mock
    ReadCSVFiles CSVFileObject = new ReadCSVFiles(TEAMS_CSV, CARS_CSV, PARTS_CSV);

    @Mock
    List<Parts> partsList = CSVFileObject.partsList;

    @Mock
    List<Teams> teamsList = CSVFileObject.teamsList;

    public CarTuningTest() throws IOException {
    }

    @Test
    public void findMostEfficientPartsTest() {

        Parts p1 = new Parts();
        p1.setPart_list_id("P101");
        p1.setPart_id("P1");
        p1.setPrice(34);
        p1.setSpeed_boost(45);

        Parts p2 = new Parts();
        p2.setPart_list_id("P101");
        p2.setPart_id("P2");
        p2.setPrice(54);
        p2.setSpeed_boost(45);

        List<Parts> origPartList = new ArrayList<>();
        origPartList.add(p1);
        origPartList.add(p2);

        List<Parts> resultPartList = new CarTuning()
                .findMostEfficientParts(origPartList);

        assertEquals(resultPartList.get(0).getPart_id(),
                p1.getPart_id());
    }

    @Test
    public void findCarWithMAXSpeedTest() {
        Cars c1 = new Cars();
        c1.setCar_id("ID_1101");
        c1.setCar_name("MODEL_A1");
        c1.setBase_speed(124);
        c1.setTop_speed(236);
        c1.setPart_list_id("PART55");

        Cars c2 = new Cars();
        c2.setCar_id("ID_1102");
        c2.setCar_name("MODEL_A2");
        c2.setBase_speed(134);
        c2.setTop_speed(236);
        c2.setPart_list_id("PART65");

        List<Cars> origCarList = new ArrayList<>();
        origCarList.add(c1);
        origCarList.add(c2);

        List<Cars> resultCarList = new CarTuning()
                .findCarWithMAXSpeed(origCarList);

        assertEquals(resultCarList.get(0).getCar_id(),
                c2.getCar_id());

    }

    @Test
    public void performModificationTest() {

        Cars c1 = new Cars();
        c1.setCar_id("CARID_2047");
        c1.setCar_name("MODEL_DF178");
        c1.setBase_speed(140);
        c1.setTop_speed(252);
        c1.setPart_list_id("PARTLIST_FCB9B");

        Teams t1 = new Teams();
        t1.setCars("CARID_2047");
        t1.setFunds(32770);
        t1.setTeam_id(2);
        t1.setTeam_name("Mercedes");

        List<Parts> available_parts = new CarTuning()
                .findPartsByPartListID(partsList, c1.getPart_list_id());
        ModifiedCar modifiedCar = new CarTuning().performModification(c1, t1, available_parts);

        assertEquals(c1.getTop_speed(), modifiedCar.getModified_speed());
        assertTrue(t1.getFunds() >= modifiedCar.getFund_spent());
        assertEquals(t1.getTeam_name(), modifiedCar.getTeam_name());

    }

    @Test
    public void findPartsByPartListIDTest() {
        // In the input Parts.csv file we have total of 61 parts
        // named as below part_list_id.

        String part_list_id = "PARTLIST_5E6B2";
        List<Parts> resultListOfParts = new CarTuning()
                .findPartsByPartListID(partsList, part_list_id);

        assertEquals(61, resultListOfParts.size());
    }

    @Test
    public void findTeamByCarIDTest() {
        // The car with below car_id belongs to the
        // TEAM of WILLIAMS.
        String car_id = "CARID_5943";

        Teams actual_teams = new CarTuning().findTeamByCarID(teamsList, car_id);

        assertEquals("Williams", actual_teams.getTeam_name());
    }

}
