package Road;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class RoadController {

    List<RoadModel>listOfRoadModels = new ArrayList<>();
    List<HashMap> listOfRoadViews;


    public void createRoadModel(HashMap<String, Integer> spawnpoint, HashMap<String, Integer> endpoint, HashMap<String, Integer> trafficLightsPoint, String name) {
        RoadModel roadModel = new RoadModel(spawnpoint, endpoint, trafficLightsPoint, name);
        listOfRoadModels.add(roadModel);
    }

    public void createRoadView(){
        RoadView roadView = new RoadView();
        for (int i = 0; i < listOfRoadModels.size() ; i++) {
            roadView.handleRoadView(listOfRoadModels.get(i).getRoadLine());
        }

    }
}
