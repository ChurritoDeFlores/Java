package Modelos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import Vistas.Ventana;

public class Bloque {
	int x=1500;
	int y=0;
	int velx =10;
	int alto = 700/6;
	int ancho = 1500/40;
	public Boolean estado;
	
	public int get_X() {
		return x;
	}
	public int get_Y1() {
		return y;
	}
	public int get_Y2() {
		return y+alto;
	}
	public void reset_X() {
		x=1500;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,ancho,alto);
	}
	public void paint(Graphics2D g) {
		if (estado) {
			g.fillRect(x, y, ancho, alto);
		}
	}
	public void mover() { x -= velx; }
	
	public Boolean Estado() {
		Random rand = new Random();
		return rand.nextBoolean();
	}
	public Bloque(int i) {
		estado = Estado();
		y = alto*i;
	}

}
