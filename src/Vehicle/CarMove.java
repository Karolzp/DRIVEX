package Vehicle;

import javafx.animation.AnimationTimer;

public class CarMove extends AnimationTimer {
    Vehicle carModel;
    CarView carView;

    public CarMove(Vehicle carModel, CarView carView) {
        this.carModel = carModel;
        this.carView = carView;
    }

    @Override
    public void handle(long now) {
        carModel.move(carModel.getRoadWithThisCar());
        double newPosition = carModel.getPositionX();
        if (carModel.checkIfReachedTheEnd()) {
            this.stop();
            carModel.removeCarFromList();
            carView.removeCarFromScene();
            return;
        }
        carView.changeCarLayout(newPosition);
    }

}
