package es.adriansoriagarcia.listamotos;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class FileSave extends Pane {
    //ListaMotos listaMotos;
    public FileSave(Stage stage, ListaMotos listaMotos){
        //listaMotos = new ListaMotos();
        //System.out.println(listaMotos.getListaMotos());
        Button ButtonFile = new Button("Guardar");
        ButtonFile.setLayoutX(550);
        this.getChildren().add(ButtonFile);
        ButtonFile.setOnAction((t) -> {
            FileChooser file = new FileChooser();  
            file.setTitle("Save"); 
            file.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
            
            JAXBContext contexto;
        try {
            java.io.File file1 = file.showSaveDialog(stage); 
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
        });
    }

    
}
