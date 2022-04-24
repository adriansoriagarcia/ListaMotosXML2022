package es.adriansoriagarcia.listamotos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/*
//Clase BotonesInferior contiene los botones siguientes y anterior para pasar de una moto a otra
*/
public class BotonesInferior extends HBox{
    Button ButtonSiguiente = new Button("");
    Button ButtonAtras = new Button("");
    int motoActual = 0;
    static int total;
    static int numMoto ;
    int cero = 0;
   public BotonesInferior(Motos motos){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        ButtonAtras.setGraphic(new ImageView("/images/anterior.PNG"));
        this.getChildren().add(ButtonAtras);
        ButtonSiguiente.setGraphic(new ImageView("/images/siguiente.PNG"));
        this.getChildren().add(ButtonSiguiente);
        MuestraMoto.tableView.requestFocus();
        total += motos.getListaMotos().size();
        if (total == 0) {
            numMoto = 0;
        } else {
            numMoto = 1;
        }
        ButtonAtras.setOnAction((t) -> {
            motoActual--;
            //if para control de errores.
            if(motos.getListaMotos().isEmpty()) {
                numMoto = 0;
            }
            if(numMoto <= 1 && motos.getListaMotos().isEmpty()) {
                numMoto = 0;
            }
            if(numMoto != 1 && numMoto > 1) {
                numMoto --;
            }
            
            LayoutPanel.textNum.setText(String.valueOf(numMoto));
            //System.out.println("numero de moto: " + motoActual);
            try{
                System.out.println(motos.getListaMotos().get(motoActual));
               final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
                //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
                MuestraMoto.tableView.setItems(datos);
              
            } catch(IndexOutOfBoundsException ex){
               ex.printStackTrace();
               motoActual = 0;
               total = 0;
               //numMoto = 1;
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               //alert.getDialogPane().setGraphic(new ImageView("/images/fallo.PNG"));
               alert.setHeaderText(null);
               alert.setTitle("Información");
               alert.setContentText("No existen mas motos");
               alert.showAndWait();
            }
        });

        ButtonSiguiente.setOnAction((t) -> {
            motoActual++;
            if (numMoto <= motos.getListaMotos().size() -1 ) {
               numMoto ++; 
            }
            LayoutPanel.textNum.setText(String.valueOf(numMoto));
            
            System.out.println("numero de moto: " + motoActual);
            try{
                final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
                //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
                MuestraMoto.tableView.setItems(datos);
                //MuestraMoto.tableView.requestFocus();
            } catch(IndexOutOfBoundsException ex){
                ex.printStackTrace();
                motoActual= motos.getListaMotos().size() - 1;
                total = motos.getListaMotos().size() - 1;
                numMoto = motos.getListaMotos().size();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("No existen mas motos");
                alert.showAndWait();
            } catch (Exception ex){
                 ex.printStackTrace();
            }

        }); 

        if(motos.getListaMotos().size() != 0){
            final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
            //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
            MuestraMoto.tableView.setItems(datos);
        }
    }

}
