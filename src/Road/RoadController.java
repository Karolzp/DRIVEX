package Road;

import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RoadController {
    protected static List<RoadModel> listOfRoadModel = new ArrayList<RoadModel>();
    protected List<Line> listOfGraphicalRepresentationOfRoad = new ArrayList<javafx.scene.shape.Line>();
    private int endPointXonLeftSideKAROLEKRoad;
    private int endPointXonRightSideJARORoad;

    public RoadController(){
        createRoads();
    }

    public static List<RoadModel> getListOfRoadModel() {
        return listOfRoadModel;
    }

    public int getEndPointXonLeftSideKAROLEKRoad() {
        return endPointXonLeftSideKAROLEKRoad;
    }

    public int getEndPointXonRightSideJARORoad() {
        return endPointXonRightSideJARORoad;
    }

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
           roadView.setGraphicalRepresentationOfRoad(listOfRoadModel.get(i).getRoadLine(),listOfRoadModel.get(i).getTrafficLightStopPoint());
           this.listOfGraphicalRepresentationOfRoad.add(roadView.getGraphicalRepresentationOfRoad());
        }
    }

    //Great refactor - u missed the last letter in KAROLEK road.
    //Why isnt it a variable?
    //Why didnt you removed the same function from the main controller?
    private void createRoads(){
        HashMap<String, Integer> spawnPointKAROLEK = new HashMap<>();
        spawnPointKAROLEK.put("x", 950);
        spawnPointKAROLEK.put("y", 100);

        HashMap<String, Integer> endPointKAROLEK = new HashMap<>();
        endPointKAROLEK.put("x", 50 );
        this.endPointXonLeftSideKAROLEKRoad = endPointKAROLEK.get("x");
        endPointKAROLEK.put("y", 100);

        HashMap<String, Integer> trafficLightStopPointKAROLEK = new HashMap<>();
        trafficLightStopPointKAROLEK.put("x", 420);
        trafficLightStopPointKAROLEK.put("y", 100);

        HashMap<String, Integer> spawnPointJARO = new HashMap<>();
        spawnPointJARO.put("x", 50);
        spawnPointJARO.put("y", 142);

        HashMap<String, Integer> endPointJARO = new HashMap<>();
        endPointJARO.put("x", 950 );
        this.endPointXonRightSideJARORoad = endPointJARO.get("x");
        endPointJARO.put("y", 142);

        HashMap<String, Integer> trafficLightStopPointJARO = new HashMap<>();
        trafficLightStopPointJARO.put("x", 380);
        trafficLightStopPointJARO.put("y", 142);

        createRoadModel(spawnPointKAROLEK, endPointKAROLEK, trafficLightStopPointKAROLEK, "KAROLEK");
        createRoadModel(spawnPointJARO, endPointJARO, trafficLightStopPointJARO, "JARO");

        createRoadView();

    }
}