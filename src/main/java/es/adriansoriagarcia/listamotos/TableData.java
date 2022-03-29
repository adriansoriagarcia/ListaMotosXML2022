package es.adriansoriagarcia.listamotos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableData extends TableView {

    //private ObservableList<Moto> listaMotos;
    public TableData(ListaMotos listaMotos){
        TableColumn<Moto, String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        TableColumn<Moto, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        TableColumn<Moto, String> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        TableColumn<Moto, String> colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        TableColumn<Moto, String> colAnio = new TableColumn<>("Año");
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        TableColumn<Moto, String> colCilindrada = new TableColumn<>("Cilindrada");
        colCilindrada.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));
        this.getColumns().addAll(colMarca, colModelo, colPrecio,colPeso,colAnio,colCilindrada);
        this.setItems(data);
        
        

    }
    
     private final ObservableList<Moto> data =
        FXCollections.observableArrayList(
            new Moto("Honda", "CR"),
            new Moto("Husqvarna"),
            new Moto("Yamaha"),
            new Moto("Suzuki"),
            new Moto("KTM ")      
    );
     



}
