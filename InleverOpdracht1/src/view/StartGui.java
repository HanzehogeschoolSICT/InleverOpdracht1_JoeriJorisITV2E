package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartGui extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Sorteerdingen met stapsgewijs");
        System.out.println("test");

        primaryStage.setScene(new GuiSettings().scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
