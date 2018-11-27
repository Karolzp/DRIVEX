package Road;

import Vehicule.Vehicule;
import javafx.scene.shape.Line;
import java.util.HashMap;
import java.util.List;

public class RoadModel {
    private String name;
    private List <Vehicule> CarsOnRoad;
    private Line roadLine;
    private HashMap<String, Integer> spawnpoint;
    private HashMap<String, Integer> endpoint;
    private HashMap<String, Integer> trafficLightsPoint;


    public RoadModel(HashMap<String, Integer> spawnpoint, HashMap<String, Integer> endpoint, HashMap<String, Integer> trafficLightsPoint, String name) {
        this.spawnpoint = spawnpoint;
        this.endpoint = endpoint;
        this.trafficLightsPoint = trafficLightsPoint;
        this.createLine(spawnpoint, endpoint);
        this.name = name;
    }

    public void setCarsOnRoad(List<Vehicule> carsOnRoad) {
        CarsOnRoad = carsOnRoad;
    }

    public List<Vehicule> getCarsOnRoad() {
        return CarsOnRoad;
    }

    public HashMap<String, Integer> getSpawnpoint() {
        return spawnpoint;
    }

    public HashMap<String, Integer> getEndpoint() {
        return endpoint;
    }

    public HashMap<String, Integer> getTrafficLightsPoint() {
        return trafficLightsPoint;
    }

    public Line getRoadLine() {
        return roadLine;
    }

    public String getName() {
        return name;
    }

    private void createLine (HashMap<String, Integer> spawnpoint, HashMap<String, Integer> endpoint) {
        this.roadLine= new Line();
        roadLine.setStartX(spawnpoint.get("x"));
        roadLine.setStartY(spawnpoint.get("y"));
        roadLine.setEndX(endpoint.get("x"));
        roadLine.setEndX(endpoint.get("y"));
    }
}
