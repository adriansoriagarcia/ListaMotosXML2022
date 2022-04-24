
package es.adriansoriagarcia.listamotos;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/*
//Clase LayoutPanel contiene el texto con la cantidad de motos disponibles.
*/
public class LayoutPanel extends HBox{
    Text textMoto; //Declaracion variable usada para la palabra moto.
    static Text textNum;//Declaracion variable usada para el numero de motos.
    Text textDe;//Declaracion variable usada para la palabra de.
    static Text textTotal; //Declaracion variable usada para el numero total de motos.
    final int TEXT_SIZE = 20;//Declaración e inicialización usada para el tamaño de letra de los text. 
    public LayoutPanel(Motos motos){
       Panel(motos); 
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);//Espacio entre componentes.  
        
    }
    private void Panel(Motos motos){
        
        //Texto moto
        textMoto = new Text("Moto");
        textMoto.setFont(Font.font(TEXT_SIZE));
        textMoto.setFill(Color.BLACK);
        textMoto.setLayoutX(200);
        //Texto para el numero de motos.
        if(motos.getListaMotos().isEmpty()){
           textNum = new Text("0");
        }else{
           textNum = new Text("1"); 
        }
        //textNum = new Text("0");
        textNum.setFont(Font.font(TEXT_SIZE));
        textNum.setFill(Color.BLACK);
        
        //Texto de
        textDe = new Text("de");
        textDe.setFont(Font.font(TEXT_SIZE));
        textDe.setFill(Color.BLACK);
        
        //Texto para el numero total de motos.
        textTotal = new Text(""+BotonesInferior.total);
        textTotal.setFont(Font.font(TEXT_SIZE));
        textTotal.setFill(Color.BLACK);
        
        this.getChildren().add(textMoto);
        this.getChildren().add(textNum);
        this.getChildren().add(textDe);
        this.getChildren().add(textTotal);
    }
}
