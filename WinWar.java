import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class WinWar extends JPanel{
    private JButton boton1;
    private JTextField cajaTexto;
    private boolean turno;
    public WinWar (){
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(2,1));
        this.setVisible(true);
        crearBotones();
        cajaDeTexto();
        turno = false;
    }
    
    public void crearBotones(){
        boton1= new JButton("Atacar");
        boton1.setForeground(Color.BLACK);
        boton1.setFont(new Font("cooper black",Font.PLAIN,18));
        boton1.setBackground(Color.ORANGE);
        this.add(boton1);
        eventoOyenteAccion();
    }
    
    public void cajaDeTexto(){
        cajaTexto=new JTextField();
        cajaTexto.setFont(new Font("cooper black",Font.PLAIN,20));
        this.add(cajaTexto);
    }
    
    public void eventoOyenteAccion(){
        ActionListener oyenteAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(!cajaTexto.getText().isBlank()){
                    String co = cajaTexto.getText();
                    String[] coo = new String[2];
                    coo = co.split(",");
                    Main.jugador1.eliminarFicha(Integer.parseInt(coo[0]),Integer.parseInt(coo[1]));
                    Main.jugador2.eliminarFicha(Integer.parseInt(coo[0]),Integer.parseInt(coo[1]));
                    if(turno==true){
                        turno = false;
                        Main.board.setBackground(Color.RED);
                    }else{
                        turno = true;
                        Main.board.setBackground(Color.GREEN);
                    }
                    gano();
                }
            }        
        };
        boton1.addActionListener(oyenteAccion);
    }
    public void gano(){
        if(Main.jugador1.estaSinFichas()){
            JOptionPane.showMessageDialog(new JPanel(), "Gano el jugador2", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        }else if(Main.jugador2.estaSinFichas()){
            JOptionPane.showMessageDialog(new JPanel(), "Gano el jugador1", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
