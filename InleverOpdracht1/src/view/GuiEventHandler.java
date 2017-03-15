package view;

import javafx.event.ActionEvent;

public class GuiEventHandler {
    public void doReset(ActionEvent event){
        System.out.println(event);
        System.out.println("Nu moet de array opnieuw gevuld worden.");
//        System.out.println("Toggled: " + GuiAttributes.toggleGroup.getSelectedToggle());
    }
}
