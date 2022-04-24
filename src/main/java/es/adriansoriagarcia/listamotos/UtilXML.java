package es.adriansoriagarcia.listamotos;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/*
//Clase UtilXML se encargar de abrir FileChooser para poder guardar e importar datos a la app.
*/
public class UtilXML {
    //ListaMotos listaMotos;
    

    public UtilXML(Stage stage, Motos motos){
        
    }
    //Método guardarDatosXml, guarda los datos en un archivo xml.
    public static void guardarDatosXml(Stage stage, Motos motos){
        FileChooser file = new FileChooser();  
        file.setTitle("Save"); 
        file.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));

        JAXBContext contexto;
        try {
            File file1 = file.showSaveDialog(stage);//Guardar archivo 
            contexto = JAXBContext.newInstance(
                    Motos.class );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                Boolean.TRUE);
            marshaller.marshal(motos, System.out);
            marshaller.marshal(motos, file1);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();//muestra el error.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error en la aplicacion");
            alert.showAndWait();
        }
    }
    
    //Método leerArchivoXML, importa los datos de un xml a nuestra app.
    public static Motos leerArchivoXML(Stage stage){
        //System.out.println(listaMotos.getListaMotos());
        FileChooser file = new FileChooser();  
        file.setTitle("Open"); 
        file.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
            new FileChooser.ExtensionFilter("All Files", "*.*"));
        
        try {
            File file1 = file.showOpenDialog(stage);//Abrir archivo 
            JAXBContext context = JAXBContext.newInstance(Motos.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Motos motosImport = (Motos)unmarshaller.unmarshal(file1);
            return motosImport;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Error en el archivo XML");
            alert.setContentText("El formato de archivo XML no es correcto");
            alert.showAndWait();
        }
        return null;
    }
}
