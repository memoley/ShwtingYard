/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
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
public class Banco extends JFrame {
     private JPanel fondo;
    private JPanel botones;
    private FindejuegoDialog fd;
    public Banco() {
    }
    
    public void mBanco(Integer promedio){
        super.setSize(350,400);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        fondo=new JPanel();
        JLabel fondo=new JLabel();
        fondo.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
        fondo.setForeground(Color.WHITE);
        fondo.setFont(new Font("Arial Black",1,18));
        int pr=(int) (promedio*0.2);
        fondo.setText("El banco te ofrece $"+String.valueOf(promedio-pr));
        getContentPane().add(fondo);
            addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent ev){
                   Image imgFondo=new ImageIcon(getClass().getResource("../ImagenesA/banco.jpg")).getImage();
                    fondo.setIcon(new ImageIcon(imgFondo.getScaledInstance(ev.getComponent().getWidth(), ev.getComponent().getHeight(), Image.SCALE_DEFAULT)));
                }
            });
        super.add(fondo,BorderLayout.CENTER);
        botones=new JPanel();
        botones.setBackground(Color.BLACK);
        super.add(botones,BorderLayout.SOUTH);
        ImageIcon a=new ImageIcon(getClass().getResource("../ImagenesA/acep.png"));
        ImageIcon a1=new ImageIcon(a.getImage().getScaledInstance(100,30,Image.SCALE_DEFAULT));
        JButton aceptar=new JButton(a1);
        aceptar.setPreferredSize(new Dimension(100,30));
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FindejuegoDialog().fin(promedio-pr);
            }
        });
        botones.add(aceptar);
        ImageIcon r=new ImageIcon(getClass().getResource("../ImagenesA/rech.png"));
        ImageIcon r1=new ImageIcon(r.getImage().getScaledInstance(100,30,Image.SCALE_DEFAULT));
        JButton rechazar=new JButton(r1);
        rechazar.setPreferredSize(new Dimension(100,30));
        rechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.setText("");
                dispose();
            }
        });
        botones.add(rechazar);
        
        super.setVisible(true);
    }
}
