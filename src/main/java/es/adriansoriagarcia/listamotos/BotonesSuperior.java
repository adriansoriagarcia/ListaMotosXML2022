package es.adriansoriagarcia.listamotos;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BotonesSuperior extends HBox{
    public BotonesSuperior(Stage stage, Motos motos){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        Button ButtonFileSave = new Button("");
        ButtonFileSave.setGraphic(new ImageView("/images/guardar.PNG"));
        this.getChildren().add(ButtonFileSave);
        ButtonFileSave.setOnAction((t) -> {
            UtilXML.guardarDatosXml(stage, motos);
        });
        
        Button ButtonFileOpen = new Button("");
        ButtonFileOpen.setGraphic(new ImageView("/images/importar.PNG"));
        this.getChildren().add(ButtonFileOpen);
        ButtonFileOpen.setOnAction((t) -> {
            Motos motosImport = UtilXML.leerArchivoXML(stage);
            System.out.println("Numero de Motos importados: ");
            System.out.println(motosImport.getListaMotos().size());
            motos.fusionarMotos(motosImport);//1ª manera de pasar la lista
            
        });
    }
}
