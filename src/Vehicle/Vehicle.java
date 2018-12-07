package Vehicle;

import Road.RoadModel;
import javafx.scene.shape.Rectangle;

public abstract class Vehicle {

    protected CarController.CarModels carEnum;
    protected double speedMax;
    protected double speedActual;
    protected double acceleration;
    protected double breakAcceleration;
    protected RoadModel roadWithThisCar;
    protected double positionX;
    protected double positionY;
    protected double widthOfCar = 35;
    protected double heightOfCar = 35;
    protected Rectangle carRectangle;
    protected Vehicle carBefore;

    public Vehicle(RoadModel roadWithThisCar, Vehicle carBefore) {
        this.roadWithThisCar = roadWithThisCar;
        this.positionX = roadWithThisCar.getSpawnPoint().get("x") - 17.5;
        this.positionY = roadWithThisCar.getSpawnPoint().get("y") - 18;
        this.carRectangle = createCarRectangle();
        this.carBefore = carBefore;
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
        if (positionX > this.roadWithThisCar.getEndPoint().get("x") - 17.5 - stopMargin && positionX < this.roadWithThisCar.getEndPoint().get("x") - 17.5 + stopMargin){
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

    public void calculateActualSpeed(Vehicle nextCar) {

            if (speedActual > nextCar.speedActual) {
                if ((Math.abs(positionX - nextCar.positionX) <= widthOfCar*1.2)){
                    speedActual = nextCar.speedActual;
                }else if((Math.abs(positionX - nextCar.positionX)-widthOfCar)*(speedActual - nextCar.speedActual) <= (speedMax - nextCar.speedActual) * speedMax*220){
                    speedActual = speedActual - ((speedActual - nextCar.speedActual) / (10*(Math.abs(positionX - nextCar.positionX))+widthOfCar/2));
                    System.out.println(speedActual);
                }
            }
            else if (speedActual < nextCar.speedActual) {
                if (speedActual < speedMax) {
                    speedActual = speedActual + acceleration;
                }
            }
//            else if(speedActual == nextCar.speedActual && (Math.abs(positionX - nextCar.positionX) <= widthOfCar*1)){
//                speedActual = speedActual - 0.15;
//            }

        }


    protected void move(RoadModel roadWithThisCar){

        int endPointX = roadWithThisCar.getEndPoint().get("x");
        int spawnPointX = roadWithThisCar.getSpawnPoint().get("x");
        int trafficLightsStopPointX = roadWithThisCar.getTrafficLightStopPoint().get("x");

        if (carBefore != null) {
            calculateActualSpeed(carBefore);
        }
        if (spawnPointX > endPointX){
            positionX -= speedActual;
//            System.out.println("car heading right. endPoint is = " + endPointX + "actual position of car = " + positionX);
        } else {
            positionX += speedActual;
//            System.out.println("car heading left. endPoint is = " + endPointX + "actual position of car = " + positionX);
        }
    }
}
