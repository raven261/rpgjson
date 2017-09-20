package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * Created by ravenalb on 29-5-2017.
 */
public class Main extends Application {


    private AnchorPane ui;
    private AnchorPane inv;

    @Override
    public void start(Stage primaryStage){
        try{
            //BorderPane root = new BorderPane();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui.fxml"));
            ui = loader.load();

            Scene scene = new Scene(ui);
            primaryStage.setTitle("RPG game");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }


//
//        initUiLayout();
        //inventoryScreen();
    }

//    public void inventoryScreen(){
//        try{
//
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inv.fxml"));
//            inv = loader.load();
//            Stage inventoryStage = new Stage();
//
//            Scene invScene = new Scene(inv);
//            inventoryStage.setTitle("Inventory");
//            inventoryStage.setScene(invScene);
//            inventoryStage.show();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

//    public Stage getPrimaryStage(){
//        return primaryStage;
//    }

    public static void main(String[] args) {
        launch(args);
    }

}
