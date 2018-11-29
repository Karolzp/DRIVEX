package Lights;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sample.Controller;


public class LightsView {
    private final Color GREEN = Color.DARKGREEN;
    private final Color RED = Color.DARKRED;
    private final Color TAFFICLIGHTSBOX = Color.GRAY;
    private Circle redLight;
    private Circle greenLight;

    public Color getGREEN() {
        return GREEN;
    }

    public Color getRED() {
        return RED;
    }

    public void setGraphicalRepresentationOfTrafficLightsBox(Rectangle trafficLightsBox){
        trafficLightsBox.setFill(TAFFICLIGHTSBOX);
        trafficLightsBox.setStyle("-fx-stroke: black; -fx-stroke-width: 2;");
        Controller.StaticMainStage.getChildren().add(trafficLightsBox);

    }

    public void setGraphicalRepresentationOfTrafficLights(Circle redLight, Circle greenLight){
        this.redLight = redLight;
        this.redLight.setFill(RED);
        Controller.StaticMainStage.getChildren().add(this.redLight);

        this.greenLight = greenLight;
        this.greenLight.setFill(GREEN);
        Controller.StaticMainStage.getChildren().add(this.greenLight);

    }


}
