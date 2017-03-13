package view;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class GuiAttributes {
    Button resetButton;
    RadioButton radioButton;

    public GuiAttributes(){
        try {
            this.resetButton = makeResetButton();
            this.radioButton = makeRadioButtons();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private Button makeResetButton() throws Exception{
        Button button = new Button("Reset");
        return button;
    }

    private RadioButton makeRadioButtons() throws Exception{
        RadioButton radioBubble = new RadioButton();
        return radioBubble;
    }
}
