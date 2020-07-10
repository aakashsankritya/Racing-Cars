package services;

import beans.Cars;
import beans.ModifiedCar;
import beans.Parts;
import beans.Teams;

import java.util.List;
import java.util.PriorityQueue;

public class FindWinner {

    /**
     * The utility function to find the winner of virtual race
     *
     * @param carsListSortedByMaxSpeed
     * @param carTuningObject
     * @param CSVObject
     */
    public static ModifiedCar findWinner(List<Cars> carsListSortedByMaxSpeed, CarTuning carTuningObject,
                                         ReadCSVFiles CSVObject) {

        // PriorityQueue to keep track of the winning car.
        PriorityQueue<ModifiedCar> modifiedCarPriorityQueue =
                new PriorityQueue<>((modifiedCar1, modifiedCar2) -> {

            if (modifiedCar1.getModified_speed() == modifiedCar2.getModified_speed())
                return Integer.compare(modifiedCar1.getFund_spent(), modifiedCar2.getFund_spent());
            else
                return Integer.compare(modifiedCar2.getModified_speed(), modifiedCar1.getModified_speed());
        });

        // Traverse the carsListSortedByMaxSpeed
        for (Cars currCar : carsListSortedByMaxSpeed) {
            Teams currTeam = carTuningObject
                    .findTeamByCarID(CSVObject.teamsList, currCar.getCar_id());

            List<Parts> available_parts = carTuningObject
                    .findPartsByPartListID(CSVObject.partsList, currCar.getPart_list_id());

            ModifiedCar modifiedCar = carTuningObject
                    .performModification(currCar, currTeam, available_parts);

            // Add the Modified Car into PriorityQueue.
            modifiedCarPriorityQueue.add(modifiedCar);
        }

        // PRINT_THE_WINNER. i.e CAR at the Peek of PriorityQueue.
        ModifiedCar winnerCar = modifiedCarPriorityQueue.peek();
        printWinner(winnerCar);

        return winnerCar;
    }

    /**
     * Utility method to print the winner details
     *
     * @param winner
     */
    public static void printWinner(ModifiedCar winner) {
        System.out.println("Winner");
        System.out.println("========");
        System.out.println("Team:");
        System.out.println(winner.getTeam_name());
        System.out.println();
        System.out.println("Car:");
        System.out.println(winner.getCar_id());
        System.out.println("Speed Achieved:");
        System.out.println(winner.getModified_speed());
        System.out.println();
        System.out.println("Funds spent:");
        System.out.println(winner.getFund_spent());
        System.out.println();
        System.out.println("Parts");
        for (Parts p : winner.getParts_added()) {
            System.out.println(p.getPart_id());
        }
    }
}
