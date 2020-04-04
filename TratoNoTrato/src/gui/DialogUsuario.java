/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import exceptions.Nombrevacioexception;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import objetos.Usuario2;

/**
 *
 * @author memol
 */
public class DialogUsuario extends JDialog {
   private JPanel datos;
    private JPanel botones;
    private JTextField nombre;
    private JButton aceptar;
    private JButton cancelar;
    private Framesecundario framesecundario;
    public DialogUsuario(JFrame frame) {
        super(frame,true);
        
    }
    public void setListener(){
        super.setLayout(new BorderLayout());
        super.setSize(500,200);
        Image imgFondo=new ImageIcon(getClass().getResource("../Imagenes/tenor.gif")).getImage();
        datos=new JPanel();
        nombre=new JTextField(10);
        datos.add(new JLabel("Jugador: "));
        datos.add(nombre);
        botones=new JPanel();
        aceptar=new JButton("Aceptar");
        framesecundario=new Framesecundario();
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario2 usuario2=new Usuario2();
                    usuario2.agregar(nombre.getText());
                    framesecundario.setListener();
                    dispose();
                } catch (Nombrevacioexception ex) {
                    nombre(ex);
                }
            }
        });
        cancelar=new JButton("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        botones.add(aceptar);
        botones.add(cancelar);
        super.add(botones,BorderLayout.SOUTH);
        super.add(datos,BorderLayout.CENTER);
        super.setVisible(true);    
    }
    public void nombre(Nombrevacioexception ex){
        JOptionPane.showMessageDialog(this,"No ingreso un nombre","Error",JOptionPane.ERROR_MESSAGE);
    } 
}
