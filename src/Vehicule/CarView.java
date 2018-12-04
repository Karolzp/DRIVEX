package Vehicule;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Controller;

import java.util.HashMap;


public class CarView {
    private Rectangle graphicalRepresentationOfCar;
    private final Color CARCOLOR = Color.RED;

    public CarView(Rectangle graphicalRepresentationOfCar) {
        this.graphicalRepresentationOfCar = graphicalRepresentationOfCar;
    }

    public void setGraphicalRepresentationOfCar(Rectangle graphicalRepresentationOfCar) {
        this.graphicalRepresentationOfCar = graphicalRepresentationOfCar;
        this.graphicalRepresentationOfCar.setFill(CARCOLOR);
        Controller.StaticMainStage.getChildren().add(this.graphicalRepresentationOfCar);
    }

    public void changeCarLayout(int newPosition){
        this.graphicalRepresentationOfCar.setX(newPosition);
//        this.graphicalRepresentationOfCar.setTranslateX(newPosition);
    }

    public CarView getGraphicalRepresentationOfCar() {
        return this;
    }
}
