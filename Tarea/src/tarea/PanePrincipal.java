/*package tarea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanePrincipal extends JFrame {
	private JFrame ventana;
	private JButton botonRojo;
	private JButton botonVerde;
	private JButton botonAzul;
	private JPanel ventanaContenedora;
	
	public PanePrincipal() {
	 ventana= new JFrame();
	 ventana.setVisible(true);
	 ventana.setBounds(200, 200, 500, 500);
	 ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 ventana.setTitle("Programa Principal");
	 
	 ventanaContenedora = new JPanel();
	 ventanaContenedora.setBorder(new EmptyBorder(5, 5, 5, 5));
	 
	 ventana.setContentPane(ventanaContenedora);
	 
	 botonRojo = new JButton("Rojo");
	 botonVerde = new JButton("Verde");
	 botonAzul = new JButton("Azul");

	 ventanaContenedora.add(botonRojo);
	 ventanaContenedora.add(botonAzul);
	 ventanaContenedora.add(botonVerde);
	 
	 botonRojo.addActionListener( new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ventanaContenedora.setBackground(Color.red);
			System.out.println("Color Rojo");
		}
		 
	 }	 
	);
	 
	 botonVerde.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaContenedora.setBackground(Color.green);
				System.out.println("Color Verde");
			}
			 
		 }	 
		);
	 
	 botonAzul.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaContenedora.setBackground(Color.blue);
				System.out.println("Color Azul");
			}
			 
		 }	 
		);
	  
	}
	
}*/
package tarea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanePrincipal extends JFrame implements ColorObserver {
    private JFrame ventana;
    private JButton botonRojo;
    private JButton botonVerde;
    private JButton botonAzul;
    private JPanel ventanaContenedora;
    private ColorObservable colorObservable;

    public PanePrincipal(ColorObservable colorObservable) {
        this.colorObservable = colorObservable;
        colorObservable.añadirObservador(this);

        ventana = new JFrame();
        ventana.setVisible(true);
        ventana.setBounds(200, 200, 500, 500);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setTitle("Programa Principal");

        ventanaContenedora = new JPanel();
        ventanaContenedora.setBorder(new EmptyBorder(5, 5, 5, 5));

        ventana.setContentPane(ventanaContenedora);

        botonRojo = new JButton("Rojo");
        botonVerde = new JButton("Verde");
        botonAzul = new JButton("Azul");

        ventanaContenedora.add(botonRojo);
        ventanaContenedora.add(botonAzul);
        ventanaContenedora.add(botonVerde);

        botonRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorObservable.setColor(Color.RED);
            }
        });

        botonVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorObservable.setColor(Color.GREEN);
            }
        });

        botonAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorObservable.setColor(Color.BLUE);
            }
        });
    }

    @Override
    public void actualizarColor(Color color) {
        ventanaContenedora.setBackground(color);
        System.out.println("El objeto " + this.getClass().getSimpleName() + " detectó la notificación y cambió a color " + color.toString());
    }

    public static void main(String[] args) {
        ColorObservable colorObservable = new ColorObservable();
        new PanePrincipal(colorObservable);
    }
}
