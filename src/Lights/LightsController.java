package Lights;

import Road.RoadModel;

import java.util.*;

public class LightsController {
    List<LightsModel> listOfLights = new ArrayList();

    public LightsController(List<RoadModel> listOfRoadModel) {
        createTrafficLights(listOfRoadModel);
        changeColorOfLights();
    }

    private void createTrafficLightsModels(HashMap<String,Integer> positionOfTrafficLightBox, int rotation, RoadModel roadModel){
        LightsModel lights = new LightsModel(true, positionOfTrafficLightBox, rotation);
        roadModel.setTrafficlights(lights);
        listOfLights.add(lights);
    }

    private void createTrafficLightsView(){

        for (int i = 0; i < listOfLights.size(); i++){
            LightsView lightsView = new LightsView();
            listOfLights.get(i).setLightView(lightsView);
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

            createTrafficLightsModels(downLights,rotation, listOfRoadModel.get(i));
        }

        createTrafficLightsView();
    }
    public void changeColorOfLights(){
        Timer timer = new Timer();

        timer.schedule( new TimerTask() {
            public void run() {
                for (int i = 0; i < listOfLights.size(); i++){
                    listOfLights.get(i).getLightView().setGreenLight();
                    listOfLights.get(i).setGreen(true);
                }
            }
        }, 0, 6000);

        timer.schedule( new TimerTask() {
            public void run() {
                for (int i = 0; i < listOfLights.size(); i++){
                    listOfLights.get(i).getLightView().setRedLight();
                    listOfLights.get(i).setGreen(false);
                }
            }
        }, 3000, 6000);
    }
}
