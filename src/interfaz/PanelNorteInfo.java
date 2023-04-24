package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;




public class PanelNorteInfo extends JPanel implements ActionListener
{
    private JButton btnBuscar;
    
    private JButton btnOpc1;

    private JButton btnOpc2;
    
    private VentanaJuego principal;
    
    public PanelNorteInfo(VentanaJuego principal)
    {
        this.principal=principal;
        
        setLayout( new GridLayout( 1,3 ) );
        setBorder( new TitledBorder( "Información del juego" ) );
        
        btnBuscar= new JButton("Buscar por nombre" );
        btnBuscar.addActionListener( this );
        btnBuscar.setBackground( new Color( 228, 44, 233 ) );
        btnBuscar.setForeground( Color.WHITE );
        
        add(btnBuscar);
        btnOpc1=new JButton( "Opcion 1");
        btnOpc1.addActionListener( this );
        add(btnOpc1);
        btnOpc2=new JButton( "Opcion 2");
        add(btnOpc2);
        btnOpc2.addActionListener( this );
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    
}