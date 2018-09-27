/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * Declaración de la clase JugadorUsuario, esta clase contiene los atributos y
 * los metodos get y set del usuario y hereda de Jugador
 *
 * @author Guillermo Perales Gallar
 * @version 04/05/18
 */
import java.awt.Color;
import java.time.LocalDate;

public class JugadorUsuario extends Jugador{
    
    

    //Declaración de los atributos privados
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private LocalDate fechaNacimiento;
    private int partidasJugadas;
    private int partidasGanadas;
    private double puntosPorPartida;
    private double cartasPorPartida;
        
    

    /**
     * Constructor de la clase JugadorUsuario
     *
     * @param color, un Color que indica el color asociado al jugador
     */
    public JugadorUsuario(Color color) {
        super(color);
    }//Cierre del constructor

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNIF() {
        return nif;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public int getPartidasJugadas(){
        return partidasJugadas;
    }
    
    public int getPartidasGanadas(){
        return partidasGanadas;
    }
    
    public double getPuntosPorPartida(){
        return puntosPorPartida;
    }
    public double getCartasPorPartida(){
        return cartasPorPartida;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setNIF(String nif) {
        this.nif = nif;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setPartidasJugadas(int partidasJugadas){
        this.partidasJugadas = partidasJugadas;
    }
    
    public void setPartidasGanadas(int partidasGanadas){
        this.partidasGanadas = partidasGanadas;
    }
    
    public void setPuntosPorPartida(double puntosPorPartida){
        this.puntosPorPartida = puntosPorPartida;
    }
    public void setCartasPorPartida(double cartasPorPartida){
        this.cartasPorPartida = cartasPorPartida;
    }
    
    
    @Override
    public String toString() {
        return "Nombre:" + this.getNombre() + " " + this.apellido1 + " " + this.apellido2 + " " + "NIF:" + this.getNIF();
    }
    
    

}
