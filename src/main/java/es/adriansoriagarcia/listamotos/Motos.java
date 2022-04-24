package es.adriansoriagarcia.listamotos;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

/*
//Clase Motos contiene los arrayList con todo el contenido de datos.
*/
public class Motos {
    public Motos( ){

    }
    private ArrayList<Moto> listaMotos  = new ArrayList();
   
    public ArrayList<Moto> getListaMotos(){
        return listaMotos;
        
    }
    @XmlElement(name = "Moto")//Nombre de cada elemento
    public void setListaMotos(ArrayList<Moto> listaMotos){
        this.listaMotos = listaMotos;

    }
    
    //Metodo encargado de fusionar la lista principal con la importada.
    public void fusionarMotos(Motos motosNuevas){
        this.getListaMotos().addAll(motosNuevas.getListaMotos());
        listaMotos.forEach(System.out::println);
        BotonesInferior.total += motosNuevas.getListaMotos().size();
        System.out.println("total con añadido " + BotonesInferior.total);
        LayoutPanel.textTotal.setText(String.valueOf(BotonesInferior.total));

    }

    
}
