package Road;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.StrokeType;
import sample.Controller;

import java.util.HashMap;


public class RoadView {
    private final int roadWidth = 40;
    private String pathToTunnelImage = "Road/RoadResources/tunnel.png";
    private Image tunnelImage = new Image(pathToTunnelImage);
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
//        setTunnels();
    }

    private void setTunnels(){
        ImageView tunnelLeft = new ImageView(tunnelImage);
        tunnelLeft.setFitHeight(200);
        tunnelLeft.setPreserveRatio(true);
        tunnelLeft.setViewOrder(-2);
        tunnelLeft.setRotate(-30);
        tunnelLeft.setX(graphicalRepresentationOfRoad.getEndX()- 50);
        tunnelLeft.setY(graphicalRepresentationOfRoad.getEndY() - 110);
        if(tunnelLeft.getX() > 500){
            tunnelLeft.setScaleX(-1);
            tunnelLeft.setRotate(60);
            tunnelLeft.setY(graphicalRepresentationOfRoad.getEndY()- 130);
            tunnelLeft.setX(graphicalRepresentationOfRoad.getEndX()- 100);
            tunnelLeft.setScaleX(-1);

        }
        Controller.StaticMainStage.getChildren().add(tunnelLeft);
    }


    public Line getGraphicalRepresentationOfRoad() {
        return graphicalRepresentationOfRoad;
    }
}