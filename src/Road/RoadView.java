package Road;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import sample.Controller;


public class RoadView {
    private final int roadWidth = 40;
    private Line graphicalRepresentationOfRoad;
    private final Color ROADCOLOR = Color.DIMGRAY;

    public void setGraphicalRepresentationOfRoad(Line graphicalRepresentationOfRoad) {
        this.graphicalRepresentationOfRoad = graphicalRepresentationOfRoad;
        this.graphicalRepresentationOfRoad.setStrokeWidth(roadWidth);
        this.graphicalRepresentationOfRoad.setFill(ROADCOLOR);
        Controller.StaticMainStage.getChildren().add(this.graphicalRepresentationOfRoad);
    }

    public Line getGraphicalRepresentationOfRoad() {
        return graphicalRepresentationOfRoad;
    }
}
