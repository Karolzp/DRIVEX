package Lights;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sample.Controller;


public class LightsView {
    private final Color GREEN = Color.DARKGREEN;
    private final Color RED = Color.DARKRED;
    private final Color brightGREEN = Color.LAWNGREEN;
    private final Color brightRED = Color.RED;
    private final Color TAFFICLIGHTSBOX = Color.GRAY;
    private Circle redLight;
    private Circle greenLight;


    public Color getGREEN() {
        return GREEN;
    }

    public Color getRED() {
        return RED;
    }

    public void setGraphicalRepresentationOfTrafficLight(Rectangle trafficLightsBox,Circle redLight, Circle greenLight, int rotation){
        Group box = new Group();

        trafficLightsBox.setFill(TAFFICLIGHTSBOX);
        trafficLightsBox.setStyle("-fx-stroke: black; -fx-stroke-width: 2;");
        box.getChildren().add(trafficLightsBox);

        this.redLight = redLight;
        this.redLight.setFill(RED);
        box.getChildren().add(this.redLight);

        this.greenLight = greenLight;
        this.greenLight.setFill(GREEN);
        box.getChildren().add(this.greenLight);

        box.setRotate(rotation);

        Controller.StaticMainStage.getChildren().add(box);
    }

    public void setGreenLight(){
        this.greenLight.setFill(brightGREEN);
        this.redLight.setFill(RED);
    }
    public void setRedLight(){
        this.greenLight.setFill(GREEN);
        this.redLight.setFill(brightRED);
    }


//    public void setGraphicalRepresentationOfTrafficLightsBox(Rectangle trafficLightsBox){
//        trafficLightsBox.setFill(TAFFICLIGHTSBOX);
//        trafficLightsBox.setStyle("-fx-stroke: black; -fx-stroke-width: 2;");
//        Controller.StaticMainStage.getChildren().add(trafficLightsBox);
//
//    }
//
//    public void setGraphicalRepresentationOfTrafficLights(Circle redLight, Circle greenLight){
//        this.redLight = redLight;
//        this.redLight.setFill(RED);
//        Controller.StaticMainStage.getChildren().add(this.redLight);
//
//        this.greenLight = greenLight;
//        this.greenLight.setFill(GREEN);
//        Controller.StaticMainStage.getChildren().add(this.greenLight);
//
//    }


}
