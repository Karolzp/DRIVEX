package Vehicle.CarTypes;

import Road.RoadModel;
import Vehicle.Vehicle;

import static Vehicle.CarController.CarModels.AUDI;

public class AudiCarModel extends Vehicle {

    /* constructor */
    public AudiCarModel(RoadModel roadWithThisCar, Vehicle carBefore) {
        super(roadWithThisCar, carBefore);
        speedMax = 0.2;
        acceleration = 0.03;
        breakAcceleration = 0.15;
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
