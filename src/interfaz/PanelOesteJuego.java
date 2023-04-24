package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaz.VentanaJuego;

public class PanelOesteJuego extends JPanel implements MouseListener
{
	 private int ladoTablero;
	   private VentanaJuego principal;
	    
	    
	    public PanelOesteJuego( VentanaJuego pPrincipal )
	    {
	        principal = pPrincipal;
	        addMouseListener( this );
	        add(new JLabel("                                                                          " ));
	    }
	    
	    public void paint(Graphics g)
	    {
	        Graphics2D  g2d = (Graphics2D) g;
	        
	        g.drawRect( 0, 0, 120, 320 );
	        g.setColor( Color.CYAN );
	        
	        g.fillRect( 10, 50, 50, 60 );
	        
	        boolean[][] tableroJuego= principal.darTableroJuego( );
	        tableroJuego[5][3]=true;
	        tableroJuego[5][4]=true;
	        ladoTablero=tableroJuego.length;
	        
	        int ancho=getWidth( )/ladoTablero;
	        int alto= getHeight( )/ladoTablero;
	        
	        for(int i=0;i<ladoTablero;i++)
	        {
	            for(int j=0; j<ladoTablero;j++)
	            {
	                if(tableroJuego[i][j]==true)
	                {
	                    g.setColor( Color.YELLOW );
	                    g.fillRect( i*ancho, j*alto, ancho, alto );
	                    g.setColor( Color.BLACK );
	                    g.drawRect( i*ancho, j*alto, ancho, alto );
	                    
	                }
	                else
	                {
	                    g.setColor( Color.GRAY );
	                    g.fillRect( i*ancho, j*alto, ancho, alto );
	                    g.setColor( Color.BLUE );
	                    g.drawRect( i*ancho, j*alto, ancho, alto );
	                }
	                
	                
	            }
	            
	        }
	        
	        
	    }


	    @Override
	    public void mouseClicked( MouseEvent e )
	    {
	        // no se hace
	        
	    }

	    @Override
	    public void mousePressed(MouseEvent e)
	    {
	        int click_x = e.getX();
	        int click_y = e.getY();
	        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
	        //cuenta los clicks por casilla
	        //cantidades[casilla[0]][casilla[1]]++;
	        //Hace click
//	        JOptionPane.showMessageDialog( this, "Hizo click en \n fila:"+ casilla[0] +"\n columna" +casilla[1] );
	        principal.jugar(casilla[1], casilla[0]);
	        // guarda las ultimas coordenadas
	        //this.ultima_fila = casilla[0];
	        //this.ultima_columna = casilla[1];
	        repaint();
	    }
	    
	    private int[] convertirCoordenadasACasilla(int x, int y)
	    {
//	        int ladoTablero = tablero.length;
	        int altoPanelTablero = getHeight();
	        int anchoPanelTablero = getWidth();
	        int altoCasilla = altoPanelTablero / ladoTablero;
	        int anchoCasilla = anchoPanelTablero / ladoTablero;
	        int fila = (int) (y / altoCasilla);
	        int columna = (int) (x / anchoCasilla);
	        return new int[] { fila, columna };
	    }

	    @Override
	    public void mouseReleased( MouseEvent e )
	    {
	        // no se hace
	        
	    }

	    @Override
	    public void mouseEntered( MouseEvent e )
	    {
	        // no se hace
	    }

	    @Override
	    public void mouseExited( MouseEvent e )
	    {
	        // no se hace
	        
	    }
}
