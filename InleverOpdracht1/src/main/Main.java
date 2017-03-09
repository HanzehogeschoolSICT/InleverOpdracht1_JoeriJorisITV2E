package main;

import model.ArrayCreation;

public class Main{
    public static void main(String[] args){
        ArrayCreation arrayCreation = new ArrayCreation();
        int[] array = arrayCreation.createArray(30);

//        new Thread(){
//            @Override
//            public void run(){
        javafx.application.Application.launch(view.StartGui.class);
//            }
//        }.start();

    }

}
