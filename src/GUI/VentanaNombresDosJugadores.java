/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Diego Espinosa-
 * @author Brigitte Chavez-2041700
 */
public final class VentanaNombresDosJugadores {

    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnContinuar;
    private JButton btnSalir;
    private JTextField NombreUno;
    private JTextField NombreDos;
    private String nombreJugadorUno;
    private String nombreJugadorDos;

    public VentanaNombresDosJugadores() {
        initComponents();
    }

    public void initComponents() {
        btnSalir = new JButton("Salir");
        btnContinuar = new JButton("Continuar");
        JFrame1 = new JFrame();
        panelPpal = new JPanel();
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/maderaBG.jpg"));
        lblFondo = new JLabel(imagenFondo);
        NombreUno = new JTextField("Jugador 1");
        NombreDos = new JTextField("Jugador 2");

        NombreUno.setBounds(100, 200, 105, 20);
        NombreDos.setBounds(100, 250, 105, 20);
        
        NombreDos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NombreDos.setText("");
            }
        });
        
        NombreUno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NombreUno.setText("");
            }
        });

        btnSalir.setBounds(400, 0, 100, 25);
        btnSalir.setBackground(Color.red);
        btnSalir.setForeground(white);
        btnSalir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        lblFondo.setSize(500, 500);

        Color cafe = new Color(131, 51, 0);
        btnContinuar.setBounds(160, 350, 150, 50);
        btnContinuar.setBackground(cafe);
        btnContinuar.setForeground(white);
        btnContinuar.addActionListener((ActionEvent e) -> {
            String nombreJugadorUno = NombreUno.getText();
            String nombreJugadorDos = NombreDos.getText();
            JFrame1.setVisible(false);
            //
            VentanaJuegoUnoContraUno ventanaJuego = new VentanaJuegoUnoContraUno(this);
            ventanaJuego.mostrarFrameJuego();
        });

        
        
        panelPpal.setLayout(null);
        panelPpal.add(btnSalir);
        panelPpal.add(btnContinuar);
        panelPpal.add(NombreUno);
        panelPpal.add(NombreDos);

        panelPpal.setSize(500, 500);
        panelPpal.add(lblFondo);

        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame1.setSize(500, 500);
        JFrame1.getContentPane().add(panelPpal);
        JFrame1.setLocationRelativeTo(null);
        JFrame1.setUndecorated(true);
        JFrame1.setVisible(true);
    }

    public String getNombreJugadorUno() {
        return nombreJugadorUno;
    }

    public String getNombreJugadorDos() {
        return nombreJugadorDos;
    }

    public JFrame getJFrame1() {
        return JFrame1;
    }

    

}
