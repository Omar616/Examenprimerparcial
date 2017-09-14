/*
 * Alumno:Bueno Rosas BrayanOmar
Version: Examen
fecha:14/09/2017
 */

package convertidor;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author BuenoRosas BrayanOmar 
 */
public class Operacion extends JFrame {
    JPanel panelnumeros,paneloperacion;
    JTextField pantalla;
    boolean nuevaoperacion;
    double resultado; 
    //Se construye la pantalla
    Operacion(){
        setSize(500,500); // Establecemos tamaño
        setResizable(false); //Evitamos que la ventana se deforme
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Declaramos el metodo para que cierre la ventana
        setTitle("Examen convertidor");//Titulo
        
        JPanel panel = (JPanel)this.getContentPane(); //Creamos el panel contenedor
        /*
        Atributos que tendra el Textfield donde se mostraran los numeros que se coloquen
        */
        pantalla = new JTextField("0",40);
        pantalla.setBorder(new EmptyBorder(4,4,4,4));
        pantalla.setBackground(Color.WHITE);
       // pantalla.setLayout( new GridLayout(1,1));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        
        panel.add("North",pantalla); // Se agrega el panel numeros al panel general
       
        panelnumeros = new JPanel();
        panelnumeros.setBorder(new EmptyBorder(4,4,4,4));
        panelnumeros.setLayout( new GridLayout(4,3));
        panelnumeros.setBackground(Color.BLUE);
        //Creamos el panel numero
        // Realizamos un for que creara los numeros uno a uno 
        for (int n = 9; n >= 0; n--) {
            System.out.println(n);
            nuevoBotonnumerico(""+ n);
        }
        nuevoBotonnumerico(".");// El boton que falta :)
        
        panel.add("Center",panelnumeros);
        
        paneloperacion = new JPanel();
        paneloperacion.setBorder(new EmptyBorder(4,4,4,4));
        paneloperacion.setLayout( new GridLayout(2,1));
        paneloperacion.setBackground(Color.BLACK);
        // Creamos los operaciones
        nuevoBotonoperacion("limpiar");
        nuevoBotonoperacion("Convertir");
        
        panel.add("East",paneloperacion);
       
    }
    //Metodo para crear botones de operacion recibe un parametro que asigna a un nuevo boton creado 
    private void nuevoBotonoperacion(String operacion){
        JButton btn= new JButton(operacion);
        btn.setBackground(Color.WHITE);
        System.out.println("Aqui estoy operacion");
        btn.addMouseListener(new MouseAdapter(){
       
            @Override //Sobreescribe el metodo de una interfaz 
            public void mouseReleased(MouseEvent evt){
               JButton btn = (JButton)evt.getSource();
               operacionpulsada(btn.getText());
            }
        });
        paneloperacion.add(btn); // agrega al panel numeros
    }
    private void operacionpulsada(String clave){  //recibe el parametro de la operacion que se pulso 
        if (clave.equals("limpiar")) {
            resultado=0;
            pantalla.setText("0"); // inicializa de neuvo el JTextField
            nuevaoperacion=true;
        }else if(clave.equals("Convertir")){
            System.out.println(pantalla.getText());
            resultado=1;
            //resultado=intermediate;
            resultado=Double.parseDouble(pantalla.getText());
            pantalla.setText(""+resultado/17);  //  Establece la operacion 
            nuevaoperacion=true;
        }
    }
    
    // Metodo para crear de manera instantanea los botones numericos 
    //recibe un parametro que coloca en el boton 
    private void nuevoBotonnumerico(String digito){ 
        JButton btn= new JButton();
        btn.setBackground(Color.cyan);
        btn.setText(digito);
        System.out.println("Aqui estoy");
        btn.addMouseListener(new MouseAdapter(){
       
            @Override    // El listener que se encarga de saber que boton se esta presionando
            public void mouseReleased(MouseEvent evt){
               JButton btn = (JButton)evt.getSource();
               numeropulsado(btn.getText());
            }
           
        });
        panelnumeros.add(btn);
    }
    //metodo para acciones de boton
    // recibe el parametro del boton que se pulsa 
    // si la variable booleana se encuentra en true sabe que es una operacion nueva
    private void numeropulsado(String digito){
        if (pantalla.getText().equals("0")||nuevaoperacion){            
            pantalla.setText(digito);// establece el numero que se tecleo
        }else{
            pantalla.setText(pantalla.getText()+digito);// toma el dato anterior y lo coloca 
        }
         nuevaoperacion=false;
    }
    
}

