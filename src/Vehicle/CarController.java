package Vehicle;

import Road.RoadModel;
import Vehicle.CarTypes.*;
import javafx.application.Platform;

import java.util.*;
import java.util.concurrent.*;

public class CarController {

    private static final Random rand = new Random();

    private List<RoadModel> listOfRoads;


    /**
    Constructor
     */
    public CarController(List<RoadModel> listOfRoads) {
        this.listOfRoads = listOfRoads;
        moveCars();
    }

    /**
     Randomly picks one of the roads to spawn a car.
     */
    private RoadModel pickRoadModel() {
        int pickedRoad = rand.nextInt(listOfRoads.size());
        return listOfRoads.get(pickedRoad);
    }

    /**
     Randomly picks type of the car from the enum class.
     */
    private CarModels pickCarModel() {
        int pickedCarModel = rand.nextInt(CarModels.values().length);
        return CarModels.values()[pickedCarModel];

    }

    /**
     Creates a new model of the car according to picked enum.
     */
    private Vehicle createCarModel() {

        RoadModel pickedRoad = pickRoadModel();
        Vehicle nextCar = pickedRoad.getCarsOnRoad().get(pickedRoad.getCarsOnRoad().size()-1);

        switch (pickCarModel()) {
            case AUDI:
                Vehicle audiCarModel = new AudiCarModel(pickedRoad, nextCar);
                audiCarModel.getRoadWithThisCar().addCarToListOfCarsOnRoad(audiCarModel);

                return audiCarModel;
            case BLACK_VIPER:
                Vehicle blackViperCarModel = new BlackViperCarModel(pickedRoad, nextCar);
                blackViperCarModel.getRoadWithThisCar().addCarToListOfCarsOnRoad(blackViperCarModel);
                return blackViperCarModel;
            case TRUCK:
                Vehicle truckCarModel = new TruckCarModel(pickedRoad, nextCar);
                truckCarModel.getRoadWithThisCar().addCarToListOfCarsOnRoad(truckCarModel);
                return truckCarModel;
            case POLICE:
                Vehicle policeCarModel = new PoliceCarModel(pickedRoad, nextCar);
                policeCarModel.getRoadWithThisCar().addCarToListOfCarsOnRoad(policeCarModel);
                return policeCarModel;
            case TAXI:
                Vehicle taxiCarModel = new TaxiCarModel(pickedRoad, nextCar);
                taxiCarModel.getRoadWithThisCar().addCarToListOfCarsOnRoad(taxiCarModel);
                return taxiCarModel;
            default:
                Vehicle defaultAudi = new AudiCarModel(pickedRoad, nextCar);
                defaultAudi.getRoadWithThisCar().addCarToListOfCarsOnRoad(defaultAudi);
                return defaultAudi;
        }
    }

    /**
     * Creates a new view for a car.
     */
    private CarView createCarView(Vehicle carModel) {
        CarView carView = new CarView(carModel.getCarRectangle(), carModel.getCarEnum(), carModel.getRoadWithThisCar().getRoadName());
        carView.setGraphicalRepresentationOfCar();
        return carView;
    }

    /**
    Creates an executor that start new thread every x to x seconds(random)
     */
    private void moveCars() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(startNewCar(), 0, rand.nextInt(1) + 3, TimeUnit.SECONDS);
    }

    /**
     Essence of the thread. This method instantiate car model, view and starts animation.
     */
    private Runnable startNewCar(){
        Runnable runnable = () -> {
            try {
                Vehicle carModel = createCarModel();
                Platform.runLater(() -> {
                    CarView carView = createCarView(carModel);
                    CarMove carMove = new CarMove(carModel, carView);
                    carMove.start();
                });
            } catch (Exception e){
                System.out.println(e);
            }
        };
        return runnable;
    }

    /**
     Helper enum class for car types.
     */
    public enum CarModels {
        AUDI,
        BLACK_VIPER,
        TRUCK,
        POLICE,
        TAXI
    }
}









