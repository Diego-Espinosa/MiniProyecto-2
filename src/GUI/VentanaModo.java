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
/**
 *
 * @author diego
 */
public class VentanaModo {

    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnUnoContraUno;
    private JButton btnContraPc;
    private JButton btnSalir;

    public VentanaModo() {
        initComponents();
    }

    public void initComponents() {
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

        Color cafe = new Color(131, 51, 0);
        btnUnoContraUno.setBounds(160,150, 150, 50);
        btnUnoContraUno.setBackground(cafe);
        btnUnoContraUno.setForeground(white);
        btnUnoContraUno.addActionListener((ActionEvent e) -> {
            JFrame1.setVisible(false);
            VentanaNombresDosJugadores ventanaNombres = new VentanaNombresDosJugadores();
            ventanaNombres.getJFrame1().setVisible(true);
        });
        
        
        btnContraPc.setBounds(160,205, 150, 50);
        btnContraPc.setBackground(cafe);
        btnContraPc.setForeground(white);
        btnContraPc.addActionListener((ActionEvent e) -> {
            JFrame1.setVisible(false);
            VentanaNombreUnJugador VentanaNombreUnJugador = new VentanaNombreUnJugador();
            VentanaNombreUnJugador.getJFrame1().setVisible(true);
        });
        panelPpal.setSize(500, 500);

        panelPpal.setLayout(null);
        panelPpal.add(btnSalir);
        panelPpal.add(btnUnoContraUno);
        panelPpal.add(btnContraPc);

        panelPpal.add(lblFondo);

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
