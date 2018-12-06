package Vehicle;

import Road.RoadModel;
import javafx.scene.shape.Rectangle;

public abstract class Vehicle {

    protected CarController.CarModels carEnum;
    protected double speedMax;
    protected double speedActual;
    protected RoadModel roadWithThisCar;
    protected double positionX;
    protected double positionY;
    protected double widthOfCar = 35;
    protected double heightOfCar = 35;
    protected Rectangle carRectangle;

    public Vehicle(RoadModel roadWithThisCar) {
        this.roadWithThisCar = roadWithThisCar;
        this.positionX = roadWithThisCar.getSpawnPoint().get("x");
        this.positionY = roadWithThisCar.getSpawnPoint().get("y") - 18;
        this.carRectangle = createCarRectangle();
    }

    public CarController.CarModels getCarEnum() {
        return carEnum;
    }

    protected RoadModel getRoadWithThisCar() {
        return roadWithThisCar;
    }

    protected double getPositionX() {
        return positionX;
    }

    protected double getPositionY() {
        return positionY;
    }

    protected double getWidthOfCar() {
        return widthOfCar;
    }

    protected double getHeightOfCar() {
        return heightOfCar;
    }

    protected Rectangle getCarRectangle() {
        return carRectangle;
    }

    protected abstract void slowDown();
    protected abstract void speedUp();

    protected boolean checkIfReachedTheEnd(){
        byte stopMargin = 2;
        if (positionX > this.roadWithThisCar.getEndPoint().get("x") - stopMargin && positionX < this.roadWithThisCar.getEndPoint().get("x") + stopMargin){
            return true;
        }
        return false;
    }

    private Rectangle createCarRectangle(){
        Rectangle newRectangle = new Rectangle();
        newRectangle.setX(positionX);
        newRectangle.setY(positionY);
        newRectangle.setWidth(widthOfCar);
        newRectangle.setHeight(heightOfCar);
        return newRectangle;
    }

    protected void move(RoadModel roadWithThisCar){

        int endPointX = roadWithThisCar.getEndPoint().get("x");
        int spawnPointX = roadWithThisCar.getSpawnPoint().get("x");
        int trafficLightsStopPointX = roadWithThisCar.getTrafficLightStopPoint().get("x");

        if (spawnPointX > endPointX){
            positionX -= speedActual;
            System.out.println("car heading right. endPoint is = " + endPointX + "actual position of car = " + positionX);
        } else {
            positionX += speedActual;
            System.out.println("car heading left. endPoint is = " + endPointX + "actual position of car = " + positionX);
        }
    }
}
