package Road;

import javafx.scene.shape.Line;

import java.util.HashMap;

public class RoadView {
    private final int roadWidth = 40;
    private Line graphicalRepresentationOfRoad;

    public RoadView(HashMap<String, Integer> spawnPoint, HashMap<String, Integer> endPoint){
//        TODO
//        it will call the crrwteList method
    }



    private createLine (HashMap<String, Integer> spawnPoint, HashMap<String, Integer> endPoint) {
        Line line = new Line();
        line.setStartX(spawnPoint.get("x"));
        line.setStartY(spawnPoint.get("y"));
        line.setEndX(endPoint.get("x"));
        line.setEndX(endPoint.get("y"));
    }
}
