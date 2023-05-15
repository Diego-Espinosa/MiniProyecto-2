/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Diego Espinosa-
 * @author Brigitte Chavez-2041700
 */
public class VentanaNombreUnJugador {
    
    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnContinuar;
    private JButton btnSalir;
    private JTextField NombreUno;
        public VentanaNombreUnJugador() {
        initComponents();
    }

    public void initComponents() {
        btnSalir = new JButton("Salir");
        btnContinuar = new JButton("Continuar");
        JFrame1 = new JFrame();
        panelPpal = new JPanel();
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/maderaBG.jpg"));
        lblFondo = new JLabel(imagenFondo);
        NombreUno = new JTextField("Nombre jugador 1");

        NombreUno.setBounds(100, 200, 105, 20);
        
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
            JFrame1.setVisible(false);
            VentanaJuegoContraPC ventanaJuegoContraPC = new VentanaJuegoContraPC();
            ventanaJuegoContraPC.mostrarFrameJuego();
        });

        panelPpal.setLayout(null);
        panelPpal.add(btnSalir);
        panelPpal.add(btnContinuar);
        panelPpal.add(NombreUno);

        panelPpal.setSize(500, 500);
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

