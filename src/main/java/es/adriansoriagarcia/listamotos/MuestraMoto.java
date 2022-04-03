package es.adriansoriagarcia.listamotos;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class MuestraMoto extends VBox {
    public MuestraMoto(){
        TextArea textArea = new TextArea(
        "This is an editable JTextArea. " +
        "A text area is a \"plain\" text component, " +
        "which means that although it can display text " +
        "in any font, all of the text is in the same font.");

       this.getChildren().add(textArea);
    }
}
