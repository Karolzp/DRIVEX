package Vehicule;

import javafx.scene.shape.Rectangle;

public abstract class Vehicule {

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

    protected abstract void slowDown();
    protected abstract void speedUp();
    protected abstract void moveLeft(int endPointX);
    protected abstract void moveRight(int endPointX);
}
