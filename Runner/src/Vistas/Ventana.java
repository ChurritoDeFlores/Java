package Vistas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modelos.Bloque;
import Modelos.Nave;
import javax.swing.JLabel;

public class Ventana extends JPanel {
	JLabel lblVidas;
	public Ventana() {
		addKeyListener ( new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				nave.pulsar(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				nave.soltar();
			}
		});
		setFocusable(true);
		setLayout(null);
		
		lblVidas = new JLabel("Vidas"+String.valueOf(nave.vidas()));
		lblVidas.setBounds(10, 11, 46, 14);
		add(lblVidas);
	}
	public Bloque bloque1 = new Bloque(0);
	public Bloque bloque2 = new Bloque(1);
	public Bloque bloque3 = new Bloque(2);
	public Bloque bloque4 = new Bloque(3);
	public Bloque bloque5 = new Bloque(4);
	public Bloque bloque6 = new Bloque(5);
	Nave nave = new Nave(this);

	
	public  void mover() {
		//System.out.println(nave.vidas());
		bloque1.mover();
		bloque2.mover();
		bloque3.mover();
		bloque4.mover();
		bloque5.mover();
		bloque6.mover();
		if (bloque1.get_X() < 0) {
			bloque1 = new Bloque(0);
			bloque2 = new Bloque(1);
			bloque3 = new Bloque(2);
			bloque4 = new Bloque(3);
			bloque5 = new Bloque(4);
			bloque6 = new Bloque(5);
		}
		nave.mover();
		if (nave.colision()) {
			nave.vida();
			lblVidas.setText("Vidas"+String.valueOf(nave.vidas()));
			nave.restart();
		}

	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D=(Graphics2D)g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		bloque1.paint(g2D);
		bloque2.paint(g2D);
		bloque3.paint(g2D);
		bloque4.paint(g2D);
		bloque5.paint(g2D);
		bloque6.paint(g2D);

		nave.paint(g2D);

	}
	public void vidas() {
		if (nave.get_X()== bloque1.get_X()) {
			if (nave.get_Y1()>bloque1.get_Y2()) {
				nave.vida();
			}
		}
	}
	public static void main(String[ ]args) throws InterruptedException {
		JFrame Frm = new JFrame();
		Ventana V = new Ventana();
		Frm.getContentPane().add(V);
		Frm.setSize(1500,700);
		Frm.setVisible(true);
		Frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			V.mover();
			V.repaint();
			
			Thread.sleep(10);
		}
	}
}
