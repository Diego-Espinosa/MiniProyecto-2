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
import java.awt.event.KeyEvent;
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
import static javax.swing.SpringLayout.NORTH;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Diego Espinosa-
 * @author Brigitte Chavez-2041700
 */
public class VentanaJuegoContraPC implements KeyListener {

    private JFrame JFrame1;
    private JPanel panelPpal;
    private JLabel lblFondo;
    private ImageIcon imagenFondo;
    private JButton btnSalir;
    private JPanel panelTabla;
    private ImageIcon imagenX;
    private ImageIcon imagenO;
    private boolean turnoHumano;
    private static int matriz[][] = {{11, 12, 13}, {14, 15, 16}, {17, 18, 19}};
    private static JLabel[][] celdas = new JLabel[3][3];
    private MouseAdapter miMoseAdapter;
    private int victoriasJugadorO;
    private int victoriasJugadorX;
    private int empates;
    private JLabel panelEstadistica;
    private int currentRow = 0;
    private int currentCol = 0;
    private JLabel lblGanador; 

    public VentanaJuegoContraPC() {
        initComponents();

    }

    private void initComponents() {
        Color cafe = new Color(131, 51, 0);
        
        victoriasJugadorO = 0;
        victoriasJugadorX = 0;
        empates = 0;

        lblGanador = new JLabel();
        lblGanador.setBounds(225, 80, 200, 50);
        lblGanador.setBackground(cafe);
        lblGanador.setForeground(white);
        lblGanador.setVisible(true);
        
        
        turnoHumano = true;
        imagenX = new ImageIcon(getClass().getResource("/imagenes/TicTacToeX.jpg"));
        Image nuevaImagenX = imagenX.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon nuevaImagenIconoX = new ImageIcon(nuevaImagenX);
        boolean[][] celdasLibres = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                celdasLibres[i][j] = false;
            }
        }

        //Escucha
        miMoseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("TurnoHumano" + turnoHumano);
                int fila = -1;
                int columna = -1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (celdas[i][j] == e.getSource()) {
                            fila = i;
                            columna = j;
                            break;
                        }
                    }
                }

                if (turnoHumano) {

                    matriz[fila][columna] = 1;
                    celdas[fila][columna].setIcon(nuevaImagenIconoX);
                    celdas[fila][columna].removeMouseListener(this);
                    turnoHumano = false;

                } else {
                    jugarComputadora();

                }
                if (tieneTresEnLinea() && turnoHumano) {
                    lblGanador.setText("¡Te ha vencido una computadora!");
                    victoriasJugadorO++;
                    System.out.println(victoriasJugadorO);
                    terminarPartida();
                    String victoriasO = Integer.toString(victoriasJugadorO);
                    panelEstadistica.setText(victoriasO);

                } else {
                    if (tieneTresEnLinea() && !turnoHumano) {
                        
                        victoriasJugadorX++;
                        lblGanador.setText("¡Ganaste!");
                        System.out.println(victoriasJugadorX);
                        terminarPartida();
                        String victoriasX = Integer.toString(victoriasJugadorX);
                        panelEstadistica.setText(victoriasX);

                    }
                }
                
            }
        };

        JFrame1 = new JFrame();
        panelPpal = new JPanel();
        panelEstadistica = new JLabel();
        String victoriasX = Integer.toString(victoriasJugadorX);
        panelEstadistica.setText(victoriasX);
        String victoriasO = Integer.toString(victoriasJugadorO);
        panelEstadistica.setText(victoriasO);
        //JFrame1.add(panelEstadistica, NORTH);
        imagenFondo = new ImageIcon(getClass().getResource("/imagenes/maderaBG.jpg"));
        lblFondo = new JLabel(imagenFondo);
        btnSalir = new JButton("Salir");
        panelTabla = new JPanel(new GridLayout(3, 3));
        
        panelTabla.setBounds(150, 150, 200, 200);
        panelTabla.setFocusable(true);
        panelTabla.requestFocusInWindow();
        panelTabla.requestFocus();
        panelTabla.addKeyListener(this);
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                celdas[fila][columna] = new JLabel(imagenFondo);
                celdas[fila][columna].addMouseListener(miMoseAdapter);
                celdas[fila][columna].setPreferredSize(new Dimension(50, 50));
                celdas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelTabla.add(celdas[fila][columna]);

            }

            btnSalir.setBounds(400, 0, 100, 25);
            btnSalir.setBackground(Color.red);
            btnSalir.setForeground(white);
            btnSalir.addActionListener((ActionEvent e) -> {
                System.exit(0);
            });

            lblFondo.setSize(500, 500);

            panelPpal.add(lblGanador);
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

    }

    private void jugarComputadora() {
        imagenO = new ImageIcon(getClass().getResource("/imagenes/tictactoeO.png"));
        Image nuevaImagenO = imagenO.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon nuevaImagenIconoO = new ImageIcon(nuevaImagenO);

        if (!turnoHumano) {
            Random random = new Random();
            int fila = -1;
            int columna = -1;

            do {

                fila = random.nextInt(3);
                columna = random.nextInt(3);
            } while (matriz[fila][columna] == 1 || matriz[fila][columna] == 2);
            celdas[fila][columna].setIcon(nuevaImagenIconoO);
            celdas[fila][columna].removeMouseListener(miMoseAdapter);
            matriz[fila][columna] = 2;
            turnoHumano = true;

        } else {
            turnoHumano = false;
        }
    }

    public void mostrarFrameJuego() {
        if (JFrame1.isVisible()) {
            JFrame1.setVisible(false);

        } else {
            JFrame1.setVisible(true);
            SwingUtilities.invokeLater(() -> {
                panelTabla.requestFocus();
            });
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

    public void terminarPartida() {
        if (tieneTresEnLinea()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    celdas[i][j].removeMouseListener(miMoseAdapter);
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                if (currentRow > 0) {
                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    currentRow--;
                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.GREEN));

                }
                break;
            case KeyEvent.VK_DOWN:
                if (currentRow < 2) {
                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    currentRow++;
                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.GREEN));

                }
                break;
            case KeyEvent.VK_LEFT:
                if (currentCol > 0) {

                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    currentCol--;

                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                }
                break;

            case KeyEvent.VK_RIGHT:
                if (currentCol < 2) {
                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    currentCol++;
                    celdas[currentRow][currentCol].setBorder(BorderFactory.createLineBorder(Color.GREEN));

                    break;

                }
            case KeyEvent.VK_ENTER:
                int fila = currentRow;
                int columna = currentCol;
                celdas[fila][columna].dispatchEvent(new MouseEvent(celdas[fila][columna], MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 0, 0, 1, false));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
