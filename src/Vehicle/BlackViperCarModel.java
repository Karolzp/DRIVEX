package Vehicle;

import Road.RoadModel;

import static Vehicle.CarController.CarModels.BLACK_VIPER;

public class BlackViperCarModel extends Vehicle {

    /* constructor */
    public BlackViperCarModel(RoadModel roadWithThisCar, Vehicle carBefore) {
        super(roadWithThisCar, carBefore);
        speedMax = 0.4;
        acceleration = 0.04;
        breakAcceleration = 0.4;
        speedActual = speedMax;
        carEnum = BLACK_VIPER;
    }

    @Override
    protected void slowDown() {
//TODO
    }

    @Override
    protected void speedUp() {
//TODO
    }

}
