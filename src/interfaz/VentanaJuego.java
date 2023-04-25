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
	
	public static void main(String[] args)
	{
		VentanaJuego ventana = new VentanaJuego();
		ventana.setLocationRelativeTo( null );
        ventana.setVisible( true );
	}

	public int tableroSize = 4;
	private Tablero tablero;
	private PanelNorteInfo  panelInfo;
	private PanelEsteOpciones panelOpciones;
	private PanelOesteJuego dondeJuego;
	private PanelSurNJugadas nJugadas;
	private Top10 top10 ;
	private ReporteJugadas reporteJugadas;
	private static final  File archivoTtop10 = new File("src/uniandes/dpoo/taller4/top10.csv");
	
	private boolean[][] matriz;
	
	
	public VentanaJuego()
	{
		reporteJugadas = new ReporteJugadas(this);
		top10 = new Top10();
		top10.cargarRecords(archivoTtop10);
		tablero = new Tablero(tableroSize);
		
		
		setSize( 800,800 );
		setResizable( false );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );// copiado de ejemlo de museo
		setTitle( "Luces afuera" );
		//setLayout( new BorderLayout( ) );
		
		panelInfo = new PanelNorteInfo(this);
		add(panelInfo, BorderLayout.NORTH);
		
		dondeJuego = new PanelOesteJuego( this, tableroSize );
        add(dondeJuego, BorderLayout.CENTER);
        
        panelOpciones = new PanelEsteOpciones(this);
        add(panelOpciones, BorderLayout.EAST);
        
        reporteJugadas = new ReporteJugadas(this);
        add(reporteJugadas, BorderLayout.SOUTH);
	}
	
	
	public void setSizeTablero(int n) {
		tableroSize = n;
	}
	
	public void dispose()
    {
        JOptionPane.showMessageDialog( this, "Gracias por jugar" );
        //guardar los cambios!
        //VER QUE ES LO QUE HAY QUE HACER
        
        System.exit( 0 );
    }
	
	 
	 
	 //LOS QUE DEVUELVEN
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
	 
	 public PanelNorteInfo darConfiguracionJuego() {
			return this.panelInfo;
		}
	 
	
	 
	 
	 
	 public void setTablero(Tablero newTab) {
			tablero = newTab;
			reporteJugadas.actualizarContador(tablero.darJugadas());
		}
	 
	 public void contadorjugadas() {
			reporteJugadas.actualizarContador(tablero.darJugadas());
		}
	 
	 public void finalizo() {
			if (tablero.tableroIluminado() && tablero.darJugadas()!=0) {
				JOptionPane.showMessageDialog(this,"Bien!!");
				top10.agregarRegistro(reporteJugadas.getJugador(), tablero.calcularPuntaje());
				dondeJuego.actualizarTablero();
			}
		}
	 
	 
	 private void replayy() {
			tablero.reiniciar();
			dondeJuego.actualizarTablero();
			reporteJugadas.actualizarContador(tablero.darJugadas());
	}
	 
	 
	 public void actionPerformed(ActionEvent e) 
	 {
		 if (e.getSource()==panelOpciones.getBTop10()) 
		 {
			 MostrarTop10 ventanaEmergente = new MostrarTop10(this);
		 }
		 else if (e.getSource()== panelOpciones.getNewGame())
		 {
			 int dificultadJuego = panelInfo.darDificultadParaTablero();
			 
			 tablero.desordenar(dificultadJuego);
			 dondeJuego.repaint(); //revisar para que si se esté repintando 
		 }
		 
		 
		 if (e.getSource()==panelInfo.getJuegoSize()) 
		 {
			   if (panelInfo.getJuegoSize().getSelectedItem()=="4x4")
			   {
				   dondeJuego.actualizarTableroSize(4);//System.out.println(panelInfo.getJuegoSize().getSelectedItem()); 
			   }
			   else if (panelInfo.getJuegoSize().getSelectedItem()=="5x5")
			   {
				   dondeJuego.actualizarTableroSize(5);//System.out.println(panelInfo.getJuegoSize().getSelectedItem()); 
			   }
			   else if (panelInfo.getJuegoSize().getSelectedItem()=="6x6")
			   {
				   dondeJuego.actualizarTableroSize(6);//System.out.println(panelInfo.getJuegoSize().getSelectedItem()); 
			   }
			   else if (panelInfo.getJuegoSize().getSelectedItem()=="7x7")
			   {
				   dondeJuego.actualizarTableroSize(7);//System.out.println(panelInfo.getJuegoSize().getSelectedItem()); 
			   }
		 }
	 }
	 
	 
	 

}
