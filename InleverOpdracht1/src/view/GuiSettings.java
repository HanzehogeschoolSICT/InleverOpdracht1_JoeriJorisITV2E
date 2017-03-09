package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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

    private GridPane makeRootGridPane() throws Exception{
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(25,25,25,25));

        gridPane.setGridLinesVisible(true);

        VBox vBox = makeVBox();
        GridPane bottomPane = makeBottomGridpane();

        bottomPane.setGridLinesVisible(true);

        gridPane.getChildren().addAll(vBox,bottomPane);

        return gridPane;
    }

    private VBox makeVBox() throws Exception{
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(25,25,25,25));
        vBox.isVisible();

        return vBox;
    }

    private GridPane makeBottomGridpane() throws Exception{
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        return gridPane;
    }

    private Scene makeScene() throws Exception{
        GridPane rootPane = makeRootGridPane();
        Scene scene = new Scene(rootPane,650,400);
        return scene;
    }
}
