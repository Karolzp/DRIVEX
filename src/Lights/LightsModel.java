package Lights;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class LightsModel {

    private boolean isGreen;
    private HashMap<String,Integer> positionOfTrafficLightBox;
    private Rectangle trafficLightsBox;
    private Circle redLight;
    private Circle greenLight;
    private int rotation;



    public LightsModel(boolean isGreen, HashMap<String, Integer> positionOfTrafficLightBox,int  rotation) {
        this.isGreen = isGreen;
        this.positionOfTrafficLightBox = positionOfTrafficLightBox;
        this.rotation = rotation;
        createTrafficLightBox();
        createTrafficLightsCircles();
    }
    public Rectangle getTrafficLightsBox() {
        return trafficLightsBox;
    }

    public Circle getRedLight() {
        return redLight;
    }

    public Circle getGreenLight() {
        return greenLight;
    }

    public int getRotation() {
        return rotation;
    }

    public HashMap<String, Integer> getPositionOfTrafficLightBox() {
        return positionOfTrafficLightBox;
    }


    public boolean isGreen() {
        return isGreen;
    }

    public void setGreen(boolean green) {
        isGreen = green;
    }

    private void createTrafficLightBox(){
        this.trafficLightsBox = new Rectangle();
        trafficLightsBox.setX(positionOfTrafficLightBox.get("x"));
        trafficLightsBox.setY(positionOfTrafficLightBox.get("y"));
        trafficLightsBox.setHeight(positionOfTrafficLightBox.get("h"));
        trafficLightsBox.setWidth(positionOfTrafficLightBox.get("w"));
    }

    private void createTrafficLightsCircles(){
        this.greenLight = new Circle();
        this.redLight = new Circle();

        greenLight.setCenterX(positionOfTrafficLightBox.get("x")+(positionOfTrafficLightBox.get("w")/2));
        greenLight.setCenterY(positionOfTrafficLightBox.get("y")+positionOfTrafficLightBox.get("h")-(positionOfTrafficLightBox.get("h")/3.5));
        greenLight.setRadius(positionOfTrafficLightBox.get("w")/3);
        greenLight.setStyle("-fx-stroke: black; -fx-stroke-width: 0.6;");

        redLight.setCenterX(positionOfTrafficLightBox.get("x")+(positionOfTrafficLightBox.get("w")/2));
        redLight.setCenterY(positionOfTrafficLightBox.get("y")+(positionOfTrafficLightBox.get("h")/3.5));
        redLight.setRadius(positionOfTrafficLightBox.get("w")/3);
        redLight.setStyle("-fx-stroke: black; -fx-stroke-width: 0.6;");
    }
}
