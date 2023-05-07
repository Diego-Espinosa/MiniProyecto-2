/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;

/**
 *
 * @author diego
 */
public class VentanaJuegoContraPC {

    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnSalir;
    private JPanel panelTabla;
    private ImageIcon imagenX;
    private ImageIcon imagenO;
    private int turno;
    private static int matriz[][] = {{11, 12, 13}, {14, 15, 16}, {17, 18, 19}};
    private static JLabel[][] celdas = new JLabel[3][3];
    private MouseAdapter miMoseAdapter;

    public VentanaJuegoContraPC() {
        initComponents();
    }

    private void initComponents() {
        turno = 0;

        imagenX = new ImageIcon(getClass().getResource("/imagenes/TicTacToeX.jpg"));
        imagenO = new ImageIcon(getClass().getResource("/imagenes/tictactoeO.png"));
        Image nuevaImagenX = imagenX.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image nuevaImagenO = imagenO.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon nuevaImagenIconoO = new ImageIcon(nuevaImagenO);
        ImageIcon nuevaImagenIconoX = new ImageIcon(nuevaImagenX);

        miMoseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Random random = new Random();

                int numeroAleatorio1 = random.nextInt(3);
                int numeroAleatorio2 = random.nextInt(3);
                boolean condicionCumplida = false;
                turno++;

                int fila = -1;
                int columna = -1;
                
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (celdas[i][j] == e.getSource()) {
                            if (celdas[i][j].getIcon() == imagenFondo) {

                                if (turno % 2 == 0) {
                                    celdas[numeroAleatorio1][numeroAleatorio2].setIcon(nuevaImagenIconoO);
                                } else {
                                    celdas[i][j].setIcon(nuevaImagenIconoX);
                                }
                                celdas[i][j].removeMouseListener(this);
                                condicionCumplida = true;
                                fila = i;
                                columna = j;
                            }else{
                                condicionCumplida=false;
                            }
                            break;
                        }
                    }
                }

                // Asignar el valor correspondiente en la matriz
                if (turno % 2 == 0) {
                    matriz[numeroAleatorio1][numeroAleatorio2] = 2;
                } else {
                    matriz[fila][columna] = 1;

                }

                declararGanador();
            }
        };

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

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                celdas[fila][columna] = new JLabel(imagenFondo);
                celdas[fila][columna].addMouseListener(miMoseAdapter);
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

    public static boolean tieneTresEnLinea() {
        for (int fila = 0; fila < 3; fila++) {
            if (matriz[fila][0] == matriz[fila][1] && matriz[fila][1] == matriz[fila][2]) {
                return true;
            }
        }

        for (int columna = 0; columna < 3; columna++) {
            if (matriz[0][columna] == matriz[1][columna] && matriz[1][columna] == matriz[2][columna]) {
                return true;
            }
        }

        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) {
            return true;
        }

        if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]) {
            return true;
        }

        return false;
    }

    public void declararGanador() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");

        }
        if (tieneTresEnLinea() && turno % 2 == 0) {
            System.out.println("Ganador: Jugador O");
            terminarPartida();

        } else {
            if (tieneTresEnLinea() && turno % 2 != 0) {
                System.out.println("Ganador: Jugador X");
                terminarPartida();

            }
        }
    }

    public void terminarPartida() {
        if (tieneTresEnLinea()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    celdas[i][j].removeMouseListener(miMoseAdapter);
                }
            }
        }
    }
}
