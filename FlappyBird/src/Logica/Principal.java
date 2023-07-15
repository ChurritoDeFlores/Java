package Logica;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Font;

public class Principal extends JFrame{
	JPanel jpanel1;
	public PanelImage panelImage1;
	public PanelImage jsuelo;
	public JLabel jflappy;
	Point posicionFlappy;
	MunFlappy movimiento;
	public boolean checkGameOver;
	public JLabel puntos;
	public int vidas;
	private int MaxPuntos;
	public JLabel Vidas1;
	public JLabel Vidas2;
	public JLabel Vidas3;
	public JLabel Vidas4;
	public JLabel Vidas5;
	public JLabel jtubo_arriba1;
	public JLabel jtubo_arriba2;
	public JLabel jtubo_abajo1;
	public JLabel jtubo_abajo2;
	MunTubos movimientoTubo;
	public Principal() {
		checkGameOver = false;
		jpanel1 = new JPanel();
		panelImage1=new PanelImage();
		jsuelo = new PanelImage();
		jflappy = new JLabel();
		
		this.setLocationRelativeTo(null);
		posicionFlappy = jflappy.getLocation();
		this.jpanel1.setSize(400,607);
		movimiento = new MunFlappy(this);
		
		jtubo_arriba1 = new JLabel();
		jtubo_arriba2 = new JLabel();
		jtubo_abajo1 = new JLabel();
		jtubo_abajo2 = new JLabel();
		puntos = new JLabel();
		MaxPuntos = 0;
		puntos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Vidas1 = new JLabel();
		Vidas2 = new JLabel();
		Vidas3 = new JLabel();
		Vidas4 = new JLabel();
		Vidas5 = new JLabel();
		IniciarComponente();
		movimientoTubo = new MunTubos(this);
		movimientoTubo.start();
		movimiento.start();
		
	}
	public void IniciarComponente() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		jpanel1.setBackground(new Color(25,255,255));
		panelImage1.setIcon(new ImageIcon(getClass().getResource("/Images/MAPA_NRO1.png")));
		panelImage1.setLayout(null);
		jsuelo.setIcon(new ImageIcon(getClass().getResource("/Images/piso.png")));
		panelImage1.addMouseListener(mL);
		// Suelo
		GroupLayout jsueloLayout = new GroupLayout(jsuelo);
		panelImage1.add(jsuelo);
		jsuelo.setBounds(-130, 470, 580, 180);
		// Flappy
		jflappy.setIcon(new ImageIcon(getClass().getResource("/Images/pezRojo1.png")));
		panelImage1.add(jflappy);
		jflappy.setBounds(70, 230, 34, 24);
		
		//Vidas
		vidas=5;
		
		Vidas1.setIcon(new ImageIcon(getClass().getResource("/Images/corazon.png")));
		panelImage1.add(Vidas1);
		Vidas1.setBounds(0, 0, 30, 30);
		Vidas1.setVisible(true);
		
		Vidas2.setIcon(new ImageIcon(getClass().getResource("/Images/corazon.png")));
		panelImage1.add(Vidas2);
		Vidas2.setBounds(30, 0, 30, 30);
		Vidas2.setVisible(true);
		
		Vidas3.setIcon(new ImageIcon(getClass().getResource("/Images/corazon.png")));
		panelImage1.add(Vidas3);
		Vidas3.setBounds(60, 0, 30, 30);
		Vidas3.setVisible(true);
		
		Vidas4.setIcon(new ImageIcon(getClass().getResource("/Images/corazon.png")));
		panelImage1.add(Vidas4);
		Vidas4.setBounds(90, 0, 30, 30);
		Vidas4.setVisible(true);
		
		Vidas5.setIcon(new ImageIcon(getClass().getResource("/Images/corazon.png")));
		panelImage1.add(Vidas5);
		Vidas5.setBounds(120, 0, 30, 30);
		Vidas5.setVisible(true);
		
		// Puntos
		puntos.setText("Puntos: 0");
		panelImage1.add(puntos);
		puntos.setBounds(0, 20, 150, 40);
		//	Check Game Over
		checkGameOver = false;
		
		// tubo arriba 1
		jtubo_arriba1.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_1.png")));
		panelImage1.add(jtubo_arriba1);
		jtubo_arriba1.setBounds(370, -120, 52, 320);
		// tubo arriba 2
		jtubo_arriba2.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_1.png")));
		panelImage1.add(jtubo_arriba2);
		jtubo_arriba2.setBounds(590,-120,52,320);
		// tubo abajo 1
		jtubo_abajo1.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_2.png")));
		panelImage1.add(jtubo_abajo1);
		jtubo_abajo1.setBounds(370, 280, 52, 320);
		// tubo abajo 2
		jtubo_abajo2.setIcon(new ImageIcon(getClass().getResource("/Images/Tubo_2.png")));
		panelImage1.add(jtubo_abajo2);
		jtubo_abajo2.setBounds(590, 280, 52, 320);
		
		
		
		GroupLayout jPanel1Layout = new GroupLayout(jpanel1);//Creamos un contenedor mas grande  para incluir el panel principal
        jpanel1.setLayout(jPanel1Layout);
        
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()//al ser un grupo secuencial, una va pegada a otra
                        .addComponent(panelImage1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE).addGap(0, 0, 0)));
        //el espacio de separacion es 0 en todos los casos
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(panelImage1, GroupLayout.PREFERRED_SIZE, 600,GroupLayout.PREFERRED_SIZE));
        
        
        
        GroupLayout layout = new GroupLayout(getContentPane());//este el panel general de JFRAME ver vista diseñador
        getContentPane().setLayout(layout);
        this.addComponent(jpanel1);
        this.setBounds(0, 0, 308, 266);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jpanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jpanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        pack();
	}
	private void addComponent(JPanel jpanel) {
		
	}
	MouseListener mL = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub	
		}

		@Override
		public void mousePressed(MouseEvent e) {
			movimiento.setSaltar(true);
			jflappy.requestFocus(true);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			movimiento.setSaltar(false);
			jflappy.requestFocus(true);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
		
	};
	public void gameover() {
		if (checkGameOver) {
			if (movimiento.getPuntos()>MaxPuntos) {
				MaxPuntos = movimiento.getPuntos();
			}
			JOptionPane.showMessageDialog(this,"Game Over \nTu puntuacion es de: "+movimiento.getPuntos()+"\nLa puntuacion record es: "+MaxPuntos);
			IniciarComponente();
			movimiento = new MunFlappy(this);
			movimiento.start();
			movimientoTubo = new MunTubos(this);
			movimientoTubo.start();
		}
	}
	public boolean colision(JLabel _tubo) {
		Rectangle flappy = jflappy.getBounds();
		Rectangle tubo = _tubo.getBounds();
		if(flappy.intersects(tubo))
			return true;
		else
			return false;
	}
}
