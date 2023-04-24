package interfaz;
//asdfasdfs
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private JButton bRestart;
	private JButton bNewGame;
	private JButton bChangePlayer;
	private JButton bTop10;
	private VentanaJuego vJuego;
    
	
    public PanelEsteOpciones(VentanaJuego principal)
    {
    	vJuego = principal;
    	setPreferredSize(new Dimension(300, 200));
		FlowLayout bl = new FlowLayout(100, 100, 100);
		setLayout(bl);

		bRestart = new JButton("Reiniciar Juego");
		//bRestart.addActionListener((ActionListener) principal);
		
		bNewGame = new JButton("Nuevo Juego");
		//bNewGame.addActionListener((ActionListener) vJuego);
		
		bChangePlayer = new JButton("Cambiar Jugador");
		//bChangePlayer.addActionListener((ActionListener) vJuego);
			
		bTop10 = new JButton("Mejores 10");
		bTop10.addActionListener((ActionListener) vJuego);
		
		add(bRestart);
		add(bNewGame);
		add(bChangePlayer);
		add(bTop10);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public JButton getBTop10()
	{
		return bTop10;
	}

    
}