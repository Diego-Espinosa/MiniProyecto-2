/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author diego
 */
public class VentanaJuego {

    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnSalir;
    private JPanel panelTabla;

    public VentanaJuego() {
        initComponents();
    }

    private void initComponents() {
        JFrame1 = new JFrame();
        panelPpal = new JPanel();
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/maderaBG.jpg"));
        lblFondo = new JLabel(imagenFondo);
        btnSalir = new JButton("Salir");
        panelTabla = new JPanel(new GridLayout(3, 3));
        Color cafe = new Color(131, 51, 0);
        panelTabla.setBounds(150, 150, 200, 200);

        btnSalir.setBounds(400, 0, 100, 25);
        btnSalir.setBackground(Color.red);
        btnSalir.setForeground(white);
        btnSalir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        JLabel[][] celdas = new JLabel[3][3];
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                celdas[fila][columna] = new JLabel(imagenFondo);
                celdas[fila][columna].setPreferredSize(new Dimension(50, 50));
                celdas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelTabla.add(celdas[fila][columna]);
            }
        }

        lblFondo.setSize(500, 500);

        panelPpal.setLayout(null);
        panelPpal.add(btnSalir);
        panelPpal.setSize(500, 500);
        panelPpal.add(lblFondo);

        JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame1.setSize(500, 500);
        JFrame1.add(panelTabla);
        JFrame1.getContentPane().add(panelPpal);
        JFrame1.setLocationRelativeTo(null);
        JFrame1.setUndecorated(true);

    }

    public void mostrarFrameJuego() {
        if (JFrame1.isVisible()) {
            JFrame1.setVisible(false);

        } else {
            JFrame1.setVisible(true);
        }
    }
}
