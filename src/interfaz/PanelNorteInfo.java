package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;




public class PanelNorteInfo extends JPanel implements ActionListener
{	
	private JComboBox<String> juegoSize;
	private JRadioButton dFacil;// estos son lso botones de radio qeu van a indicar la dificultad del jeugo 
	private JRadioButton dMedio;
	private JRadioButton dDificil;
	
	private JLabel infoDificultad;
	private JLabel infoSize; 
	
	
	public PanelNorteInfo(VentanaJuego vJuego)
	{
		juegoSize=new JComboBox<String>();
		juegoSize.setBounds(10,10,80,20); //cuadra mas o menos el tamaño
		juegoSize.addItem("4x4");
		juegoSize.addItem("5x5");
		juegoSize.addItem("6x6");
		juegoSize.addItem("7x7");
		juegoSize.addActionListener(vJuego); //se le añade el action listener
		
		configurarDFacil(new JRadioButton("Fácil"));
		configurarDMedio(new JRadioButton("Medio"));
		configurarDDificil(new JRadioButton("Difícil"));
		
		dFacil.setSelected(true); //Default que la dificultad sea la fácil
		
		
		ButtonGroup grupoDificultades = new ButtonGroup();
		grupoDificultades.add(getDDificil());
		grupoDificultades.add(getDMedio());
		grupoDificultades.add(getDFacil());
		
		infoDificultad = new JLabel("Seleccione dificultad: "); // Esto es lo que le agrega los textos para que uno pueda ver que es lo que hacen los botoenes
		infoSize = new JLabel("Seleccione el tamaño: ");
		
		add(infoSize);
		add(juegoSize); //Esto es lo que agrega todos los botones a la interfaz de verdad
		add(infoDificultad);
		add(getDDificil());
		add(getDMedio());
		add(getDFacil());
		
		juegoSize.addActionListener(vJuego.darTableroDeJuego());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int darDificultadParaTablero()//asigna el número de la dificultad 
	{
		int dificultad = 2;
		if (dMedio.isSelected()==true)
		{
			dificultad = 5;
		}
		else if (dDificil.isSelected()==true)
		{
			dificultad = 10;
		}
		
		return dificultad; 
		
	}
	
	
	//Asigna las dificultades a facil medio y dificil añañay
	public void configurarDFacil(JRadioButton dFacil)
	{
		this.dFacil = dFacil;
	}
	
	public void configurarDMedio(JRadioButton dMedio)
	{
		this.dMedio = dMedio;
	}
    
	public void configurarDDificil(JRadioButton dDificil)
	{
		this.dDificil = dDificil;
	}
	
	//Retorna las dificultades
	public JRadioButton getDFacil() 
	{
		return dFacil;
	}
	
	public JRadioButton getDMedio() 
	{
		return dMedio;
	}
	
	public JRadioButton getDDificil() 
	{
		return dDificil;
	}
	
	public String getTableroSize() {
		 return juegoSize.getSelectedItem().toString();
	 }
	
	public JComboBox getJuegoSize()
	{
		return juegoSize;
	}
}