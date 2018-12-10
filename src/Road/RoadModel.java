package Road;

import Lights.LightsModel;
import Vehicle.Vehicle;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoadModel {
    private String roadName;
    private List <Vehicle> carsOnRoad = new ArrayList<Vehicle>();
    private HashMap<String, Integer> spawnPoint;
    private HashMap<String, Integer> endPoint;
    private HashMap<String, Integer> trafficLightStopPoint;
    private Line roadLine;
    private LightsModel trafficlights;


/* constructor */
    public RoadModel(HashMap<String, Integer> spawnPoint, HashMap<String, Integer> endPoint, HashMap<String, Integer> trafficLightStopPoint, String roadName) {
        this.roadName = roadName;
        this.spawnPoint = spawnPoint;
        this.endPoint = endPoint;
        this.trafficLightStopPoint = trafficLightStopPoint;
        this.createRoadLine(spawnPoint, endPoint);
        addCarToListOfCarsOnRoad(null);
    }


    public String getRoadName() {
        return roadName;
    }

    public void addCarToListOfCarsOnRoad(Vehicle car) {
        this.carsOnRoad.add(car);
    }

    public List<Vehicle> getCarsOnRoad() {
        return carsOnRoad;
    }

    public HashMap<String, Integer> getSpawnPoint() {
        return spawnPoint;
    }

    public HashMap<String, Integer> getEndPoint() {
        return endPoint;
    }

    public HashMap<String, Integer> getTrafficLightStopPoint() {
        return trafficLightStopPoint;
    }

    public Line getRoadLine() {
        return roadLine;
    }

    public void setTrafficlights(LightsModel trafficlight) {

        this.trafficlights = trafficlight;
    }

    public LightsModel getTrafficlights() {
        return trafficlights;
    }

    /**
     creates roadLine. Starting point is spawnPoint X and Y. Ending point is endPoint X and Y.
     * @param spawnPoint
     * @param endPoint
     */
    private void createRoadLine (HashMap<String, Integer> spawnPoint, HashMap<String, Integer> endPoint) {
        this.roadLine = new Line();
        roadLine.setStartX(spawnPoint.get("x"));
        roadLine.setStartY(spawnPoint.get("y"));
        roadLine.setEndX(endPoint.get("x"));
        roadLine.setEndY(endPoint.get("y"));
    }
}