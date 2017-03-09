package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ArrayCreation;

public class Main extends Application{
    public static void main(String[] args){
        ArrayCreation arrayCreation = new ArrayCreation();
        int[] array = arrayCreation.createArray(30);

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Sorteerdingen met stapsgewijs");
        System.out.println("test");
    }
}
