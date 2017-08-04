package UI;

/*
 * Created by ravenalb on 29-5-2017.
 */

import game.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Game game = new Game();

    @FXML
    private TextArea roomName;
    @FXML
    private TextArea roomDescription;
    @FXML
    private TextField actionTextField;
    @FXML
    private Button btnStart;
    @FXML
    private TextArea exitsOverview;
    @FXML
    private TextArea groundItems;
    @FXML
    private TextArea pcInventory;
    @FXML
    private TextArea coinPurse;

    @FXML
    private Button btnTest;

    @FXML
    private void handleActionTextField(ActionEvent event){
        actionTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    game.getPlayerAction(actionTextField.getText());
                    game.performAction();
                    displayRoomData();
                    actionTextField.clear();
                }
            }
        });
    }

    @FXML
    private void handleStartButton(){
        game.initializeGameData();
        displayRoomData();
    }

    @FXML
    private void handleTestButton(){
        openInventory();
        displayInventory();
    }

    private void displayRoomData(){
        roomName.setText(game.returnRoomName());
        roomDescription.setText(game.returnRoomDescription());
        exitsOverview.setText(game.returnRoomExits());
        groundItems.setText(game.returnRoomItems());
        pcInventory.setText(game.returnPcInventory());
        coinPurse.setText(game.returnCoinPurse());
    }

    private void openInventory(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/inv.fxml"));
            Parent inv = fxmlLoader.load();
            Stage inventoryStage = new Stage();
            inventoryStage.setScene(new Scene(inv));
            inventoryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void displayInventory(){
        pcInventory.setText(game.returnPcInventory());
        coinPurse.setText(game.returnCoinPurse());
    }


    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

}
