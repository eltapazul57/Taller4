package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaz.VentanaJuego;
import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelOesteJuego extends JPanel implements ActionListener,MouseMotionListener,MouseListener
{
	
	
	private int sizeCell = 0;
	private Dimension size = new Dimension(500,500);
	private int sideCell = 0;
	private Image on = null;
	private Image off = null;
	private VentanaJuego interfaz = null;
	private Tablero tablero = null;
	private boolean[][] matriz = null;
	
	public PanelOesteJuego( VentanaJuego interf, int tamm) 
	{
		this.setSize(size);
		this.setVisible(true);
		this.sideCell = tamm;
		this.sizeCell = size.height/tamm;
		//this.on = onn;
		//this.off = offf;
		this.interfaz = interf;
		this.tablero = interf.darTablero();
		this.matriz = interf.darTablero().darTablero();
	
		addMouseListener(this);
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
					
		int alto = size.height/sideCell;
		int ancho = size.width/sideCell;
		int fila = 1;
		int columna = 1;
		int xaxis = 0;
		int yaxis = 0;
		
		
		while (columna <= sideCell && fila <= sideCell)
		{
			boolean onn = matriz[fila-1][columna-1];
			RoundRectangle2D.Double rectangle = new RoundRectangle2D.Double(xaxis,yaxis,alto,ancho,20,20);
			g2d.draw(rectangle); //dibuja los rectangulos
			if (onn) {
				g2d.setPaint(new GradientPaint( xaxis, yaxis, Color.YELLOW, xaxis+ancho, yaxis+alto,Color.GREEN));
			}
			else if (onn == false) {
				g2d.setPaint(new GradientPaint( xaxis, yaxis, Color.BLACK, xaxis+ancho, yaxis+alto,Color.GRAY ) );
			}
			g2d.fill(rectangle);
			
			if (onn) {
				g2d.drawImage(on,xaxis+15,yaxis+15,ancho-30,alto-30,this);
			}
			else if (onn == false) {
				g2d.drawImage(off,xaxis+15,yaxis+15,ancho-30,alto-30,this);
			}
			xaxis += ancho;
			if (columna == sideCell) {
				yaxis += alto;
				xaxis = 0;
				columna = 1;
				fila ++;
			}
			else {columna++;}
		}
	}
	
	void actualizarTableroSize(int n) {
		interfaz.setTablero(new Tablero(n));
		interfaz.setSizeTablero(n);
		
		this.sideCell = n;
		this.sizeCell = size.height/n;
		
		actualizarTablero();
		
	}
	
	private void pintarCasilla(int fila, int columna) {
			tablero.jugar(fila, columna);
			interfaz.setTablero(tablero);
			interfaz.contadorjugadas();
			actualizarTablero();
			interfaz.finalizo();
			
	}
	
	private int[] hallarCasilla(int X, int Y) {
		int fila = (Y / sizeCell);
		int columna = (X / sizeCell);
		int[] casilla = {fila,columna};
		return casilla;
	}

	public void actualizarTablero() {
		this.tablero = interfaz.darTablero();
		this.matriz = interfaz.darTablero().darTablero();
		repaint();
	}
	
	
	
	
public void actionPerformed(ActionEvent e) {
		
		
		
		
	}
	
	


	public void mouseClicked(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		int coordX = e.getX();
		int coordY = e.getY();
		if (coordX <= sizeCell*sideCell && coordY <= sizeCell*sideCell) 
		{
			int[] casilla = hallarCasilla(coordX,coordY);
			pintarCasilla(casilla[0], casilla[1]);
						
		}
	}
	
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}




		  
}
