package Modelos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Vistas.Ventana;

public class Nave {
	int x=100;
	int y=350;
	int vel_base=10;
	int velX=0;
	int velY=0;
	int ancho=130;
	int alto=100;
	int vidas= 5;
	Ventana v;
	BufferedImage imagenNave;
	public Nave(Ventana newv) {
		v = newv;
	}
	public int get_X() {
		return x+ancho;
	}
	public int get_Y1() {
		return y;
	}
	public int get_Y2() {
		return y+alto;
	}
	public int vidas() {
		return vidas;
	}
	public void vida() {
		vidas--;
	}
	public void restart() {
		x=100;
		y=350;
	}
	public boolean colision() {
		// Rectangulo raqueta intercepcion rectangulo Bola [TRUE/FALSE]
		Boolean choque = false;
			if (v.bloque1.estado && v.bloque1.getBounds().intersects(getBounds())) {
				choque = true;
			}
			if (v.bloque2.estado && v.bloque2.getBounds().intersects(getBounds())) {
				choque = true;
			}
			if (v.bloque3.estado && v.bloque3.getBounds().intersects(getBounds())) {
				choque = true;
			}
			if (v.bloque4.estado && v.bloque4.getBounds().intersects(getBounds())) {
				choque = true;
			}
			if (v.bloque5.estado && v.bloque5.getBounds().intersects(getBounds())) {
				choque = true;
			}
			if (v.bloque6.estado && v.bloque6.getBounds().intersects(getBounds())) {
				choque = true;
			}
			return choque;
		}
	public Rectangle getBounds() {
		return new Rectangle(x,y,ancho,alto);
	}
	public void paint(Graphics2D g) {//g.fillRect(x, y, ancho, alto);
		
		try {
			imagenNave= ImageIO.read(new File("C:\\Users\\ferco\\eclipse-workspace\\Runner\\nave.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image imagenNaveEscalada = imagenNave.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		g.drawImage(imagenNaveEscalada, x, y, null);
	}
	public void mover() {
		if (y+velY<(v.getHeight()-alto)&&(y+velY>0)){
			y = y + velY;
		}
		if (x+velX<(v.getWidth()-ancho)&&(x+velX>0)) {
			x = x + velX;
		}
	}
	public void pulsar(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_A) {
			velX=-vel_base;
		}if (e.getKeyCode()==KeyEvent.VK_D) {
			velX=vel_base;
		}
		if (e.getKeyCode()==KeyEvent.VK_W) {
			velY=-vel_base;
		}if (e.getKeyCode()==KeyEvent.VK_S) {
			velY=vel_base;
		}
	}
	public void soltar() {
		velX=0;
		velY=0;
	}
}
