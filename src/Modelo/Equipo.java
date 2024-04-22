package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

import Herramientas.Utilidades;

public class Equipo {
    private Scanner scanner = new Scanner(System.in);
    private String nombre;
    private String ciudad;
    private Entrenador entrenador;
    private ArrayList<Jugador> plantilla;

    public Equipo(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
        plantilla = new ArrayList<>();
        entrenador = null;
    }

    public String getNombre(){
        return nombre;
    }

    public Entrenador getEntrenador(){
        return entrenador;
    }

    public void gestionEquipo(){
        boolean salir = false;
        while (!salir){
            salir = mostrarMenuGestionEquipo();
        }
    }

    private boolean mostrarMenuGestionEquipo(){
        boolean salir = false;
        System.out.println("**********************************");
        System.out.println("****** Menu gestión equipo ******");
        System.out.println("*********************************");
        System.out.println("1.- Alta entrenador");
        System.out.println("2.- Baja entrenador");
        System.out.println("3.- Alta jugador");
        System.out.println("4.- Baja jugador");

        System.out.println("9.- Salir");

        
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                altaEntrenador();
                break;
            case "2":
                entrenador = null;
                break;
            case "3":
                altaJugador();
                break;
            case "4":
                bajaJugador();
                break;
            case "9":
                salir = true;
                break;
            default:
                break;
        }
        return salir;
    }

    private void altaEntrenador(){
        System.out.println("****************************");
        System.out.println("****** Alta entrenador******");
        System.out.println("****************************");
        System.out.println("Nombre entrenador");
        String nombre = scanner.nextLine();
        System.out.println("Apellido entrenador");
        String apellido = scanner.nextLine();
        int anioLicencia = Utilidades.leerEntero("año");
        entrenador = new Entrenador(nombre, apellido, anioLicencia);
    }

    private Jugador buscarJugador(int dorsal){
        Jugador jugadorEncontrado = null;
        int contador = 0;
        while (jugadorEncontrado == null && contador < plantilla.size()){
            if (plantilla.get(contador).getDorsal() == dorsal){
                jugadorEncontrado = plantilla.get(contador);
            }
            contador++;
        }
        return jugadorEncontrado;
    }

    private void altaJugador(){
        System.out.println("****************************");
        System.out.println("****** Alta jugador  ******");
        System.out.println("****************************");
        int dorsal = Utilidades.leerEntero("dorsal");
        Jugador jugador = buscarJugador(dorsal);

        if (jugador != null){
            System.out.println("Dorsal repetido");
        }
        else{
            System.out.println("Nombre jugador");
            String nombre = scanner.nextLine();
            System.out.println("Apellido jugador");
            String apellido = scanner.nextLine();
            double peso = Utilidades.leerDouble("peso");
            double altura = Utilidades.leerDouble("altura");
            jugador = new Jugador(nombre, apellido, dorsal, peso, altura);
            plantilla.add(jugador);
        }
    }

    private void bajaJugador(){
        System.out.println("****************************");
        System.out.println("****** Baja jugador  ******");
        System.out.println("****************************");
        int dorsal = Utilidades.leerEntero("dorsal");
        Jugador jugador = buscarJugador(dorsal);

        if (jugador == null){
            System.out.println("Dorsal no existe");
        }
        else{
            plantilla.remove(jugador);
        }
    }

    public void datosJugadorMasAlto(){
        Jugador jugadorMasAltoPorAhora = null;
        for (Jugador jugador: plantilla){
            if (jugadorMasAltoPorAhora == null){
                jugadorMasAltoPorAhora = jugador;
            }
            else{
                if (jugadorMasAltoPorAhora.getAltura() < jugador.getAltura()){
                    jugadorMasAltoPorAhora = jugador;
                }
            }
        }

        if (jugadorMasAltoPorAhora == null){
            System.out.println("El equipo " + nombre + " no tiene jugadores inscritos");
        }
        else{
            jugadorMasAltoPorAhora.escribirDatos();
        }
    }
}
