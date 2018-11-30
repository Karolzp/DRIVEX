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


    /**
     * decreases the actual x position by value of speed. So car moves to the left
     */
    @Override
    public void moveLeft(int endPointX){
        while(positionX >= endPointX){
            positionX -= speedActual;
        }
        System.out.println("car reached endpoint on left. endPoint is = " + endPointX + "actual position of car = " + positionX);

    }

    /**
     * increases the actual x position by value of speed. So car moves to the right
     */
    @Override
    public void moveRight(int endPointX) {
        while(this.positionX <= endPointX){
            positionX += speedActual;
        }
        System.out.println("car reached endpoint on RIGHT. endPoint is = " + endPointX + "actual position of car = " + positionX);
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
        if (positionX == 950) {
            this.nameOfRoadWithThisCar = "KAROLEK";
        } else {this.nameOfRoadWithThisCar = "JARO";}
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
