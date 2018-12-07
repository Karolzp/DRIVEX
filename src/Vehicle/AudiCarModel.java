package Vehicle;

import Road.RoadModel;

import static Vehicle.CarController.CarModels.AUDI;

public class AudiCarModel extends Vehicle {

    /* constructor */
    public AudiCarModel(RoadModel roadWithThisCar, Vehicle carBefore) {
        super(roadWithThisCar, carBefore);
        speedMax = 0.2;
        speedActual = speedMax;
        carEnum = AUDI;
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
