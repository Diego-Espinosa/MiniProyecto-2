/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import GUI.VentanaJuegoContraPC;
import java.awt.event.ActionListener;
/**
 *
 * @author Diego Espinosa-
 * @author Brigitte Chavez-2041700
 */
public class VentanaModo {

    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnUnoContraUno;
    private JButton btnContraPc;
    private JButton btnSalir;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JLabel lblnumPartidas;
    
     
    
    public VentanaModo() {
        initComponents();
    }

    public void initComponents() {
        Color cafe = new Color(131, 51, 0);
        
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        lblnumPartidas = new JLabel("Número de partidas");
        
        btnSalir = new JButton("Salir");
        
        btnUnoContraUno = new JButton("Uno conta uno");
        btnContraPc = new JButton("Uno conta PC");
        
        JFrame1 = new JFrame();
        panelPpal = new JPanel();
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/maderaBG.jpg"));
        lblFondo = new JLabel(imagenFondo);
        
        
        
        
        btnSalir.setBounds(400, 0, 100, 25);
        btnSalir.setBackground(Color.red);
        btnSalir.setForeground(white);
        btnSalir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

   
        lblFondo.setSize(500, 500);

        btn1.setBounds(120,350, 50, 50);
        btn1.setBackground(cafe);
        btn1.setForeground(white);
        btn1.setVisible(true);
        btn1.addActionListener((ActionEvent e) -> {
            //llamar método en la clase VentanaJuegoUnoContaUno para actualizar el número de turnos de los jugadores
            System.out.println("Se presionó el botón 1");
        });
        
        btn2.setBounds(180,350, 50, 50);
        btn2.setBackground(cafe);
        btn2.setForeground(white);
        btn2.setVisible(true);
        
        btn3.setBounds(240,350, 50, 50);
        btn3.setBackground(cafe);
        btn3.setForeground(white);
        btn3.setVisible(true);
        
        btn4.setBounds(300,350, 50, 50);
        btn4.setBackground(cafe);
        btn4.setForeground(white);
        btn4.setVisible(true);
        
        lblnumPartidas.setBounds(150,270, 150, 150);
        btn4.setBackground(cafe);
        btn4.setForeground(white);
        
        
       
  
        /////Botón de uno contra uno
        btnUnoContraUno.setBounds(160,150, 150, 50);
        btnUnoContraUno.setBackground(cafe);
        btnUnoContraUno.setForeground(white);
        btnUnoContraUno.addActionListener((ActionEvent e) -> {
            JFrame1.setVisible(false);
            VentanaNombresDosJugadores ventanaNombres = new VentanaNombresDosJugadores();
            ventanaNombres.getJFrame1().setVisible(true);
        });
        
        /////Botón de uno contra el computador
        btnContraPc.setBounds(160,205, 150, 50);
        btnContraPc.setBackground(cafe);
        btnContraPc.setForeground(white);
        btnContraPc.addActionListener((ActionEvent e) -> {
            JFrame1.setVisible(false);
            VentanaNombreUnJugador VentanaNombreUnJugador = new VentanaNombreUnJugador();
            VentanaNombreUnJugador.getJFrame1().setVisible(true);
        });
        
        //Panel principal ->add
        panelPpal.setSize(500, 500);
        panelPpal.setLayout(null);
        panelPpal.add(btnSalir);
        panelPpal.add(btnUnoContraUno);
        panelPpal.add(btnContraPc);
        panelPpal.add(lblFondo);
        
        panelPpal.add(btn1);
        panelPpal.add(btn2);
        panelPpal.add(btn3);
        panelPpal.add(btn4);
        panelPpal.add(lblnumPartidas);
        
        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame1.setSize(500, 500);
        JFrame1.getContentPane().add(panelPpal);
        JFrame1.setLocationRelativeTo(null);
        JFrame1.setUndecorated(true);
        JFrame1.setVisible(true);
    }

    public JFrame getJFrame1() {
        return JFrame1;
    }
}
