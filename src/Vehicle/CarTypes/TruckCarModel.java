package Vehicle.CarTypes;

import Road.RoadModel;
import Vehicle.Vehicle;

import static Vehicle.CarController.CarModels.TRUCK;

public class TruckCarModel extends Vehicle {

    /* constructor */
    public TruckCarModel(RoadModel roadWithThisCar, Vehicle carBefore) {
        super(roadWithThisCar, carBefore);
        speedMax = 0.1;
        acceleration = 0.02;
        breakAcceleration = 0.1;
        speedActual = speedMax;
        carEnum = TRUCK;
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
