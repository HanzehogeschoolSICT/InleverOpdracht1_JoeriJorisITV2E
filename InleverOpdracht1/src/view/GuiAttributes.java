package view;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import model.ArrayCreation;
import model.BubbleStep;

import java.util.Arrays;

public class GuiAttributes {
    Button resetButton;
    Button stepButton;
    RadioButton radioBubble;
    RadioButton radioInsertion;
    RadioButton radioQuick;
    TextArea textArea;
    String textAreaString;
    ArrayCreation arrayCreation = new ArrayCreation();
    int[] currentArray;


    final ToggleGroup toggleGroup = new ToggleGroup();

    public GuiAttributes(){
        try {
            this.resetButton = makeResetButton();
            this.stepButton = makeStepButton();
            this.radioBubble = makeRadioBubble();
            this.radioInsertion = makeRadioInsertion();
            this.radioQuick = makeRadioQuick();
            this.textAreaString = fillTextArea();
            this.textArea = testTextArea(textAreaString);
            this.currentArray = arrayCreation.createArray(20);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Button makeResetButton() throws Exception{
        Button button = new Button("Reset");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setOnAction(e -> doReset());

        return button;
    }

    private Button makeStepButton() throws Exception{
        Button button = new Button("Step");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setOnAction(e -> doStep());

        return button;
    }

    private RadioButton makeRadioBubble() throws Exception{
        RadioButton radioBubble = new RadioButton();
        radioBubble.setToggleGroup(toggleGroup);
        radioBubble.setMaxWidth(Double.MAX_VALUE);
        radioBubble.setAlignment(Pos.CENTER);
        radioBubble.setText("Bubble sort");

        return radioBubble;
    }

    private RadioButton makeRadioInsertion() throws Exception{
        RadioButton radioInsertion = new RadioButton();
        radioInsertion.setToggleGroup(toggleGroup);
        radioInsertion.setMaxWidth(Double.MAX_VALUE);
        radioInsertion.setAlignment(Pos.CENTER);
        radioInsertion.setText("Insertion sort");

        return radioInsertion;
    }

    private RadioButton makeRadioQuick() throws Exception{
        RadioButton radioQuick = new RadioButton();
        radioQuick.setToggleGroup(toggleGroup);
        radioQuick.setMaxWidth(Double.MAX_VALUE);
        radioQuick.setAlignment(Pos.CENTER);
        radioQuick.setText("Quick sort");

        return radioQuick;
    }

    private TextArea testTextArea(String list) throws Exception{
        TextArea textArea = new TextArea();
        textArea.setText(list);

        return textArea;
    }

    //-----------Event Handlers-----------
    private void doReset(){
        currentArray = arrayCreation.createArray(20);
        String currentArrayString = Arrays.toString(currentArray);
        textArea.setText(currentArrayString);
        System.out.println(currentArrayString);
        System.out.println("Toggled: " + toggleGroup.getSelectedToggle());

    }

    private void doStep(){
        textArea.setText(Arrays.toString(BubbleStep.bubbleStep(currentArray)));
    }

    private String fillTextArea(){
        textAreaString = Arrays.toString(arrayCreation.createArray(20));
        return textAreaString;
    }

}

