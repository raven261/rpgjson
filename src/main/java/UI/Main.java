package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * Created by ravenalb on 29-5-2017.
 */
public class Main extends Application {


    private AnchorPane ui;

    @Override
    public void start(Stage primaryStage){
        try{
            BorderPane root = new BorderPane();

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
    }

//    public void initUiLayout(){
//        try{
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("C:\\Users\\ravenalb\\IdeaProjects\\jsonTest\\src\\main\\java\\UI\\ui.fxml"));
//            ui = loader.load();
//
//            Scene scene = new Scene(ui);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        }catch(IOException e){
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
