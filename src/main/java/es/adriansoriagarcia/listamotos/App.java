package es.adriansoriagarcia.listamotos;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Moto moto1 = new Moto("Honda", "CR");
        System.out.println(moto1.getMarca());
        moto1.setMarca("Honda");
        System.out.println(moto1.getMarca());
        
        Moto moto2 = new Moto();
        Moto moto3 = new Moto("Yamaha");
        
        ListaMotos listaMotos = new ListaMotos();
        listaMotos.getListaMotos().add(moto1);
        listaMotos.getListaMotos().add(moto2);
        listaMotos.getListaMotos().add(moto3);

        
        // Mostrar la marca de la tercera moto
        //System.out.println(listaMotos.getListaMotos(2).getMarca());
        //System.out.println(listaMotos.getListaMotos());
        
        // Eliminar segundo libro
        //listaMotos.getListaMotos().remove(1);
        
        // Mostrar todos los libros de la lista
//        for(int i=0; i<listaMotos.size(); i++){
//            System.out.println(listaMotos.getListaMotos(i).getMarca());
//        }
        
        JAXBContext contexto;
        try {
            File fileListaMotos = new File("ListaMotos.xml");
            contexto = JAXBContext.newInstance(
                    ListaMotos.class );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
            marshaller.marshal(listaMotos, System.out);
            marshaller.marshal(listaMotos, fileListaMotos);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();//muestra el error.
        }
    }

    public static void main(String[] args) {
        launch();
    }

}