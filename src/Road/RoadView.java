package Road;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.StrokeType;
import sample.Controller;

import java.util.HashMap;


public class RoadView {
    private final int roadWidth = 40;
    private Line graphicalRepresentationOfRoad;
    private final Color ROADCOLOR = Color.DIMGRAY;


    public void setGraphicalRepresentationOfRoad(Line graphicalRepresentationOfRoad, HashMap<String, Integer> trafficLightStopPoint) {
        this.graphicalRepresentationOfRoad = graphicalRepresentationOfRoad;
        this.graphicalRepresentationOfRoad.setStrokeWidth(roadWidth);
        this.graphicalRepresentationOfRoad.setFill(ROADCOLOR);
        Line stopLine = new Line();
        stopLine.setStroke(Color.WHITE);
        stopLine.setStartX(trafficLightStopPoint.get("x"));
        stopLine.setEndX(trafficLightStopPoint.get("x"));
        stopLine.setStartY(trafficLightStopPoint.get("y")-20);
        stopLine.setEndY(trafficLightStopPoint.get("y")+20);
//        stopLine.setViewOrder(2);
        Controller.StaticMainStage.getChildren().add(this.graphicalRepresentationOfRoad);
        Controller.StaticMainStage.getChildren().add(stopLine);
    }

    public Line getGraphicalRepresentationOfRoad() {
        return graphicalRepresentationOfRoad;
    }
}