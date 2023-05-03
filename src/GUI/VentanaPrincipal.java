/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.*;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import GUI.VentanaInstrucciones;
import GUI.VentanaJuego;
/**
 *
 * @author diego
 */
public class VentanaPrincipal {
    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnSalir;
    private JButton btnJugar;
    private JButton btnInstrucciones;

    public VentanaPrincipal() {
        initComponents();
    }
    
    public void initComponents(){
        JFrame1 = new JFrame();
        panelPpal= new JPanel();
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/maderaBG.jpg"));
        lblFondo= new JLabel(imagenFondo);
        btnSalir = new JButton("Salir");
        btnJugar = new JButton("Jugar");
        btnInstrucciones = new JButton("Instrucciones");
        
       
      
        lblFondo.setSize(500,500);
        
       
        
        
        Color cafe= new Color(131, 51, 0);
        btnJugar.setBackground(cafe);
        btnJugar.setBounds(175,175,150,50);
        btnJugar.setForeground(white);
        btnJugar.addActionListener((ActionEvent e) -> {
            JFrame1.setVisible(false);
            VentanaJuego ventanaJuego = new VentanaJuego();
            ventanaJuego.mostrarFrameJuego();
        });
        
        btnInstrucciones.setBackground(cafe);
        btnInstrucciones.setForeground(white);
        btnInstrucciones.setBounds(175,230,150,50);
        btnInstrucciones.addActionListener((ActionEvent e) -> {
            JFrame1.setVisible(false);
            VentanaInstrucciones ventanaInstrccuiones = new VentanaInstrucciones();
            ventanaInstrccuiones.mostrarFrameInstrucciones();
        });
        
        btnSalir.setBounds(400,0,100,25);
        btnSalir.setBackground(Color.red);
        btnSalir.setForeground(white);
        btnSalir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        panelPpal.add(btnInstrucciones);
        panelPpal.add(btnSalir);
        panelPpal.add(btnJugar);
        panelPpal.setLayout(null);
        panelPpal.add(lblFondo);
        panelPpal.setSize(500, 500);
  
        
        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame1.setSize( 500, 500);
        JFrame1.getContentPane().add(panelPpal);
        JFrame1.setLocationRelativeTo(null);
        JFrame1.setUndecorated(true);
        JFrame1.setVisible(true);
        
    }

    public JFrame getJFrame1() {
        return JFrame1;
    }

    
}
