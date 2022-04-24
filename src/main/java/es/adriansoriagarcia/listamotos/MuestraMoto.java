package es.adriansoriagarcia.listamotos;

import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/*
//Clase MuestraMoto se encargar de mostrar las motos en una tabla creada a continuación.
*/
public class MuestraMoto extends VBox {
    static TableView tableView;
    int motoActual = 0;
    public MuestraMoto(Motos motos){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
 
        tableView = new TableView();//Declaración de la tabla.
        TableColumn colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory("marca"));//Atributo.
        TableColumn colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory("modelo"));//Atributo.
        TableColumn colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));//Atributo.
        TableColumn colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory("peso"));//Atributo.
        TableColumn colAnio = new TableColumn<>("Año");
        colAnio.setCellValueFactory(new PropertyValueFactory("anio"));//Atributo.
        TableColumn colCilindrada = new TableColumn<>("Cilindrada");
        colCilindrada.setCellValueFactory(new PropertyValueFactory("cilindrada"));//Atributo.
        tableView.getColumns().addAll(colMarca, colModelo, colPrecio, colPeso, colAnio, colCilindrada);
        tableView.getStylesheets().add("css/style.css");
        //todas las columnas cambiarán su tamaño por igual hasta que se alcance el ancho máximo de TableView
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMaxHeight(50);
        tableView.setMaxWidth(600);
        this.getChildren().add(tableView);
    }
}


