package Road;

import java.util.List;
import java.util.HashMap;


public class RoadController {

    List<HashMap> listOfRoadModels;


    public void createRoadModel(HashMap<String, Integer> spawnpoint, HashMap<String, Integer> endpoint, HashMap<String, Integer> trafficLightsPoint, String name) {
        RoadModel roadModel = new RoadModel(spawnpoint, endpoint, trafficLightsPoint, name);
        HashMap<String,RoadModel> myMap = new HashMap<>();
        myMap.put(roadModel.getName(),roadModel);
        listOfRoadModels.add(myMap);
    }

    private void createRoadView(){

    }
}
