/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.FlowLayout;
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
public class Frameprincipal extends JFrame{
    private JPanel nuevo;
    private JButton jugar;
    private DialogUsuario dialogUsuario;
    public Frameprincipal() {
        super("Deal or not Deal");
        this.getContentPane().setBackground(Color.BLACK);
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/mini.gif")).getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(900,500);
            
            super.setLayout(new FlowLayout());
            ///////
            jugar=new JButton("Jugar");
            jugar.setForeground(Color.WHITE);
            jugar.setBackground(Color.black);
            dialogUsuario=new DialogUsuario(this);
            jugar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialogUsuario.setListener();
                    dispose();
                }
            });
            super.add(jugar);
            JLabel fondo = new JLabel();
            getContentPane().add(fondo);
            addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent ev){
                   Image imgFondo=new ImageIcon(getClass().getResource("../Imagenes/tenor.gif")).getImage();
                    fondo.setIcon(new ImageIcon(imgFondo.getScaledInstance(ev.getComponent().getWidth(), ev.getComponent().getHeight(), Image.SCALE_DEFAULT)));
                }
            });

        super.setVisible(true);
    }
}
