package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Created by ravenalb on 29-5-2017.
 */
public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("game.fxml"));
        primaryStage.setTitle("RPG");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        //final Scene scene1 = new Scene(game, 700, 500);

       // primaryStage.setScene(scene1);
    }


    public static void main(String[] args) {


        launch(args);
    }

}
