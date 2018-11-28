package Vehicule;

import Road.RoadController;
import Road.RoadModel;
import javafx.scene.shape.Rectangle;

public class CarModel extends Vehicule {

    private String carName;
    private String carType;
    private int speedMax;
    private int speedActual;
    private String nameOfRoadWithThisCar;
    private int positionX;
    private int positionY;
    private int widthOfCar;
    private int heightOfCar;
    private Rectangle carRectangle;

    @Override
    protected void slowDown() {
//TODO
    }

    @Override
    protected void speedUp() {
//TODO
    }

    @Override
    protected void moveLeft(int actualPositionX, int endPointX){
        if (actualPositionX >= endPointX) {
            positionX = actualPositionX - 5;
            System.out.println("moving left, position x  =  " + positionX);
        } else {
            System.out.println("car reached the LEFT END point and stopped"); }
    }


    @Override
    protected void moveRight(int actualPositionX, int endPointX) {
        if (actualPositionX <= endPointX) {
            positionX = actualPositionX + 5;
            System.out.println("moving Right, position x  =  " + positionX);
        } else {
            System.out.println("car reached the RIGHT END point and stopped");
        }
    }



    /* constructor */
    public CarModel(int speedMax, int positionX, int positionY, int widthOfCar, int heightOfCar, String carName, String carType) {
        this.speedMax = speedMax;
        this.speedActual = speedMax;
        this.positionX = positionX;
        this.positionY = positionY;
        this.widthOfCar = widthOfCar;
        this.heightOfCar = heightOfCar;
        this.carName = carName;
        this.carType = carType;
        this.createCarRectangle();
    }


    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

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

    public String getNameOfRoadWithThisCar() {
        return nameOfRoadWithThisCar;
    }

    public Rectangle getCarRectangle() {
        return carRectangle;
    }

    private void createCarRectangle(){
        this.carRectangle = new Rectangle();
        carRectangle.setX(positionX);
        carRectangle.setY(positionY);
        carRectangle.setWidth(widthOfCar);
        carRectangle.setHeight(heightOfCar);
    }
}
