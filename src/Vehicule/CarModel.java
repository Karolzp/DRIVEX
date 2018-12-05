package Vehicule;

import Road.RoadController;
import Road.RoadModel;
import javafx.scene.shape.Rectangle;

public class CarModel extends Vehicule {

    private String carName;
//    private String carType;
    private double speedMax;
    private double speedActual;
    private RoadModel roadWithThisCar;
    private double positionX;
    private int positionY;
    private int widthOfCar;
    private int heightOfCar;
    private Rectangle carRectangle;
    private double acceleration;
    private double breakAcceleration;

    @Override
    protected void slowDown() {
//TODO
    }

    @Override
    protected void speedUp() {
//TODO
    }


    /**
     * decreases the actual x position by value of speed. So car moves to the left
     */
    @Override
    public void moveLeft(int endPointX){
        positionX -= 1;
        System.out.println("car reached endpoint on left. endPoint is = " + endPointX + "actual position of car = " + positionX);
    }

    /**
     * increases the actual x position by value of speed. So car moves to the right
     */
    @Override
    public void moveRight(int endPointX) {
        positionX += 1;
        System.out.println("car reached endpoint on RIGHT. endPoint is = " + endPointX + "actual position of car = " + positionX);
    }

    @Override
    public void calculateActualSpeed(CarModel nextCar){
        if (speedActual > nextCar.speedActual) {
            if (Math.abs(positionX - nextCar.positionX) / speedActual == (speedActual - nextCar.speedActual) / breakAcceleration) {
                speedActual = speedActual - breakAcceleration;
            } else if (Math.abs(positionX - nextCar.positionX) / speedActual <= (speedActual - nextCar.speedActual) / breakAcceleration) {
                speedActual = speedActual - (Math.pow((speedActual - nextCar.speedActual), 2) / (2 * Math.abs(positionX - nextCar.positionX)));
            } else {
                speedActual = speedActual;
            }
        } else if(speedActual < nextCar.speedActual){
            if(speedActual<speedMax){
                speedActual = speedActual + acceleration;
            }else{
                speedActual = speedActual;
            }

        } else if (speedActual == nextCar.speedActual){
            speedActual = speedActual
        }



    }
    @Override
    public void move(RoadModel roadWithThisCar, int endPointX){
        calculateActualSpeed(nextCar);
        if (roadWithThisCar.getRoadName().equals("KAROLEK")){
            positionX = positionX - speedActual;
            System.out.println("car heading right. endPoint is = " + endPointX + "actual position of car = " + positionX);
        } else {
            positionX = positionX + speedActual;
            System.out.println("car heading left. endPoint is = " + endPointX + "actual position of car = " + positionX);
        }
    }




    /* constructor */
    public CarModel(int speedMax, int positionX, int positionY, int widthOfCar, int heightOfCar, String carName, RoadModel roadWithThisCar) {
        this.speedMax = speedMax;
        this.speedActual = speedMax;
        this.positionX = positionX;
        this.positionY = positionY;
        this.widthOfCar = widthOfCar;
        this.heightOfCar = heightOfCar;
        this.carName = carName;
//        this.carType = carType;
        this.createCarRectangle();
        this.roadWithThisCar = roadWithThisCar;
    }



    public String getCarName() {
        return carName;
    }

//    public String getCarType() {
//        return carType;
//    }

    public int getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(int speedMax) {
        this.speedMax = speedMax;
    }

    public int getSpeedActual() {
        return speedActual;
    }

    public void setSpeedActual(int speedActual) {
        this.speedActual = speedActual;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getWidthOfCar() {
        return widthOfCar;
    }

    public void setWidthOfCar(int widthOfCar) {
        this.widthOfCar = widthOfCar;
    }

    public int getHeightOfCar() {
        return heightOfCar;
    }

    public void setHeightOfCar(int heightOfCar) {
        this.heightOfCar = heightOfCar;
    }

    public RoadModel getRoadWithThisCar() {
        return roadWithThisCar;
    }

    public Rectangle getCarRectangle() {
        return carRectangle;
    }

    private void createCarRectangle(){
        this.carRectangle = new Rectangle();
        this.carRectangle.setX(positionX);
        this.carRectangle.setY(positionY);
        this.carRectangle.setWidth(widthOfCar);
        this.carRectangle.setHeight(heightOfCar);
    }

    public boolean checkIfReachedTheEnd(){
        if (this.roadWithThisCar.getEndPoint().get("x") == this.positionX){
            return true;
        }
        return false;
    }


}
