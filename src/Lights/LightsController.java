package Lights;

import Road.RoadModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LightsController {
    List<LightsModel> listOfLights = new ArrayList();

    public LightsController() {
        createTrafficLights();
    }

    private void createTrafficLightsModels(HashMap<String,Integer> positionOfTrafficLightBox){
        LightsModel lights = new LightsModel(true, positionOfTrafficLightBox);
        listOfLights.add(lights);
    }

    private void createTrafficLightsView(){
        LightsView lightsView = new LightsView();
        for (int i = 0; i < listOfLights.size(); i++){
            lightsView.setGraphicalRepresentationOfTrafficLightsBox(listOfLights.get(i).getTrafficLightsBox());
            lightsView.setGraphicalRepresentationOfTrafficLights(listOfLights.get(i).getRedLight(),listOfLights.get(i).getGreenLight());
        }
    }

    private void createTrafficLights(){
        HashMap<String,Integer> downLights = new HashMap<>();
        downLights.put("x", 500 );
        downLights.put("y", 400);
        downLights.put("h", 30);
        downLights.put("w", 15);

        createTrafficLightsModels(downLights);
        createTrafficLightsView();
    }
}
