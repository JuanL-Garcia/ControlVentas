/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;


import javax.swing.*;
import javax.swing.border.Border;

import login.LoginProcess;



/**
 *
 * @author Juan Luis
 * 
 * Clase se crea el formulario de inicio de sesion para el sistema
 */
public class InterfaceLogin extends JFrame{
    private JLabel labelTitle, labelUser, labelPass;
    private JTextField txtFldUser;
    private JPasswordField txtFldPass;
    private JButton btnIngresar, btnSalir;
    /*
    * Constructor de la clase
    */
    public InterfaceLogin(){
        
        // Configura los parametros de comportamiento del JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("El Lavadero - Inicio de Sesion");
        int[] RGBColor = {122, 138, 153};
        setLayout(null);
        
        //Setea valores para la etiqueta de titulo
        labelTitle = new JLabel("Inicio de Sesión", SwingConstants.CENTER);
        labelTitle.setBounds(100, 20, 200, 40);
        //labelTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(labelTitle);
        
        //Setea valores para la etiqueta de usuario
        labelUser = new JLabel("Usuario: ");
        labelUser.setBounds(20, 65, 100, 25);
        labelUser.setHorizontalAlignment(JLabel.RIGHT);
        add(labelUser);
        
        //Setea valores para el campo de usuario
        txtFldUser = new JTextField();
        txtFldUser.setBounds(125, 65, 160, 25);
        //txtFldUser.setBorder(new RoundedBorder(15, RGBColor));
        add(txtFldUser);
        
        //Setea valores para la etiqueta de contraseña
        labelPass = new JLabel("Contraseña: ");
        labelPass.setHorizontalAlignment(JLabel.RIGHT);
        labelPass.setBounds(20, 100, 100, 25);
        add(labelPass);
        
        //Setea valores para el campo de contraseña
        txtFldPass = new JPasswordField();
        txtFldPass.setBounds(125, 100, 160, 25);
        //txtFldPass.setBorder(new RoundedBorder(15, RGBColor));
        add(txtFldPass);
        
        //Setea valores para el boton ingresar
        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(e -> {
            LoginProcess loginProcess = 
                    new LoginProcess(txtFldUser.getText(), txtFldPass.getPassword());
            if( loginProcess.getResultConnection()){
                JOptionPane.showMessageDialog(this, "Acceso Consedido!");
            }else{
                JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrectos!");
            }
            
        }); 
        btnIngresar.setBounds(185, 135, 100, 25);
        add(btnIngresar);
        
        //setea valores para el boton salir
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            System.exit(0);
        });
        btnSalir.setBounds(270, 225, 100, 25);
        add(btnSalir);
        
        
    }
    
    
}

//-----------clase con la interface para modificar el borde para que sea redondo

class RoundedBorder implements Border {

    private int radius;
    private Color personalizedColor;

    RoundedBorder(int radius, int rgb[]) {
        this.radius = radius;
        this.personalizedColor = new Color(rgb[0], rgb[1], rgb[2]);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return false;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(personalizedColor);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        //g.fillRoundRect(x, y, width - 1, height - 1, 80, 80);
        g.setColor(personalizedColor);
    }
}
