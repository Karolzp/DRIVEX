package sample;

import Road.RoadController;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Pane MainStage;
    public static Pane StaticMainStage;
    private RoadController roadController;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StaticMainStage = this.MainStage;

        this.createRoadsController();
        this.createRoads();


    }

    private void createRoadsController() {
        RoadController roadController = new RoadController();
        this.roadController = roadController;
    }



    private void createRoads() {
        HashMap spawnpointKAROLEK = new HashMap<String, Integer>();
        spawnpointKAROLEK.put("x",0);
        spawnpointKAROLEK.put("y", 400);
        HashMap endpointKAROLEK = new HashMap<String, Integer>();
        endpointKAROLEK.put("x",1000);
        endpointKAROLEK.put("y", 400);
        HashMap trafficLightsPointKAROLEK = new HashMap<String, Integer>();
        trafficLightsPointKAROLEK.put("x",400);
        trafficLightsPointKAROLEK.put("y", 400);
        String nameKAROLEK = "KAROLEK";

        HashMap spawnpointJARO = new HashMap<String, Integer>();
        spawnpointJARO.put("x",0);
        spawnpointJARO.put("y", 350);
        HashMap endpointJARO = new HashMap<String, Integer>();
        endpointJARO.put("x",1000);
        endpointJARO.put("y", 350);
        HashMap trafficLightsPointJARO = new HashMap<String, Integer>();
        trafficLightsPointJARO.put("x",400);
        trafficLightsPointJARO.put("y", 350);
        String nameJARO = "JARO";



        roadController.createRoadModel(spawnpointKAROLEK, endpointKAROLEK,trafficLightsPointKAROLEK, nameKAROLEK);
        roadController.createRoadModel(spawnpointJARO, endpointJARO,trafficLightsPointJARO, nameJARO);

        roadController.createRoadView();
    }


}
