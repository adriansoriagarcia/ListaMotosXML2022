# ListaMotosXML2022
Desarrolla una aplicación que permita mantener una estructura de datos XML, con opción de exportar e importar los datos a documentos XML.

Declara en una clase la estructura de datos de los objetos que desees para tu aplicación. La clase deberá contener propiedades de distintos tipos de datos básicos. Todas las propiedades deberán tener un ámbito privado, por lo que la clase debe contener los métodos get y set que permitan acceder a sus propiedades.
Declara una clase que contenga un ArrayList de objetos de la clase anterior, también de ámbito privado.
Crea, en otra clase Java más, los métodos necesarios para exportar a un archivo XML los datos contenidos en el ArrayList anterior, así como para importar los datos contenidos en otro archivo XML. 
La opción de importar el contenido de un archivo XML se debe ofrecer con un método estático al que se le pasen por parámetros las 2 listas a fusionar, o mediante un método no estático, al que se le pase por parámetro sólo la lista con los nuevos datos.
El usuario debe poder seleccionar el archivo a guardar o importar mediante una ventana FileChooser.
Muestra los datos en la ventana de la aplicación de manera que cada vez se muestren los datos de un mismo objeto, y ofrece la posibilidad de que el usuario pueda navegar al objeto siguiente o anterior. 
La información mostrada debe aparecer clara para el usuario, y manteniendo una organización responsiva de los elementos.
Controla los posibles errores de la aplicación, mostrando una ventana Alert con el mensaje de error correspondiente.
