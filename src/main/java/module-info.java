module es.adriansoriagarcia.listamotos {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.adriansoriagarcia.listamotos;
    opens es.adriansoriagarcia.listamotos to java.xml.bind;
}
