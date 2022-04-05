package es.adriansoriagarcia.listamotos;

import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class MuestraMoto extends VBox {
    static TableView tableView;
    int motoActual = 0;
    public MuestraMoto(Motos motos){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
 
        tableView = new TableView();
        TableColumn colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory("marca"));//obtiene el valor del dato deseado.
        TableColumn colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        TableColumn colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        TableColumn colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory("peso"));
        TableColumn colAnio = new TableColumn<>("Año");
        colAnio.setCellValueFactory(new PropertyValueFactory("anio"));
        TableColumn colCilindrada = new TableColumn<>("Cilindrada");
        colCilindrada.setCellValueFactory(new PropertyValueFactory("cilindrada"));
        tableView.getColumns().addAll(colMarca, colModelo, colPrecio, colPeso, colAnio, colCilindrada);
        tableView.getStylesheets().add("css/style.css");
        //todas las columnas cambiarán su tamaño por igual hasta que se alcance el ancho máximo de TableView
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMaxHeight(50);
        tableView.setMaxWidth(600);
        this.getChildren().add(tableView);
    }
}


