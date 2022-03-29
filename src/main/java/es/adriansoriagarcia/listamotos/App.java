package es.adriansoriagarcia.listamotos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {
    ListaMotos listaMotos;
    @Override
    public void start(Stage stage) {
        Pane paneRoot;
        paneRoot = new Pane();
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
        Moto moto1 = new Moto("Honda", "CR");
        //System.out.println(moto1.getMarca());
        //moto1.setMarca("Honda");
        //System.out.println(moto1.getMarca());
        
        Moto moto2 = new Moto("Husqvarna");
        Moto moto3 = new Moto("Yamaha");
        
        listaMotos = new ListaMotos();
        listaMotos.getListaMotos().add(moto1);
        listaMotos.getListaMotos().add(moto2);
        listaMotos.getListaMotos().add(moto3);

        
        FileSave file = new FileSave(stage, listaMotos);
        paneRoot.getChildren().add(file);
        
        TableData tabla = new TableData(listaMotos);
        paneRoot.getChildren().add(tabla);
        
        
    }
    

    public static void main(String[] args) {
        launch();
    }

   
}