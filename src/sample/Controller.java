package sample;

import Lights.LightsController;
import Road.*;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Pane MainStage;
    public static Pane StaticMainStage;
    private RoadController roadController;
    private LightsController lightsController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StaticMainStage = this.MainStage;
        createRoadController();
        createTrafficLightsController();
    }


    public void createRoadController() {
        RoadController roadController = new RoadController();
        this.roadController = roadController;
    }

    public void createTrafficLightsController(){
        LightsController lightsController = new LightsController();
        this.lightsController = lightsController;
    }



}