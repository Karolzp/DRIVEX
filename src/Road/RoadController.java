package Road;

import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RoadController {

    protected List<RoadModel> listOfRoadModel = new ArrayList<RoadModel>();

    protected List<Object> listOfGraphicalRepresentationOfRoad;



    /**
     * creates roadModel based on the given attributes...
     * ...and then...
     * adds roadModel to List
     * @param spawnPoint
     * @param endPoint
     * @param trafficLightStopPoint
     * @param roadName
     */
    public void createRoadModel(HashMap<String, Integer> spawnPoint, HashMap<String, Integer> endPoint, HashMap<String, Integer> trafficLightStopPoint, String roadName){
      RoadModel roadModel = new RoadModel(spawnPoint, endPoint, trafficLightStopPoint, roadName);
      listOfRoadModel.add(roadModel);
    }


    /**
     creates roadViews based on the objects in listOfRoadModel
     * ...and then...
     * adds each roadView to List
     */
    public void createRoadView(){
      RoadView roadView = new RoadView();
        for (int i = 0; i < listOfRoadModel.size(); i++){
           roadView.setGraphicalRepresentationOfRoad(listOfRoadModel.get(i).getRoadLine());
//           this.listOfGraphicalRepresentationOfRoad.add(roadView.getGraphicalRepresentationOfRoad());
            System.out.println(listOfGraphicalRepresentationOfRoad);
        }
    }

}
