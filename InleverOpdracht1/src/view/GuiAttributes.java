package view;

import javafx.application.Platform;
import javafx.collections.ObservableArray;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import model.ArrayCreation;
import model.BubbleStep;
import model.Controller_Event;
import model.InsertionStep;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class GuiAttributes {
    Button resetButton;
    Button stepButton;
    Button runButton;
    Boolean autoBoolean = false;
    RadioButton radioBubble;
    RadioButton radioInsertion;
    TextArea textArea;
    Canvas canvas;
    BarChart barChart;
    String textAreaString;
    ArrayCreation arrayCreation = new ArrayCreation();

    int[] currentArray;

    InsertionStep insertionStep = new InsertionStep();
    BubbleStep bubbleStep = new BubbleStep();

    final ToggleGroup toggleGroup = new ToggleGroup();
    public static final int BUTTON_BUBBLE = 1;
    public static final int BUTTON_INSERTION = 2;

    public Controller_Event controller_event;

    public void set_controller_eventhandler(Controller_Event controller_event) {
        this.controller_event=controller_event;
    }

    public GuiAttributes(){
        try {
            this.resetButton = makeResetButton();
            this.stepButton = makeStepButton();
            this.runButton = makeRunButton();
            this.radioBubble = makeRadioBubble();
            this.radioInsertion = makeRadioInsertion();
            this.textAreaString = fillTextArea();
            this.textArea = testTextArea(textAreaString);
            this.canvas = new Canvas();

            this.currentArray = arrayCreation.createArray(20);
            makeBarchart();


            Timer timer = new Timer( );
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        if (autoBoolean) {
                            tryStep();
                        }
                    });
                }
            }, 1000, 1000);

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
        button.setOnAction(e -> tryStep());

        return button;
    }

    private Button makeRunButton(){
        Button button = new Button("Auto Run");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setOnAction(e -> {
            try {
                autoRun();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

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

    private TextArea testTextArea(String list) throws Exception{
        TextArea textArea = new TextArea();
        textArea.setText(list);

        return textArea;
    }

    //-----------Event Handlers-----------
    private void autoRun() throws InterruptedException {
        autoBoolean ^= true;
    }

    private void doReset(){
        currentArray = arrayCreation.createArray(20);
        String currentArrayString = Arrays.toString(currentArray);
        textArea.setText(currentArrayString);

    }

   private void tryStep(){
        try {
            if (toggleGroup.getSelectedToggle().toString().contains("Bubble")) {
                textArea.setText(Arrays.toString(bubbleStep.doStep(currentArray)));
                makeBarchart();
                controller_event.event(BUTTON_BUBBLE, null);
            } else if (toggleGroup.getSelectedToggle().toString().contains("Insertion")) {
                textArea.setText(Arrays.toString(insertionStep.doStep(currentArray)));
                makeBarchart();
                controller_event.event(BUTTON_INSERTION, null);
            }
        } catch (NullPointerException e){
            System.out.println("Er is geen sorterings algoritme geselecteerd");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String fillTextArea(){
        textAreaString = Arrays.toString(arrayCreation.createArray(20));
        return textAreaString;
    }

    private void makeBarchart(){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart =
                new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Sorting algorithm step-by-step");

        XYChart.Series series1 = new XYChart.Series();

        for (int item:currentArray){
            series1.getData().add(new XYChart.Data(Integer.toString(item), item));
        }
        barChart.getData().addAll(series1);
        barChart.setBarGap(1);
        barChart.setCategoryGap(0);

        this.barChart = barChart;
    }

}

