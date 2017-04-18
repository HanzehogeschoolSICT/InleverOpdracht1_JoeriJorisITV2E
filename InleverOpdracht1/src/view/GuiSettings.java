package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Controller_Event;

public class GuiSettings {

    Scene scene;
    GuiAttributes guiAttributes = new GuiAttributes();
    public Controller_Event controller_event;

    public void set_controller_eventhandler(Controller_Event controller_event) {
        this.controller_event=controller_event;
    }

    public GuiSettings(){
        try{
            this.scene = makeScene();
        } catch (Exception e){
            e.printStackTrace();
        }

        guiAttributes.set_controller_eventhandler(new Controller_Event() {
            @Override
            public void event(int event_id, Object extra_info) {
                if (event_id == GuiAttributes.BUTTON_BUBBLE){
                    try {
                        scene = makeScene();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    controller_event.event(GuiAttributes.BUTTON_BUBBLE, null);
                }
                else if (event_id == GuiAttributes.BUTTON_INSERTION){
                    try {
                        scene = makeScene();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    controller_event.event(GuiAttributes.BUTTON_INSERTION, null);
                }
                else if (event_id == GuiAttributes.BUTTON_QUICK){
                    try{
                        scene = makeScene();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    controller_event.event(GuiAttributes.BUTTON_QUICK, null);
                }
            }
        });
    }

    private BorderPane makeRootVBox() throws Exception{
        BorderPane vBox = new BorderPane();

        vBox.visibleProperty();

        HBox hBox = makeHBox();
        HBox bottomPane = makeBottomGridpane();

        vBox.borderProperty();


        hBox.getChildren().add(
                guiAttributes.barChart);
        bottomPane.getChildren().addAll(
                guiAttributes.radioBubble,
                guiAttributes.radioInsertion,
                guiAttributes.radioQuick,
                guiAttributes.runButton,
                guiAttributes.stepButton,
                guiAttributes.resetButton);
        vBox.setCenter(hBox);
        vBox.setBottom(bottomPane);

        return vBox;
    }

    private HBox makeHBox() throws Exception{
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setPadding(new Insets(25,25,25,25));
        hBox.isVisible();

        return hBox;
    }

    private HBox makeBottomGridpane() throws Exception{
        HBox gridPane = new HBox();
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        gridPane.setPadding(new Insets(25,25,25,25));

        return gridPane;
    }

    private Scene makeScene() throws Exception{
        BorderPane rootPane = makeRootVBox();
        Scene scene = new Scene(rootPane,650,400);
        return scene;
    }


}
