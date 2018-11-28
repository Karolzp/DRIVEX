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
     * creates carModel based on the given attributes
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
     *  creates carView
     */
    public void createCarView() {
        CarView carView = new CarView();
        for (int i = 0; i < listOFCarModel.size(); i++) {
            carView.setGraphicalRepresentationOfCar(listOFCarModel.get(i).getCarRectangle());
            this.listOfGraphicalRepresentationOfCar.add(carView.getGraphicalRepresentationOfCar());
        }
    }

    public void moveLeft(int actualPositionX, int endPointX){
        CarModel car1 = listOFCarModel.get(0);
        car1.moveLeft(actualPositionX, endPointX);

    }
}
