package es.adriansoriagarcia.listamotos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        paneRoot.setStyle("-fx-background-image:url('images/background.jpg');");
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Moto moto1 = new Moto("Honda", "CR");
        Moto moto2 = new Moto("Husqvarna");
        Moto moto3 = new Moto("Yamaha");
        Moto moto4 = new Moto("KTM","EXC",2000,100,2020,250);
        
        motos = new Motos();
        motos.getListaMotos().add(moto1);
        motos.getListaMotos().add(moto2);
        motos.getListaMotos().add(moto3);
        motos.getListaMotos().add(moto4);
        
        //System.out.println(listaMotos.getListaMotos());
        
        //añadimos la clase botonesSuperior al panel.
        BotonesSuperior botonesSuperior = new BotonesSuperior(stage, motos);
        paneRoot.getChildren().add(botonesSuperior);
        
        //añadimos la clase MuestraMoto al panel.
        MuestraMoto muestra = new MuestraMoto(motos);
        paneRoot.getChildren().add(muestra);
        
        //añadimos la clase BotonesInferior al panel.
        BotonesInferior botonesInferior = new BotonesInferior(motos);
        paneRoot.getChildren().add(botonesInferior);
        
        //añadimos la clase LayoutPanel al panel.
        LayoutPanel layout = new LayoutPanel(motos);
        paneRoot.getChildren().add(layout);
        
    }
    

    public static void main(String[] args) {
        launch();
    }

   
}