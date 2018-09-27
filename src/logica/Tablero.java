/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**Declaraciónde la clase Tablero que contiene las cartas en Juego 
 * @author Guillermo Perales Gallar
 * @version 05/04/18
*/

public class Tablero {
    //Declaración de los atributos privados
    private final Carta  juego[] =new Carta[10];
   
    /**
     * Constructor para la clase Tablero
     * En este constructor creamos y añadimos cartas vacias y rellenamos el tablero con ellas.
     * El motivo de las cartas vacias es que para saber las posiciones vacias en los Arrays es decir, cuando no hay carta
     * he usado el atributo imagen como null
     */
    public Tablero(){
        int i;
        Carta c = new Carta(null,0,0,null,0,true);
        for(i=0;i<10;i++){
            colocarCarta(c,i);
        
        }
    }
    public Carta[] getJuego(){
        return juego;
    }
    /**
     * Método que coloca una carta introducida como parámetro en una poscición del Array dada
     * @param carta, una Carta que queremos introducir
     * @param posicion, posición del tablero en la que queremos introducir la carta 
     */
    public void colocarCarta(Carta carta,int posicion){
        this.getJuego()[posicion] = carta;
    }  
}
