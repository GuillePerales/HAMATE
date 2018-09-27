/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**Declaración de la clase Jugador, esta clase contiene los datos generales de los jugadores y sus metodos get y set
 * @author Guillermo Perales Gallar
 * @version 04/05/18
 */

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.io.Serializable;

public class Jugador implements Serializable,Comparable<JugadorUsuario> {
    
    
    //Declaración de los atributos privados
    private ArrayList<Carta> mano = new ArrayList<>();
    private Color color;
    private int puntos;
    private int cartasGanadas;
    
    
    /**
     * Constructor para la clase Jugador
     * @param color, un Color que indica el color asociado al jugador
     */
    public Jugador(Color color){
        this.color = color;
    }//Cierre del contructor
    
    public Color getColor(){
        return color;
    }
    public ArrayList<Carta> getMano(){
        return mano;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
    public int getPuntos(){
        return puntos;
    }
    public void setCartasGanadas(int cartasGanadas){
        this.cartasGanadas = cartasGanadas;
    }
    public void setMano(ArrayList<Carta> mano){
        this.mano = mano;
    }
    public int getCartasGanadas(){
        return cartasGanadas;
    }
    /**
     * Método que añade una Carta introducida como parámetro al ArrayList mano del jugador
     * @param carta, Carta que queremos introducir
     */
    public void añadirCarta(Carta carta){
        mano.add(carta);
    }
    /**
     * Método que elimina la carta de la mano según una posición de la mano indicada(Introduce una carta vacía para evitar problemas)
     * Explicación cartas vacias:
     * @see Tablero
     * @param posCarta, un int que indica la posicion de la carta que queremos eliminar
     */
    public void quitarCarta(int posCarta){
        Carta carta = new Carta(null,0,0,null,1,true);
        mano.set(posCarta, carta); 
    }
    /**
     * Método que elimina de la mano una carta indicada como parametro. 
     * Para ello recorre la mano en busca de la posición de la carta y hace uso del método anterior.
     * @param carta, una Carta que queremos eliminar de la mano
     */
    public void quitarCarta(Carta carta){
        int i,pos = -1;
        for(i=0;i<5;i++){
            if(this.getMano().get(i)== carta)pos=i;
        }
        Carta cartaVacia = new Carta(null,0,0,null,1,true);
        mano.set(pos, cartaVacia);
    }
    /**
     * Método que crea un ArrayList de 5 cartas aleatorias sacadas del mazo introducido como parámetro.
     * Para ello genera un número aleatorio entre 0 y el número de cartas del mazo, que será la posición
     * de la carta en el mazo,se establece el color de la carta, se introduce la carta a la mano y se 
     * elimina la carta del mazo.
     * @param mazo, un Mazo usado en el juego
     * @return mano, un ArrayList de 5 cartas que sera la mano del jugador
     */
    public ArrayList crearMano(Mazo mazo){
        int nCartas,i,carta;
        Random rand = new Random();
        ArrayList<Carta> nuevaMano = new ArrayList<>();
        for(i=0;i<5;i++){
            nCartas = mazo.getMazoCartas().size();
            carta = rand.nextInt(nCartas);
            nuevaMano.add(mazo.getMazoCartas().get(carta));
            nuevaMano.get(i).setColor(this.getColor());
            mazo.getMazoCartas().remove(carta);
        }
        this.setMano(nuevaMano);
        return mano;
    } 
    public void borrarMano(){
        ArrayList<Carta> nuevaMano = new ArrayList<>();
        this.mano = nuevaMano;
    }
    /**
     * Método que realiza un duelo entre una carta introducida y la de su derecha, ambas adquieren el color del ganador.
     * Compara el valorDerecha de una Carta que introducimos con el valorIzquierda de la carta 
     * de su derecha para así saber quien gana el duelo y cambiar el color.
     * También tiene en cuenta si la posicion es la última, ya que si es asi no hay carta a la derecha y por tanto podria dar NullException.
     * @param carta,  Carta que introducimos
     * @param juego, Tablero para saber las posiciones de las cartas en el juego
     * @param posicion, un int que indica la posición en que ponemos la carta.
     */
    public void retoDerecha(Carta carta,Tablero juego,int posicion){
        if(posicion != 9){
            if(juego.getJuego()[posicion+1].getImagen() != null){
                if(carta.getValorDer()>juego.getJuego()[posicion+1].getValorIzq()){
                    juego.getJuego()[posicion+1].setColor(carta.getColor());
                }
                else if(carta.getValorDer()==juego.getJuego()[posicion+1].getValorIzq()){}
                else{
                    carta.setColor(juego.getJuego()[posicion+1].getColor());
                }
            }
        }
    }
    /**
     * Método que realiza un duelo entre una carta introducida y la de su izquierda, ambas adquieren el color del ganador.
     * Compara el valorIzquierda de una Carta que introducimos con el valorDerecga de la carta
     * de su izquierda para así saber quien gana el duelo y cambiar el color.
     * También tiene en cuenta si la posicion es la primera, ya que si es así no hay carta a la izquierda y por tanto podria dar NullException.
     * @param carta,  Carta que introducimos
     * @param juego, Tablero para saber las posiciones de las cartas en el juego
     * @param posicion, un int que indica la posición en que ponemos la carta.
     */
    public void retoIzquierda(Carta carta,Tablero juego,int posicion){
        if(posicion != 0){
            if(juego.getJuego()[posicion-1].getImagen()!=null){
                if(carta.getValorIzq()>juego.getJuego()[posicion-1].getValorDer()){
                    juego.getJuego()[posicion-1].setColor(carta.getColor());
                }
                else if(carta.getValorIzq()==juego.getJuego()[posicion-1].getValorDer()){}
                else{
                    carta.setColor(juego.getJuego()[posicion-1].getColor());
                }
            }
        }
    }
    


    @Override
    public int compareTo(JugadorUsuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}//Cierre de la clase
