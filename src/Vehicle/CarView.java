package Vehicle;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Controller;

public class CarView {
    /**
     Strings with paths to the car images.
     */
    private String pathToPoliceImage = new String("Vehicle/CarsResources/Police.png");
    private String pathToAudiImage = new String("Vehicle/CarsResources/Audi.png");
    private String pathToBlackViperImage = new String("Vehicle/CarsResources/Black_viper.png");
    private String pathToTruckImage = new String("Vehicle/CarsResources/Mini_truck.png");
    private String pathToTaxiImage = new String("Vehicle/CarsResources/taxi.png");

    private CarController.CarModels typeOfCar;
    private Rectangle graphicalRepresentationOfCar;
    private String roadWithThisCar;

    /**
     Angles that are needed to properly align cars on the road.
     */
    private int left = 270;
    private int right = 90;

    /**
     Constructor
     */
    public CarView(Rectangle graphicalRepresentationOfCar, CarController.CarModels typeOfCar, String roadWithThisCar) {
        this.typeOfCar = typeOfCar;
        this.graphicalRepresentationOfCar = graphicalRepresentationOfCar;
        this.roadWithThisCar = roadWithThisCar;
    }

    /**
     Method that checks what kind of car it got and fills it shape with proper image.
     */
    private void fillCarViewWithImage(){
        switch (typeOfCar) {
            case AUDI:
                graphicalRepresentationOfCar.setFill(new ImagePattern(new Image(pathToAudiImage)));
                break;
            case BLACK_VIPER:
                graphicalRepresentationOfCar.setFill(new ImagePattern(new Image(pathToBlackViperImage)));
                break;
            case TRUCK:
                graphicalRepresentationOfCar.setFill(new ImagePattern(new Image(pathToTruckImage)));
                break;
            case POLICE:
                graphicalRepresentationOfCar.setFill(new ImagePattern(new Image(pathToPoliceImage)));
                break;
            case TAXI:
                graphicalRepresentationOfCar.setFill(new ImagePattern(new Image(pathToTaxiImage)));
                break;
        }
    }

    /**
     Method that checks on which road car is spawned and then aligns image according to road direction.
     */
    private void rotateCarView(){
        if (roadWithThisCar.equals("KAROLEK")) {
            graphicalRepresentationOfCar.setRotate(left);
        } else {
            graphicalRepresentationOfCar.setRotate(right);
        }
    }

    /**
     Calls up fillCar and rotate methods then adds a rectangle to scene.
     */
    public void setGraphicalRepresentationOfCar() {
        fillCarViewWithImage();
        rotateCarView();
        Controller.StaticMainStage.getChildren().add(this.graphicalRepresentationOfCar);
    }

    /**
     Updates car position on the scene.
     */
    public void changeCarLayout(double newPosition){
        this.graphicalRepresentationOfCar.setX(newPosition);
    }

    public void removeCarFromScene(){
        Controller.StaticMainStage.getChildren().remove(graphicalRepresentationOfCar);
    }

}
