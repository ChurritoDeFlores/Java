package Logica;

import java.awt.Point;

public class MunTubos extends Thread{
	int tbn1;
	int tbn2;
	int oldHit=0;
	int vidas;
	int puntos;
	Point pos1;
	Point pos2;
	private Principal pr;
	private int velocidad;
	public MunTubos(Principal pr) {
		this.pr=pr;
		this.vidas = pr.vidas;
		this.puntos = pr.movimiento.getPuntos();
		velocidad=7;
	}
	public int numero_aleatorio() {
		int numero = (int)(Math.random()*(0-(-200))+(-200));
		return numero;
	}
	@Override
	public void run() {
		pos1 = pr.jtubo_arriba1.getLocation();
		pos2 = pr.jtubo_arriba2.getLocation();
		tbn1 = pos1.x;
		tbn2 = pos2.x;
		while(true) {
			try {
				Thread.sleep(velocidad);
				tbn1--;
				tbn2--;
				pr.jtubo_arriba1.setLocation(tbn1,pos1.y);
				pr.jtubo_arriba2.setLocation(tbn2,pos2.y);
				pr.jtubo_abajo1.setLocation(tbn1,pos1.y+425);
				pr.jtubo_abajo2.setLocation(tbn2,pos2.y+425);
				if (vidas==5) {
					pr.Vidas5.setVisible(true);
					pr.Vidas4.setVisible(true);
					pr.Vidas3.setVisible(true);
					pr.Vidas2.setVisible(true);
					pr.Vidas1.setVisible(true);
				}else if (vidas==4) {
					pr.Vidas5.setVisible(false);
					pr.Vidas4.setVisible(true);
					pr.Vidas3.setVisible(true);
					pr.Vidas2.setVisible(true);
					pr.Vidas1.setVisible(true);
				}else if (vidas==3) {
					pr.Vidas5.setVisible(false);
					pr.Vidas4.setVisible(false);
					pr.Vidas3.setVisible(true);
					pr.Vidas2.setVisible(true);
					pr.Vidas1.setVisible(true);
				}else if (vidas==2) {
					pr.Vidas5.setVisible(false);
					pr.Vidas4.setVisible(false);
					pr.Vidas3.setVisible(false);
					pr.Vidas2.setVisible(true);
					pr.Vidas1.setVisible(true);
				}else if (vidas==1) {
					pr.Vidas5.setVisible(false);
					pr.Vidas4.setVisible(false);
					pr.Vidas3.setVisible(false);
					pr.Vidas2.setVisible(false);
					pr.Vidas1.setVisible(true);
				}else if (vidas==0) {
					pr.Vidas5.setVisible(false);
					pr.Vidas4.setVisible(false);
					pr.Vidas3.setVisible(false);
					pr.Vidas2.setVisible(false);
					pr.Vidas1.setVisible(false);
					pr.checkGameOver = true;
					pr.gameover();
					break;
				}
				if(vidas<5) {
					if ((pr.movimiento.getPuntos() - puntos)==30) {
						vidas++;
						puntos = pr.movimiento.getPuntos();
					}

				}
				if(pr.colision(pr.jtubo_abajo1)||pr.colision(pr.jtubo_abajo2)||pr.colision(pr.jtubo_arriba1)||pr.colision(pr.jtubo_arriba2)) {
					if((pr.movimiento.getLifeTime()- oldHit) >= 30) {
						oldHit = pr.movimiento.getLifeTime();
						vidas --;
					}
				}
				
				if(tbn1<=-51) {
					pos1.y=numero_aleatorio();
					tbn1=425;
				}
				if(tbn2<=-51) {
					pos2.y=numero_aleatorio();
					tbn2=425;
				}
			}catch(Exception e) {
			}
		}
	}
}
