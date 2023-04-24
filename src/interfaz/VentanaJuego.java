package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

//ensayis
//ensayis2

public class VentanaJuego  extends JFrame implements ActionListener
{

	
	private Tablero tablero;
	private PanelNorteInfo  panelInfo;
	private PanelEsteOpciones panelOpciones;
	private PanelOesteJuego dondeJuego;
	private PanelSurNJugadas nJugadas;
	private Top10 top10 ;
	private static final  File archivoTtop10 = new File("src/uniandes/dpoo/taller4/top10.csv");
	
	private boolean[][] matriz;
	
	
	public VentanaJuego()
	{
		try
		{
			
			matriz= new boolean[9][9];
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		top10 = new Top10();
		top10.cargarRecords(archivoTtop10);
		
		
		
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
	
	 public boolean[][] darTableroJuego( ) //retorna la matriz eso se hizo igualito que en el ejemplo de museo posiblemente hay aque cambiar ojoooo
	    {
	        return matriz;
	    }
	 public void jugar( int i, int j )
	    {
	        matriz[i][j]=true;
	    }
	 
	 public Tablero darTablero() 
	 {
			return this.tablero;
	 }
	
	 public PanelOesteJuego darTableroDeJuego() 
	 {
			return this.dondeJuego;
	 }
	 
	 public Top10 darTop10()
	 {
		 return top10;
	 }
	 
	 
	 public void actionPerformed(ActionEvent e) 
	 {
		 if (e.getSource()==panelOpciones.getBTop10()) 
		 {
			 MostrarTop10 ventanaEmergente = new MostrarTop10(this);
		 }
		 
	 }
	 

}
