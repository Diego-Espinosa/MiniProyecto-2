/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import GUI.VentanaPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
/**
 *
 * @author diego
 */
public class VentanaInstrucciones {
    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JLabel lblInstrucciones;
    private JButton btnRegresar;
    private JButton btnSalir;
    public VentanaInstrucciones() {
       initComponents();
    }

    private void initComponents() {
        btnSalir = new JButton("Salir");
        btnRegresar = new JButton("Regresar");
        JFrame1 = new JFrame();
        panelPpal= new JPanel();
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/maderaBG.jpg"));
        lblFondo= new JLabel(imagenFondo);
        lblInstrucciones= new JLabel("<html>Para ganar debes hacer una linea recta con tres circulos o 3 X en el tablero, dicha linea puede ser diagonal. <html>");
        
        btnSalir.setBounds(400,0,100,25);
        btnSalir.setBackground(Color.red);
        btnSalir.setForeground(white);
        btnSalir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        Color cafe= new Color(131, 51, 0);
        btnRegresar.setBounds(160,350,150,50);
        btnRegresar.setBackground(cafe);
        btnRegresar.setForeground(white);
        btnRegresar.addActionListener((ActionEvent e) -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            ventanaPrincipal.getJFrame1().setVisible(true);
        });
        Font font = new Font("Arial", Font.PLAIN, 20);
        lblInstrucciones.setBounds(150,150,200, 200);
        lblInstrucciones.setFont(font);
        lblInstrucciones.setForeground(white);

        
        lblFondo.setSize(500,500);
        
        panelPpal.setLayout(null);
        panelPpal.add(btnSalir);
        panelPpal.add(lblInstrucciones);
        panelPpal.add(btnRegresar);
        panelPpal.setSize(500, 500);
        panelPpal.add(lblFondo);
   
        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame1.setSize( 500, 500);
        JFrame1.getContentPane().add(panelPpal);
        JFrame1.setLocationRelativeTo(null);
        JFrame1.setUndecorated(true);
    }

    public void mostrarFrameInstrucciones() {
         if(JFrame1.isVisible()){
            JFrame1.setVisible(false);
         
        }else{
            JFrame1.setVisible(true);
         }
    }
}