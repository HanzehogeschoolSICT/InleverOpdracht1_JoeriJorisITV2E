package view;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import model.ArrayCreation;

import java.util.Arrays;

public class GuiAttributes {
    Button resetButton;
    Button stepButton;
    RadioButton radioBubble;
    RadioButton radioInsertion;
    RadioButton radioQuick;
    TextArea textArea;
    String textAreaString;
    BarChart barChart;
    ArrayCreation arrayCreation = new ArrayCreation();


    final ToggleGroup toggleGroup = new ToggleGroup();

    public GuiAttributes(){
        try {
//            int[] array = arrayCreation.createArray(30);
            this.resetButton = makeResetButton();
            this.stepButton = makeStepButton();
            this.radioBubble = makeRadioBubble();
            this.radioInsertion = makeRadioInsertion();
            this.radioQuick = makeRadioQuick();
            this.textAreaString = fillTextArea();
            this.textArea = testTextArea(fillTextArea());
//            this.textArea = testTextArea(Arrays.toString(arrayCreation.array));
            this.barChart = makeBarchart();
            this.textArea = testTextArea(textAreaString);
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
//        button.setOnAction(e -> doReset()); MOET NOG FUNCTION VOOR WORDEN GEMAAKT

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

    private BarChart makeBarchart() {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> bc =
                new BarChart<>(xAxis, yAxis);
//        XYChart.Series series = new XYChart.Series();
//        series.getData().add(5, 6);
        bc.setTitle("Sorting algorithm step-by-step");

        return bc;
    }

    private TextArea testTextArea(String list) throws Exception{
        TextArea textArea = new TextArea();
        textArea.setText(list);

        return textArea;
    }

    //-----------Event Handlers-----------
    private void doReset(){
        textArea.setText(fillTextArea());
        System.out.println(textAreaString);
        System.out.println("Toggled: " + toggleGroup.getSelectedToggle());

    }

    private String fillTextArea(){
        textAreaString = Arrays.toString(arrayCreation.createArray(30));
        return textAreaString;
    }

}

