package es.adriansoriagarcia.listamotos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BotonesInferior extends HBox{
    Button ButtonSiguiente = new Button("");
    Button ButtonAtras = new Button("");
    int motoActual = 0;
    static int total;
    int numMoto = 1;
   public BotonesInferior(Motos motos){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        ButtonAtras.setGraphic(new ImageView("/images/anterior.PNG"));
        this.getChildren().add(ButtonAtras);
        ButtonSiguiente.setGraphic(new ImageView("/images/siguiente.PNG"));
        this.getChildren().add(ButtonSiguiente);
        MuestraMoto.tableView.requestFocus();
        total += motos.getListaMotos().size();
        ButtonAtras.setOnAction((t) -> {
            motoActual--;
            if(numMoto != 1) {
                numMoto --;
            }
            //numMoto --;
            LayoutPanel.textNum.setText(String.valueOf(numMoto));
            System.out.println("numero de moto: " + motoActual);
            try{
                System.out.println(motos.getListaMotos().get(motoActual));
               final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
                //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
                MuestraMoto.tableView.setItems(datos);
              
            } catch(IndexOutOfBoundsException ex){
               ex.printStackTrace();
               motoActual = 0;
               total = 0;
               numMoto = 1;
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText(null);
               alert.setTitle("Información");
               alert.setContentText("No existen mas motos");
               alert.showAndWait();
            }
        });

        ButtonSiguiente.setOnAction((t) -> {
            System.out.println(motos.getListaMotos().get(motoActual));
            motoActual++;
            if (numMoto <= motos.getListaMotos().size() -1) {
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
            }

        }); 

        //BotonesInferior.ButtonAtras.setVisible(false);
        final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
        //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
        MuestraMoto.tableView.setItems(datos);
        
        //layoutPanel();
    
    }
    
    /*
     * Muestra los intentos restantes y el tiempo de la cuenta atras.
    */
    /*private void layoutPanel(){
        this.setSpacing(10);//Espacio entre componentes.
        //Texto de etiqueta para tiempo
        textMoto = new Text("Moto");
        textMoto.setFont(Font.font(TEXT_SIZE));
        textMoto.setFill(Color.BLACK);
        textMoto.setLayoutX(200);
        //Texto para el tiempo restante
        textNum = new Text("1");
        textNum.setFont(Font.font(TEXT_SIZE));
        textNum.setFill(Color.BLACK);
        
        textDe = new Text("de");
        textDe.setFont(Font.font(TEXT_SIZE));
        textDe.setFill(Color.BLACK);
        
        textTotal = new Text(""+total);
        textTotal.setFont(Font.font(TEXT_SIZE));
        textTotal.setFill(Color.BLACK);
        
        this.getChildren().add(textMoto);
        this.getChildren().add(textNum);
        this.getChildren().add(textDe);
        this.getChildren().add(textTotal);

        //-------------------------------------------------
          
    }*/
}
