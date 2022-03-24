package es.adriansoriagarcia.listamotos;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaMotos {
    private ArrayList<Moto> listaMotos  = new ArrayList();
    
    public ArrayList<Moto> getListaMotos(){
        return listaMotos;
    }
    public void setListaMotos(ArrayList<Moto> listaMotos){
        this.listaMotos = listaMotos;
    }
}
