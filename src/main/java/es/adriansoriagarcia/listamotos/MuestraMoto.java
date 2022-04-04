package es.adriansoriagarcia.listamotos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class MuestraMoto extends VBox {
    static TextArea textArea;
    int motoActual = 0;
    public MuestraMoto(Motos motos){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        textArea = new TextArea();
        
        textArea.setEditable(false);

        this.getChildren().add(textArea);
        
        TableView tableView = new TableView();
        TableColumn colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        TableColumn colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        TableColumn colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        TableColumn colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory("peso"));
        TableColumn colAnio = new TableColumn<>("Año");
        colAnio.setCellValueFactory(new PropertyValueFactory("año"));
        TableColumn colCilindrada = new TableColumn<>("Cilindrada");
        colCilindrada.setCellValueFactory(new PropertyValueFactory("cilindrada"));
        tableView.getColumns().addAll(colMarca, colModelo, colPrecio, colPeso, colAnio, colCilindrada);
        tableView.getStylesheets().add("css/style.css");
        
        this.getChildren().add(tableView);
        
        Button ButtonSiguiente = new Button("Siguiente");
        this.getChildren().add(ButtonSiguiente);
       
        Button ButtonAtras = new Button("Anterior");
        this.getChildren().add(ButtonAtras);
        
        ButtonAtras.setOnAction((t) -> {
            motoActual--;
            System.out.println("numero de moto: " + motoActual);
            try{
               textArea.setText(motos.getListaMotos().get(motoActual).toString());
               
               final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
                //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
                tableView.setItems(datos);
              
            } catch(IndexOutOfBoundsException ex){
               ex.printStackTrace();
               motoActual = 0;
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText(null);
               alert.setTitle("Información");
               alert.setContentText("No existen mas motos");
               alert.showAndWait();
            }
        });

        ButtonSiguiente.setOnAction((t) -> {
            motoActual++;
            System.out.println("numero de moto: " + motoActual);
            try{
               textArea.setText(motos.getListaMotos().get(motoActual).toString());
                
                final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
                //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
                tableView.setItems(datos);
            } catch(IndexOutOfBoundsException ex){
                ex.printStackTrace();
                motoActual= motos.getListaMotos().size() - 1;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("No existen mas motos");
                alert.showAndWait();
            }

        }); 

        textArea.setText(motos.getListaMotos().get(motoActual).toString());

        final ObservableList<Moto> datos = FXCollections.observableArrayList(motos.getListaMotos().get(motoActual));
        //Agregamos los datos en la tabla, aquí la tabla ya muestra la información.
        tableView.setItems(datos);
       
       
    }
}
