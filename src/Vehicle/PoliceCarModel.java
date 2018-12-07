package Vehicle;

import Road.RoadModel;

import static Vehicle.CarController.CarModels.POLICE;

public class PoliceCarModel extends Vehicle {

    /* constructor */
    public PoliceCarModel(RoadModel roadWithThisCar, Vehicle carBefore) {
        super(roadWithThisCar, carBefore);
        speedMax = 0.2;
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
