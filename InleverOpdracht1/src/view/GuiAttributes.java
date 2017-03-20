package view;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javafx.scene.input.KeyCode.X;

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
    int[] list;


    final ToggleGroup toggleGroup = new ToggleGroup();

    public GuiAttributes(){
        try {
            this.resetButton = makeResetButton();
            this.stepButton = makeStepButton();
            this.radioBubble = makeRadioBubble();
            this.radioInsertion = makeRadioInsertion();
            this.radioQuick = makeRadioQuick();
            this.textAreaString = fillTextArea();
            this.textArea = testTextArea(fillTextArea());
            makeBarchart(this.list);
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

    private void makeBarchart(int[] list) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        List<Integer> lijst = new ArrayList<>(30);
//        lijst.add(2);
//        lijst.add(3);
//        lijst.add(4);
//        lijst.add(5);

        ObservableList<Integer> observableList = FXCollections.observableList(lijst);
        observableList.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                System.out.println("Detected change");
            }
        });

        observableList.add(2);
        observableList.add(3);
        observableList.add(4);
        observableList.add(5);
        observableList.add(6);
        observableList.add(7);

        String a = "A";
        String b = "B";

        BarChart<String, Number> bc =
        BarChart<String, Number> barChart =
                new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Sorting algorithm step-by-step");
        XYChart.Series series = new XYChart.Series();
//        series.getData(XYChart.Series(observableList<XYChart.Data<X,Y>> observableList));
//        series.getData().add(0, 6);
        series.getData().add(0, 1);
        series.getData().add(1,2);

        bc.setTitle("Sorting algorithm step-by-step");

        XYChart.Series series1 = new XYChart.Series();

        for (int item:list){
            series1.getData().add(new XYChart.Data(Integer.toString(item), item));
        }
        barChart.getData().addAll(series1);
        barChart.setBarGap(1);
        barChart.setCategoryGap(0);

        this.barChart = barChart;

        //Misschien ipv returnen daadwerkelijk maken.
    }

    private TextArea testTextArea(String list) throws Exception{
        TextArea textArea = new TextArea();
        textArea.setText(list);

        return textArea;
    }

    //-----------Event Handlers-----------
    private void doReset(){
        String array = fillTextArea();
        textArea.setText(array);
        //Maak de bar chart hier!
        System.out.println(textAreaString);
        System.out.println("Toggled: " + toggleGroup.getSelectedToggle());

    }

    private String fillTextArea(){
        int[] array = arrayCreation.createArray(30);
        textAreaString = Arrays.toString(array);
        list = array;
        makeBarchart(array);
        return textAreaString;
    }

}

