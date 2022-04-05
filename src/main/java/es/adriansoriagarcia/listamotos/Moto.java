package es.adriansoriagarcia.listamotos;


public class Moto {
    private String marca;
    private String modelo;
    private int precio;
    private float peso;
    private int anio;
    private int cilindrada;
    
    public Moto(){
        
    }
    
    public Moto(String marca){
        this.marca = marca.toUpperCase();
    }
    
    public Moto(String marca, String modelo){
        this.marca = marca.toUpperCase();
        this.modelo = modelo;
    }
    public Moto(String marca, String modelo,int precio, float peso, int anio, int cilindrada){
        this.marca = marca.toUpperCase();
        this.modelo = modelo;
        this.precio = precio;
        this.peso = peso;
        this.anio = anio;
        this.cilindrada = cilindrada;
    }
    

    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca.toUpperCase();
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public int getPrecio(){
        return precio;
    }
    
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    public float getPeso(){
        return peso;
    }
    
    public void setPeso(float peso){
        this.peso = peso;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    public int getCilindrada(){
        return cilindrada;
    }
    
    public void setCilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }
    
    @Override
    public String toString(){
        String r = "";
        r += "Marca: " + marca + "\n";
        r += "Modelo: " + modelo + "\n";
        r += "Precio: " + precio + "\n";
        r += "Peso: " + peso + "\n";
        r += "Año: " + anio + "\n";
        r += "Cilindrada: " + cilindrada + "\n";
        return r;
    }

}
