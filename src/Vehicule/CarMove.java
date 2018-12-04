package Vehicule;

import javafx.animation.AnimationTimer;

public class CarMove extends AnimationTimer {
    CarModel carModel;
    CarView carView;




    @Override
    public void handle(long now) {
        carModel.move(carModel.getRoadWithThisCar(), carModel.getRoadWithThisCar().getEndPoint().get("x"));
        int newPosition = carModel.getPositionX();
        if (carModel.checkIfReachedTheEnd()) {
            this.stop();
                    }
        carView.changeCarLayout(newPosition);
    }



    public CarMove(CarModel carModel, CarView carView) {
        this.carModel = carModel;
        this.carView = carView;
    }
//
//    @Override
//    public void run() {
//        carModel.move(carModel.getRoadWithThisCar(), carModel.getRoadWithThisCar().getEndPoint().get("x"));
//        int newPosition = carModel.getPositionX();
//        carView.changeCarLayout(newPosition);
//        System.out.println(this.getName());
//    }
}
