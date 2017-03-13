package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class GuiAttributes {
    Button resetButton;
    RadioButton radioBubble;
    RadioButton radioInsertion;
    RadioButton radioQuick;
    TextArea textArea;

    final ToggleGroup toggleGroup = new ToggleGroup();

    public GuiAttributes(){
        try {
            this.resetButton = makeResetButton();
            this.radioBubble = makeRadioBubble();
            this.radioInsertion = makeRadioInsertion();
            this.radioQuick = makeRadioQuick();
            this.textArea = testTextArea();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private Button makeResetButton() throws Exception{
        Button button = new Button("Reset");
        button.setMaxWidth(Double.MAX_VALUE);
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

    private TextArea testTextArea() throws Exception{
        TextArea textArea = new TextArea();
        textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam consequat, neque eget lacinia consequat, arcu tellus iaculis nisi, quis elementum ante nulla eu erat. Integer arcu purus, ultricies id egestas et, molestie sit amet nisi. Mauris venenatis tristique diam ac pellentesque. In molestie sapien in ipsum congue, et aliquam nulla volutpat. In hac habitasse platea dictumst. Sed posuere faucibus dignissim. Quisque tempus fringilla finibus. Sed tristique magna nec lectus commodo, ac laoreet turpis ullamcorper.\n" +
                "\n" +
                "Ut convallis velit id finibus iaculis. Nulla facilisi. Integer tempus, ante vitae convallis aliquet, sapien odio mattis eros, quis ultrices ante sem nec odio. Donec a nulla id sapien porttitor volutpat. Donec ullamcorper eleifend nibh et tristique. Aenean accumsan justo sed leo iaculis, vitae sollicitudin ante blandit. Mauris sed dui metus. Cras tincidunt tristique purus at ullamcorper.\n" +
                "\n" +
                "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec non tincidunt mi, ut aliquet nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eleifend ut nunc et suscipit. Morbi a pulvinar tortor. Donec finibus nisi justo, nec mattis nisi feugiat vitae. Vestibulum id quam at erat convallis tincidunt vel eget urna.\n" +
                "\n" +
                "Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras diam dolor, commodo rutrum aliquet id, hendrerit quis purus. Vivamus nec gravida nisl. Etiam ultricies est in justo vulputate, nec tempus eros tempor. Maecenas at dui turpis. Mauris volutpat, odio at malesuada dapibus, metus nibh tincidunt nisi, quis dictum augue diam vel sapien. In cursus volutpat nulla hendrerit commodo. Nam mollis nibh quis congue maximus. Morbi turpis massa, fringilla malesuada nisl eu, suscipit blandit lorem.\n" +
                "\n" +
                "Aenean nec fringilla turpis. Integer consequat scelerisque congue. Proin blandit nec nunc in tristique. Praesent sit amet eros condimentum, dictum ligula in, varius risus. In at tellus sem. Sed vestibulum orci eget blandit posuere. Morbi eros dui, eleifend sed nulla ac, ultrices dapibus arcu.");

        return textArea;
    }
}
