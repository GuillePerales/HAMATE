/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**Declaración de la clase Mazo, esta clase contiene un ArraList con todas las cartas del juego
 * @author Guillermo Perales Gallar
 * @version 04/05/18
 */

import java.util.ArrayList;
import java.util.Random;

public class Mazo {
    //Declaración de los atributos privados
    private final ArrayList<Carta> mazoCartas = new ArrayList<>();
    
    /**
     * Constructor para la clase Mazo
     * En este constructor creamos las 110 cartas con su imagen y valores correspondientes y las introducimos en el ArrayList
     * de Cartas mazoCartas, que contendrá todas las cartas del juego para posteriormente asignar el color:
     * @see Jugador#crearMano(lógica.Mazo)
     * 
     */
    public Mazo(){
        Random rand = new Random();
        int i,izquierda,derecha,multiplicador;
        String imagen;
        for(i=1;i<110;i++){
            izquierda = rand.nextInt(7)+1;
            derecha = rand.nextInt(7)+1;
            imagen = Integer.toString(i);
            if(i%10==0)multiplicador=2;
            else multiplicador=1;
            Carta c = new Carta(imagen,izquierda,derecha,null,multiplicador,false);
            mazoCartas.add(c);
        }//Cierre del constructor
    }
    public ArrayList<Carta> getMazoCartas(){
        return mazoCartas;
    }
    
    
}