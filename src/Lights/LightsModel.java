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

    public LightsModel(boolean isGreen, HashMap<String, Integer> positionOfTrafficLightBox) {
        this.isGreen = isGreen;
        this.positionOfTrafficLightBox = positionOfTrafficLightBox;
        createTrafficLightBox();
        createTrafficLightsCircles();
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
        greenLight.setCenterY(positionOfTrafficLightBox.get("y")+(positionOfTrafficLightBox.get("h")/3));
        greenLight.setRadius(positionOfTrafficLightBox.get("w")/3);

        redLight.setCenterX(positionOfTrafficLightBox.get("x")+(positionOfTrafficLightBox.get("w")/2));
        redLight.setCenterY(positionOfTrafficLightBox.get("y")+(positionOfTrafficLightBox.get("h")/3*2));
        redLight.setRadius(positionOfTrafficLightBox.get("w")/3);
    }
}
