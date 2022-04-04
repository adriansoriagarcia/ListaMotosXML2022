package es.adriansoriagarcia.listamotos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {
    Motos motos;
    @Override
    public void start(Stage stage) {
        VBox paneRoot;
        paneRoot = new VBox();
        paneRoot.setAlignment(Pos.CENTER);
        paneRoot.setSpacing(30);
        
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
        Moto moto1 = new Moto("Honda", "CR");
        Moto moto2 = new Moto("Husqvarna");
        Moto moto3 = new Moto("Yamaha");
        
        motos = new Motos();
        motos.getListaMotos().add(moto1);
        motos.getListaMotos().add(moto2);
        motos.getListaMotos().add(moto3);
        
        //System.out.println(listaMotos.getListaMotos());
        
        Button ButtonFileSave = new Button("Guardar");
        
        paneRoot.getChildren().add(ButtonFileSave);
        ButtonFileSave.setOnAction((t) -> {
            UtilXML.guardarDatosXml(stage, motos);
        });
        
        Button ButtonFileOpen = new Button("Importar");

        paneRoot.getChildren().add(ButtonFileOpen);
        ButtonFileOpen.setOnAction((t) -> {
            Motos motosImport = UtilXML.leerArchivoXML(stage);
            System.out.println("Numero de Motos importados: ");
            System.out.println(motosImport.getListaMotos().size());
            motos.fusionarMotos(motosImport);//1ª manera de pasar la lista
            
        });
        
        MuestraMoto muestra = new MuestraMoto(motos);
        paneRoot.getChildren().add(muestra);
        
        
    }
    

    public static void main(String[] args) {
        launch();
    }

   
}