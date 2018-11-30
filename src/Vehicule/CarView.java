package Vehicule;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Controller;


public class CarView {
    private Rectangle graphicalRepresentationOfCar;
    private final Color CARCOLOR = Color.RED;


    public void setGraphicalRepresentationOfCar(Rectangle graphicalRepresentationOfCar) {
        this.graphicalRepresentationOfCar = graphicalRepresentationOfCar;
        this.graphicalRepresentationOfCar.setFill(CARCOLOR);
        Controller.StaticMainStage.getChildren().add(this.graphicalRepresentationOfCar);
    }

    public Rectangle getGraphicalRepresentationOfCar() {
        return graphicalRepresentationOfCar;
    }
}
