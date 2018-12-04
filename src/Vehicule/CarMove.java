package Vehicule;

public class CarMove extends Thread {
    CarModel carModel;
    CarView carView;

    public CarMove(CarModel carModel, CarView carView) {
        this.carModel = carModel;
        this.carView = carView;
    }

    public void run() {
        carModel.move(carModel.getRoadWithThisCar(), carModel.getRoadWithThisCar().getEndPoint().get("x"));
        int newPosition = carModel.getPositionX();
        carView.changeCarLayout(newPosition);
        System.out.println(this.getName());
    }
}
