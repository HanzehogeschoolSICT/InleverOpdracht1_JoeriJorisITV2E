package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GuiSettings {

    Scene scene;

    public GuiSettings(){
        try{
            this.scene = makeScene();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private BorderPane makeRootVBox() throws Exception{
        BorderPane vBox = new BorderPane();

        vBox.visibleProperty();

        HBox hBox = makeHBox();
        HBox bottomPane = makeBottomGridpane();

        vBox.borderProperty();

        GuiAttributes guiAttributes = new GuiAttributes();

        hBox.getChildren().add(
                guiAttributes.textArea);
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
