package Vehicule;


import Road.RoadController;
import Road.RoadModel;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class CarController  {


//    private HashMap<String, CarModel> hashmapOfCarModel = new HashMap();
//    private HashMap<String, CarView> hashmapOfGrapicalRepresentationsOfCar = new HashMap();


    private List<HashMap> listOfCarsModelsAndViews = new ArrayList<HashMap>();

    protected List<CarModel> listOfCarModel = new ArrayList<CarModel>();
    protected List<CarView> listOfCarView = new ArrayList<CarView>();

    private int endPointXonLeftSideKAROLEKRoad;
    private int endPointXonRightSideJARORoad;

    public CarController(int endPointXonLeftSideKAROLEKRoad, int endPointXonRightSideJARORoad) {
        this.endPointXonLeftSideKAROLEKRoad = endPointXonLeftSideKAROLEKRoad;
        this.endPointXonRightSideJARORoad = endPointXonRightSideJARORoad;
        createCars();
        moveCars();
    }

//    public List<CarModel> getListOFCarModel() {
//        return listOFCarModel;
//    }
//
//    public List<CarView> getListOfGraphicalRepresentationOfCar() {
//        return listOfGraphicalRepresentationOfCar;
//    }

    /**
     * creates carModel based on the given attributes. This method is called from Controller
     * and adds each carModel to list od car models
     *
     * @param speedMax
     * @param positionX
     * @param positionY
     * @param widthOfCar
     * @param heightOfCar
     * @param carName
     * @param carType
     */
    public CarModel createCarModel(int speedMax, int positionX, int positionY, int widthOfCar, int heightOfCar, String carName, RoadModel nameOfRoadWithThisCar) {
        CarModel carModel = new CarModel(speedMax, positionX, positionY, widthOfCar, heightOfCar, carName, nameOfRoadWithThisCar);
        listOfCarModel.add(carModel);
        return carModel;
    }


    /**
     * creates carView based on the list of all Cars. This method is called from Controller
     * and adds each carView to list od car views
     */


    public void createCarView(CarModel carModel) {
//        for (CarModel carModel : hashmapOfCarModel.values()) {
        CarView carView = new CarView(carModel.getCarRectangle());
        carView.setGraphicalRepresentationOfCar(carModel.getCarRectangle());
        listOfCarView.add(carView);
//        }
    }


    //Congratulations for using magic numbers again.
    //And for creating CAR MODELS in MAIN CONTROLLR eventhough we discussed that models of X object should be created in X object Controller.
    private void createCars() {
        CarModel carModel1 = createCarModel(1, RoadController.getListOfRoadModel().get(0).getSpawnPoint().get("x"), 90, 35, 20, "car1", RoadController.getListOfRoadModel().get(0));
        createCarView(carModel1);

        CarModel carModel2 = createCarModel(1, RoadController.getListOfRoadModel().get(1).getSpawnPoint().get("x"), 132, 35, 20, "car2", RoadController.getListOfRoadModel().get(1));
        createCarView(carModel2);

//        createCarView();

    }

    /**
     * iterates list with all carsModels and calls the method in carModel to move left or right, based on the upper or lowe road
     *
     * @param endPointXonLeftSideKAROLEKRoad
     * @param endPointXonRightSideJARORoad
     */
    public void moveCars() {

        for (int i = 0; i < listOfCarModel.size(); i++) {
            CarMove carMove = new CarMove(listOfCarModel.get(i), listOfCarView.get(i));
            carMove.start();
        }

    }
//    private AnimationTimer timer;
//    @Override public void start() {
//
//        timer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                for (int i = 0; i < listOfCarModel.size(); i++) {
//
//                    listOfCarModel.get(0).move(listOfCarModel.get(0).getRoadWithThisCar(), listOfCarModel.get(0).getRoadWithThisCar().getEndPoint().get("x"));
//                    int newPosition = listOfCarModel.get(0).getPositionX();
//                    if (listOfCarModel.get(0).checkIfReachedTheEnd()) {
//
//                    }
//                    listOfCarView.get(0).changeCarLayout(newPosition);
//
//
//                }
//            }
//
//        };
//    }
}








