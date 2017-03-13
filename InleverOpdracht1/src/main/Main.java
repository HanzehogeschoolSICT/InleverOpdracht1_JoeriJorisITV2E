package main;

import model.ArrayCreation;

public class Main{
    public static void main(String[] args){
        ArrayCreation arrayCreation = new ArrayCreation();
        int[] array = arrayCreation.createArray(30);
        System.out.println(array);
        array = model.InsertionStep.insertionStep(array);
        System.out.println(array);
        javafx.application.Application.launch(view.StartGui.class);
    }

}
