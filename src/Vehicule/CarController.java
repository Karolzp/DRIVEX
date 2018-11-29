package Vehicule;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class CarController {
    protected List<CarModel> listOFCarModel = new ArrayList<CarModel>();
    protected List<Rectangle> listOfGraphicalRepresentationOfCar = new ArrayList<>();

    public List<CarModel> getListOFCarModel() {
        return listOFCarModel;
    }

    public List<Rectangle> getListOfGraphicalRepresentationOfCar() {
        return listOfGraphicalRepresentationOfCar;
    }

    /**
     * creates carModel based on the given attributes. This method is called from Controller
     * and adds each carModel to list od car models
     * @param speedMax
     * @param positionX
     * @param positionY
     * @param widthOfCar
     * @param heightOfCar
     * @param carName
     * @param carType
     */
    public void createCarModel(int speedMax, int positionX, int positionY, int widthOfCar, int heightOfCar, String carName, String carType){
        CarModel carModel = new CarModel(speedMax, positionX, positionY, widthOfCar, heightOfCar, carName, carType);
        listOFCarModel.add(carModel);
    }


    /**
     *  creates carView based on the list of all Cars. This method is called from Controller
     *  and adds each carView to list od car views
     */
    public void createCarView() {
        CarView carView = new CarView();
        for (int i = 0; i < listOFCarModel.size(); i++) {
            carView.setGraphicalRepresentationOfCar(listOFCarModel.get(i).getCarRectangle());
            this.listOfGraphicalRepresentationOfCar.add(carView.getGraphicalRepresentationOfCar());
        }
    }

    /**
     * iterates list with all carsModels and calls the method in carModel to move left or right, based on the upper or lowe road
     * @param endPointXonLeftSideKAROLEKRoad
     * @param endPointXonRightSideJARORoad
     */
    public void moveCars(int endPointXonLeftSideKAROLEKRoad, int endPointXonRightSideJARORoad){
        System.out.println("DUPA");
        System.out.println(endPointXonLeftSideKAROLEKRoad);
        System.out.println(endPointXonRightSideJARORoad);
        for(int i = 0; i < listOFCarModel.size(); i++){
            listOFCarModel.get(i).getNameOfRoadWithThisCar();
            if(listOFCarModel.get(i).getNameOfRoadWithThisCar() == "KAROLEK"){
                listOFCarModel.get(i).moveLeft(endPointXonLeftSideKAROLEKRoad);
            } else { listOFCarModel.get(i).moveRight(endPointXonRightSideJARORoad);}
        }
    }

}
