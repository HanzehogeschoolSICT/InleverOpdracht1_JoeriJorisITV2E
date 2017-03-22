package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import model.ArrayCreation;
import model.BubbleStep;
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
    String textAreaString;
    ArrayCreation arrayCreation = new ArrayCreation();
    int[] currentArray;
    int currentAutoRun = 0;


    final ToggleGroup toggleGroup = new ToggleGroup();

    public GuiAttributes(){
        try {
            this.resetButton = makeResetButton();
            this.stepButton = makeStepButton();
            this.runButton = makeRunButton();
            this.radioBubble = makeRadioBubble();
            this.radioInsertion = makeRadioInsertion();
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
        Timer timer = new Timer( );
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //gaat ineens sneller lopen als pauze
                if (autoBoolean){
                    doStep();
                    System.out.println("Timer at "+ currentAutoRun);
                    currentAutoRun +=1;
                }
            }
        }, 1000, 1000);
    }

    private void doReset(){
        currentArray = arrayCreation.createArray(20);
        String currentArrayString = Arrays.toString(currentArray);
        textArea.setText(currentArrayString);
        System.out.println(currentArrayString);
        System.out.println("Toggled: " + toggleGroup.getSelectedToggle());

    }

    private void doStep(){
        try {
            if (toggleGroup.getSelectedToggle().toString().contains("Bubble")) {
                textArea.setText(Arrays.toString(BubbleStep.bubbleStep(currentArray)));
            } else if (toggleGroup.getSelectedToggle().toString().contains("Insertion")) {
                textArea.setText(Arrays.toString(InsertionStep.insertionStep(currentArray)));
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

}

