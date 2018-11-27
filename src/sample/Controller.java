package sample;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Pane MainStage;
    public static Pane StaticMainStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.MainStage = StaticMainStage;

    }


}
