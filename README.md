**Racing Cars**

`Goal:`

To build a project which follows Object Oriented Modelling and 
Good Design principle.

`Getting Started:`

This project uses Gradle as a build-tool along with dependencies such as:

    i. JUnit 4.12 - for testing purposes.
    ii. Mockito 2.7 - mocking framework for unit test in Java.
    iii. OpenCsv 5.2 - for parsing the input CSV files.



`Project Structure`

1. `src package:` 

    `RunAppplication.java` - The main class which calls methods from different 
    mapped classes to find the winner.

2. `dto package:`
    This package includes Beans classes which were used to parse CSV files.
    
    `Cars.java` - Bean class to parse Cars.csv.
    
    `Parts.java` - Bean class to parse Parts.csv.
    
    `Teams.java` - Bean class to parse Teams.csv.
    
    `ModifiedCar.java` - to keep track of modified cars.
    
3. `services package` This package includes classes which is used for modifying 
racing cars depending on their parts availability.

    `CarTuning.java` - This class includes methods which were used to find the 
    most efficient parts for a particular racing car.
    
    `FindWinner.java` - This class implements utility method which performs 
    logic to find the winner team.
    
    `ReadCSVFiles.java` - This class is used to parse different csv into 
    Java Beans.
    
4. `rsources:` - This package includes the resources such as the required csv 
files.



`Testing:`

For the purpose of testing this project includes 2 test classes which are:
        
        i. CarTuningTest - for testing the methods of CarTuning Class.
        
        ii. FindWinnerTest - for testing the methods of FindWinner Class.
        






    