package main;

import javafx.application.Platform;

public class Main {
    public static void main(String[] args) {
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                // Update UI here.
//            }
//        });
        javafx.application.Application.launch(view.StartGui.class);
    }
}