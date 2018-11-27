package Road;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import sample.Controller;

public class RoadView {
    private final int roadWidth = 40;
    private Line graphicalRepresentationOfRoad;
    private final Color roadColor = Color.DIMGRAY;


    public void handleRoadView(Line graphicalRepresentationOfRoad) {
        this.graphicalRepresentationOfRoad = graphicalRepresentationOfRoad;
        this.setFill();
        this.setWidth();
        this.addToScene();
    }

    private void setWidth(){
        this.graphicalRepresentationOfRoad.setStrokeWidth(roadWidth);
    }

    private void setFill() {
        this.graphicalRepresentationOfRoad.setFill(roadColor);
    }

    private void addToScene(){
        Controller.StaticMainStage.getChildren().add(this.graphicalRepresentationOfRoad);
    }

}
