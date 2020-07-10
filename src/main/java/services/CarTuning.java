package services;

import beans.Cars;
import beans.ModifiedCar;
import beans.Parts;
import beans.Teams;

import java.util.ArrayList;
import java.util.List;

public class CarTuning {

    /**
     * This function return List of parts with most efficient at TOP.
     *
     * @param partsList
     * @return List<Parts>
     */
    public List<Parts> findMostEfficientParts(List<Parts> partsList) {

        partsList.sort((p1, p2) -> {
            if (p1.getSpeed_boost() == p2.getSpeed_boost())
                return Integer.compare(p1.getPrice(), p2.getPrice());
            else
                return Integer.compare(p2.getSpeed_boost(), p1.getSpeed_boost());
        });
        return partsList;
    }

    /**
     * This function sort the CarsList by their TOP SPEED.
     *
     * @param carsList
     * @return List<Cars>
     */
    public List<Cars> findCarWithMAXSpeed(List<Cars> carsList) {
        carsList.sort((c1, c2) -> {
            if (c1.getTop_speed() == c2.getTop_speed())
                return Integer.compare(c2.getBase_speed(), c1.getBase_speed());
            else
                return Integer.compare(c2.getTop_speed(), c1.getTop_speed());
        });
        return carsList;
    }


    /**
     * Used to modify the car as per it's Parts Availability
     *
     * @param currentCar
     * @param currentTeam
     * @param available_parts
     * @return ModifiedCar
     */
    public ModifiedCar performModification(Cars currentCar, Teams currentTeam, List<Parts> available_parts) {

        int money_spent = 0;
        // SORT the Parts available depending upon their SPEED_BOOST.
        available_parts = findMostEfficientParts(available_parts);

        int modified_speed = currentCar.getBase_speed();
        int top_speed = currentCar.getTop_speed();

        int partCounter = 0;

        // Adding Values to Winner.

        List<Parts> parts_used = new ArrayList<>();

        // Modifying Car
        while (money_spent <= currentTeam.getFunds() && partCounter < available_parts.size()) {
            if (modified_speed >= top_speed) {
                modified_speed = top_speed;
                break;
            }
            // Get the most efficient part available.
            Parts mostEfficientPart = available_parts.get(partCounter);
            // Speed Up the Car
            modified_speed += mostEfficientPart.getSpeed_boost();
            // Increment the FUNDS SPENT
            money_spent += mostEfficientPart.getPrice();
            // Add parts to the used list.
            parts_used.add(mostEfficientPart);

            partCounter++;
        }

        return new ModifiedCar(currentCar.getCar_id(), currentTeam.getTeam_name(),
                modified_speed, money_spent, parts_used);
    }


    /**
     * function to filter out the PART By part_list_id in PartsList
     *
     * @param partsList
     * @param part_list_id
     * @return List<Parts>
     */
    public List<Parts> findPartsByPartListID(List<Parts> partsList, String part_list_id) {
        List<Parts> resultPartsList = new ArrayList<>();

        for (Parts p : partsList) {
            if (p.getPart_list_id().equals(part_list_id))
                resultPartsList.add(p);
            else if (resultPartsList.size() > 0)
                break;
        }
        return resultPartsList;
    }


    /**
     * To find out the team of specific car
     *
     * @param teamsList
     * @param car_id
     * @return
     */
    public Teams findTeamByCarID(List<Teams> teamsList, String car_id) {
        for (Teams t : teamsList) {
            if (t.getCars().equals(car_id))
                return t;
        }
        return null;
    }
}
