package es.adriansoriagarcia.listamotos;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML extends Pane {
    //ListaMotos listaMotos;
    Button ButtonFileSave = new Button("Guardar");
    Button ButtonFileOpen = new Button("Abrir");
    
    public UtilXML(Stage stage, ListaMotos listaMotos){
        ButtonFileSave.setLayoutX(550);
        this.getChildren().add(ButtonFileSave);
        ButtonFileSave.setOnAction((t) -> {
            guardarDatosXml(stage, listaMotos);
        });
        
        ButtonFileOpen.setLayoutX(550);
        ButtonFileOpen.setLayoutY(50);
        this.getChildren().add(ButtonFileOpen);
        ButtonFileOpen.setOnAction((t) -> {
            leerArchivoXML(stage, listaMotos);
        });
    }
    public void guardarDatosXml(Stage stage, ListaMotos listaMotos){
        FileChooser file = new FileChooser();  
        file.setTitle("Save"); 
        file.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));

        JAXBContext contexto;
        try {
            java.io.File file1 = file.showSaveDialog(stage);//Guardar archivo 
            contexto = JAXBContext.newInstance(
                    ListaMotos.class );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
            marshaller.marshal(listaMotos, System.out);
            marshaller.marshal(listaMotos, file1);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();//muestra el error.
        }
    }
    
    public ListaMotos leerArchivoXML(Stage stage, ListaMotos listaMotos){
        //System.out.println(listaMotos.getListaMotos());
        FileChooser file = new FileChooser();  
        file.setTitle("Open"); 
        file.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));
        
        try {
            java.io.File file1 = file.showOpenDialog(stage);//Abrir archivo 
            JAXBContext context = JAXBContext.newInstance( ListaMotos.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListaMotos motos = (ListaMotos)unmarshaller.unmarshal(file1);
            //listaMotos.setListaMotos();
            //System.out.println(motos.getListaMotos());
            //System.out.println("Lista añadida " + "\n" + listaMotos.getListaMotos()); 
            return motos;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    
}
