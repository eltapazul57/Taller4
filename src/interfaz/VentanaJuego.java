package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import uniandes.dpoo.taller4.modelo.Tablero;



public class VentanaJuego  extends JFrame
{

	
	
	private PanelNorteInfo  panelInfo;
	private PanelEsteOpciones panelOpciones;
	private PanelOesteJuego dondeJuego;
	private PanelSurNJugadas nJugadas;
	private boolean[][] matriz;
	
	
	public VentanaJuego()
	{
		try
		{
			System.out.println("ptp");
			matriz= new boolean[9][9];
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		setSize( 900,650 );
		//setResizable( false );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setTitle( "Prueba" );
		setLayout( new BorderLayout( ) );
		
		panelInfo = new PanelNorteInfo(this);
		add(panelInfo, BorderLayout.NORTH);
		
		dondeJuego = new PanelOesteJuego( this );
        add(dondeJuego, BorderLayout.WEST);
        
        panelOpciones = new PanelEsteOpciones(this);
        add(panelOpciones, BorderLayout.EAST);
        
        nJugadas = new PanelSurNJugadas(this);
        add(nJugadas, BorderLayout.SOUTH);
	}
	public static void main(String[] args)
	{
		VentanaJuego ventana = new VentanaJuego();
		ventana.setLocationRelativeTo( null );
        ventana.setVisible( true );
	}
	
	public void dispose()
    {
        JOptionPane.showMessageDialog( this, "Gracias por jugar" );
        //guardar los cambios!
        //VER QUE ES LO QUE HAY QUE HACER
        
        System.exit( 0 );
    }
	
	 public boolean[][] darTableroJuego( )
	    {
	        return matriz;
	    }
	 public void jugar( int i, int j )
	    {
	        matriz[i][j]=true;
	    }
	

}
