/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author memol
 */
public class FindejuegoDialog extends JFrame{
    public FindejuegoDialog() {
    }
    
    public void fin(Integer valor){
        super.setSize(700,400);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        JPanel boton=new JPanel();
        JButton salir=new JButton("Salir");
        salir.setBackground(Color.BLACK);
        salir.setForeground(Color.WHITE);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        boton.add(salir,BorderLayout.CENTER);
        JLabel fondo = new JLabel();
            getContentPane().add(fondo);
            addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent ev){
                   Image imgFondo=new ImageIcon(getClass().getResource("../Imagenes/tenor.gif")).getImage();
                    fondo.setIcon(new ImageIcon(imgFondo.getScaledInstance(ev.getComponent().getWidth(), ev.getComponent().getHeight(), Image.SCALE_DEFAULT)));
                }
            });
        fondo.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
        fondo.setForeground(Color.WHITE);
        fondo.setFont(new Font("Arial Black",1,18));
        fondo.setText("Felicidades gano $"+String.valueOf(valor));
        
        super.add(fondo);
        super.add(boton,BorderLayout.SOUTH);
        
        super.setVisible(true);
    }
}
