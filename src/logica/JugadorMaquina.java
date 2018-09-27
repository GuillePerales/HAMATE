/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**Declaración de la clase JugadorMaquina, esta clase contiene el método del turno de la máquina y hereda de Jugador
 * @author Guillermo Perales Gallar
 * @version 04/05/18
 */

import java.awt.Color;
import java.util.Random;

public class JugadorMaquina extends Jugador {
    //Declaración de los atributos privados
    private String modoJuego;
    
    /**
     * Constructor para la clase JugadorMaquina
     * @param color, un Color que indica el color asociado al Jugador
     * @param modoJuego, un String que indica el modo de juego de la maquina basico/avanzado
     */
    public JugadorMaquina(Color color,String modoJuego){
        super(color);
        this.modoJuego = modoJuego;
    }//Cierre del contructor
    
     public String getModoJuego(){
        return modoJuego;
    }
    public void setModoJuego(String modoJuego){
        this.modoJuego = modoJuego;
    }
    /**Método que a partir del tablero del juego introducido como parámetro, para saber las posiciones libres y ocupadas realiza el movimiento de la máquina
     * Modo Básico:
     *      El modo básico usa tanto la carta de la mano utilizada, la posicion del tablero y el reto de manera aleatoria.
     *      Para ello genera un número aleatorio para la posición del tablero y otro para la carta de la mano, si encuentra
     *      una posición libre del tablero, busca una carta disponible en la mano, cuando encuentra una posicion y una carta
     *      de la mano disponible genera un último número aleatorio para elegir el reto y por ultimo realiza el movimiento segun
     *      estos datos generados.
     * Modo Avanzado:
     *      El modo avanzado recorre el tablero en busca de cartas a las que pueda ganar, cuando encuentra una carta en el tablero
     *      del jugador contrario compara sus valores izquierdos y derechos de sus cartas y si puedo ganar pone la carta.
     *      En caso de que no pueda ganar pone la carta aleatoria
     *      
     * 
     * @param tablero tablero en el que se va a realizar los movimientos
     */
    public void turnoMaquina(Tablero tablero){
        
        //Modo Juego Básico: Posicion, carta y reto aleatorio
         
        if("basico".equals(this.getModoJuego())){
            int posicionTablero = 0,posicionMano = 0,reto;
            boolean cartaPuesta = false,cartaManoDisponible = false;
            Random rand = new Random();
            //Ponemos la carta en el tablero
            while(!cartaPuesta){
                posicionTablero = rand.nextInt(10);
                 posicionMano = rand.nextInt(5);
                 //Buscamos posicion libre en el tablero
                if(tablero.getJuego()[posicionTablero].getImagen() == null){
                   //Buscamos carta disponible en la mano
                    while(!cartaManoDisponible){
                        posicionMano = rand.nextInt(5);
                        if(this.getMano().get(posicionMano).getImagen() == null){cartaManoDisponible=false;}
                        else{cartaManoDisponible=true;}
                        }
                    tablero.colocarCarta(this.getMano().get(posicionMano),posicionTablero);
                    this.quitarCarta(posicionMano);
                    cartaPuesta = true;
                }
                else{
                    cartaPuesta=false;
                }  
                
            }
            reto = rand.nextInt(2);
            if(reto == 0)this.retoIzquierda(tablero.getJuego()[posicionTablero], tablero, posicionTablero);
            else{ this.retoDerecha(tablero.getJuego()[posicionTablero], tablero, posicionTablero);} 
        }
        
        if("avanzado".equals(this.getModoJuego())){
            int i,j;
            for(i=0;i<10;i++){
                if(tablero.getJuego()[i].getColor() != this.getColor()){
                    for(j=0;j<5;j++){
                        if(i != 0){
                            if(this.getMano().get(j).getValorDer()>tablero.getJuego()[i].getValorIzq()){
                                if(tablero.getJuego()[i-1].getVacia()){
                                    tablero.colocarCarta(this.getMano().get(j), i-1);
                                    this.quitarCarta(j);
                                    this.retoDerecha(tablero.getJuego()[i-1],tablero, i-1);
                                    return;
                                }                                
                            }                      
                        }
                        if(i != 9){
                            if(this.getMano().get(j).getValorIzq()>tablero.getJuego()[i].getValorDer()){
                                if(tablero.getJuego()[i+1].getVacia()){
                                    tablero.colocarCarta(this.getMano().get(j), i+1);
                                    this.quitarCarta(j);
                                    this.retoIzquierda(tablero.getJuego()[i+1],tablero, i+1);
                                    return;     
                                }   
                            }
                        }
                    }    
                }
            }
        int posicionTablero = 0,posicionMano = 0,reto;
            boolean cartaPuesta = false,cartaManoDisponible = false;
            Random rand = new Random();
            //Ponemos la carta en el tablero
            while(!cartaPuesta){
                posicionTablero = rand.nextInt(10);
                 posicionMano = rand.nextInt(5);
                 //Buscamos posicion libre en el tablero
                if(tablero.getJuego()[posicionTablero].getImagen() == null){
                   //Buscamos carta disponible en la mano
                    while(!cartaManoDisponible){
                        posicionMano = rand.nextInt(5);
                        if(this.getMano().get(posicionMano).getImagen() == null){cartaManoDisponible=false;}
                        else{cartaManoDisponible=true;}
                        }
                    tablero.colocarCarta(this.getMano().get(posicionMano),posicionTablero);
                    this.quitarCarta(posicionMano);
                    cartaPuesta = true;
                }
                else{
                    cartaPuesta=false;
                }  
                
            }
            reto = rand.nextInt(2);
            if(reto == 0)this.retoIzquierda(tablero.getJuego()[posicionTablero], tablero, posicionTablero);
            else{ this.retoDerecha(tablero.getJuego()[posicionTablero], tablero, posicionTablero);} 
        }         
    }    
}
