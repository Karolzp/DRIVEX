package Lights;

import Road.RoadModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LightsController {
    List<LightsModel> listOfLights = new ArrayList();

    public LightsController(List<RoadModel> listOfRoadModel) {
        createTrafficLights(listOfRoadModel);
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

    private void createTrafficLights(List<RoadModel> listOfRoadModel){

        for (int i = 0; i < listOfRoadModel.size(); i++) {
            HashMap<String, Integer> downLights = new HashMap<>();
            downLights.put("x", listOfRoadModel.get(i).getTrafficLightStopPoint().get("x")-8);
            downLights.put("y", listOfRoadModel.get(i).getTrafficLightStopPoint().get("y")-15);
            downLights.put("h", 30);
            downLights.put("w", 16);

            createTrafficLightsModels(downLights);
        }

        createTrafficLightsView();
    }
}
