package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class GuiSettings {
    private GridPane gridPane () throws Exception{
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        return gridPane;
    }
}
