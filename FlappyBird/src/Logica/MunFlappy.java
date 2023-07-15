package Logica;

import java.awt.Point;

public class MunFlappy extends Thread{
	private boolean saltar;
	private Principal pr;
	private int lifeTime;
	private int puntos;
	public boolean isSaltar() {
		return saltar;
	}
	public MunFlappy(Principal pr) {
		this.pr=pr;
	}
	public void setSaltar(boolean saltar) {
		this.saltar=saltar;
		}
	public int getLifeTime() {
		return this.lifeTime;
	}
	public int getPuntos() {
		return puntos;
	}
	@Override
	public void run() {
		while (true) {
			if (saltar) {
				Point pos = pr.jflappy.getLocation();
				try {
					Thread.sleep(20);
				}catch(InterruptedException e){
				}
				if(pos.y>0) {
					pos.y-=4;
					pr.jflappy.setLocation(pos);
				}				
			}else {
				Point pos = pr.jflappy.getLocation();
				try {
					Thread.sleep(20);
				}catch(InterruptedException e) {
				}
				if(pos.y<445) {
					pos.y+=4;
				pr.jflappy.setLocation(pos);
				}
			}
			lifeTime+=1;
			if ((lifeTime%100)==0) {
				puntos+=1;
			}
			if (pr.checkGameOver) {
				break;
			}
			pr.puntos.setText("Puntos: "+puntos);
		}
	}
	
}
