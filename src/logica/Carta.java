/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**Declaración de la clase Carta, esta clase contine los datos de la carta y sus correspondientes métodos get y set
 * @author Guillermo Perales Gallar
 * @version 04/05/18
 */

import java.awt.Color;
import java.io.Serializable;

public class Carta implements Serializable {
    //Declaración de los atributos privados
    private String imagen;
    private int valorIzquierda;
    private int valorDerecha;
    private Color color;
    private boolean vacia;
    private int multiplicador;
    
    /**Constructor para la clase Carta 
     * @param imagen, un String que contiene el número de la direccion de la carta.
     * @param valorIzquierda, un int que contiene el valor de ataque izquierdo de la carta
     * @param valorDerecha, un int que contiene el valor de ataque izquierdo de la carta
     * @param color, un Color que contiene el color de la carta y por tanto a que jugador pertenece
     * @param multiplicador, un int que indica si se duplican los puntos o no
     * @param vacia, un boolean para saber si una carta es vacia
     */
    public Carta(String imagen, int valorIzquierda,int valorDerecha, Color color,int multiplicador,boolean vacia){
        this.imagen = imagen;
        this.valorIzquierda = valorIzquierda;
        this.valorDerecha  = valorDerecha;
        this.color = color;
        this.multiplicador = multiplicador;
        this.vacia = vacia;
        
    }//Cierre del contructor
    
    public Color getColor(){
        return color;
    }
    public int getValorIzq(){
        return valorIzquierda;
    }
    public int getValorDer(){
        return valorDerecha;
    }
    public String getImagen(){
        return imagen;
    }
    public int getMultiplicador(){
        return multiplicador;
    }
    public boolean getVacia(){
        return vacia;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setValorIzq(int valorIzquierda){
        this.valorIzquierda = valorIzquierda;
    }
    public void setValorDer(int valorDerecha){
        this.valorDerecha = valorDerecha;
    }
    public void setimagen(String imagen){
        this.imagen = imagen;
    }
    public int setMultiplicador(int multiplicador){
        return multiplicador;
    }
    

}//Cierre de la clase
