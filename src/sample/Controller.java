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
    private int endPointXonLeftSideKAROLEKRoad;
    private int endPointXonRightSideJARORoad;
    protected int spawnPointOnKAROLEKRoadValueX;
    protected int spawnPointOnJARORoadValueX;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StaticMainStage = this.MainStage;
        createRoadController();
        createRoadModels();
        createCarController();
        createCarModels();
        moveCars();
    }

    /**
     * iterates list with road models and based on the name of the road gets its end point
     * then calls the move Cars method in car controller and passes endpoint to this method
     */
    private void moveCars() {
        for (int i = 0; i < roadController.getListOfRoadModel().size(); i++) {
            if (roadController.getListOfRoadModel().get(i).getRoadName() == "KAROLEK") {
                endPointXonLeftSideKAROLEKRoad = roadController.getListOfRoadModel().get(i).getEndPoint().get("x");
            } else {
                endPointXonRightSideJARORoad = roadController.getListOfRoadModel().get(i).getEndPoint().get("x");
            }
        }
        carController.moveCars(endPointXonLeftSideKAROLEKRoad, endPointXonRightSideJARORoad);
    }


    private void createRoadController() {
        RoadController roadController = new RoadController();
        this.roadController = roadController;
    }


    private void createRoadModels(){
        HashMap<String, Integer> spawnPointKAROLEK = new HashMap<>();
        spawnPointKAROLEK.put("x", 950);
        spawnPointOnKAROLEKRoadValueX = spawnPointKAROLEK.get("x");
        spawnPointKAROLEK.put("y", 100);

        HashMap<String, Integer> endPointKAROLEK = new HashMap<>();
        endPointKAROLEK.put("x", 50 );
        endPointKAROLEK.put("y", 100);

        HashMap<String, Integer> trafficLightStopPointKAROLEK = new HashMap<>();
        trafficLightStopPointKAROLEK.put("x", 420);
        trafficLightStopPointKAROLEK.put("y", 100);





        HashMap<String, Integer> spawnPointJARO = new HashMap<>();
        spawnPointJARO.put("x", 50);
        spawnPointOnJARORoadValueX = spawnPointJARO.get("x");
        spawnPointJARO.put("y", 142);

        HashMap<String, Integer> endPointJARO = new HashMap<>();
        endPointJARO.put("x", 950 );
        endPointJARO.put("y", 142);

        HashMap<String, Integer> trafficLightStopPointJARO = new HashMap<>();
        trafficLightStopPointJARO.put("x", 380);
        trafficLightStopPointJARO.put("y", 142);

        roadController.createRoadModel(spawnPointKAROLEK, endPointKAROLEK, trafficLightStopPointKAROLEK, "KAROLEK");
        roadController.createRoadModel(spawnPointJARO, endPointJARO, trafficLightStopPointJARO, "JARO");

        roadController.createRoadView();
    }

    private void createCarController(){
        CarController carController = new CarController();
        this.carController = carController;
    }

    private void createCarModels(){
        carController.createCarModel(2, spawnPointOnKAROLEKRoadValueX, 90, 35, 20, "car1", "normal");
        carController.createCarModel(3, spawnPointOnJARORoadValueX, 132, 35, 20, "car2", "normal");
        carController.createCarView();

    }

}