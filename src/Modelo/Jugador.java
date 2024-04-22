package Modelo;

public class Jugador extends Persona{
    private int dorsal;
    private double peso;
    private double altura;


    public Jugador (String nombre, String apellido, int dorsal, double peso, double altura){
        super(nombre, apellido);
        this.dorsal = dorsal;
        this.altura = altura;
        this.peso = peso;
    }

    public int getDorsal(){
        return dorsal;
    }

    public double getAltura(){
        return altura;
    }

    public void escribirDatos(){
        super.escribirDatos();
        System.out.println("Dorsal: " + dorsal);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
    }
}
