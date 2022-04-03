package es.adriansoriagarcia.listamotos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
        Moto moto1 = new Moto("Honda", "CR");
        //System.out.println(moto1.getMarca());
        //moto1.setMarca("Honda");
        //System.out.println(moto1.getMarca());
        
        Moto moto2 = new Moto("Husqvarna");
        Moto moto3 = new Moto("Yamaha");
        
        motos = new Motos();
        motos.getListaMotos().add(moto1);
        motos.getListaMotos().add(moto2);
        motos.getListaMotos().add(moto3);
        
        //System.out.println(listaMotos.getListaMotos());
        
        Button ButtonFileSave = new Button("Guardar");
        
        //ButtonFileSave.setLayoutX(550);
        paneRoot.getChildren().add(ButtonFileSave);
        ButtonFileSave.setOnAction((t) -> {
            UtilXML.guardarDatosXml(stage, motos);
        });
        
        Button ButtonFileOpen = new Button("Abrir");
        //ButtonFileOpen.setLayoutX(550);
        //ButtonFileOpen.setLayoutY(50);
        paneRoot.getChildren().add(ButtonFileOpen);
        ButtonFileOpen.setOnAction((t) -> {
            Motos motosImport = UtilXML.leerArchivoXML(stage);
            System.out.println("Numero de Motos importados: ");
            System.out.println(motosImport.getListaMotos().size());
            motos.fusionarMotos(motosImport);//1ª manera de pasar la lista
            
        });
        
        MuestraMoto muestra = new MuestraMoto();
        paneRoot.getChildren().add(muestra);
        
        
    }
    

    public static void main(String[] args) {
        launch();
    }

   
}