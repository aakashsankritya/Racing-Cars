package services;

import com.opencsv.bean.CsvToBeanBuilder;
import beans.Cars;
import beans.Parts;
import beans.Teams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ReadCSVFiles {

    public List<Teams> teamsList;
    public List<Cars> carsList;
    public List<Parts> partsList;


    /**
     * This constructor will instantiate an Object of the three input list
     *
     * @param teamsCSV
     * @param carsCSV
     * @param partsCSV
     * @throws IOException
     */
    public ReadCSVFiles(String teamsCSV, String carsCSV, String partsCSV) throws IOException {

        teamsList = new CsvToBeanBuilder<Teams>(new InputStreamReader(new FileInputStream(teamsCSV)))
                .withType(Teams.class).build().parse();

        carsList = new CsvToBeanBuilder<Cars>(new InputStreamReader(new FileInputStream(carsCSV)))
                .withType(Cars.class).build().parse();

        partsList = new CsvToBeanBuilder<Parts>(new InputStreamReader(new FileInputStream(partsCSV)))
                .withType(Parts.class).build().parse();

    }
}
