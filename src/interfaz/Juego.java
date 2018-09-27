/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import logica.Mazo;
import logica.JugadorMaquina;
import logica.JugadorUsuario;
import logica.JugadorException;
import logica.Tablero;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JRadioButton;

/**
 *
 * @author Guillermo Perales Gallar
 */
public final class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    Juego juego;
    JugadorUsuario usuario;
    Tablero tablero;
    JugadorMaquina maquina;
    AudioInputStream musica;
    Clip clip = AudioSystem.getClip();
    String modoInicio;
    private FileOutputStream fosJugadores;
    private ObjectOutputStream oosJugadores;

    public Juego() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        initComponents();
        Mazo mazo = new Mazo();
        this.tablero = new Tablero();
        this.usuario = Inicio.getUsuario();
        this.maquina = ModoJuego.getMaquina();
        modoInicio = maquina.getModoJuego();
        
        try {
            musica = AudioSystem.getAudioInputStream(new File("src/sonidos/musica.wav")); 
            clip.open(musica);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuario.crearMano(mazo);
        maquina.crearMano(mazo);
        actualizarInterfaz(tablero, usuario, maquina);
        botSiguienteTurno.setEnabled(false);
        
    }
    public Juego getPantallaJuego(){
        return this;
    }
    
    public void getImagen(Tablero tablero, JugadorUsuario usuario, JugadorMaquina maquina) {
        ImageIcon imgTablero = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/frame-1-normal.png");
        ImageIcon imgTableroRed = new ImageIcon(imgTablero.getImage().getScaledInstance(100, 100, 1));
        imgJuego0.setIcon(imgTableroRed);
        imgJuego1.setIcon(imgTableroRed);
        imgJuego2.setIcon(imgTableroRed);
        imgJuego3.setIcon(imgTableroRed);
        imgJuego4.setIcon(imgTableroRed);
        imgJuego5.setIcon(imgTableroRed);
        imgJuego6.setIcon(imgTableroRed);
        imgJuego7.setIcon(imgTableroRed);
        imgJuego8.setIcon(imgTableroRed);
        imgJuego9.setIcon(imgTableroRed);

        ImageIcon imgUsu1 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + usuario.getMano().get(0).getImagen() + ".png");
        ImageIcon imgUsu1Red = new ImageIcon(imgUsu1.getImage().getScaledInstance(100, 100, 1));
        imgUsuario0.setIcon(imgUsu1Red);
        imgUsuario0.setBackground(Color.blue);
        valorDerUsuario0.setText(String.valueOf(usuario.getMano().get(0).getValorDer()));
        valorIzqUsuario0.setText(String.valueOf(usuario.getMano().get(0).getValorIzq()));

        ImageIcon imgUsu2 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + usuario.getMano().get(1).getImagen() + ".png");
        ImageIcon imgUsu2Red = new ImageIcon(imgUsu2.getImage().getScaledInstance(100, 100, 1));
        imgUsuario1.setIcon(imgUsu2Red);
        valorDerUsuario1.setText(String.valueOf(usuario.getMano().get(1).getValorDer()));
        valorIzqUsuario1.setText(String.valueOf(usuario.getMano().get(1).getValorIzq()));

        ImageIcon imgUsu3 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + usuario.getMano().get(2).getImagen() + ".png");
        ImageIcon imgUsu3Red = new ImageIcon(imgUsu3.getImage().getScaledInstance(100, 100, 1));
        imgUsuario2.setIcon(imgUsu3Red);
        valorDerUsuario2.setText(String.valueOf(usuario.getMano().get(2).getValorDer()));
        valorIzqUsuario2.setText(String.valueOf(usuario.getMano().get(2).getValorIzq()));

        ImageIcon imgUsu4 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + usuario.getMano().get(3).getImagen() + ".png");
        ImageIcon imgUsu4Red = new ImageIcon(imgUsu4.getImage().getScaledInstance(100, 100, 1));
        imgUsuario3.setIcon(imgUsu4Red);
        valorDerUsuario3.setText(String.valueOf(usuario.getMano().get(3).getValorDer()));
        valorIzqUsuario3.setText(String.valueOf(usuario.getMano().get(3).getValorIzq()));

        ImageIcon imgUsu5 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + usuario.getMano().get(4).getImagen() + ".png");
        ImageIcon imgUsu5Red = new ImageIcon(imgUsu5.getImage().getScaledInstance(100, 100, 1));
        imgUsuario4.setIcon(imgUsu5Red);
        valorDerUsuario4.setText(String.valueOf(usuario.getMano().get(4).getValorDer()));
        valorIzqUsuario4.setText(String.valueOf(usuario.getMano().get(4).getValorIzq()));

        ImageIcon imgMaq1 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + maquina.getMano().get(0).getImagen() + ".png");
        ImageIcon imgMaq1Red = new ImageIcon(imgMaq1.getImage().getScaledInstance(100, 100, 1));
        imgMaquina0.setIcon(imgMaq1Red);
        imgMaquina0.setBackground(Color.blue);
        valorDerMaquina0.setText(String.valueOf(maquina.getMano().get(0).getValorDer()));
        valorIzqMaquina0.setText(String.valueOf(maquina.getMano().get(0).getValorIzq()));

        ImageIcon imgMaq2 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + maquina.getMano().get(1).getImagen() + ".png");
        ImageIcon imgMaq2Red = new ImageIcon(imgMaq2.getImage().getScaledInstance(100, 100, 1));
        imgMaquina1.setIcon(imgMaq2Red);
        valorDerMaquina1.setText(String.valueOf(maquina.getMano().get(1).getValorDer()));
        valorIzqMaquina1.setText(String.valueOf(maquina.getMano().get(1).getValorIzq()));

        ImageIcon imgMaq3 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + maquina.getMano().get(2).getImagen() + ".png");
        ImageIcon imgMaq3Red = new ImageIcon(imgMaq3.getImage().getScaledInstance(100, 100, 1));
        imgMaquina2.setIcon(imgMaq3Red);
        valorDerMaquina2.setText(String.valueOf(maquina.getMano().get(2).getValorDer()));
        valorIzqMaquina2.setText(String.valueOf(maquina.getMano().get(2).getValorIzq()));

        ImageIcon imgMaq4 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + maquina.getMano().get(3).getImagen() + ".png");
        ImageIcon imgMaq4Red = new ImageIcon(imgMaq4.getImage().getScaledInstance(100, 100, 1));
        imgMaquina3.setIcon(imgMaq4Red);
        valorDerMaquina3.setText(String.valueOf(maquina.getMano().get(3).getValorDer()));
        valorIzqMaquina4.setText(String.valueOf(maquina.getMano().get(3).getValorIzq()));

        ImageIcon imgMaq5 = new ImageIcon("/home/guilleroot/NetBeansProjects/HAMATE/src/imagenes/" + maquina.getMano().get(4).getImagen() + ".png");
        ImageIcon imgMaq5Red = new ImageIcon(imgMaq5.getImage().getScaledInstance(100, 100, 1));
        imgMaquina4.setIcon(imgMaq5Red);
        valorDerMaquina4.setText(String.valueOf(maquina.getMano().get(4).getValorDer()));
        valorIzqMaquina3.setText(String.valueOf(maquina.getMano().get(4).getValorIzq()));
    }
    /**
     * Este metodo actualiza toda la interfaz según como esten los arrays de los atributos introducidos
     * @param tablero
     * @param usuario
     * @param maquina
     * 
     */
    public void actualizarInterfaz(Tablero tablero, JugadorUsuario usuario, JugadorMaquina maquina) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        //Imágenes Tablero
        if (tablero.getJuego()[0].getImagen() != null) {
            valorDerJuego0.setText(String.valueOf(tablero.getJuego()[0].getValorDer()));
            valorIzqJuego0.setText(String.valueOf(tablero.getJuego()[0].getValorIzq()));
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[0].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego0.setIcon(imgRedimensionada);
            imgJuego0.setBackground(tablero.getJuego()[0].getColor());

        } else {
            valorDerJuego0.setText("");
            valorIzqJuego0.setText("");
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego0.setIcon(imgRedimensionada);
            imgJuego0.setBackground(null);

        }
        if (tablero.getJuego()[1].getImagen() != null) {
            valorDerJuego1.setText(String.valueOf(tablero.getJuego()[1].getValorDer()));
            valorIzqJuego1.setText(String.valueOf(tablero.getJuego()[1].getValorIzq()));
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[1].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego1.setIcon(imgRedimensionada);
            imgJuego1.setBackground(tablero.getJuego()[1].getColor());

        } else {
            valorDerJuego1.setText("");
            valorIzqJuego1.setText("");
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego1.setIcon(imgRedimensionada);
            imgJuego1.setBackground(null);

        }
        if (tablero.getJuego()[2].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[2].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego2.setIcon(imgRedimensionada);
            imgJuego2.setBackground(tablero.getJuego()[2].getColor());
            valorDerJuego2.setText(String.valueOf(tablero.getJuego()[2].getValorDer()));
            valorIzqJuego2.setText(String.valueOf(tablero.getJuego()[2].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego2.setIcon(imgRedimensionada);
            imgJuego2.setBackground(null);
            valorDerJuego2.setText("");
            valorIzqJuego2.setText("");
        }
        if (tablero.getJuego()[3].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[3].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego3.setIcon(imgRedimensionada);
            imgJuego3.setBackground(tablero.getJuego()[3].getColor());
            valorDerJuego3.setText(String.valueOf(tablero.getJuego()[3].getValorDer()));
            valorIzqJuego3.setText(String.valueOf(tablero.getJuego()[3].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego3.setIcon(imgRedimensionada);
            imgJuego3.setBackground(null);
            valorDerJuego3.setText("");
            valorIzqJuego3.setText("");
        }
        if (tablero.getJuego()[4].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[4].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego4.setIcon(imgRedimensionada);
            imgJuego4.setBackground(tablero.getJuego()[4].getColor());
            valorDerJuego4.setText(String.valueOf(tablero.getJuego()[4].getValorDer()));
            valorIzqJuego4.setText(String.valueOf(tablero.getJuego()[4].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego4.setIcon(imgRedimensionada);
            imgJuego4.setBackground(null);
            valorDerJuego4.setText("");
            valorIzqJuego4.setText("");
        }
        if (tablero.getJuego()[5].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[5].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego5.setIcon(imgRedimensionada);
            imgJuego5.setBackground(tablero.getJuego()[5].getColor());
            valorDerJuego5.setText(String.valueOf(tablero.getJuego()[5].getValorDer()));
            valorIzqJuego5.setText(String.valueOf(tablero.getJuego()[5].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego5.setIcon(imgRedimensionada);
            imgJuego5.setBackground(null);
            valorDerJuego5.setText("");
            valorIzqJuego5.setText("");
        }
        if (tablero.getJuego()[6].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[6].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego6.setIcon(imgRedimensionada);
            imgJuego6.setBackground(tablero.getJuego()[6].getColor());
            valorDerJuego6.setText(String.valueOf(tablero.getJuego()[6].getValorDer()));
            valorIzqJuego6.setText(String.valueOf(tablero.getJuego()[6].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego6.setIcon(imgRedimensionada);
            imgJuego6.setBackground(tablero.getJuego()[6].getColor());
            valorDerJuego6.setText("");
            valorIzqJuego6.setText("");
        }
        if (tablero.getJuego()[7].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[7].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego7.setIcon(imgRedimensionada);
            imgJuego7.setBackground(tablero.getJuego()[7].getColor());
            valorDerJuego7.setText(String.valueOf(tablero.getJuego()[7].getValorDer()));
            valorIzqJuego7.setText(String.valueOf(tablero.getJuego()[7].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego7.setIcon(imgRedimensionada);
            imgJuego7.setBackground(null);
            valorDerJuego7.setText("");
            valorIzqJuego7.setText("");
        }
        if (tablero.getJuego()[8].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[8].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego8.setIcon(imgRedimensionada);
            imgJuego8.setBackground(tablero.getJuego()[8].getColor());
            valorDerJuego8.setText(String.valueOf(tablero.getJuego()[8].getValorDer()));
            valorIzqJuego8.setText(String.valueOf(tablero.getJuego()[8].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego8.setIcon(imgRedimensionada);
            imgJuego8.setBackground(null);
            valorDerJuego8.setText("");
            valorIzqJuego8.setText("");
        }
        if (tablero.getJuego()[9].getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + tablero.getJuego()[9].getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego9.setIcon(imgRedimensionada);
            imgJuego9.setBackground(tablero.getJuego()[9].getColor());
            valorDerJuego9.setText(String.valueOf(tablero.getJuego()[9].getValorDer()));
            valorIzqJuego9.setText(String.valueOf(tablero.getJuego()[9].getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgJuego9.setIcon(imgRedimensionada);
            imgJuego9.setBackground(null);
            valorDerJuego9.setText("");
            valorIzqJuego9.setText("");
        }
        //Imagenes Mano Jugador
        if (usuario.getMano().get(0).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + usuario.getMano().get(0).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario0.setIcon(imgRedimensionada);
            imgUsuario0.setBackground(usuario.getColor());
            valorDerUsuario0.setText(String.valueOf(usuario.getMano().get(0).getValorDer()));
            valorIzqUsuario0.setText(String.valueOf(usuario.getMano().get(0).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario0.setIcon(imgRedimensionada);
            imgUsuario0.setBackground(null);
            valorDerUsuario0.setText("");
            valorIzqUsuario0.setText("");
        }
        if (usuario.getMano().get(1).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + usuario.getMano().get(1).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario1.setIcon(imgRedimensionada);
            imgUsuario1.setBackground(usuario.getColor());
            valorDerUsuario1.setText(String.valueOf(usuario.getMano().get(1).getValorDer()));
            valorIzqUsuario1.setText(String.valueOf(usuario.getMano().get(1).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario1.setIcon(imgRedimensionada);
            imgUsuario1.setBackground(null);
            valorDerUsuario1.setText("");
            valorIzqUsuario1.setText("");
        }
        if (usuario.getMano().get(2).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + usuario.getMano().get(2).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario2.setIcon(imgRedimensionada);
            imgUsuario2.setBackground(usuario.getColor());
            valorDerUsuario2.setText(String.valueOf(usuario.getMano().get(2).getValorDer()));
            valorIzqUsuario2.setText(String.valueOf(usuario.getMano().get(2).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario2.setIcon(imgRedimensionada);
            imgUsuario2.setBackground(null);
            valorDerUsuario2.setText("");
            valorIzqUsuario2.setText("");
        }
        if (usuario.getMano().get(3).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + usuario.getMano().get(3).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario3.setIcon(imgRedimensionada);
            imgUsuario3.setBackground(usuario.getColor());
            valorDerUsuario3.setText(String.valueOf(usuario.getMano().get(3).getValorDer()));
            valorIzqUsuario3.setText(String.valueOf(usuario.getMano().get(3).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario3.setIcon(imgRedimensionada);
            imgUsuario3.setBackground(null);
            valorDerUsuario3.setText("");
            valorIzqUsuario3.setText("");
        }
        if (usuario.getMano().get(4).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + usuario.getMano().get(4).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario4.setIcon(imgRedimensionada);
            imgUsuario4.setBackground(usuario.getColor());
            valorDerUsuario4.setText(String.valueOf(usuario.getMano().get(4).getValorDer()));
            valorIzqUsuario4.setText(String.valueOf(usuario.getMano().get(4).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgUsuario4.setIcon(imgRedimensionada);
            imgUsuario4.setBackground(null);
            valorDerUsuario4.setText("");
            valorIzqUsuario4.setText("");
        }
        //Imagenes Mano Maquina
        if (maquina.getMano().get(0).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + maquina.getMano().get(0).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina0.setIcon(imgRedimensionada);
            imgMaquina0.setBackground(maquina.getColor());
            valorDerMaquina0.setText(String.valueOf(maquina.getMano().get(0).getValorDer()));
            valorIzqMaquina0.setText(String.valueOf(maquina.getMano().get(0).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina0.setIcon(imgRedimensionada);
            imgMaquina0.setBackground(null);
            valorDerMaquina0.setText("");
            valorIzqMaquina0.setText("");
        }
        if (maquina.getMano().get(1).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + maquina.getMano().get(1).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina1.setIcon(imgRedimensionada);
            imgMaquina1.setBackground(maquina.getColor());
            valorDerMaquina1.setText(String.valueOf(maquina.getMano().get(1).getValorDer()));
            valorIzqMaquina1.setText(String.valueOf(maquina.getMano().get(1).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina1.setIcon(imgRedimensionada);
            imgMaquina1.setBackground(null);
            valorDerMaquina1.setText("");
            valorIzqMaquina1.setText("");
        }
        if (maquina.getMano().get(2).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + maquina.getMano().get(2).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina2.setIcon(imgRedimensionada);
            imgMaquina2.setBackground(maquina.getColor());
            valorDerMaquina2.setText(String.valueOf(maquina.getMano().get(2).getValorDer()));
            valorIzqMaquina2.setText(String.valueOf(maquina.getMano().get(2).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina2.setIcon(imgRedimensionada);
            imgMaquina2.setBackground(null);
            valorDerMaquina2.setText("");
            valorIzqMaquina2.setText("");
        }
        if (maquina.getMano().get(3).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + maquina.getMano().get(3).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina3.setIcon(imgRedimensionada);
            imgMaquina3.setBackground(maquina.getColor());
            valorDerMaquina3.setText(String.valueOf(maquina.getMano().get(3).getValorDer()));
            valorIzqMaquina3.setText(String.valueOf(maquina.getMano().get(3).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina3.setIcon(imgRedimensionada);
            imgMaquina3.setBackground(null);
            valorDerMaquina3.setText("");
            valorIzqMaquina3.setText("");
        }
        if (maquina.getMano().get(4).getImagen() != null) {
            ImageIcon imagen = new ImageIcon("src/imagenes/" + maquina.getMano().get(4).getImagen() + ".png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina4.setIcon(imgRedimensionada);
            imgMaquina4.setBackground(maquina.getColor());
            valorDerMaquina4.setText(String.valueOf(maquina.getMano().get(4).getValorDer()));
            valorIzqMaquina4.setText(String.valueOf(maquina.getMano().get(4).getValorIzq()));
        } else {
            ImageIcon imagen = new ImageIcon("src/imagenes/frame-1-normal.png");
            ImageIcon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, 1));
            imgMaquina4.setIcon(imgRedimensionada);
            imgMaquina4.setBackground(null);
            valorDerMaquina4.setText("");
            valorIzqMaquina4.setText("");
        }
        //Actualizamos Marcadores
        int i,j,cartasAzules = 0,cartasBlue=0,cartasRojas = 0,puntosUsuario=0,puntosMaquina=0,cartasPuestas=0;
        for(i=0;i<10;i++){
            if(tablero.getJuego()[i].getColor() == Color.blue)cartasBlue++;
            if(tablero.getJuego()[i].getColor() == Color.red)cartasRojas++;
            if(tablero.getJuego()[i].getVacia() == false)cartasPuestas++;
        }
        marcadorUsuario.setText(String.valueOf(cartasBlue));
        marcadorMaquina.setText(String.valueOf(cartasRojas));
        if(cartasPuestas==10){
            pararMusica(clip);
            for(j=0;j<10;j++){
                if(tablero.getJuego()[j].getColor() == Color.blue)cartasAzules++;
                if(tablero.getJuego()[j].getColor() == Color.blue){
                    puntosUsuario += (tablero.getJuego()[j].getValorDer()+tablero.getJuego()[j].getValorIzq())*tablero.getJuego()[j].getMultiplicador();
                    
                }
                else if(tablero.getJuego()[j].getColor() == maquina.getColor()){
                    puntosMaquina += (tablero.getJuego()[j].getValorDer()+tablero.getJuego()[j].getValorIzq())*tablero.getJuego()[j].getMultiplicador();   
                }
            }
            usuario.setPuntos(usuario.getPuntos()+puntosUsuario);
            usuario.setCartasGanadas(usuario.getCartasGanadas()+cartasAzules);
            usuario.setPartidasJugadas(usuario.getPartidasJugadas()+1);
            usuario.setPuntosPorPartida(usuario.getPuntos()/usuario.getPartidasJugadas());
            usuario.setPuntosPorPartida(usuario.getCartasGanadas()/usuario.getPartidasJugadas());
            usuario.borrarMano();
            maquina.setPuntos(maquina.getPuntos()+puntosMaquina);
            maquina.setCartasGanadas(maquina.getCartasGanadas()+cartasRojas);
            HashMap tabla = Inicio.getTablaJugadores();
            this.fosJugadores = new FileOutputStream("Jugadores.dat");
            this.oosJugadores = new ObjectOutputStream(fosJugadores);
            if(cartasAzules > cartasRojas){
                usuario.setPartidasGanadas(usuario.getPartidasGanadas()+1);
                tabla.put(usuario.getNIF(), usuario);
                oosJugadores.writeObject(tabla);
                oosJugadores.close();
                Inicio.setTablaJugadores(tabla);
                PantallaGanador ganador = new PantallaGanador();
                ganador.setVisible(true);
                }
            else if(cartasAzules < cartasRojas){
                tabla.put(usuario.getNIF(), usuario);
                oosJugadores.writeObject(tabla);
                oosJugadores.close();
                Inicio.setTablaJugadores(tabla);
                PantallaPerdedor perdedor = new PantallaPerdedor();
                perdedor.setVisible(true);
            }
            
            else if(cartasAzules == cartasRojas){
                tabla.put(usuario.getNIF(), usuario);
                oosJugadores.writeObject(tabla);                
                oosJugadores.close();
                Inicio.setTablaJugadores(tabla);
                PantallaEmpate empate = new PantallaEmpate();
                empate.setVisible(true);
            }
        }
    }

    public JRadioButton getBotonSeleccionado(ButtonGroup grupoBotones) {
        for (Enumeration botones = grupoBotones.getElements(); botones.hasMoreElements();) {
            JRadioButton boton = (JRadioButton) botones.nextElement();
            if (boton.getModel() == grupoBotones.getSelection()) {
                return boton;
            }
        }
        return null;
    }
    
    public void reproducirMusica(Clip clip) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        clip.start();   
    }
    public void pararMusica(Clip clip){
        clip.stop();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesTablero = new javax.swing.ButtonGroup();
        botonesUsuario = new javax.swing.ButtonGroup();
        jPanelFondo = new javax.swing.JPanel();
        manoUsuario = new javax.swing.JPanel();
        valorDerUsuario0 = new javax.swing.JLabel();
        valorDerUsuario1 = new javax.swing.JLabel();
        valorDerUsuario2 = new javax.swing.JLabel();
        valorDerUsuario3 = new javax.swing.JLabel();
        valorDerUsuario4 = new javax.swing.JLabel();
        valorIzqUsuario0 = new javax.swing.JLabel();
        valorIzqUsuario1 = new javax.swing.JLabel();
        valorIzqUsuario2 = new javax.swing.JLabel();
        valorIzqUsuario3 = new javax.swing.JLabel();
        valorIzqUsuario4 = new javax.swing.JLabel();
        imgUsuario0 = new javax.swing.JLabel();
        botUsuario0 = new javax.swing.JRadioButton();
        imgUsuario1 = new javax.swing.JLabel();
        botUsuario1 = new javax.swing.JRadioButton();
        imgUsuario2 = new javax.swing.JLabel();
        botUsuario2 = new javax.swing.JRadioButton();
        imgUsuario3 = new javax.swing.JLabel();
        botUsuario3 = new javax.swing.JRadioButton();
        imgUsuario4 = new javax.swing.JLabel();
        botUsuario4 = new javax.swing.JRadioButton();
        tableroJuego = new javax.swing.JPanel();
        valorDerJuego0 = new javax.swing.JLabel();
        valorDerJuego1 = new javax.swing.JLabel();
        valorDerJuego2 = new javax.swing.JLabel();
        valorDerJuego3 = new javax.swing.JLabel();
        valorDerJuego4 = new javax.swing.JLabel();
        valorDerJuego5 = new javax.swing.JLabel();
        valorDerJuego6 = new javax.swing.JLabel();
        valorDerJuego7 = new javax.swing.JLabel();
        valorDerJuego8 = new javax.swing.JLabel();
        valorDerJuego9 = new javax.swing.JLabel();
        valorIzqJuego0 = new javax.swing.JLabel();
        valorIzqJuego1 = new javax.swing.JLabel();
        valorIzqJuego2 = new javax.swing.JLabel();
        valorIzqJuego3 = new javax.swing.JLabel();
        valorIzqJuego4 = new javax.swing.JLabel();
        valorIzqJuego5 = new javax.swing.JLabel();
        valorIzqJuego6 = new javax.swing.JLabel();
        valorIzqJuego7 = new javax.swing.JLabel();
        valorIzqJuego8 = new javax.swing.JLabel();
        valorIzqJuego9 = new javax.swing.JLabel();
        imgJuego0 = new javax.swing.JLabel();
        botJuego0 = new javax.swing.JRadioButton();
        botJuego1 = new javax.swing.JRadioButton();
        imgJuego1 = new javax.swing.JLabel();
        imgJuego2 = new javax.swing.JLabel();
        botJuego2 = new javax.swing.JRadioButton();
        imgJuego3 = new javax.swing.JLabel();
        botJuego3 = new javax.swing.JRadioButton();
        imgJuego4 = new javax.swing.JLabel();
        botJuego4 = new javax.swing.JRadioButton();
        imgJuego5 = new javax.swing.JLabel();
        botJuego5 = new javax.swing.JRadioButton();
        imgJuego6 = new javax.swing.JLabel();
        botJuego6 = new javax.swing.JRadioButton();
        imgJuego7 = new javax.swing.JLabel();
        botJuego7 = new javax.swing.JRadioButton();
        imgJuego8 = new javax.swing.JLabel();
        botJuego8 = new javax.swing.JRadioButton();
        imgJuego9 = new javax.swing.JLabel();
        botJuego9 = new javax.swing.JRadioButton();
        manoMaquina = new javax.swing.JPanel();
        valorDerMaquina0 = new javax.swing.JLabel();
        valorDerMaquina1 = new javax.swing.JLabel();
        valorDerMaquina2 = new javax.swing.JLabel();
        valorDerMaquina3 = new javax.swing.JLabel();
        valorDerMaquina4 = new javax.swing.JLabel();
        valorIzqMaquina0 = new javax.swing.JLabel();
        valorIzqMaquina1 = new javax.swing.JLabel();
        valorIzqMaquina2 = new javax.swing.JLabel();
        valorIzqMaquina3 = new javax.swing.JLabel();
        valorIzqMaquina4 = new javax.swing.JLabel();
        imgMaquina0 = new javax.swing.JLabel();
        imgMaquina1 = new javax.swing.JLabel();
        imgMaquina2 = new javax.swing.JLabel();
        imgMaquina3 = new javax.swing.JLabel();
        imgMaquina4 = new javax.swing.JLabel();
        activarMusica = new javax.swing.JCheckBox();
        reiniciarJuego = new javax.swing.JButton();
        botSalir = new javax.swing.JButton();
        botAtaqueIzq = new javax.swing.JButton();
        botAtaqueDer = new javax.swing.JButton();
        botSiguienteTurno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        marcadorMaquina = new javax.swing.JTextField();
        marcadorUsuario = new javax.swing.JTextField();
        botRanking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(1220, 700));
        setSize(new java.awt.Dimension(1220, 700));
        getContentPane().setLayout(null);

        jPanelFondo.setBackground(new java.awt.Color(204, 255, 204));
        jPanelFondo.setToolTipText("");
        jPanelFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelFondo.setMaximumSize(new java.awt.Dimension(1220, 700));
        jPanelFondo.setMinimumSize(new java.awt.Dimension(1220, 700));
        jPanelFondo.setName(""); // NOI18N
        jPanelFondo.setPreferredSize(new java.awt.Dimension(1220, 700));
        jPanelFondo.setLayout(null);

        manoUsuario.setBackground(new java.awt.Color(120, 121, 236));
        manoUsuario.setPreferredSize(new java.awt.Dimension(570, 130));
        manoUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        manoUsuario.add(valorDerUsuario0, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 20, 20));
        manoUsuario.add(valorDerUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 20, 20));
        manoUsuario.add(valorDerUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 20, 20));
        manoUsuario.add(valorDerUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 20, 20));
        manoUsuario.add(valorDerUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 20, 20));

        valorIzqUsuario0.setToolTipText("");
        manoUsuario.add(valorIzqUsuario0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 20, 20));
        manoUsuario.add(valorIzqUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 20, 20));
        manoUsuario.add(valorIzqUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 20, 20));
        manoUsuario.add(valorIzqUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 20, 20));
        manoUsuario.add(valorIzqUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 20, 20));

        imgUsuario0.setBackground(new java.awt.Color(255, 153, 102));
        imgUsuario0.setForeground(new java.awt.Color(229, 22, 22));
        imgUsuario0.setOpaque(true);
        imgUsuario0.setPreferredSize(new java.awt.Dimension(100, 100));
        manoUsuario.add(imgUsuario0, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, -1, -1));

        botonesUsuario.add(botUsuario0);
        botUsuario0.setPreferredSize(new java.awt.Dimension(20, 20));
        manoUsuario.add(botUsuario0, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        imgUsuario1.setBackground(new java.awt.Color(255, 153, 102));
        imgUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        imgUsuario1.setOpaque(true);
        imgUsuario1.setPreferredSize(new java.awt.Dimension(100, 100));
        manoUsuario.add(imgUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        botonesUsuario.add(botUsuario1);
        botUsuario1.setPreferredSize(new java.awt.Dimension(20, 20));
        manoUsuario.add(botUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        imgUsuario2.setBackground(new java.awt.Color(255, 153, 102));
        imgUsuario2.setForeground(new java.awt.Color(255, 255, 255));
        imgUsuario2.setOpaque(true);
        imgUsuario2.setPreferredSize(new java.awt.Dimension(100, 100));
        manoUsuario.add(imgUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 10, -1, -1));

        botonesUsuario.add(botUsuario2);
        botUsuario2.setPreferredSize(new java.awt.Dimension(20, 20));
        manoUsuario.add(botUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        imgUsuario3.setBackground(new java.awt.Color(255, 153, 102));
        imgUsuario3.setForeground(new java.awt.Color(255, 255, 255));
        imgUsuario3.setOpaque(true);
        imgUsuario3.setPreferredSize(new java.awt.Dimension(100, 100));
        manoUsuario.add(imgUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 10, -1, -1));

        botonesUsuario.add(botUsuario3);
        botUsuario3.setPreferredSize(new java.awt.Dimension(20, 20));
        manoUsuario.add(botUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        imgUsuario4.setBackground(new java.awt.Color(255, 153, 102));
        imgUsuario4.setForeground(new java.awt.Color(255, 255, 255));
        imgUsuario4.setOpaque(true);
        imgUsuario4.setPreferredSize(new java.awt.Dimension(100, 100));
        manoUsuario.add(imgUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 10, -1, -1));

        botonesUsuario.add(botUsuario4);
        botUsuario4.setPreferredSize(new java.awt.Dimension(20, 20));
        manoUsuario.add(botUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        jPanelFondo.add(manoUsuario);
        manoUsuario.setBounds(330, 530, 570, 150);

        tableroJuego.setBackground(new java.awt.Color(103, 254, 198));
        tableroJuego.setPreferredSize(new java.awt.Dimension(1120, 130));
        tableroJuego.setLayout(null);
        tableroJuego.add(valorDerJuego0);
        valorDerJuego0.setBounds(90, 120, 20, 20);
        tableroJuego.add(valorDerJuego1);
        valorDerJuego1.setBounds(200, 120, 20, 20);

        valorDerJuego2.setText("\n");
        tableroJuego.add(valorDerJuego2);
        valorDerJuego2.setBounds(310, 120, 20, 20);
        tableroJuego.add(valorDerJuego3);
        valorDerJuego3.setBounds(430, 120, 20, 20);
        tableroJuego.add(valorDerJuego4);
        valorDerJuego4.setBounds(540, 120, 20, 20);
        tableroJuego.add(valorDerJuego5);
        valorDerJuego5.setBounds(650, 120, 20, 20);
        tableroJuego.add(valorDerJuego6);
        valorDerJuego6.setBounds(760, 120, 20, 20);
        tableroJuego.add(valorDerJuego7);
        valorDerJuego7.setBounds(870, 120, 20, 20);
        tableroJuego.add(valorDerJuego8);
        valorDerJuego8.setBounds(980, 120, 20, 20);
        tableroJuego.add(valorDerJuego9);
        valorDerJuego9.setBounds(1090, 120, 20, 20);
        tableroJuego.add(valorIzqJuego0);
        valorIzqJuego0.setBounds(20, 120, 20, 20);
        tableroJuego.add(valorIzqJuego1);
        valorIzqJuego1.setBounds(130, 120, 20, 20);
        tableroJuego.add(valorIzqJuego2);
        valorIzqJuego2.setBounds(240, 120, 20, 20);
        tableroJuego.add(valorIzqJuego3);
        valorIzqJuego3.setBounds(360, 120, 20, 20);
        tableroJuego.add(valorIzqJuego4);
        valorIzqJuego4.setBounds(470, 120, 20, 20);
        tableroJuego.add(valorIzqJuego5);
        valorIzqJuego5.setBounds(580, 120, 20, 20);
        tableroJuego.add(valorIzqJuego6);
        valorIzqJuego6.setBounds(690, 120, 20, 20);
        tableroJuego.add(valorIzqJuego7);
        valorIzqJuego7.setBounds(800, 120, 20, 20);
        tableroJuego.add(valorIzqJuego8);
        valorIzqJuego8.setBounds(910, 120, 20, 20);
        tableroJuego.add(valorIzqJuego9);
        valorIzqJuego9.setBounds(1020, 120, 20, 20);

        imgJuego0.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego0.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego0.setOpaque(true);
        imgJuego0.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego0);
        imgJuego0.setBounds(15, 15, 100, 100);

        botonesTablero.add(botJuego0);
        botJuego0.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego0);
        botJuego0.setBounds(55, 122, 20, 20);

        botonesTablero.add(botJuego1);
        botJuego1.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego1);
        botJuego1.setBounds(166, 122, 20, 20);

        imgJuego1.setBackground(new java.awt.Color(254, 153, 102));
        imgJuego1.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego1.setOpaque(true);
        imgJuego1.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego1);
        imgJuego1.setBounds(125, 15, 100, 100);

        imgJuego2.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego2.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego2.setOpaque(true);
        imgJuego2.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego2);
        imgJuego2.setBounds(235, 15, 100, 100);

        botonesTablero.add(botJuego2);
        botJuego2.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego2);
        botJuego2.setBounds(275, 122, 20, 20);

        imgJuego3.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego3.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego3.setOpaque(true);
        imgJuego3.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego3);
        imgJuego3.setBounds(353, 15, 100, 100);

        botonesTablero.add(botJuego3);
        botJuego3.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego3);
        botJuego3.setBounds(386, 122, 20, 20);

        imgJuego4.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego4.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego4.setOpaque(true);
        imgJuego4.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego4);
        imgJuego4.setBounds(463, 15, 100, 100);

        botonesTablero.add(botJuego4);
        botJuego4.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego4);
        botJuego4.setBounds(496, 122, 20, 20);

        imgJuego5.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego5.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego5.setOpaque(true);
        imgJuego5.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego5);
        imgJuego5.setBounds(573, 15, 100, 100);

        botonesTablero.add(botJuego5);
        botJuego5.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego5);
        botJuego5.setBounds(606, 122, 20, 20);

        imgJuego6.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego6.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        imgJuego6.setOpaque(true);
        imgJuego6.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego6);
        imgJuego6.setBounds(683, 15, 100, 100);

        botonesTablero.add(botJuego6);
        botJuego6.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego6);
        botJuego6.setBounds(719, 122, 20, 20);

        imgJuego7.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego7.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego7.setOpaque(true);
        imgJuego7.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego7);
        imgJuego7.setBounds(793, 15, 100, 100);

        botonesTablero.add(botJuego7);
        botJuego7.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego7);
        botJuego7.setBounds(826, 122, 20, 20);

        imgJuego8.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego8.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego8.setOpaque(true);
        imgJuego8.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego8);
        imgJuego8.setBounds(903, 15, 100, 100);

        botonesTablero.add(botJuego8);
        botJuego8.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego8);
        botJuego8.setBounds(935, 122, 20, 20);

        imgJuego9.setBackground(new java.awt.Color(255, 153, 102));
        imgJuego9.setForeground(new java.awt.Color(255, 255, 255));
        imgJuego9.setOpaque(true);
        imgJuego9.setPreferredSize(new java.awt.Dimension(100, 100));
        tableroJuego.add(imgJuego9);
        imgJuego9.setBounds(1013, 15, 100, 100);

        botonesTablero.add(botJuego9);
        botJuego9.setPreferredSize(new java.awt.Dimension(20, 20));
        tableroJuego.add(botJuego9);
        botJuego9.setBounds(1044, 122, 20, 20);

        jPanelFondo.add(tableroJuego);
        tableroJuego.setBounds(44, 246, 1120, 158);

        manoMaquina.setBackground(new java.awt.Color(235, 121, 98));
        manoMaquina.setPreferredSize(new java.awt.Dimension(570, 130));
        manoMaquina.setLayout(null);
        manoMaquina.add(valorDerMaquina0);
        valorDerMaquina0.setBounds(100, 120, 20, 20);
        manoMaquina.add(valorDerMaquina1);
        valorDerMaquina1.setBounds(210, 120, 20, 20);
        manoMaquina.add(valorDerMaquina2);
        valorDerMaquina2.setBounds(320, 120, 20, 20);
        manoMaquina.add(valorDerMaquina3);
        valorDerMaquina3.setBounds(430, 120, 20, 20);
        manoMaquina.add(valorDerMaquina4);
        valorDerMaquina4.setBounds(540, 120, 20, 20);
        manoMaquina.add(valorIzqMaquina0);
        valorIzqMaquina0.setBounds(20, 120, 20, 20);
        manoMaquina.add(valorIzqMaquina1);
        valorIzqMaquina1.setBounds(130, 120, 20, 20);
        manoMaquina.add(valorIzqMaquina2);
        valorIzqMaquina2.setBounds(240, 120, 20, 20);
        manoMaquina.add(valorIzqMaquina3);
        valorIzqMaquina3.setBounds(350, 120, 20, 20);
        manoMaquina.add(valorIzqMaquina4);
        valorIzqMaquina4.setBounds(470, 120, 20, 20);

        imgMaquina0.setBackground(new java.awt.Color(255, 153, 102));
        imgMaquina0.setForeground(new java.awt.Color(255, 255, 255));
        imgMaquina0.setOpaque(true);
        imgMaquina0.setPreferredSize(new java.awt.Dimension(100, 100));
        imgMaquina0.setVerifyInputWhenFocusTarget(false);
        manoMaquina.add(imgMaquina0);
        imgMaquina0.setBounds(15, 15, 100, 100);

        imgMaquina1.setBackground(new java.awt.Color(255, 153, 102));
        imgMaquina1.setForeground(new java.awt.Color(255, 255, 255));
        imgMaquina1.setOpaque(true);
        imgMaquina1.setPreferredSize(new java.awt.Dimension(100, 100));
        manoMaquina.add(imgMaquina1);
        imgMaquina1.setBounds(127, 15, 100, 100);

        imgMaquina2.setBackground(new java.awt.Color(255, 153, 102));
        imgMaquina2.setForeground(new java.awt.Color(255, 255, 255));
        imgMaquina2.setOpaque(true);
        imgMaquina2.setPreferredSize(new java.awt.Dimension(100, 100));
        manoMaquina.add(imgMaquina2);
        imgMaquina2.setBounds(239, 15, 100, 100);

        imgMaquina3.setBackground(new java.awt.Color(255, 153, 102));
        imgMaquina3.setForeground(new java.awt.Color(255, 255, 255));
        imgMaquina3.setOpaque(true);
        imgMaquina3.setPreferredSize(new java.awt.Dimension(100, 100));
        manoMaquina.add(imgMaquina3);
        imgMaquina3.setBounds(351, 16, 100, 100);

        imgMaquina4.setBackground(new java.awt.Color(255, 153, 102));
        imgMaquina4.setForeground(new java.awt.Color(255, 255, 255));
        imgMaquina4.setOpaque(true);
        imgMaquina4.setPreferredSize(new java.awt.Dimension(100, 100));
        manoMaquina.add(imgMaquina4);
        imgMaquina4.setBounds(463, 16, 100, 100);

        jPanelFondo.add(manoMaquina);
        manoMaquina.setBounds(330, 50, 575, 150);

        activarMusica.setText("Activar Música");
        activarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarMusicaActionPerformed(evt);
            }
        });
        jPanelFondo.add(activarMusica);
        activarMusica.setBounds(920, 530, 140, 24);

        reiniciarJuego.setText("Reiniciar");
        reiniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarJuegoActionPerformed(evt);
            }
        });
        jPanelFondo.add(reiniciarJuego);
        reiniciarJuego.setBounds(200, 630, 90, 29);

        botSalir.setText("Salir");
        botSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSalirActionPerformed(evt);
            }
        });
        jPanelFondo.add(botSalir);
        botSalir.setBounds(930, 630, 70, 29);

        botAtaqueIzq.setText("Ataque Izquierda");
        botAtaqueIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAtaqueIzqActionPerformed(evt);
            }
        });
        jPanelFondo.add(botAtaqueIzq);
        botAtaqueIzq.setBounds(330, 480, 275, 29);

        botAtaqueDer.setText("Ataque Derecha");
        botAtaqueDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAtaqueDerActionPerformed(evt);
            }
        });
        jPanelFondo.add(botAtaqueDer);
        botAtaqueDer.setBounds(620, 480, 275, 29);

        botSiguienteTurno.setText("Turno Maquina");
        botSiguienteTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSiguienteTurnoActionPerformed(evt);
            }
        });
        jPanelFondo.add(botSiguienteTurno);
        botSiguienteTurno.setBounds(330, 210, 575, 29);

        jLabel1.setText("Marcador");
        jPanelFondo.add(jLabel1);
        jLabel1.setBounds(100, 30, 80, 17);

        marcadorMaquina.setEditable(false);
        marcadorMaquina.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        marcadorMaquina.setForeground(new java.awt.Color(255, 0, 0));
        marcadorMaquina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanelFondo.add(marcadorMaquina);
        marcadorMaquina.setBounds(140, 60, 90, 90);

        marcadorUsuario.setEditable(false);
        marcadorUsuario.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        marcadorUsuario.setForeground(java.awt.Color.blue);
        marcadorUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanelFondo.add(marcadorUsuario);
        marcadorUsuario.setBounds(40, 60, 90, 90);

        botRanking.setText("Ranking");
        botRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRankingActionPerformed(evt);
            }
        });
        jPanelFondo.add(botRanking);
        botRanking.setBounds(1072, 630, 90, 29);

        getContentPane().add(jPanelFondo);
        jPanelFondo.setBounds(0, 0, 1220, 700);
        jPanelFondo.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void botSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botSalirActionPerformed

    private void reiniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarJuegoActionPerformed
        // TODO add your handling code here:
        dispose();
        ModoJuego nuevo = new ModoJuego();
        nuevo.setVisible(true);

    }//GEN-LAST:event_reiniciarJuegoActionPerformed

    private void activarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarMusicaActionPerformed

        // TODO add your handling code here:
        if(activarMusica.isSelected()){
            try {
                if(!clip.isRunning())reproducirMusica(clip);
                reproducirMusica(clip);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
                pararMusica(clip);
        }
        
           

    }//GEN-LAST:event_activarMusicaActionPerformed

    private void botAtaqueIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAtaqueIzqActionPerformed
        // TODO add your handling code here:
        JRadioButton botJugadorSeleccionado = getBotonSeleccionado(botonesUsuario);
        JRadioButton botTableroSeleccionado = getBotonSeleccionado(botonesTablero);
        int posMano = 0, posTablero = 0;
        
        
        try{
            if (botJugadorSeleccionado.equals(botUsuario0)) {posMano = 0;} 
            else if (botJugadorSeleccionado.equals(botUsuario1)) {posMano = 1;} 
            else if (botJugadorSeleccionado.equals(botUsuario2)) {posMano = 2;} 
            else if (botJugadorSeleccionado.equals(botUsuario3)) {posMano = 3;}
            else if (botJugadorSeleccionado.equals(botUsuario4)) {posMano = 4;}
            
            if (botTableroSeleccionado.equals(botJuego0)) {posTablero = 0;} 
            else if (botTableroSeleccionado.equals(botJuego1)) {posTablero = 1;} 
            else if (botTableroSeleccionado.equals(botJuego2)) {posTablero = 2;} 
            else if (botTableroSeleccionado.equals(botJuego3)) {posTablero = 3;}
            else if (botTableroSeleccionado.equals(botJuego4)) {posTablero = 4;} 
            else if (botTableroSeleccionado.equals(botJuego5)) {posTablero = 5;} 
            else if (botTableroSeleccionado.equals(botJuego6)) {posTablero = 6;}
            else if (botTableroSeleccionado.equals(botJuego7)) {posTablero = 7;} 
            else if (botTableroSeleccionado.equals(botJuego8)) {posTablero = 8;} 
            else if (botTableroSeleccionado.equals(botJuego9)) {posTablero = 9; }

            if (usuario.getMano().get(posMano).getImagen() == null)throw new JugadorException(JugadorException.CARTA_NO_SELECCIONADA);
            if (tablero.getJuego()[posTablero].getImagen() != null)throw new JugadorException(JugadorException.POSICION_TABLERO_INCORRECTA);
            tablero.colocarCarta(usuario.getMano().get(posMano), posTablero);
            usuario.quitarCarta(posMano);
            usuario.retoIzquierda(tablero.getJuego()[posTablero], tablero, posTablero);
            actualizarInterfaz(tablero, usuario, maquina);
            botSiguienteTurno.setEnabled(true);
            botAtaqueDer.setEnabled(false);
            botAtaqueIzq.setEnabled(false);

        } catch (JugadorException ex) {
            JOptionPane.showMessageDialog(this,ex,"Error", WARNING_MESSAGE);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botAtaqueIzqActionPerformed

    private void botAtaqueDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAtaqueDerActionPerformed
        // TODO add your handling code here:
        JRadioButton botJugadorSeleccionado = getBotonSeleccionado(botonesUsuario);
        JRadioButton botTableroSeleccionado = getBotonSeleccionado(botonesTablero);
        int posMano = 0, posTablero = 0;
        
        
        try{
            if (botJugadorSeleccionado.equals(botUsuario0)) {posMano = 0;} 
            else if (botJugadorSeleccionado.equals(botUsuario1)) {posMano = 1;} 
            else if (botJugadorSeleccionado.equals(botUsuario2)) {posMano = 2;} 
            else if (botJugadorSeleccionado.equals(botUsuario3)) {posMano = 3;}
            else if (botJugadorSeleccionado.equals(botUsuario4)) {posMano = 4;}
            
            if (botTableroSeleccionado.equals(botJuego0)) {posTablero = 0;} 
            else if (botTableroSeleccionado.equals(botJuego1)) {posTablero = 1;} 
            else if (botTableroSeleccionado.equals(botJuego2)) {posTablero = 2;} 
            else if (botTableroSeleccionado.equals(botJuego3)) {posTablero = 3;}
            else if (botTableroSeleccionado.equals(botJuego4)) {posTablero = 4;} 
            else if (botTableroSeleccionado.equals(botJuego5)) {posTablero = 5;} 
            else if (botTableroSeleccionado.equals(botJuego6)) {posTablero = 6;}
            else if (botTableroSeleccionado.equals(botJuego7)) {posTablero = 7;} 
            else if (botTableroSeleccionado.equals(botJuego8)) {posTablero = 8;} 
            else if (botTableroSeleccionado.equals(botJuego9)) {posTablero = 9; }

            if (usuario.getMano().get(posMano).getImagen() == null)throw new JugadorException(JugadorException.CARTA_NO_SELECCIONADA);
            if (tablero.getJuego()[posTablero].getImagen() != null)throw new JugadorException(JugadorException.POSICION_TABLERO_INCORRECTA);
            tablero.colocarCarta(usuario.getMano().get(posMano), posTablero);
            usuario.quitarCarta(posMano);
            usuario.retoDerecha(tablero.getJuego()[posTablero], tablero, posTablero);
            actualizarInterfaz(tablero, usuario, maquina);
            botSiguienteTurno.setEnabled(true);
            botAtaqueDer.setEnabled(false);
            botAtaqueIzq.setEnabled(false);
            
        } catch (JugadorException ex) {
            JOptionPane.showMessageDialog(this,ex,"Error", WARNING_MESSAGE);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botAtaqueDerActionPerformed

    private void botSiguienteTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSiguienteTurnoActionPerformed
        // TODO add your handling code here:
        maquina.turnoMaquina(tablero);
        try {
            this.actualizarInterfaz(tablero, usuario, maquina);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
        botSiguienteTurno.setEnabled(false);
        botAtaqueDer.setEnabled(true);
        botAtaqueIzq.setEnabled(true);
        
        
    }//GEN-LAST:event_botSiguienteTurnoActionPerformed

    private void botRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRankingActionPerformed
        // TODO add your handling code here:
        Ranking ranking = new Ranking();
        ranking.setVisible(true);
    }//GEN-LAST:event_botRankingActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Juego().setVisible(true);
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JCheckBox activarMusica;
    javax.swing.JButton botAtaqueDer;
    javax.swing.JButton botAtaqueIzq;
    javax.swing.JRadioButton botJuego0;
    javax.swing.JRadioButton botJuego1;
    javax.swing.JRadioButton botJuego2;
    javax.swing.JRadioButton botJuego3;
    javax.swing.JRadioButton botJuego4;
    javax.swing.JRadioButton botJuego5;
    javax.swing.JRadioButton botJuego6;
    javax.swing.JRadioButton botJuego7;
    javax.swing.JRadioButton botJuego8;
    javax.swing.JRadioButton botJuego9;
    javax.swing.JButton botRanking;
    javax.swing.JButton botSalir;
    javax.swing.JButton botSiguienteTurno;
    javax.swing.JRadioButton botUsuario0;
    javax.swing.JRadioButton botUsuario1;
    javax.swing.JRadioButton botUsuario2;
    javax.swing.JRadioButton botUsuario3;
    javax.swing.JRadioButton botUsuario4;
    javax.swing.ButtonGroup botonesTablero;
    javax.swing.ButtonGroup botonesUsuario;
    javax.swing.JLabel imgJuego0;
    javax.swing.JLabel imgJuego1;
    javax.swing.JLabel imgJuego2;
    javax.swing.JLabel imgJuego3;
    javax.swing.JLabel imgJuego4;
    javax.swing.JLabel imgJuego5;
    javax.swing.JLabel imgJuego6;
    javax.swing.JLabel imgJuego7;
    javax.swing.JLabel imgJuego8;
    javax.swing.JLabel imgJuego9;
    javax.swing.JLabel imgMaquina0;
    javax.swing.JLabel imgMaquina1;
    javax.swing.JLabel imgMaquina2;
    javax.swing.JLabel imgMaquina3;
    javax.swing.JLabel imgMaquina4;
    javax.swing.JLabel imgUsuario0;
    javax.swing.JLabel imgUsuario1;
    javax.swing.JLabel imgUsuario2;
    javax.swing.JLabel imgUsuario3;
    javax.swing.JLabel imgUsuario4;
    javax.swing.JLabel jLabel1;
    javax.swing.JPanel jPanelFondo;
    javax.swing.JPanel manoMaquina;
    javax.swing.JPanel manoUsuario;
    javax.swing.JTextField marcadorMaquina;
    javax.swing.JTextField marcadorUsuario;
    javax.swing.JButton reiniciarJuego;
    javax.swing.JPanel tableroJuego;
    javax.swing.JLabel valorDerJuego0;
    javax.swing.JLabel valorDerJuego1;
    javax.swing.JLabel valorDerJuego2;
    javax.swing.JLabel valorDerJuego3;
    javax.swing.JLabel valorDerJuego4;
    javax.swing.JLabel valorDerJuego5;
    javax.swing.JLabel valorDerJuego6;
    javax.swing.JLabel valorDerJuego7;
    javax.swing.JLabel valorDerJuego8;
    javax.swing.JLabel valorDerJuego9;
    javax.swing.JLabel valorDerMaquina0;
    javax.swing.JLabel valorDerMaquina1;
    javax.swing.JLabel valorDerMaquina2;
    javax.swing.JLabel valorDerMaquina3;
    javax.swing.JLabel valorDerMaquina4;
    javax.swing.JLabel valorDerUsuario0;
    javax.swing.JLabel valorDerUsuario1;
    javax.swing.JLabel valorDerUsuario2;
    javax.swing.JLabel valorDerUsuario3;
    javax.swing.JLabel valorDerUsuario4;
    javax.swing.JLabel valorIzqJuego0;
    javax.swing.JLabel valorIzqJuego1;
    javax.swing.JLabel valorIzqJuego2;
    javax.swing.JLabel valorIzqJuego3;
    javax.swing.JLabel valorIzqJuego4;
    javax.swing.JLabel valorIzqJuego5;
    javax.swing.JLabel valorIzqJuego6;
    javax.swing.JLabel valorIzqJuego7;
    javax.swing.JLabel valorIzqJuego8;
    javax.swing.JLabel valorIzqJuego9;
    javax.swing.JLabel valorIzqMaquina0;
    javax.swing.JLabel valorIzqMaquina1;
    javax.swing.JLabel valorIzqMaquina2;
    javax.swing.JLabel valorIzqMaquina3;
    javax.swing.JLabel valorIzqMaquina4;
    javax.swing.JLabel valorIzqUsuario0;
    javax.swing.JLabel valorIzqUsuario1;
    javax.swing.JLabel valorIzqUsuario2;
    javax.swing.JLabel valorIzqUsuario3;
    javax.swing.JLabel valorIzqUsuario4;
    // End of variables declaration//GEN-END:variables
}
