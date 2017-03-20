package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartGui extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Sorteeralgoritmen per stap");

        primaryStage.setScene(new GuiSettings().scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
