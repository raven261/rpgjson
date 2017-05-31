package UI;

/*
 * Created by ravenalb on 29-5-2017.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea roomName;
    @FXML
    private TextField actionTextField;

    @FXML
    private void handleActionTextField(ActionEvent event){
        actionTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    System.out.println("it works!");
                    actionTextField.clear();
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

}
