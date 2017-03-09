package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class GuiSettings {

    GridPane gridPane;

    public GuiSettings(){
        try{
            this.gridPane = makeGridPane();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private GridPane makeGridPane() throws Exception{
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        return gridPane;
    }
}
