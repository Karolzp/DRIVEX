package Vehicle;

import Road.RoadModel;

import static Vehicle.CarController.CarModels.POLICE;

public class PoliceCarModel extends Vehicle {

    /* constructor */
    public PoliceCarModel(RoadModel roadWithThisCar, Vehicle carBefore) {
        super(roadWithThisCar, carBefore);
        speedMax = 0.2;
        acceleration = 0.003;
        breakAcceleration = 0.15;
        speedActual = speedMax;
        carEnum = POLICE;
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
