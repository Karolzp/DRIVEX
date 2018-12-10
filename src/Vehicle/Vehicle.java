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
    protected Vehicle nextCar;
    protected boolean beAtTrafficLights = false;

    public Vehicle(RoadModel roadWithThisCar, Vehicle nextCar) {
        this.roadWithThisCar = roadWithThisCar;
        this.positionX = roadWithThisCar.getSpawnPoint().get("x") - 17.5;
        this.positionY = roadWithThisCar.getSpawnPoint().get("y") - 17.5;
        this.carRectangle = createCarRectangle();
        this.nextCar = nextCar;
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

    public void calculateSpeedForFirstCar(double trafficLightsStopPointX){
        if (Math.abs(positionX - trafficLightsStopPointX) - widthOfCar*0.5 < 1) {
            beAtTrafficLights = true;
        }
        if (!roadWithThisCar.getTrafficlights().isGreen() && !beAtTrafficLights && Math.abs(positionX - trafficLightsStopPointX) - widthOfCar*0.5 < 2) {
            speedActual = 0;
        } else if (!roadWithThisCar.getTrafficlights().isGreen() && !beAtTrafficLights && Math.abs(positionX - trafficLightsStopPointX) - widthOfCar*0.5 < speedMax * 220) {
            if(speedActual > 0)
                speedActual = speedActual - (speedActual / (10 * (Math.abs(positionX - trafficLightsStopPointX) - widthOfCar*0.5)));

        } else if (roadWithThisCar.getTrafficlights().isGreen()) {
            if (speedActual < speedMax ) {
                speedActual = speedActual + acceleration;
            }
        }
    }

    public void calculateSpeedForOtherCars(double trafficLightsStopPointX){
        if(Math.abs(positionX - trafficLightsStopPointX) - widthOfCar*0.5 < 1) {
            beAtTrafficLights = true;
        }
        if (!roadWithThisCar.getTrafficlights().isGreen() && !beAtTrafficLights && Math.abs(positionX - trafficLightsStopPointX) - widthOfCar*0.5 < 2) {
            speedActual = 0;
        }
        else if (!roadWithThisCar.getTrafficlights().isGreen() && nextCar.beAtTrafficLights && !beAtTrafficLights && Math.abs(positionX - trafficLightsStopPointX) - widthOfCar*0.5 < speedMax * 220){
            speedActual = speedActual - (speedActual / (10 * (Math.abs(positionX - trafficLightsStopPointX))));
        }
        else if (speedActual > nextCar.speedActual) {
            if ((Math.abs(positionX - nextCar.positionX) <= widthOfCar * 1.2)) {
                speedActual = nextCar.speedActual;
            } else if ((Math.abs(positionX - nextCar.positionX) - widthOfCar) * (speedActual - nextCar.speedActual) < (speedActual - nextCar.speedActual) * speedMax * 220) {
                if(speedActual > 0)
                    speedActual = speedActual - ((speedActual - nextCar.speedActual) / (10 * (Math.abs(positionX - nextCar.positionX)) + widthOfCar / 2));
            }else if((Math.abs(positionX - nextCar.positionX) - widthOfCar) * (speedActual - nextCar.speedActual) > (speedActual - nextCar.speedActual) * speedMax * 220){
                if (speedActual < speedMax) {
                    speedActual = speedActual + acceleration;
                }
            }
        }
        else if (speedActual < nextCar.speedActual && (Math.abs(positionX - nextCar.positionX) > widthOfCar * 1.2)) {
            if (speedActual < speedMax) {
                speedActual = speedActual + acceleration;
            }
        }
        else if((Math.abs(positionX - nextCar.positionX) - widthOfCar) * (speedActual - nextCar.speedActual) > (speedMax - nextCar.speedActual) * speedMax * 220){
            if (speedActual < speedMax) {
                speedActual = speedActual + acceleration;
            }
        }
    }

    public void calculateActualSpeed(double trafficLightsStopPointX) {
        if (nextCar == null) {
            calculateSpeedForFirstCar(trafficLightsStopPointX);
        } else if (nextCar != null) {
            calculateSpeedForOtherCars(trafficLightsStopPointX);
        }
    }


    protected void move(RoadModel roadWithThisCar){

        int endPointX = roadWithThisCar.getEndPoint().get("x");
        int spawnPointX = roadWithThisCar.getSpawnPoint().get("x");
        double trafficLightsStopPointX = roadWithThisCar.getTrafficLightStopPoint().get("x") - 17.5;

        calculateActualSpeed(trafficLightsStopPointX);

        if (spawnPointX > endPointX){
            positionX -= speedActual;
        } else {
            positionX += speedActual;
        }
    }

    protected void removeCarFromList(){
        this.getRoadWithThisCar().getCarsOnRoad().remove(this);
    }
}
