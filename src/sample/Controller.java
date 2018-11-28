package sample;

import Road.*;
import Vehicule.CarController;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Pane MainStage;
    public static Pane StaticMainStage;
    private RoadController roadController;
    private CarController carController;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StaticMainStage = this.MainStage;
        createRoadController();
        createRoadModels();
        createCarController();
        createCarModels();
    }



    public void createRoadController() {
        RoadController roadController = new RoadController();
        this.roadController = roadController;
    }


    private void createRoadModels(){
        HashMap<String, Integer> spawnPointKAROLEK = new HashMap<>();
        spawnPointKAROLEK.put("x", 950);
        spawnPointKAROLEK.put("y", 100);

        HashMap<String, Integer> endPointKAROLEK = new HashMap<>();
        endPointKAROLEK.put("x", 50 );
        endPointKAROLEK.put("y", 100);

        HashMap<String, Integer> trafficLightStopPointKAROLEK = new HashMap<>();
        trafficLightStopPointKAROLEK.put("x", 420);
        trafficLightStopPointKAROLEK.put("y", 100);





        HashMap<String, Integer> spawnPointJARO = new HashMap<>();
        spawnPointJARO.put("x", 50);
        spawnPointJARO.put("y", 142);

        HashMap<String, Integer> endPointJARO = new HashMap<>();
        endPointJARO.put("x", 950 );
        endPointJARO.put("y", 142);

        HashMap<String, Integer> trafficLightStopPointJARO = new HashMap<>();
        trafficLightStopPointJARO.put("x", 380);
        trafficLightStopPointJARO.put("y", 142);

        roadController.createRoadModel(spawnPointKAROLEK, endPointKAROLEK, trafficLightStopPointKAROLEK, "KAROLE");
        roadController.createRoadModel(spawnPointJARO, endPointJARO, trafficLightStopPointJARO, "JARO");

        roadController.createRoadView();
    }

    public void createCarController(){
        CarController carController = new CarController();
        this.carController = carController;
    }

    private void createCarModels(){
        carController.createCarModel(10, 920, 90, 35, 20, "car1", "normal");
        carController.createCarModel(10, 50, 132, 35, 20, "car1", "normal");
        carController.createCarView();

    }

}