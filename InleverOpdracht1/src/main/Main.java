package main;

import javafx.application.Application;
import model.ArrayCreation;

import view.StartGui;

public abstract class Main extends Application{
    public static void main(String[] args){
        ArrayCreation arrayCreation = new ArrayCreation();
        int[] array = arrayCreation.createArray(30);

        StartGui.launch(args);

    }

}
