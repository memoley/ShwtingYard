/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;
import objetos.Imagenes;
import objetos.Maletines;
import objetos.Paneles;
import objetos.Usuario2;
import objetos.Valores;


/**
 *
 * @author memol
 */
public class Framesecundario extends JFrame {

    private TitledBorder bordevalores;
    private Maletines Bmaletines;
    private Integer primermaleta=0;
    private Valores valoresp=new Valores();
    private Banco banco=new Banco();
    private Paneles paneles;
    private Imagenes imagenes;
    private JPanel k;
    private Usuario2 u;
    private Integer oferta=0;
    private Integer maletaguardar=0;
    private Integer promedio=0;
    private Integer g=0;
    
    public Framesecundario() {
       super("Juego");
    }
    public void setListener(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setExtendedState(MAXIMIZED_BOTH);
        super.setLayout(new BorderLayout());
        JPanel valoresb=new JPanel(new GridLayout(13,0));
        bordevalores=new TitledBorder(new BorderUIResource.EtchedBorderUIResource(10, Color.YELLOW, Color.BLACK),"");
        valoresb.setBorder(bordevalores);
        valoresb.setBackground(Color.BLACK);
        valoresb.setPreferredSize(new Dimension(300,0));
        ImageIcon fondob=new ImageIcon(getClass().getResource("../Imagenes/fondolabel.png"));
        ImageIcon fondobb=new ImageIcon(fondob.getImage().getScaledInstance(300,60,Image.SCALE_DEFAULT));
        paneles=new Paneles();
        for(int t=0;t<=12;t++){
            paneles.agregar(new JLabel());
            paneles.getPaneles().get(t).setBorder(bordevalores);
            paneles.getPaneles().get(t).setIcon(fondobb);
            paneles.getPaneles().get(t).setFont(new Font("Arial Black",1,18));
            paneles.getPaneles().get(t).setHorizontalTextPosition((int) CENTER_ALIGNMENT);
            paneles.getPaneles().get(t).setText("$"+String.valueOf(new Valores().getValores().get(t)));
            valoresb.add(paneles.getPaneles().get(t));
        }
        super.add(valoresb,BorderLayout.WEST);
        JPanel titulo=new JPanel(new BorderLayout());
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("../Imagenes/titulo.png")));
        getContentPane().add(fondo);
        fondo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        fondo.setVerticalAlignment((int) CENTER_ALIGNMENT);
        titulo.add(fondo,BorderLayout.NORTH);
        JLabel Mguardada=new JLabel();
        Mguardada.setBorder(bordevalores);
        Mguardada.setIcon(new ImageIcon(getClass().getResource("../Imagenes/titulo.png")));
        Mguardada.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        Mguardada.setPreferredSize(new Dimension(0,80));
        titulo.add(Mguardada,BorderLayout.NORTH);
        k=new JPanel();
        k.setBorder(bordevalores);
        k.setPreferredSize(new Dimension(0, 80));
        k.setBackground(Color.BLACK);
        titulo.add(k,BorderLayout.SOUTH); 
        titulo.setBorder(bordevalores);
        titulo.setBackground(Color.BLACK);
        JPanel maletines=new JPanel(new FlowLayout((int) RIGHT_ALIGNMENT,50,90)){
            @Override   
            public void paint(Graphics g) {
                Image ima=null;
                try {
                    ima=ImageIO.read(new File("D:\\Imagenes\\UNIVERSIDAD\\PROGRAMACIÓN ORIENTADA A OBJETOS\\fondom.jpg"));
                } catch (IOException ex) {
                    System.out.println("");
                }
                g.drawImage(ima, 0, 0,getWidth(),getHeight(),this);
                setOpaque(false);
                super.paint(g);
            }
        
        };
        maletines.setBackground(Color.BLACK);
        titulo.add(maletines,BorderLayout.CENTER);
        ImageIcon fondom=new ImageIcon(getClass().getResource("../Imagenes/fondolabel.png"));
        Bmaletines=new Maletines();
        valoresp.desordenar();
        for(int j=0;j<=25;j++){
            maletines.add(Bmaletines.getMaletines().get(j));
            Bmaletines.getMaletines().get(j).setPreferredSize(new Dimension(55,45));
            Bmaletines.getMaletines().get(j).setContentAreaFilled(false);
            Bmaletines.getMaletines().get(j).setBorderPainted(false);
        }
        Imagenes imag=new Imagenes();
        Bmaletines.getMaletines().get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banco=new Banco();
                oferta++;
                promedio+=valoresp.getValores().get(0);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(0);
                    k.add(new JLabel(imag.getImagenes().get(0)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(0));
                }
                Bmaletines.getMaletines().get(0).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                   new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(0));
                        }
                    }
                }
            }
        });
        Bmaletines.getMaletines().get(1).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(1);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(1);
                    k.add(new JLabel(imag.getImagenes().get(1)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(1));
                }
                Bmaletines.getMaletines().get(1).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(1));
                        }
                    }
                }
            }
        });
         Bmaletines.getMaletines().get(2).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(2);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(2);
                    k.add(new JLabel(imag.getImagenes().get(2)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(2));
                }
                Bmaletines.getMaletines().get(2).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                       for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(2));
                        }
                    }
                }
            }
        });
         
         Bmaletines.getMaletines().get(3).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(3);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(3);
                    k.add(new JLabel(imag.getImagenes().get(3)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(3));
                }
                Bmaletines.getMaletines().get(3).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(3));
                        }
                    }
                }
            }
        });
         
        Bmaletines.getMaletines().get(4).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(4);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(4);
                    k.add(new JLabel(imag.getImagenes().get(4)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(4));
                }
                Bmaletines.getMaletines().get(4).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(4));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(5).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(5);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(5);
                    k.add(new JLabel(imag.getImagenes().get(5)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(5));
                }
                Bmaletines.getMaletines().get(5).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(5));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(6).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(6);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(6);
                    k.add(new JLabel(imag.getImagenes().get(6)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(6));
                }
                Bmaletines.getMaletines().get(6).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(6));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(7).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(7);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(7);
                    k.add(new JLabel(imag.getImagenes().get(26)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(7));
                }
                Bmaletines.getMaletines().get(7).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(7));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(8).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio+=valoresp.getValores().get(8);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(8);
                    k.add(new JLabel(imag.getImagenes().get(8)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(8));
                }
                Bmaletines.getMaletines().get(8).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(8));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(9).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(9);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(9);
                    k.add(new JLabel(imag.getImagenes().get(9)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(9));
                }
                Bmaletines.getMaletines().get(9).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(9));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(10).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(10);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(10);
                    k.add(new JLabel(imag.getImagenes().get(10)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(10));
                }
                Bmaletines.getMaletines().get(10).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(10));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(11).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(11);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(11);
                    k.add(new JLabel(imag.getImagenes().get(11)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(11));
                }
                Bmaletines.getMaletines().get(11).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(11));
                        }
                    }
                }
            }
        });
        Bmaletines.getMaletines().get(12).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(12);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(12);
                    k.add(new JLabel(imag.getImagenes().get(12)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(12));
                }
                Bmaletines.getMaletines().get(12).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(12));
                        }
                    }
                }
            }
        });
        Bmaletines.getMaletines().get(13).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(13);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(13);
                    k.add(new JLabel(imag.getImagenes().get(13)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(13));
                }
                Bmaletines.getMaletines().get(13).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(13));
                        }
                    }
                }
            }
        });
        Bmaletines.getMaletines().get(14).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(14);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(14);
                    k.add(new JLabel(imag.getImagenes().get(14)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(14));
                }
                Bmaletines.getMaletines().get(14).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(14));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(15).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(15);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(15);
                    k.add(new JLabel(imag.getImagenes().get(15)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(15));
                }
                Bmaletines.getMaletines().get(15).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(15));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(16).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(16);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(16);
                    k.add(new JLabel(imag.getImagenes().get(16)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(16));
                }
                Bmaletines.getMaletines().get(16).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(16));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(17).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(17);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(17);
                    k.add(new JLabel(imag.getImagenes().get(17)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(17));
                }
                Bmaletines.getMaletines().get(17).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(17));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(18).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(18);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(18);
                    k.add(new JLabel(imag.getImagenes().get(18)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(18));
                }
                Bmaletines.getMaletines().get(18).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                       for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(18));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(19).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(19);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(19);
                    k.add(new JLabel(imag.getImagenes().get(19)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(19));
                }
                Bmaletines.getMaletines().get(19).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(19));
                        }
                    }
                }
            }
        });
        Bmaletines.getMaletines().get(20).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(20);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(20);
                    k.add(new JLabel(imag.getImagenes().get(20)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(20));
                }
                Bmaletines.getMaletines().get(20).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(20));
                        }
                    }
                }
            }
        });
        Bmaletines.getMaletines().get(21).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(21);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(21);
                    k.add(new JLabel(imag.getImagenes().get(21)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(21));
                }
                Bmaletines.getMaletines().get(21).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(21));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(22).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(22);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(22);
                    k.add(new JLabel(imag.getImagenes().get(22)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(22));
                }
                Bmaletines.getMaletines().get(22).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(22));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(23).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(23);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(23);
                    k.add(new JLabel(imag.getImagenes().get(23)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(23));
                }
                Bmaletines.getMaletines().get(23).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(23));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(24).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(24);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(24);
                    k.add(new JLabel(imag.getImagenes().get(24)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(24));
                }
                Bmaletines.getMaletines().get(24).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco((3418419-promedio)/26-oferta);
                }else{
                    if(oferta==25){
                       for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(24));
                        }
                    }
                }
            }
        });
        
        Bmaletines.getMaletines().get(25).addActionListener(new ActionListener() {
            @Override   
            public void actionPerformed(ActionEvent e) {
                oferta++;
                promedio=valoresp.getValores().get(25);
                if(primermaleta==0){
                    primermaleta++;
                    maletaguardar=valoresp.getValores().get(25);
                    k.add(new JLabel(imag.getImagenes().get(25)));
                }else{
                    AbrirMaleti(valoresp.getValores().get(25));
                }
                Bmaletines.getMaletines().get(25).setVisible(false);
                if(oferta==6||oferta==12||oferta==18||oferta==24){
                    new Banco().mBanco(((3418419-promedio)/26-oferta));
                }else{
                    if(oferta==25){
                        for(int l=0;l<=25;l++){
                            if(maletaguardar==valoresp.getValores().get(l)){
                                g=l;
                            }
                        }
                        Bmaletines.getMaletines().get(g).setVisible(true);
                    }else{
                        if(oferta==27){
                            new FindejuegoDialog().fin(valoresp.getValores().get(25));
                        }
                    }
                }
            }
        });
        ///////
        ////////////////          
        super.add(titulo,BorderLayout.CENTER);
        //////
        JPanel valoresa=new JPanel(new GridLayout(13,0));
        valoresa.setBorder(bordevalores);
        valoresa.setBackground(Color.BLACK);
        valoresa.setPreferredSize(new Dimension(300,0));
        super.add(valoresa,BorderLayout.EAST);
        
        for(int t=13;t<=25;t++){
            paneles.agregar(new JLabel());
            paneles.getPaneles().get(t).setBorder(bordevalores);
            paneles.getPaneles().get(t).setIcon(fondobb);
            paneles.getPaneles().get(t).setFont(new Font("Arial Black",1,18));
            paneles.getPaneles().get(t).setHorizontalTextPosition((int) CENTER_ALIGNMENT);
            paneles.getPaneles().get(t).setText("$"+String.valueOf(new Valores().getValores().get(t)));
            valoresa.add(paneles.getPaneles().get(t));
        }
        super.setVisible(true);
    }
    
    public void AbrirMaleti(Integer valor){
        UIManager UI=new UIManager();
        UI.put("OptionPane.background",Color.BLACK);
        UI.put("Panel.background",Color.BLACK);
        UI.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
        switch(valor){
            case 1:
                ImageIcon m1=new ImageIcon(getClass().getResource("../ImagenesA/m1.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.DEFAULT_OPTION,m1);
                paneles.getPaneles().get(0).setText("");
                break;
            case 3:
                ImageIcon m2=new ImageIcon(getClass().getResource("../ImagenesA/m2.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m2);
                paneles.getPaneles().get(1).setText("");
                break;
            case 5:
                ImageIcon m3=new ImageIcon(getClass().getResource("../ImagenesA/m3.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m3);
                paneles.getPaneles().get(2).setText("");
                break;
            case 10:
                ImageIcon m4=new ImageIcon(getClass().getResource("../ImagenesA/m4.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m4);
                paneles.getPaneles().get(3).setText("");
                break;
            case 25:
                ImageIcon m5=new ImageIcon(getClass().getResource("../ImagenesA/m5.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m5);
                paneles.getPaneles().get(4).setText("");
                break;
            case 50:
                ImageIcon m6=new ImageIcon(getClass().getResource("../ImagenesA/m6.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m6);
                paneles.getPaneles().get(5).setText("");
                break;
            case 75:
                ImageIcon m7=new ImageIcon(getClass().getResource("../ImagenesA/m7.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m7);
                paneles.getPaneles().get(6).setText("");
                break;    
            case 100:
                ImageIcon m8=new ImageIcon(getClass().getResource("../ImagenesA/m8.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m8);
                paneles.getPaneles().get(7).setText("");
                break;
            case 200:
                ImageIcon m9=new ImageIcon(getClass().getResource("../ImagenesA/m9.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m9);
                paneles.getPaneles().get(8).setText("");
                break;
            case 300:
                ImageIcon m10=new ImageIcon(getClass().getResource("../ImagenesA/m10.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m10);
                paneles.getPaneles().get(9).setText("");
                break;
            case 400:
                ImageIcon m11=new ImageIcon(getClass().getResource("../ImagenesA/m11.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m11);
                paneles.getPaneles().get(10).setText("");
                break;
            case 500:
                ImageIcon m12=new ImageIcon(getClass().getResource("../ImagenesA/m12.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m12);
                paneles.getPaneles().get(11).setText("");
                break;
            case 750:
                ImageIcon m13=new ImageIcon(getClass().getResource("../ImagenesA/m13.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m13);
                paneles.getPaneles().get(12).setText("");
                break;
            case 1000:
                ImageIcon m14=new ImageIcon(getClass().getResource("../ImagenesA/m14.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m14);
                paneles.getPaneles().get(13).setText("");
                break;    
            case 5000:
                ImageIcon m15=new ImageIcon(getClass().getResource("../ImagenesA/m15.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m15);
                paneles.getPaneles().get(14).setText("");
                break;
            case 10000:
                ImageIcon m16=new ImageIcon(getClass().getResource("../ImagenesA/m16.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m16);
                paneles.getPaneles().get(15).setText("");
                break;
            case 25000:
                ImageIcon m17=new ImageIcon(getClass().getResource("../ImagenesA/m17.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m17);
                paneles.getPaneles().get(16).setText("");
                break;
            case 50000:
                ImageIcon m18=new ImageIcon(getClass().getResource("../ImagenesA/m18.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m18);
                paneles.getPaneles().get(17).setText("");
                break;
            case 75000:
                ImageIcon m19=new ImageIcon(getClass().getResource("../ImagenesA/m19.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m19);
                paneles.getPaneles().get(18).setText("");
                break;
            case 100000:
                ImageIcon m20=new ImageIcon(getClass().getResource("../ImagenesA/m20.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m20);
                paneles.getPaneles().get(19).setText("");
                break;
            case 200000:
                ImageIcon m21=new ImageIcon(getClass().getResource("../ImagenesA/m21.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m21);
                paneles.getPaneles().get(20).setText("");
                break;    
            case 300000:
                ImageIcon m22=new ImageIcon(getClass().getResource("../ImagenesA/m22.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m22);
                paneles.getPaneles().get(21).setText("");
                break;
            case 400000:
                ImageIcon m23=new ImageIcon(getClass().getResource("../ImagenesA/m23.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m23);
                paneles.getPaneles().get(22).setText("");
                break;
            case 500000:
                ImageIcon m24=new ImageIcon(getClass().getResource("../ImagenesA/m24.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m24);
                paneles.getPaneles().get(23).setText("");
                break;    
            case 750000:
                ImageIcon m25=new ImageIcon(getClass().getResource("../ImagenesA/m25.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m25);
                paneles.getPaneles().get(24).setText("");
                break;
            case 1000000:
                ImageIcon m26=new ImageIcon(getClass().getResource("../ImagenesA/m26.png"));
                JOptionPane.showMessageDialog(this,"","Maletin", (int) JOptionPane.QUESTION_MESSAGE,m26);
                paneles.getPaneles().get(25).setText("");
                break;        
        }
    }
    
}
