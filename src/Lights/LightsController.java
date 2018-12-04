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

    private void createTrafficLightsModels(HashMap<String,Integer> positionOfTrafficLightBox, int rotation, RoadModel roadModel){
        LightsModel lights = new LightsModel(true, positionOfTrafficLightBox, rotation);
        roadModel.setTrafficlights(lights);
        listOfLights.add(lights);
    }

    private void createTrafficLightsView(){
        LightsView lightsView = new LightsView();
        for (int i = 0; i < listOfLights.size(); i++){
            lightsView.setGraphicalRepresentationOfTrafficLight(listOfLights.get(i).getTrafficLightsBox(),listOfLights.get(i).getRedLight(),listOfLights.get(i).getGreenLight(), listOfLights.get(i).getRotation());
        }
    }

    private void createTrafficLights(List<RoadModel> listOfRoadModel){
        int height = 30;
        int width = 16;
        int rotation;

        for (int i = 0; i < listOfRoadModel.size(); i++) {
            HashMap<String, Integer> downLights = new HashMap<>();

            if(listOfRoadModel.get(i).getSpawnPoint().get("x")<listOfRoadModel.get(i).getEndPoint().get("x")){
                downLights.put("y", listOfRoadModel.get(i).getTrafficLightStopPoint().get("y")-height/2+40);
                rotation = 90;
            }else{
                downLights.put("y", listOfRoadModel.get(i).getTrafficLightStopPoint().get("y")-height/2-40);
                rotation = 270;
            }

            downLights.put("x", listOfRoadModel.get(i).getTrafficLightStopPoint().get("x")-width/2);
            downLights.put("h", height);
            downLights.put("w", width);

            listOfRoadModel.get(i);
            createTrafficLightsModels(downLights,rotation, listOfRoadModel.get(i));
        }

        createTrafficLightsView();
    }
}
