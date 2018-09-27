/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**Declaración de la clase JugadorException que maneja las excepciones del juego y hereda de la clase Exception
 * @author Guillermo Perales Gallar
 * @version 04/05/18 
 */

public class JugadorException extends Exception {
    //Declaración de los atributos que indican cada excepción
    public static final String NOMBRE_INCORRECTO = "EL nombre proporcionado es incorrecto";
    public static final String APELLIDO1_INCORRECTO = "EL primero apellido proporcionado es incorrecto";
    public static final String APELLIDO2_INCORRECTO = "EL segundo apellido proporcionado es incorrecto";
    public static final String NIF_INCORRECTO = "El NIF proporcionado es incorrecto.";
    public static final String EDAD_INCORRECTA = "El jugador debe ser mayor de edad para poder jugar";
    public static final String CARTA_NO_SELECCIONADA = "No se ha seleccionado ninguna carta para jugar.";
    public static final String RETO_INCORRECTO = "No se ha seleccionado la dirección del reto.";
    public static final String POSICION_TABLERO_INCORRECTA ="Ya hay carta en la posición seleccionada.";
    public static final String USUARIO_YA_REGISTRADO ="Ya hay un usuario con resgistrado con esos datos";

        
    public JugadorException() {
        super("Se ha producido una excepción en la aplicación.");
    }

    public JugadorException (String txt) {
        super(txt);
    }
}
