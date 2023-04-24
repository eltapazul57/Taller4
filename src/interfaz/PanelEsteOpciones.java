package interfaz;
//asdfasdfs
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.*;  

import interfaz.VentanaJuego;

public class PanelEsteOpciones extends JPanel implements ActionListener
{
    private JButton btn1;
    private JButton btnOpc1;
    private JList listaTop;
    private JButton btnOpc3;
    
    private VentanaJuego principal;
    
    public PanelEsteOpciones(VentanaJuego principal)
    {
        this.principal=principal;
       
        //Lay out the label and scroll pane from top to bottom.

        setLayout(new GridLayout( 13,1  ) ); 
        setBorder( new TitledBorder( "Opciones" ) );
        
        btn1= new JButton("NUEVO" );
        btn1.addActionListener( this );
        btn1.setBackground( new Color( 100, 100, 100 ) );
        btn1.setForeground( Color.WHITE );
        
        add(btn1);
        btnOpc1=new JButton( "REINICIAR");
        btnOpc1.addActionListener( this );
        add(btnOpc1);
        
        listaTop=new JList();
        add(listaTop);
                
        btnOpc3=new JButton( "CAMBIAR JUGADOR");
        add(btnOpc3);
        btnOpc3.addActionListener( this );
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    
}