package sample;

import Lights.LightsController;
import Road.*;
import Vehicule.CarController;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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

    //half of the variables was private and other half protected, mr JARO pls explain?
    private int endPointXonLeftSideKAROLEKRoad;
    private int endPointXonRightSideJARORoad;
    private int spawnPointOnKAROLEKRoadValueX;
    private int spawnPointOnJARORoadValueX;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StaticMainStage = this.MainStage;

        createRoadController();
        createTrafficLightsController();
        createCarController();

//        moveCars();
        movePlane();
    }

    //main controller - great place for a view and model of a plane (last priority task).
    //After struggling more than a week with MVC architecture i cannot understand why its here.
    //Where is the initalization of the ImageView Plane instance?
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
//    private void moveCars() {
//        for (int i = 0; i < roadController.getListOfRoadModel().size(); i++) {
////            listOFCarModel.get(i).getNameOfRoadWithThisCar();
//            if (roadController.getListOfRoadModel().get(i).getRoadName() == "KAROLEK") {
//                endPointXonLeftSideKAROLEKRoad = roadController.getListOfRoadModel().get(i).getEndPoint().get("x");
//            } else {
//                endPointXonRightSideJARORoad = roadController.getListOfRoadModel().get(i).getEndPoint().get("x");
//            }
//        }
//        carController.moveCars(endPointXonLeftSideKAROLEKRoad, endPointXonRightSideJARORoad);
//
//    }

// THESE ARE THE BEST METHODS SO FAR
    private void createRoadController() {
        RoadController roadController = new RoadController();
        this.roadController = roadController;
    }

    public void createTrafficLightsController(){
        LightsController lightsController = new LightsController(roadController.getListOfRoadModel());
        this.lightsController = lightsController;
    }

    private void createCarController(){
        CarController carController = new CarController(roadController.getEndPointXonLeftSideKAROLEKRoad(), roadController.getEndPointXonRightSideJARORoad());
        this.carController = carController;
    }

}