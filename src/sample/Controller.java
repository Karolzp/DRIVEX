package sample;

import Lights.LightsController;
import Road.*;
import Vehicule.CarController;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Pane MainStage;
    public static Pane StaticMainStage;
    private RoadController roadController;

    private LightsController lightsController;

    private CarController carController;
    public ImageView plane;
    private int endPointXonLeftSideKAROLEKRoad;
    private int endPointXonRightSideJARORoad;
    protected int spawnPointOnKAROLEKRoadValueX;
    protected int spawnPointOnJARORoadValueX;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StaticMainStage = this.MainStage;
        createRoadController();

        createTrafficLightsController();

        createCarController();
        createCarModels();
        moveCars();
        movePlane();
    }


    /**
     * sets transitions for plane and then plays the animation of the plane in VIEW JAVA FX
     */
    private void movePlane(){

        /* moves plane on the runway*/
        TranslateTransition runWayStartTransition = new TranslateTransition();
        runWayStartTransition.setDuration(Duration.seconds(3));
        runWayStartTransition.setToX(-180);
        runWayStartTransition.setNode(plane);

        /* makes the plane x3 bigger */
        ScaleTransition scaleBigger = new ScaleTransition();
        scaleBigger.setDuration(Duration.seconds(5));
        scaleBigger.setToX(3);
        scaleBigger.setToY(3);
        scaleBigger.setNode(plane);

        /* moves plane further to left after leaving runway*/
        TranslateTransition flyFromRunWayTransition = new TranslateTransition();
        flyFromRunWayTransition.setDuration(Duration.seconds(7));
        flyFromRunWayTransition.setToX(-1000);
        flyFromRunWayTransition.setNode(plane);

        SequentialTransition sequentialTransition = new SequentialTransition();
        ParallelTransition parallelTransitionTakeOff = new ParallelTransition(scaleBigger, flyFromRunWayTransition);

        sequentialTransition.getChildren().addAll(
                runWayStartTransition,
                parallelTransitionTakeOff
        );
        sequentialTransition.play();
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

    public void createTrafficLightsController(){
        LightsController lightsController = new LightsController(roadController.getListOfRoadModel());
        this.lightsController = lightsController;
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
        trafficLightStopPointKAROLEK.put("x", 380);
        trafficLightStopPointKAROLEK.put("y", 100);





        HashMap<String, Integer> spawnPointJARO = new HashMap<>();
        spawnPointJARO.put("x", 50);
        spawnPointOnJARORoadValueX = spawnPointJARO.get("x");
        spawnPointJARO.put("y", 142);

        HashMap<String, Integer> endPointJARO = new HashMap<>();
        endPointJARO.put("x", 950 );
        endPointJARO.put("y", 142);

        HashMap<String, Integer> trafficLightStopPointJARO = new HashMap<>();
        trafficLightStopPointJARO.put("x", 420);
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
        carController.createCarModel(2, roadController.getListOfRoadModel().get(0).getSpawnPoint().get("x"), 90, 35, 20, "car1", "normal");
        carController.createCarModel(3, roadController.getListOfRoadModel().get(1).getSpawnPoint().get("x"), 132, 35, 20, "car2", "normal");
        carController.createCarView();

    }


}