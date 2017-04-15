package view;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import model.Controller_Event;

public class StartGui extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        GuiSettings guiSettings = new GuiSettings();
        primaryStage.setTitle("Sorteeralgoritmen per stap");

        primaryStage.setScene(guiSettings.scene);
        primaryStage.setOnCloseRequest(
                event -> System.exit(0)
        );
        primaryStage.show();


        guiSettings.set_controller_eventhandler(new Controller_Event() {
            @Override
            public void event(int event_id, Object extra_info) {
                if (event_id == GuiAttributes.BUTTON_BUBBLE || event_id == GuiAttributes.BUTTON_INSERTION){
                    primaryStage.setScene(guiSettings.scene);
                }
            }
        });
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
