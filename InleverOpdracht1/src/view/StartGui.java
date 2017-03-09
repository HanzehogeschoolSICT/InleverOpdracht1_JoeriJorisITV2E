package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGui extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Sorteerdingen met stapsgewijs");
        System.out.println("test");

        Scene scene = new Scene(new GuiSettings().gridPane,550,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
