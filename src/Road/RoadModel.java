package Road;

import java.util.HashMap;
import java.util.List;

public class RoadModel {
    private List <Vehicule> CarsOnRoad;
    private final HashMap<String, Integer> SPAWNPOINT;
    private final HashMap<String, Integer> ENDPOINT;
    private final HashMap<String, Integer> TRAFFICLIGHTSSTOPPOINT;


    public RoadModel(HashMap<String, Integer> SPAWNPOINT, HashMap<String, Integer> ENDPOINT, HashMap<String, Integer> TRAFFICLIGHTSSTOPPOINT) {
        this.SPAWNPOINT = SPAWNPOINT;
        this.ENDPOINT = ENDPOINT;
        this.TRAFFICLIGHTSSTOPPOINT = TRAFFICLIGHTSSTOPPOINT;
    }

    public void setCarsOnRoad(List<Vehicule> carsOnRoad) {
        CarsOnRoad = carsOnRoad;
    }

    public List<Vehicule> getCarsOnRoad() {
        return CarsOnRoad;
    }

    public HashMap<String, Integer> getSPAWNPOINT() {
        return SPAWNPOINT;
    }

    public HashMap<String, Integer> getENDPOINT() {
        return ENDPOINT;
    }

    public HashMap<String, Integer> getTRAFFICLIGHTSSTOPPOINT() {
        return TRAFFICLIGHTSSTOPPOINT;
    }
}
