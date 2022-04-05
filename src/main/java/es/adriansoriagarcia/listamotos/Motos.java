package es.adriansoriagarcia.listamotos;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
        //this.listaMotos = UtilXML.leerArchivoXML(motos);
    }
    
    public void fusionarMotos(Motos motosNuevas){
        this.getListaMotos().addAll(motosNuevas.getListaMotos());
        listaMotos.forEach(System.out::println);

    }

    
}
