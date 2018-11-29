package sample;

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
    private CarController carController;
    public ImageView plane;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StaticMainStage = this.MainStage;
        createRoadController();
        createRoadModels();
        createCarController();
        createCarModels();
        moveCarLeft();
        movePlane();
    }

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



    private void moveCarRight() {
//        int actualPositionX = carController.getListOFCarModel().get(0).getPositionX();
//        car
    }

    public void moveCarLeft(){
        for(int i = 0; i < 100; i++) {
            int actualPositionX = carController.getListOFCarModel().get(0).getPositionX();
            int endPointX = roadController.getListOfRoadModel().get(0).getEndPoint().get("x");
            carController.moveLeft(actualPositionX, endPointX);
        }
    }


    private void createRoadController() {
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

    private void createCarController(){
        CarController carController = new CarController();
        this.carController = carController;
    }

    private void createCarModels(){
        carController.createCarModel(10, 920, 90, 35, 20, "car1", "normal");
        carController.createCarModel(10, 50, 132, 35, 20, "car2", "normal");
        carController.createCarView();

    }

}