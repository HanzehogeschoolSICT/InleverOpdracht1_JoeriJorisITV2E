package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.List;

public class GuiAttributes {
    Button resetButton;
    Button stepButton;
    RadioButton radioBubble;
    RadioButton radioInsertion;
    RadioButton radioQuick;
    BarChart barChart;
    ArrayCreation arrayCreation = new ArrayCreation();

    List<Integer> listForObservable;
    ObservableList<Integer> observableList;


    final ToggleGroup toggleGroup = new ToggleGroup();

    public GuiAttributes(){
        try {
            this.resetButton = makeResetButton();
            this.stepButton = makeStepButton();
            this.radioBubble = makeRadioBubble();
            this.radioInsertion = makeRadioInsertion();
            this.radioQuick = makeRadioQuick();
            this.listForObservable = new ArrayList<>(30);
            this.observableList = FXCollections.observableList(listForObservable);
            this.barChart = makeBarchart(observableList);

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

    private BarChart makeBarchart(ObservableList<Integer> observable) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

//        observableList.addListener(new ListChangeListener<Integer>() {
//            @Override
//            public void onChanged(Change<? extends Integer> c) {
//                System.out.println("Detected change");
//            }
//        });

        BarChart<String, Number> barChart =
                new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Sorting algorithm step-by-step");
        XYChart.Series series = new XYChart.Series();

        for (int item:observable){
            series.getData().add(new XYChart.Data(Integer.toString(item), item));
        }
        barChart.getData().addAll(series);
        barChart.setBarGap(1);
        barChart.setCategoryGap(0);

        return barChart;
    }

    private TextArea testTextArea(String list) throws Exception{
        TextArea textArea = new TextArea();
        textArea.setText(list);

        return textArea;
    }

    //-----------Event Handlers-----------
    private void doReset(){
        fillObservableList();
        //Maak de bar chart hier met de nieuwe class variable observable list!
        System.out.println("Toggled: " + toggleGroup.getSelectedToggle());

    }

    private void fillObservableList(){
        int[] array = arrayCreation.createArray(30);
        for (int item: array){
            observableList.add(item);
        }
    }

}

